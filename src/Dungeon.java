import java.util.Scanner;

import DungeonGame.*;
import Maze.*;
import RoomObjects.*;

/**
 * Title: Dungeon.java
 *
 * Description: Driver file for Heroes and Monsters project
 *
 * Copyright:    Copyright (c) 2001
 * Company: Code Dogs Inc.
 * I.M. Knurdy
 *
 * History:
 *  11/4/2001: Wrote program
 *    --created DungeonCharacter class
 *    --created Hero class
 *    --created Monster class
 *    --had Hero battle Monster
 *    --fixed attack quirks (dead monster can no longer attack)
 *    --made Hero and Monster abstract
 *    --created Warrior
 *    --created Ogre
 *    --made Warrior and Ogre battle
 *    --added battleChoices to Hero
 *    --added special skill to Warrior
 *    --made Warrior and Ogre battle
 *    --created Sorceress
 *    --created Thief
 *    --created Skeleton
 *    --created Gremlin
 *    --added game play features to Dungeon.java (this file)
 *  11/27/2001: Finished documenting program
 * version 1.0
 */



/*
  This class is the driver file for the Heroes and Monsters project.  It will
  do the following:

  1.  Allow the user to choose a hero
  2.  Randomly select a monster
  3.  Allow the hero to battle the monster

  Once a battle concludes, the user has the option of repeating the above

*/
public class Dungeon
{
	
	
    public static void main(String[] args)
	{
    	Hero theHero;
		theHero = chooseHero();
    	Maze maze = MazeBuilder.buildMaze();
    	System.out.println(maze.getRooms()[maze.getPlayerPositionRow()][maze.getPlayerPositionCol()]);
    	System.out.println("wasd to move");
    	Scanner sc = new Scanner(System.in);
    	int i = 0;
    	while(i < 100) {
    	
    	String move = sc.next();
    	
    	if(move.toLowerCase().equals("w")) {
    		maze.moveNorth();
    	}
    	else if(move.toLowerCase().equals("a"))
    		maze.moveWest();
    	else if(move.toLowerCase().equals("s"))
    		maze.moveSouth();
    	else if(move.toLowerCase().equals("d"))
    		maze.moveEast();
    	else if(move.toLowerCase().equals("p"))
    		MazeBuilder.printEntireMaze(maze);
    	else if(move.toLowerCase().equals("f"))
    		VisionPotion.usePotion();
    	System.out.println(maze.getRooms()[maze.getPlayerPositionRow()][maze.getPlayerPositionCol()]);
    	checkRoomObject(maze,theHero);
    	}
    	
    	sc.close();
    }//end main method

/*-------------------------------------------------------------------
chooseHero allows the user to select a hero, creates that hero, and
returns it.  It utilizes a polymorphic reference (Hero) to accomplish
this task
---------------------------------------------------------------------*/
	public static Hero chooseHero()
	{
		int choice = 0;
		while(choice < 1 || choice > 5)
		{	
			System.out.println("Choose a hero:\n" +
					       "1. Warrior\n" +
						   "2. Sorceress\n" +
						   "3. Programmer\n" +
						   "4. Thief\n" +
						   "5. MaGiCiAn");
		
			choice = DungeonCharacter.sc.nextInt();
		}
		
		return HeroFactory.createHero(choice);
	}//end chooseHero method

/*-------------------------------------------------------------------
generateMonster randomly selects a Monster and returns it.  It utilizes
a polymorphic reference (Monster) to accomplish this task.
---------------------------------------------------------------------*/
	public static Monster generateMonster()
	{
		int choice;

		choice = (int)(Math.random() * 5) + 1;
		
		return MonsterFactory.createMonster(choice);
	}//end generateMonster method

/*-------------------------------------------------------------------
playAgain allows gets choice from user to play another game.  It returns
true if the user chooses to continue, false otherwise.
---------------------------------------------------------------------*/
	public static boolean playAgain()
	{
		
		char again;

		System.out.println("Play again (y/n)?");
		again = DungeonCharacter.sc.next().charAt(0);
		
		return (again == 'Y' || again == 'y');
	}//end playAgain method


/*-------------------------------------------------------------------
battle is the actual combat portion of the game.  It requires a Hero
and a Monster to be passed in.  Battle occurs in rounds.  The Hero
goes first, then the Monster.  At the conclusion of each round, the
user has the option of quitting.
---------------------------------------------------------------------*/
	public static void battle(Hero theHero, Monster theMonster)
	{
		
		char quit = 'p';
		System.out.println(theHero.getName() + " battles " +
							theMonster.getName());
		System.out.println("---------------------------------------------");

		//do battle
		while (theHero.isAlive() && theMonster.isAlive() && quit != 'q')
		{
		    //hero goes first
			theHero.battleChoices(theMonster);

			//monster's turn (provided it's still alive!)
			if (theMonster.isAlive())
			    theMonster.attack(theHero);

			//let the player bail out if desired
			System.out.print("\n-->q to quit, anything else to continue: ");
			quit = DungeonCharacter.sc.next().charAt(0);

		}//end battle loop

		if (!theMonster.isAlive())
		    System.out.println(theHero.getName() + " was victorious!");
		else if (!theHero.isAlive())
			System.out.println(theHero.getName() + " was defeated :-(");
		else//both are alive so user quit the game
			System.out.println("Quitters never win ;-)");
		
	}//end battle method
	
	private static void checkRoomObject(Maze maze,Hero theHero) {
		String roomObject = maze.getRooms()[maze.getPlayerPositionRow()][maze.getPlayerPositionCol()].centerObject();
		if(roomObject.equals("X")) {
			Monster theMonster = (Monster) maze.getRooms()[maze.getPlayerPositionRow()][maze.getPlayerPositionCol()].getRoomObject();
			battle(theHero, theMonster);
		}
			
	}

}//end Dungeon class
