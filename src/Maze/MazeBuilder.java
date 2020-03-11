package Maze;

public class MazeBuilder {
	
	public Maze buildMaze() {
		Maze maze = new Maze();
		initiliazeMaze(maze);
		
		
		return maze;
	}

	private void initiliazeMaze(Maze maze) {
		Room[][] roomSetup = new Room[5][5];
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				roomSetup[i][j] = new Room();
			}
		}
		initiliazeDoors(roomSetup);
		maze.setRooms(roomSetup);
	}

	//Needs Work
	private void initiliazeDoors(Room[][] roomSetup) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				//setup all of the doors
			}
		}
		lockAllBorderDoors(roomSetup);
	}

	private void lockAllBorderDoors(Room[][] roomSetup) {
		for(int i = 0; i < 5; i++) {
			roomSetup[0][i].getNorth().close();//Top rooms
			roomSetup[4][i].getSouth().close();//Bottom rooms
			roomSetup[i][0].getEast().close();//LeftSide rooms
			roomSetup[i][4].getWest().close();//RightSide rooms
		}
	}
	
}
