package Dungeon;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class Gremlin extends Monster
{

    protected Gremlin()
	{ 	
		super("Gnarltooth the Gremlin", 70, 5, .8, .4, new StatRange(15,30), new StatRange(20,40));
    }//end constructor
    
	public void attack(DungeonCharacter opponent)
	{
		System.out.println(name + " jabs his kris at " +
							opponent.getName() + ":");
		super.attack(opponent);

	}//end override of attack


}//end class Gremlin