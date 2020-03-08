package RoomObjects;

import java.util.Random;

import DungeonGame.MonsterFactory;

public class RoomObjectFactory {
	public static RoomObject createRoomObject(int choice)
	{
		switch(choice)
		{
			case 1: Random ran = new Random();
					int num = ran.nextInt(2)+1;
					return MonsterFactory.createMonster(num);

			case 2: return new Pit();

			case 3: return new Pillar();
			
			case 4: return new VisionPotion();
			
			case 5: return new HealingPotion();
		}//end switch
		return null;
	}
}
