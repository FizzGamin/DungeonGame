package Maze;

import RoomObjects.RoomObject;

public class Room {
	private Door north, south, east, west;
	private boolean exit, entrance, isDiscovered, hasPillar = false;
	private RoomObject roomObject;
		
public void initializeRoom() {
		//North
		this.setNorth(new Door());
		
		//South
		this.setSouth(new Door());
		
		//East
		this.setEast(new Door());
		
		//West
		this.setWest(new Door());
	}
	
	public Door getNorth() {
		return this.north;
	}
	
	public void setNorth(Door door) {
		this.north = door;
	}
	
	public Door getSouth() {
		return this.south;
	}
	
	public void setSouth(Door door) {
		this.south = door;
	}
	
	public Door getEast() {
		return this.east;
	}
	
	public void setEast(Door door) {
		this.east = door;
	}
	
	public Door getWest() {
		return this.west;
	}
	
	public void setWest(Door door) {
		this.west = door;
	}
	
	public RoomObject getRoomObject() {
		return this.roomObject;
	}
	
	public void setRoomObject(RoomObject roomObject) {
		this.roomObject = roomObject;
	}
	
	public boolean isExit() {
		return exit;
	}


	public void setExit(boolean exit) {
		this.exit = exit;
	}


	public boolean isEntrance() {
		return entrance;
	}


	public void setEntrance(boolean entrance) {
		this.entrance = entrance;
	}


	public boolean isDiscovered() {
		return isDiscovered;
	}


	public void setDiscovered(boolean isDiscovered) {
		this.isDiscovered = isDiscovered;
	}

	public boolean hasPillar() {
		return hasPillar;
	}

	public void setPillar(boolean hasPillar) {
		this.hasPillar = hasPillar;
	}

	public String centerObject() {
		if(!this.isDiscovered)
			return "?";
		else {
			if(this.roomObject == null) 
				return "E";
			else if(this.entrance)
				return "I";
			else if(this.exit)
				return "O";
			else if(this.hasPillar) 
				return "W";//W for Win
			else if(this.roomObject.getClass().getSuperclass().getSimpleName().equals("Monster")) 
				return "X";
			else if(this.roomObject.getClass().getSimpleName().equals("VisionPotion"))
				return "V";
			else if(this.roomObject.getClass().getSimpleName().equals("Pit"))
				return "P";
			else if(this.roomObject.getClass().getSimpleName().equals("HealingPotion"))
				return "H";
			else
				return "M";
		}
	}

	public String toString() {
		String roomToString;

		//North
		if(this.north.isClosed())
			roomToString = "***\n";
		else
			roomToString = "*-*\n";

		//West
		if(this.west.isClosed())
			roomToString += "*";
		else
			roomToString +="|";
		
		//Middle
		roomToString += centerObject();

		//East
		if(this.east.isClosed())
			roomToString += "*\n";
		else
			roomToString +="|\n";

		//South
		if(this.south.isClosed())
			roomToString += "***\n";
		else
			roomToString += "*-*\n";

		return roomToString;
	}
}
