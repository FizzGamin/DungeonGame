package DungeonGame;

import java.util.Random;

public class RoomObjectFactory {
	public static RoomObject createRoomObject(int choice)
	{
		if(choice < 15) {
			Random ran = new Random();
			int num = ran.nextInt(5)+1;
			return MonsterFactory.createMonster(num);
		}
		else if(choice > 15 && choice < 30)
			return new Pit();
		else if(choice > 30 && choice < 45)
			return new VisionPotion();
		else if(choice > 45 && choice < 60)
			return new HealingPotion();
		else return null;
	}
}
