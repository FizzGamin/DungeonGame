package Maze;

import java.util.Random;

public class MazeBuilder {
	
	
	public static void main(String[] args) {
		Maze maze = buildMaze();
		print(maze);
		
	}
	
	public static void print(Maze maze) {
		Room[][] rooms = maze.getRooms();
		
		System.out.println("*********");
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(j < 4) {
					if(rooms[i][j].getEast().isClosed())
						System.out.print("*");
					else
						System.out.print("|");	
					System.out.print(rooms[i][j]);//Print room object
				}else {
					if(rooms[i][j].getWest().isClosed())
						System.out.print("*");
					else
						System.out.print("|");
				}
			}
			System.out.println();
		}
		
		System.out.println("*********");
		
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
		maze.setRooms(roomSetup);
	}
	
	

	//Needs Work
	private static void initiliazeDoors(Room[][] roomSetup) {
		lockRandomDoors(roomSetup);
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				
			}
		}
		lockAllBorderDoors(roomSetup);
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
