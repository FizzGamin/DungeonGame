package Dungeon;

public class HeroFactory {
	public static Hero createHero(int choice) 
	{
		
		switch(choice)
		{
			case 1: return new Warrior();
			case 2: return new Sorceress();
			case 3: return new Programmer();
			case 4: return new Thief();
			case 5: return new Magician();
		}//end switch
		return null;
	}

}
