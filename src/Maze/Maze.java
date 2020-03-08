package Maze;

public class Maze {
	private Room [][] rooms;
	private int playerPositionRow, playerPositionCol;
	
	public Maze() {
		this.playerPositionRow = 0;
		this.playerPositionCol = 0;
	}
	
	public Room[][] getRooms(){
		return rooms;
	}
	
	public void setRooms(Room[][] rooms) {
		this.rooms = rooms;
	}
	
	public void moveNorth() {
		if(this.playerPositionRow == 0 || this.rooms[playerPositionRow][playerPositionCol].getNorth().isClosed())
			System.out.println("Border reached or Door Locked");
		else
			this.playerPositionRow--;
	}
	
	public void moveSouth() {
		if(this.playerPositionRow == 4 || this.rooms[playerPositionRow][playerPositionCol].getSouth().isClosed())
			System.out.println("Border reached or Door Locked");
		else
			this.playerPositionRow++;
	}
	
	public void moveEast() {
		if(this.playerPositionCol == 0 || this.rooms[playerPositionRow][playerPositionCol].getEast().isClosed())
			System.out.println("Border reached or Door Locked");
		else
			this.playerPositionCol--;
	}
	
	public void moveWest() {
		if(this.playerPositionRow == 4 || this.rooms[playerPositionRow][playerPositionCol].getWest().isClosed())
			System.out.println("Border reached or Door Locked");
		else
			this.playerPositionCol++;
	}
	
}
