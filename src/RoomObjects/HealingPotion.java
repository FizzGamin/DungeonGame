package RoomObjects;

import java.util.Random;

import DungeonGame.Hero;

public class HealingPotion extends Potion {
	private Hero hero = Hero.getGameHero();
	private boolean alreadyPickedUp = false;
	
	public void usePotion(){
		Random ran = new Random();
		int randomInt = ran.nextInt(11) + 5;
		System.out.println(randomInt);
		hero.changeHitPoints(randomInt);
		hero.setNumHealingPotions(Hero.getGameHero().getNumHealingPotions() - 1);
		System.out.println(randomInt + " Hit points have been added to " + hero.getName());
	}
		
	public void pickupPotion() {
		if(!this.alreadyPickedUp) {
			hero.setNumHealingPotions(hero.getNumHealingPotions() + 1);
			setAlreadyPickedUp(true);
		}
	}
	
	public boolean isAlreadyPickedUp() {
		return alreadyPickedUp;
	}

	public void setAlreadyPickedUp(boolean alreadyPickedUp) {
		this.alreadyPickedUp = alreadyPickedUp;
	}

	@Override
	public String getName() {
		return "Healing Potion";
	}
}
