package Dungeon;

public abstract class Hero extends DungeonCharacter
{
	protected double chanceToBlock;
	protected int numTurns;
	protected int numHealingPotions = 0;
	protected int numVisionPotions = 0;
	protected int numPillarsFound = 0;
	protected abstract String abilityName();
	//Singleton related
	protected static Hero gameHero = null;
	
	public static Hero getGameHero() {
		return gameHero;
	}
	
	public static void setGameHero(Hero newHero) {
		gameHero = newHero;
	}
	
	public abstract void useAbility(DungeonCharacter opponent);
//-----------------------------------------------------------------
//calls base constructor and gets name of hero from user
  public Hero(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, StatRange damageRange,
					 double chanceToBlock)
  {
	super(name, hitPoints, attackSpeed, chanceToHit, damageRange);
	this.chanceToBlock = chanceToBlock;
	gameHero = this;
	readName();
  }
  
/*-------------------------------------------------------
readName obtains a name for the hero from the user
---------------------------------------------------------*/
  public void readName()
  {
	  	
		System.out.print("Enter character name: ");
		name = DungeonCharacter.sc.next();
		
  }//end readName method

/*-------------------------------------------------------
defend determines if hero blocks attack
---------------------------------------------------------*/
  public boolean defend()
  {
		return Math.random() <= chanceToBlock;

  }//end defend method

/*-------------------------------------------------------
subtractHitPoints checks to see if hero blocked attack, if so a message
is displayed, otherwise base version of this method is invoked to
perform the subtraction operation.  This method overrides the method
inherited from DungeonCharacter promoting polymorphic behavior
---------------------------------------------------------*/
public void changeHitPoints(int hitPoints)
	{
		if (defend())
		{
			System.out.println(name + " BLOCKED the attack!");
		}
		else
		{
			super.changeHitPoints(hitPoints);
		}


	}//end method

/*-------------------------------------------------------
battleChoices will be overridden in derived classes.  It computes the
number of turns a hero will get per round based on the opponent that is
being fought. All hero's will call this for their battle choices
---------------------------------------------------------*/
	public void battleChoices(DungeonCharacter opponent)
	{
	    numTurns = attackSpeed/opponent.getAttackSpeed();

		if (numTurns == 0)
			numTurns++;

		System.out.println("Number of turns this round is: " + numTurns);
		int choice;

		while(numTurns > 0 && hitPoints > 0 && opponent.getHitPoints() > 0){
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. "+ abilityName());
		    System.out.print("Choose an option: ");
		    choice = DungeonCharacter.sc.nextInt();

		    switch (choice)
		    {
			    case 1: attack(opponent);
			        break;
			    case 2: useAbility(opponent);
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

			numTurns--;
		    if (numTurns > 0)
			    System.out.println("Number of turns remaining is: " + numTurns);

		};
		
    }//end overridden method
	
	public int getNumHealingPotions() {
		return numHealingPotions;
	}
	public void setNumHealingPotions(int numHealingPotions) {
		this.numHealingPotions = numHealingPotions;
	}
	public int getNumVisionPotions() {
		return numVisionPotions;
	}
	public void setNumVisionPotions(int numVisionPotions) {
		this.numVisionPotions = numVisionPotions;
	}
	public int getNumPillarsFound() {
		return numPillarsFound;
	}
	public void setNumPillarsFound(int numPillarsFound) {
		this.numPillarsFound = numPillarsFound;
	}
	

}//end Hero class
