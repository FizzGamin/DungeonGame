package DungeonGame;

public class MonsterFactory {
	public static Monster createMonster(int choice)
	{
		switch(choice)
		{
			case 1: return new Ogre();
			case 2: return new Gremlin();
			case 3: return new Skeleton();
			case 4: return new Dragon();
			case 5: return new Pokemans();
			
		}//end switch
		return null;
	}
}
