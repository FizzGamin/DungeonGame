import java.util.Scanner;

import Dungeon.*;

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
public class DungeonAdventure
{
	
	
    public static void main(String[] args)
	{
    	//intro
    	System.out.println("  ___ ___       ");
    	System.out.println(" /   |   \\   ___________  ____  ______    ");
    	System.out.println("/    ~    \\_/ __ \\_  __ \\/  _ \\/  ___/  ");
    	System.out.println("\\    Y    /\\  ___/|  | \\(  <_> )___ \\     and monsters tm.");
    	System.out.println(" \\___|_  /  \\___  >__|   \\____/____  >  ");
    	System.out.println("");
    	System.out.println("We hope you enjoy your stay and find all four pillars of OO");
    	System.out.println("Controls: WASD to move, or F to use a potion");
    	System.out.println("Rooms[E-Empty,X-Monster,P-Pit,V/H-Potion,W-Pillar]");
    	System.out.println("Good luck!");
    	System.out.println("");
    	
    	Hero theHero;
		
    	theHero = chooseHero();
    	
    	printHeroCurrentStats();
    	
    	VisionPotion potionForTesting = new VisionPotion();
	
    	Maze maze = MazeBuilder.buildMaze();
    	
    	System.out.println(getCurrentRoom(maze));

    	
    	Scanner sc = new Scanner(System.in);
    	
    	while(theHero.getNumPillarsFound() < 4 && !getCurrentRoom(maze).isExit()) {
    		System.out.println("");
    		System.out.println("");
    		System.out.println("");
    		System.out.println("");
    		System.out.println(getCurrentRoom(maze));
    		printHeroCurrentStats();
    		System.out.println("Move(WASD), Use Potion(F)");
    		System.out.print("Enter choice:");
	    	String move = sc.next(); 
	    	System.out.println("::::::::::::::::::::::::::::::::::::::::::::");
	    	
	    	if(move.toLowerCase().equals("w")) 
	    		maze.moveNorth();
	    	else if(move.toLowerCase().equals("a"))
	    		maze.moveWest();
	    	else if(move.toLowerCase().equals("s"))
	    		maze.moveSouth();
	    	else if(move.toLowerCase().equals("d"))
	    		maze.moveEast();
	    	else if(move.toLowerCase().equals("p")) //here is the secret button that pritns the whole map
	    		MazeBuilder.printEntireMaze(maze);
	    	else if(move.toLowerCase().equals("f"))
	    		potionForTesting.usePotion();
	    	
	    	checkRoomObject(maze);
	    	
    	}
    	
    	System.out.println("You have Completed the maze");
    	MazeBuilder.printEntireMaze(maze);
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
	public static void battle(Monster theMonster)
	{
		Hero theHero = Hero.getGameHero();
		System.out.println("---BATTLE---");
		System.out.println("You must battle " + theMonster.getName());
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
	
	private static void checkRoomObject(Maze maze) {
		String roomObjectString = getCurrentRoom(maze).centerObject();
		
		RoomObject roomObject = getCurrentRoom(maze).getRoomObject();
		
		printMessage(roomObject,maze);
		
		if(roomObjectString.equals("X")) {
			Monster theMonster = (Monster) roomObject;
			battle(theMonster);
			System.out.println(getCurrentRoom(maze));
			
		}else if(roomObjectString.equals("V") || roomObjectString.equals("H")) {
			Potion potion = (Potion)roomObject;
			potion.pickupPotion();
			potion.setAlreadyPickedUp(true);
		}else if(roomObjectString.equals("W")) {
			Hero.getGameHero().setNumPillarsFound(Hero.getGameHero().getNumPillarsFound() + 1);
		}else if(roomObjectString.equals("P")) {
			Pit pit = (Pit) roomObject;
			pit.fallInPit();
		}

	}
	
	private static void printMessage(RoomObject roomObject,Maze maze) {
		System.out.print("You have come accross ");
		if(roomObject == null)
			System.out.println("an Empty room");
		else if(getCurrentRoom(maze).hasPillar())
			System.out.println("a Pillar");
		else if(getCurrentRoom(maze).isEntrance())
			System.out.println("the entrance");
		else if(getCurrentRoom(maze).isExit())
			System.out.println("the exit");
		else
			System.out.print("a " + roomObject.getName() + "\n");
		
	}
	
	private static void printHeroCurrentStats() {
		Hero theHero = Hero.getGameHero();
		System.out.printf("%-15s|%-15s|%-15s%n","Healing Potions","Vision Potions","Pillars Found");
		System.out.printf("%-15s|%-15s|%-15s%n",theHero.getNumHealingPotions(),theHero.getNumVisionPotions(),theHero.getNumPillarsFound());
	}
	
	private static Room getCurrentRoom(Maze maze) {
		return maze.getRooms()[maze.getPlayerPositionRow()][maze.getPlayerPositionCol()];
	}

}//end Dungeon class
