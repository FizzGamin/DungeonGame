package DungeonGame;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class Pokemans extends Monster
{

    protected Pokemans()
	{ 	
		super("Pikashoe the Pokemans", 40, 8, .3, .1, new StatRange(10,50), new StatRange(10,25));
    }//end constructor
    
	public void attack(DungeonCharacter opponent)
	{
		System.out.println(name + " was chosen, it does the lightning strike at " +
							opponent.getName() + ":");
		super.attack(opponent);

	}//end override of attack


}//end class Dragon