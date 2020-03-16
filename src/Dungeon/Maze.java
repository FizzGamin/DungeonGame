package Dungeon;
import Dungeon.*;

public class Maze {
	private Room [][] rooms;
	private int playerPositionRow, playerPositionCol;
	private Hero gameHero = null;
	
	public Maze() {
		this.playerPositionRow = 0;
		this.playerPositionCol = 0;
		//when creating maze, we will get reference to the current hero
		gameHero = Hero.getGameHero();
	}
	
	public Room[][] getRooms(){
		return rooms;
	}
	
	public void setRooms(Room[][] rooms) {
		this.rooms = rooms;
	}
	
	public int getPlayerPositionRow() {
		return playerPositionRow;
	}

	public void setPlayerPositionRow(int playerPositionRow) {
		this.playerPositionRow = playerPositionRow;
	}

	public int getPlayerPositionCol() {
		return playerPositionCol;
	}

	public void setPlayerPositionCol(int playerPositionCol) {
		this.playerPositionCol = playerPositionCol;
	}

	public void moveNorth() {
		if(this.rooms[playerPositionRow][playerPositionCol].getNorth().isClosed())
			System.out.println("Door Locked");
		else {
			this.playerPositionRow--;
		}
	}
	
	public void moveSouth() {
		if(this.rooms[playerPositionRow][playerPositionCol].getSouth().isClosed())
			System.out.println("Door Locked");
		else {
			this.playerPositionRow++;
		}
	}
	
	public void moveEast() {
		if(this.rooms[playerPositionRow][playerPositionCol].getEast().isClosed())
			System.out.println("Door Locked");
		else {
			this.playerPositionCol++;
		}
	}
	
	public void moveWest() {
		if(this.rooms[playerPositionRow][playerPositionCol].getWest().isClosed())
			System.out.println("Door Locked");
		else {
			this.playerPositionCol--;
		}
	}
	
}