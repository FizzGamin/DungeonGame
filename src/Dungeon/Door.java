package Dungeon;

public class Door {
	private boolean closed = false;
	
	public boolean isClosed() {
		return this.closed;
	}
	
	public void open() {
		this.closed = false;
	}
	public void close() {
		this.closed = true;
	}
}
