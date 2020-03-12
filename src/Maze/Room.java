package Maze;

import RoomObjects.RoomObject;

public class Room {
	private Door north, south, east, west;
	private boolean exit, entrance, isDiscovered = false;
	private RoomObject roomObject;
		
public void initializeRoom() {
		//North
		Door northDoor = new Door();
		this.setNorth(northDoor);
		
		//South
		Door southDoor = new Door();
		this.setSouth(southDoor);
		
		//East
		Door eastDoor = new Door();
		this.setEast(eastDoor);
		
		//West
		Door westDoor = new Door();
		this.setWest(westDoor);
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


	public String toString() {
		if(!this.isDiscovered)
			return "?";
		else {
			if(this.roomObject == null) 
				return "E";
			else if(this.entrance == true)
				return "I";
			else if(this.exit == true)
				return "O";
			else if(this.roomObject.getClass().getSuperclass().getSimpleName().equals("Monster")) 
				return "X";
			else if(this.roomObject.getClass().getSimpleName().equals("Pillar")) 
				return "W";//W for Win
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
}
