package DungeonGame;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class Dragon extends Monster
{

    protected Dragon()
	{ 	
		super("Darrin the Dragon", 180, 2, .6, .33, new StatRange(30,50), new StatRange(10,60));
    }//end constructor
    
	public void attack(DungeonCharacter opponent)
	{
		System.out.println(name + " unleashes it's fire breathe at " +
							opponent.getName() + ":");
		super.attack(opponent);

	}//end override of attack


}//end class Dragon