package Dungeon;

import java.util.Scanner;

/**
 * Title: DungeonCharacter.java
 *
 * Description: Abstract Base class for inheritance hierarchy for a
 *              role playing game
 *
 *  class variables (all will be directly accessible from derived classes):
 *    name (name of character)
 *    hitPoints (points of damage a character can take before killed)
 *    attackSpeed (how fast the character can attack)
 *    chanceToHit (chance an attack will strike the opponent)
 *    damageMin, damageMax (range of damage the character can inflict on
 *     opponent)
 *
 *  class methods (all are directly accessible by derived classes):
 *    DungeonCharacter(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax)
	  public String getName()
	  public int getHitPoints()
	  public int getAttackSpeed()
	  public void addHitPoints(int hitPoints)
	  public void subtractHitPoints(int hitPoints) -- this method will be
	    overridden
	  public boolean isAlive()
	  public void attack(DungeonCharacter opponent) -- this method will be
	    overridden
 *
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public abstract class DungeonCharacter implements Comparable<DungeonCharacter>
{

	public static final Scanner sc = new Scanner(System.in);
	protected String name;
	protected int hitPoints;
	protected int attackSpeed;
	protected double chanceToHit;
	private StatRange damageRange;

	public int compareTo(DungeonCharacter dc)
	{  //compares speed between characters
		return getAttackSpeed() - dc.getAttackSpeed();
	}

//-----------------------------------------------------------------
//explicit constructor to initialize instance variables -- it is called
// by derived classes
	public DungeonCharacter(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, StatRange damageRange)
	{

		this.name = name;
		this.hitPoints = hitPoints;
		this.attackSpeed = attackSpeed;
		this.chanceToHit = chanceToHit;
		this.damageRange = damageRange;

	}//end constructor

//-----------------------------------------------------------------
	public String getName()
	{
		return name;
	}//end getName

//-----------------------------------------------------------------
	public int getHitPoints()
	{
		return hitPoints;
	}//end getHitPoints
	public void setHitPoints(int newHealth)
	{
		hitPoints = newHealth;
	}
//-----------------------------------------------------------------
	public int getAttackSpeed()
	{
		return attackSpeed;
	}//end getAttackSpeed


	public void changeHitPoints(int hitPoints) {
		this.hitPoints += hitPoints;
		if(this.hitPoints < 0)
			this.hitPoints = 0;
		if(hitPoints < 0) {
			System.out.println(getName() + " hit " +
					" for <" + Math.abs(hitPoints) + "> points damage.");
			System.out.println(getName() + " now has " +
					getHitPoints() + " hit points remaining.");
			System.out.println();
		}
		if (this.hitPoints == 0)
			System.out.println(name + " has been killed :-(");
	}

    public boolean isAlive()
	{
	  return (hitPoints > 0);
	}//end isAlive method

/*-------------------------------------------------------
attack allows character to attempt attack on opponent.  First, chance to hit
is considered.  If a hit can occur, then the damage is calculated based on
character's damage range.  This damage is then applied to the opponenet.
---------------------------------------------------------*/
	public void attack(DungeonCharacter opponent)
	{
		boolean canAttack;
		int damage;

		canAttack = Math.random() <= chanceToHit;

		if (canAttack)
		{
			damage = (int)(Math.random() * (damageRange.max - damageRange.min + 1))
						+ damageRange.min ;
			opponent.changeHitPoints(-damage);



			System.out.println();
		}//end if can attack
		else
		{

			System.out.println(getName() + "'s attack on " + opponent.getName() +
								" failed!");
			System.out.println();
		}//end else

	}//end attack method

//-----------------------------------------------------------------



}//end class Character