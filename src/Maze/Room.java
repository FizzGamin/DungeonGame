package Maze;

import DungeonGame.*;

public class Room {
	private Door north, south, east, west;
	private boolean exit, entrance = false;
	private RoomObject roomObject;
	
	public static void main(String[] args) {
		Room room = new Room();
		
		//North
		Door northDoor = new Door();
		room.setNorth(northDoor);
		room.north.close();
		
		//South
		Door southDoor = new Door();
		room.setSouth(southDoor);
		room.south.open();
		
		//East
		Door eastDoor = new Door();
		room.setEast(eastDoor);
		room.east.close();
		
		//West
		Door westDoor = new Door();
		room.setWest(westDoor);
		room.west.open();
		
		RoomObject roomObject = new Pillar();
		 room.setRoomObject(roomObject);
		
		System.out.print(room);
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
	
	public String centerObject() {
		if(this.roomObject == null) 
			return "E";
		else if(this.roomObject.getClass().getSuperclass().getSimpleName().equals("Monster")) 
			return "X";
		else if(this.roomObject.getClass().getSimpleName().equals("Pillar")) 
			return "W";//W for Win
		else if(this.entrance == true)
			return "I";
		else if(this.roomObject.getClass().getSimpleName().equals("Vision Potion"))
			return "V";
		else if(this.exit == true)
			return "O";
		else if(this.roomObject.getClass().getSimpleName().equals("Pit"))
			return "P";
		else if(this.roomObject.getClass().getSimpleName().equals("Healing Potion"))
			return "H";
		else
			return "M";
	}
	
	public String toString() {
		String roomToString;
		
		//North
		if(north.isClosed())
			roomToString = "***\n";
		else
			roomToString = "*-*\n";
		
		//East
		if(east.isClosed())
			roomToString += "*";
		else
			roomToString +="|";
		
		//Middle
		roomToString += centerObject();
		
		//West
		if(west.isClosed())
			roomToString += "*\n";
		else
			roomToString +="|\n";
		
		//South
		if(south.isClosed())
			roomToString += "***\n";
		else
			roomToString += "*-*\n";
		
		return roomToString;
	}
}
