package Dungeon;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
public class PotionTester {
	Potion visionPotion1, visionPotion2, healthPotion1, healthPotion2;
	
	@Test
	public void testReferences() {
		visionPotion1 = new VisionPotion();
		visionPotion2 = visionPotion1;
		healthPotion1 = new HealingPotion();
		healthPotion2 = healthPotion1;
		assertSame(visionPotion1, visionPotion2);
		assertSame(healthPotion1, healthPotion2);
		visionPotion2 = null;
		healthPotion2 = null;
		assertNotSame(visionPotion1, visionPotion2);
		assertNotSame(healthPotion1, healthPotion2);
	}
	@Test
	public void testNull() {
		assertNull(visionPotion1);
		assertNull(healthPotion1);
		visionPotion1 = new VisionPotion();
		healthPotion1 = new HealingPotion();
		assertNotNull(visionPotion1);
		assertNotNull(healthPotion1);
	}
	
	@Test
	public void testPotionEquality() {
		visionPotion1 = new VisionPotion();
		visionPotion2 = visionPotion1;
		healthPotion1 = new HealingPotion();
		healthPotion2 = healthPotion1;
		assertEquals(visionPotion1, visionPotion2);
		assertEquals(healthPotion2, healthPotion2);
		visionPotion2 = new VisionPotion();
		healthPotion2 = new HealingPotion();
		assertNotEquals(visionPotion1, healthPotion1);
		assertNotEquals(healthPotion2, visionPotion2);	
	}
}
