package RoomObjects;

import Maze.*;

public class VisionPotion implements RoomObject {
	
	public static void usePotion() {
		Maze maze = MazeBuilder.getMaze();
		int row = maze.getPlayerPositionRow();
		int col = maze.getPlayerPositionCol();
		//If not near the border
		if(row > 0 && col > 0 && row < 4 && col < 4) {
			for(int i = row-1; i < row+2; i++) {
				MazeBuilder.printRow(i, col-1, col+1, maze.getRooms());
			}
			MazeBuilder.printBottomRow(row+1, col-1, col+1, maze.getRooms());
		}
		//If on top row
		else if(row == 0 && col > 0 && col < 4) {
			for(int i = row; i < row+2; i++) {
				MazeBuilder.printRow(i, col-1, col+1, maze.getRooms());
			}
			MazeBuilder.printBottomRow(row+1, col-1, col+1, maze.getRooms());
		}
		//If on bottom row
		else if(row == 4 && col > 0 && col < 4) {
			for(int i = row-1; i < row+1; i++) {
				MazeBuilder.printRow(i, col-1, col+1, maze.getRooms());
			}
			MazeBuilder.printBottomRow(row, col-1, col+1, maze.getRooms());
		}
		//If on left side wall
		else if(col == 0 && row > 0 && row < 4) {
			for(int i = row-1; i < row+2; i++) {
				MazeBuilder.printRow(i, col, col+1, maze.getRooms());
			}
			MazeBuilder.printBottomRow(row+1, col, col+1, maze.getRooms());
		}
		//If on right side wall
		else if(col == 4 && row > 0 && row < 4) {
			for(int i = row-1; i < row+2; i++) {
				MazeBuilder.printRow(i, col-1, col, maze.getRooms());
			}
			MazeBuilder.printBottomRow(row+1, col-1, col, maze.getRooms());
		}
		//If in top left corner
		else if(row == 0 && col == 0){
			for(int i = row; i < row+2; i++) {
				MazeBuilder.printRow(i, col, col+1, maze.getRooms());
			}
			MazeBuilder.printBottomRow(row+1, col, col+1, maze.getRooms());
		}
		//If in top right corner
		else if(row == 0 && col == 4){
			for(int i = row; i < row+2; i++) {
				MazeBuilder.printRow(i, col-1, col, maze.getRooms());
			}
			MazeBuilder.printBottomRow(row+1, col-1, col, maze.getRooms());
		}
		//if in bottom left corner
		else if(row == 4 && col == 0){
			for(int i = row-1; i < row+1; i++) {
				MazeBuilder.printRow(i, col, col+1, maze.getRooms());
			}
			MazeBuilder.printBottomRow(row, col, col+1, maze.getRooms());
		}
		//If in bottom right corner
		else if(row == 4 && col == 4){
			for(int i = row-1; i < row+1; i++) {
				MazeBuilder.printRow(i, col-1, col, maze.getRooms());
			}
			MazeBuilder.printBottomRow(row, col-1, col, maze.getRooms());
		}
		else {
			System.out.print("You broke the game. Player position Unkown.");
		}
	}

	@Override
	public String getName() {
		return "Vision Potion";
	}
}