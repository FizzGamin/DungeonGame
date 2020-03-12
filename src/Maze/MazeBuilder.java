package Maze;

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
				if(rooms[i][j].getEast().isClosed())
					System.out.print("*");
				else
					System.out.print("|");
				System.out.print(rooms[i][j]);
			}
			System.out.println();
		}
	}
	
	public static Maze buildMaze() {
		Maze maze = new Maze();
		initiliazeMaze(maze);
		
		
		return maze;
	}

	private static void initiliazeMaze(Maze maze) {
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
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				//setup all of the doors
			}
		}
		lockAllBorderDoors(roomSetup);
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
