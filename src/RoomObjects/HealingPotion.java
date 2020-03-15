package RoomObjects;

import java.util.Random;

import DungeonGame.Hero;

public class HealingPotion implements RoomObject {
	private Hero hero = Hero.getGameHero();
	
	public void usePotion(){
		Random ran = new Random();
		int randomInt = ran.nextInt(11) + 5;
		System.out.println(randomInt);
		hero.changeHitPoints(randomInt);
		hero.setNumHealingPotions(Hero.getGameHero().getNumHealingPotions() - 1);
		System.out.println(randomInt + " Hit points have been added to " + hero.getName());
	}
		
	public void pickupPotion() {
		hero.setNumHealingPotions(hero.getNumHealingPotions() + 1);
	}

	@Override
	public String getName() {
		return "Healing Potion";
	}
}
