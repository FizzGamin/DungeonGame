package DungeonGame;

public class Magician extends Hero {

	public Magician() {
		super("MaGiCiAn", 60, 4, .5,new StatRange(25,30), .66);
	}

	@Override
	protected String abilityName() {	
		return "dO mAgIc TrIcK";
	}

	@Override
	public void useAbility(DungeonCharacter opponent) {
		
		if(opponent.attackSpeed > 1)
			opponent.attackSpeed -= 1;
				
		System.out.println("CoNfUsEd " + opponent.name + ": nOw HaS" + opponent.attackSpeed + "spEEEd");
	}

}