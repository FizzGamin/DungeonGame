package Maze;

import java.util.Random;

import RoomObjects.RoomObjectFactory;

public class MazeBuilder {
	
	
	public static void main(String[] args) {
		Maze maze = buildMaze();
		print(maze);
		
	}
	
	public static void print(Maze maze) {
		Room[][] rooms = maze.getRooms();
		

		int column = 0;
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 5; j++) {
				if(i%2 == 0) {//Print Top
					System.out.print("*");
					
					if(rooms[column][j].getNorth().isClosed())
						System.out.print("*");
					else
						System.out.print("-");
					
					if(j == 4)
						System.out.print("*");
					
				}else {//Print Middle
					if(j == 0) {
						System.out.print("*");
						System.out.print(rooms[column][j]);
					}
					
					else{
						
						if(rooms[column][j].getEast().isClosed())
							System.out.print("*");
						else
							System.out.print("|");
						System.out.print(rooms[column][j]);
						if(j==4) {
							System.out.print("*");
						}
					}
				}
			}
			if(i%2 == 1)
				column++;
			System.out.println();
		}
		
		System.out.println("***********");
		
	}
	
	public static Maze buildMaze() {
		Maze maze = new Maze();
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
		setRandomRoomObjects(roomSetup);
		setExitAndEntrance(roomSetup);
		maze.setRooms(roomSetup);
	}
	
	
	private static void setExitAndEntrance(Room[][] roomSetup) {
		Random ran = new Random();
		
		//Setup Entrance
		int entranceColumn = ran.nextInt(5);
		int entranceRow = ran.nextInt(5);
		roomSetup[entranceRow][entranceColumn].setDiscovered(true);
		roomSetup[entranceRow][entranceColumn].setEntrance(true);

		//Setup Exit
		int exitColumn = ran.nextInt(5);
		int exitRow = ran.nextInt(5);
		if(roomSetup[exitRow][exitColumn].isEntrance()) {
			exitColumn = ran.nextInt(5);
			exitRow = ran.nextInt(5);
			roomSetup[exitRow][exitColumn].setDiscovered(true);
			roomSetup[exitRow][exitColumn].setExit(true);
		}else {
			roomSetup[exitRow][exitColumn].setDiscovered(true);
			roomSetup[exitRow][exitColumn].setExit(true);
		}
		
	}
	

	private static void setRandomRoomObjects(Room[][] roomSetup) {
		Random ran = new Random();
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				int num = ran.nextInt(4) + 1;
				roomSetup[i][j].setRoomObject(RoomObjectFactory.createRoomObject(num));
			}
		}
	}

	
	private static void initiliazeDoors(Room[][] roomSetup) {
		lockRandomDoors(roomSetup);
		lockAllBorderDoors(roomSetup);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(roomSetup[i][j].getSouth().isClosed() && i < 4)
					roomSetup[i+1][j].getNorth().close();
				if(roomSetup[i][j].getEast().isClosed() && j < 4)
					roomSetup[i][j+1].getWest().close();
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
			roomSetup[i][0].getEast().close();//LeftSide rooms
			roomSetup[i][4].getWest().close();//RightSide rooms
		}
	}
	
}
