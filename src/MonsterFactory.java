
public class MonsterFactory {
	public static Monster createMonster(int choice)
	{
		switch(choice)
		{
			case 1: return new Ogre();

			case 2: return new Gremlin();

			case 3: return new Skeleton();
		}//end switch
		return null;
	}
}
