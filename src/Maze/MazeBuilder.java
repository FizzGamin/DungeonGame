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

	private void initiliazeDoors(Room[][] roomSetup) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				//setup all of the doors
			}
		}
	}

}
