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
    	printCurrentRoom(maze);
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
    	printCurrentRoom(maze);
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
battle is the actual combat portion of the game.  It requires a Hero
and a Monster to be passed in.  Battle occurs in rounds.  The Hero
goes first, then the Monster.  At the conclusion of each round, the
user has the option of quitting.
---------------------------------------------------------------------*/
	public static void battle(Hero theHero, Monster theMonster)
	{
		
		System.out.println("You have come accross a Monster, now you must battle " + theMonster.getName());
		System.out.println("---------------------------------------------");

		//do battle
		while (theHero.isAlive() && theMonster.isAlive())
		{
		    //hero goes first
			theHero.battleChoices(theMonster);

			//monster's turn (provided it's still alive!)
			if (theMonster.isAlive())
			    theMonster.attack(theHero);
		}//end battle loop

		if (!theMonster.isAlive())
		    System.out.println(theHero.getName() + " was victorious!");
		else if (!theHero.isAlive())
			System.out.println(theHero.getName() + " was defeated :-(");	
		else
			System.out.println("Need to figure out what happened");
	}//end battle method
	
	private static void checkRoomObject(Maze maze,Hero theHero) {
		String roomObject = maze.getRooms()[maze.getPlayerPositionRow()][maze.getPlayerPositionCol()].centerObject();
		if(roomObject.equals("X")) {
			Monster theMonster = (Monster) maze.getRooms()[maze.getPlayerPositionRow()][maze.getPlayerPositionCol()].getRoomObject();
			battle(theHero, theMonster);
			printCurrentRoom(maze);
		}
	}
	
	private static void printCurrentRoom(Maze maze) {
		System.out.println(maze.getRooms()[maze.getPlayerPositionRow()][maze.getPlayerPositionCol()]);
	}

}//end Dungeon class
