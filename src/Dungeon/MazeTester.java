package Dungeon;

import static org.junit.jupiter.api.Assertions.*;

import org.hamcrest.core.IsInstanceOf;
import org.junit.jupiter.api.Test;

class MazeTester {

	@Test
	void testRoomObjectCount() {
		Maze maze = MazeBuilder.buildMaze();
		Room[][] rooms = maze.getRooms();
		int pillarCount = 0, entranceCount = 0, exitCount = 0, roomObjectCount = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(rooms[i][j].isEntrance())
					entranceCount++;
				if(rooms[i][j].isExit())
					exitCount++;
				if(rooms[i][j].hasPillar())
					pillarCount++;
				if(rooms[i][j].getRoomObject() instanceof Monster || rooms[i][j].getRoomObject() instanceof Pit
						|| rooms[i][j].getRoomObject() instanceof Potion)
					roomObjectCount++;
			}
		  }
		assertNotEquals(0, roomObjectCount);
		assertEquals(1, entranceCount);
		assertEquals(1, exitCount);
		assertEquals(4, pillarCount);
	}
	
}



