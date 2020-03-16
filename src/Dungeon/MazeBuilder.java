package Dungeon;

import java.util.Random;

public class MazeBuilder {
	private static Maze maze = new Maze();
	
	public static void printEntireMaze(Maze maze) {
		Room[][] rooms = maze.getRooms();
		for(int i = 0; i < 5; i++) {
			printRow(i,0,4,rooms);
			if(i == 4)
				printBottomRow(i,0,4,rooms);
		}
	}
	
	public static void printRow(int row,int columnToStartAt, int columnToEndAt, Room[][] rooms) {
		for(int i = 0; i < 2; i++) {
			for(int j = columnToStartAt; j < columnToEndAt+1; j++) {
				//Print Top
				if(i == 0) {
					System.out.print("*");
					
					if(rooms[row][j].getNorth().isClosed())
						System.out.print("*");
					else
						System.out.print("-");
					
					if(j==columnToEndAt) 
						System.out.print("*");
				}
				//Print Middle
				else {
					if(rooms[row][j].getWest().isClosed())
						System.out.print("*");
					else
						System.out.print("|");
					
					System.out.print(rooms[row][j].centerObject());
					if(j==columnToEndAt) {
						if(rooms[row][j].getEast().isClosed())
							System.out.print("*");
						else
							System.out.print("|");
					}
				}
			}
			System.out.println();
		}
	}
	
	public static void printBottomRow(int row,int columnToStartAt, int columnToEndAt, Room[][] rooms) {
		for(int j = columnToStartAt; j < columnToEndAt+1; j++) {
			System.out.print("*");
			
			if(rooms[row][j].getSouth().isClosed())
				System.out.print("*");
			else
				System.out.print("-");
			
			if(j==columnToEndAt) 
				System.out.print("*");
		}
		System.out.println();
	}
	
	
	public static Maze buildMaze() {
		initiliazeRooms(maze);
		return maze;
	}

	private static void initiliazeRooms(Maze maze) {
		Room[][] roomSetup = new Room[5][5];
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				roomSetup[i][j] = new Room();
				roomSetup[i][j].initializeRoom();
			}
		}
		initiliazeDoors(roomSetup);
		setExitAndEntrance(roomSetup);
		setupPillars(roomSetup);
		setRandomRoomObjects(roomSetup);
		maze.setRooms(roomSetup);
	}
	
	
	private static void setExitAndEntrance(Room[][] roomSetup) {
		Random ran = new Random();
		
		//Setup Entrance
		int entranceColumn = ran.nextInt(5);
		int entranceRow = ran.nextInt(5);
		
		roomSetup[entranceRow][entranceColumn].setEntrance(true);
		maze.setPlayerPositionRow(entranceRow);
		maze.setPlayerPositionCol(entranceColumn);

		//Setup Exit
		int exitColumn = ran.nextInt(5);
		int exitRow = ran.nextInt(5);
		if(roomSetup[exitRow][exitColumn].isEntrance()) {
			exitColumn = ran.nextInt(5);
			exitRow = ran.nextInt(5);
			roomSetup[exitRow][exitColumn].setExit(true);
		}else {
			roomSetup[exitRow][exitColumn].setExit(true);
		}
		
	}
	
	private static void setupPillars(Room[][] roomSetup) {
		Random ran = new Random();
		
		for(int i = 0; i < 4; i++) {
			int row = ran.nextInt(5);
			int col = ran.nextInt(5);
			while(roomSetup[row][col].hasPillar() || roomSetup[row][col].isEntrance() || roomSetup[row][col].isExit()) {
				row = ran.nextInt(5);
				col = ran.nextInt(5);
			}
			roomSetup[row][col].setPillar(true);
		}
		
	}
	

	private static void setRandomRoomObjects(Room[][] roomSetup) {
		Random ran = new Random();
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				int num = ran.nextInt(100);
				roomSetup[i][j].setRoomObject(RoomObjectFactory.createRoomObject(num));
			}
		}
	}

	
	private static void initiliazeDoors(Room[][] roomSetup) {
		lockRandomDoors(roomSetup);
		lockAllBorderDoors(roomSetup);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				//Check south close north
				if(roomSetup[i][j].getSouth().isClosed() && i < 4)
					roomSetup[i+1][j].getNorth().close();
				//Check east close west
				if(roomSetup[i][j].getEast().isClosed() && j < 4)
					roomSetup[i][j+1].getWest().close();
				//Check north close south
				if(roomSetup[i][j].getNorth().isClosed() && i > 0)
					roomSetup[i-1][j].getSouth().close();
				//Check west close east
				if(roomSetup[i][j].getWest().isClosed() && j > 0)
					roomSetup[i][j-1].getEast().close();
				
			}
		}
	}
	
	private static void lockRandomDoors(Room[][] roomSetup) {
		Random ran = new Random();
		
		for(int i = 0; i < 10; i++) {
			int randomColumn = ran.nextInt(5);
			int randomRow = ran.nextInt(5);
			
			if(i < 2)
				roomSetup[randomRow][randomColumn].getNorth().close();
			else if(i > 2 && i < 5)
				roomSetup[randomRow][randomColumn].getSouth().close();
			else if(i > 5 && i < 8)
				roomSetup[randomRow][randomColumn].getEast().close();
			else
				roomSetup[randomRow][randomColumn].getWest().close();
		}
	}

	private static void lockAllBorderDoors(Room[][] roomSetup) {
		for(int i = 0; i < 5; i++) {
			roomSetup[0][i].getNorth().close();//Top rooms
			roomSetup[4][i].getSouth().close();//Bottom rooms
			roomSetup[i][0].getWest().close();//LeftSide rooms
			roomSetup[i][4].getEast().close();//RightSide rooms
		}
	}
	
	public static Maze getMaze() {
		return maze;
	}
	
}
