package Dungeon;

public class Programmer extends Hero {

	public Programmer() {
		super("Programmer", 15, 6, .99,new StatRange(5,55), .25);
	}

	@Override
	protected String abilityName() {	
		return "Hack Health";
	}

	@Override
	public void useAbility(DungeonCharacter opponent) {
		
		int heroHealth = getHitPoints();
		Hero.getGameHero().setHitPoints(opponent.getHitPoints());
		opponent.setHitPoints(heroHealth);
				
		System.out.println("Successfully swapped health!");

	}

}
