

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */



public class Sorceress extends Hero
{
	public final int MIN_ADD = 25;
	public final int MAX_ADD = 50;

//-----------------------------------------------------------------
    public Sorceress()
	{
		super("Sorceress", 75, 5, .7, new StatRange(25,50), .3);


    }//end constructor

//-----------------------------------------------------------------
	public void useAbility(DungeonCharacter opponent)
    {
	    int hPoints;

		hPoints = (int)(Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
		changeHitPoints(hPoints);
		System.out.println(name + " added [" + hPoints + "] points.\n"
							+ "Total hit points remaining are: "
							+ hitPoints);
		 System.out.println();

    }//end increaseHitPoints method
	public String abilityName()
	{
		return "Increase Hitpoints";
	}

//-----------------------------------------------------------------
	public void attack(DungeonCharacter opponent)
	{
		System.out.println(name + " casts a spell of fireball at " +
							opponent.getName() + ":");
		super.attack(opponent);
	}//end override of attack method

//-----------------------------------------------------------------
    
    
}//end class
