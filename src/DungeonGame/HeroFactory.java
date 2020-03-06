package DungeonGame;

public class HeroFactory {
	public static Hero createHero(int choice) 
	{
		
		switch(choice)
		{
			case 1: return new Warrior();

			case 2: return new Sorceress();

			case 3: return new Thief();
		}//end switch
		return null;
	}

}
