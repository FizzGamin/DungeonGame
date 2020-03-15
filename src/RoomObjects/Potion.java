package RoomObjects;

public abstract class Potion implements RoomObject{
	public abstract void usePotion();
	public abstract void pickupPotion();
	public abstract void setAlreadyPickedUp(boolean alreadyPickedUp);
}
