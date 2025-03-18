package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.Point;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import model.buildings.Barracks;
import model.buildings.Building;
import model.buildings.Palace;
import model.buildings.Tower;
import model.buildings.Wall;
import model.units.Archer;
import model.units.Assassin;
import model.units.Cavalry;
import model.units.Diplomat;
import model.units.Footman;
import model.units.Hero;
import model.units.Monk;
import model.units.SupportUnit;
import model.units.Unit;
import model.units.Warchief;
import model.world.BuildingCell;
import model.world.Cell;
import model.world.EmptyCell;
import model.world.ResourceCell;
import model.world.ResourceType;
import model.world.UnitCell;
import model.world.Upgradeable;

import org.junit.Test;

import engine.Game;
import engine.Player;
import exceptions.InvalidActionException;
import exceptions.InvalidTargetException;
import exceptions.NoAvailableResourcesException;
import exceptions.NotEnoughActionsException;

@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
public class M2PublicTests {

	@Test(timeout = 3000)
	public void testUpgradeExistsUpgradeable() {
		Method m = null;
		try {

			m = Upgradeable.class.getDeclaredMethod("upgrade");
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Upgradeable\" should contain a method called \"upgrade\" that takes no parameters.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(),
					false);
		}
		assertTrue(
				"Method \"upgrade\" in class \"Upgradeable\" should be void.",
				m.getReturnType().equals(void.class));
	}

	@Test(timeout = 3000)
	public void testUpgradeExistsBuilding() {
		Method m = null;
		try {

			m = Building.class.getDeclaredMethod("upgrade");
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Building\" should contain a method called \"upgrade\" that takes no parameters.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(),
					false);
		}
		assertTrue("Method \"upgrade\" in class \"Building\" should be void.",
				m.getReturnType().equals(void.class));
	}

	@Test(timeout = 3000)
	public void testUpgradeExistsSupportUnit() {
		Method m = null;
		try {
			m = SupportUnit.class.getDeclaredMethod("upgrade");
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"SupportUnit\" should contain a method called \"upgrade\" that takes no parameters.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(),
					false);
		}
		assertTrue(
				"Method \"upgrade\" in class \"SupportUnit\" should be void.",
				m.getReturnType().equals(void.class));
	}

	@Test(timeout = 3000)
	public void testUpgradeSupportUnitMaxLevel() {
		Cavalry c = new Cavalry();
		try {
			Method m = SupportUnit.class.getDeclaredMethod("setLevel",
					int.class);
			m.invoke(c, 3);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e2) {
			assertTrue("The SupportUnit class should have a setLevel method",
					false);
			e2.printStackTrace();
		}
		try {
			Method m2 = SupportUnit.class.getMethod("upgrade");
			m2.invoke(c);
			fail("Support Units cannot be upgraded above level 3, an InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Support Units cannot be upgraded above level 3, an InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeSupportUnitMaxLevel2() {
		Archer c = new Archer();
		try {
			Method m = SupportUnit.class.getDeclaredMethod("setLevel",
					int.class);
			m.invoke(c, 3);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e2) {
			assertTrue("The SupportUnit class should have a setLevel method",
					false);
			e2.printStackTrace();
		}
		try {
			Method m2 = SupportUnit.class.getMethod("upgrade");
			m2.invoke(c);
			fail("Support Units cannot be upgraded above level 3, an InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Support Units cannot be upgraded above level 3, an InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeSupportUnitMaxLevel3() {
		Footman c = new Footman();
		try {
			Method m = SupportUnit.class.getDeclaredMethod("setLevel",
					int.class);
			m.invoke(c, 3);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e2) {
			assertTrue("The SupportUnit class should have a setLevel method",
					false);
			e2.printStackTrace();
		}
		try {
			Method m2 = SupportUnit.class.getMethod("upgrade");
			m2.invoke(c);
			fail("Support Units cannot be upgraded above level 3, an InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Support Units cannot be upgraded above level 3, an InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeBuildingMaxLevel() {
		Barracks c = new Barracks();
		try {
			Method m = Building.class.getDeclaredMethod("setLevel", int.class);
			m.invoke(c, 3);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e2) {
			assertTrue("The SupportUnit class should have a setLevel method",
					false);
			e2.printStackTrace();
		}
		try {
			Method m2 = Building.class.getMethod("upgrade");
			m2.invoke(c);
			fail("Support Units cannot be upgraded above level 3, an InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Support Units cannot be upgraded above level 3, an InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeBuildingMaxLevel2() {
		Palace c = new Palace();
		try {
			Method m = Building.class.getDeclaredMethod("setLevel", int.class);
			m.invoke(c, 3);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e2) {
			assertTrue("The SupportUnit class should have a setLevel method",
					false);
			e2.printStackTrace();
		}
		try {
			Method m2 = Building.class.getMethod("upgrade");
			m2.invoke(c);
			fail("Support Units cannot be upgraded above level 3, an InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Support Units cannot be upgraded above level 3, an InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeBuildingMaxLevel3() {
		Wall c = new Wall();
		try {
			Method m = Building.class.getDeclaredMethod("setLevel", int.class);
			m.invoke(c, 3);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e2) {
			assertTrue("The SupportUnit class should have a setLevel method",
					false);
			e2.printStackTrace();
		}
		try {
			Method m2 = Building.class.getMethod("upgrade");
			m2.invoke(c);
			fail("Support Units cannot be upgraded above level 3, an InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Support Units cannot be upgraded above level 3, an InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeBuildingMaxLevel4() {
		Tower c = new Tower();
		try {
			Method m = Building.class.getDeclaredMethod("setLevel", int.class);
			m.invoke(c, 3);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e2) {
			assertTrue("The SupportUnit class should have a setLevel method",
					false);
			e2.printStackTrace();
		}
		try {
			Method m2 = Building.class.getMethod("upgrade");
			m2.invoke(c);
			fail("Support Units cannot be upgraded above level 3, an InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Support Units cannot be upgraded above level 3, an InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeBarracks() {
		Barracks c = new Barracks();
		try {
			Method m2 = Building.class.getMethod("upgrade");
			m2.invoke(c);
			int level = 2;
			String[] names = { "level" };
			Object[] values = { 2 };
			checkValuesUpgrade(c, names, values, level);
			m2.invoke(c);
			level = 3;
			Object[] values2 = { 3 };
			checkValuesUpgrade(c, names, values2, level);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeTower() {
		Tower c = new Tower();
		try {
			Method m2 = Building.class.getMethod("upgrade");
			m2.invoke(c);
			int level = 2;
			String[] names = { "level", "range" };
			Object[] values = { 2, 4 };
			checkValuesUpgrade(c, names, values, level);
			m2.invoke(c);
			level = 3;
			Object[] values2 = { 3, 5 };
			checkValuesUpgrade(c, names, values2, level);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeWall() {
		Wall c = new Wall();
		int x = (int) (Math.random() * 500);
		try {
			Method m3 = Building.class.getMethod("setCurrentHp", int.class);
			m3.invoke(c, x);
			Method m2 = Building.class.getMethod("upgrade");
			m2.invoke(c);
			int level = 2;
			String[] names = { "level", "maxHp", "currentHp" };
			Object[] values = { 2, 750, x + 250 };
			checkValuesUpgrade(c, names, values, level);
			m2.invoke(c);
			level = 3;
			Object[] values2 = { 3, 1000, x + 500 };
			checkValuesUpgrade(c, names, values2, level);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradePalace() {
		Palace c = new Palace();
		int x = (int) (Math.random() * 1000);
		try {
			Method m3 = Building.class.getMethod("setCurrentHp", int.class);
			m3.invoke(c, x);
			Method m2 = Building.class.getMethod("upgrade");
			m2.invoke(c);
			int level = 2;
			String[] names = { "level", "maxHp", "currentHp" };
			Object[] values = { 2, 1500, x + 500 };
			checkValuesUpgrade(c, names, values, level);
			m2.invoke(c);
			level = 3;
			Object[] values2 = { 3, 2000, x + 1000 };
			checkValuesUpgrade(c, names, values2, level);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeFootman() {
		Footman c = new Footman();
		int x = (int) (Math.random() * 200);
		try {
			Method m3 = SupportUnit.class.getMethod("setCurrentHp", int.class);
			m3.invoke(c, x);
			Method m2 = SupportUnit.class.getMethod("upgrade");
			m2.invoke(c);
			int level = 2;
			String[] names = { "level", "maxHp", "currentHp" };
			Object[] values = { 2, 250, x + 50 };
			checkValuesUpgrade(c, names, values, level);
			m2.invoke(c);
			level = 3;
			Object[] values2 = { 3, 300, x + 100 };
			checkValuesUpgrade(c, names, values2, level);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeArcher() {
		Archer c = new Archer();
		try {
			Method m2 = SupportUnit.class.getMethod("upgrade");
			m2.invoke(c);
			int level = 2;
			String[] names = { "level", "range" };
			Object[] values = { 2, 4 };
			checkValuesUpgrade(c, names, values, level);
			m2.invoke(c);
			level = 3;
			Object[] values2 = { 3, 5 };
			checkValuesUpgrade(c, names, values2, level);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeCavalry() {
		Cavalry c = new Cavalry();
		int x = (int) (Math.random() * 3);
		try {
			Method m3 = Unit.class.getMethod("setActionsAvailable", int.class);
			m3.invoke(c, x);
			Method m2 = SupportUnit.class.getMethod("upgrade");
			m2.invoke(c);
			int level = 2;
			String[] names = { "level", "maxActions", "actionsAvailable" };
			Object[] values = { 2, 4, x + 1 };
			checkValuesUpgrade(c, names, values, level);
			m2.invoke(c);
			level = 3;
			Object[] values2 = { 3, 5, x + 2 };
			checkValuesUpgrade(c, names, values2, level);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testUseSpecialExistsHero() {
		Method m = null;
		try {

			m = Hero.class.getDeclaredMethod("useSpecial", SupportUnit.class);
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Hero\" should contain a method called \"useSpecial\" that takes a SupportUnit as a parameter.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(),
					false);
		}
		assertTrue(
				"Method \"useSpecial\" in class \"Hero\" should be abstract.",
				Modifier.isAbstract(m.getModifiers()));
		assertTrue("Method \"useSpecial\" in class \"Hero\" should be void.", m
				.getReturnType().equals(void.class));
	}

	@Test(timeout = 3000)
	public void testUseSpecialAssassin() {
		Assassin a = new Assassin("Hero", 100, 3, 3, 1);
		Cavalry c = new Cavalry();
		try {
			Method m2 = Hero.class.getMethod("useSpecial", SupportUnit.class);
			m2.invoke(a, c);
			assertEquals("The use of the " + a.getClass().getSimpleName()
					+ "'s special action should set the instance variable \""
					+ "specialActionCooldown" + "\" correctly.",
					a.getSpecialActionCooldown(), 3);
			assertEquals("The use of the " + a.getClass().getSimpleName()
					+ "'s special action should set the instance variable \""
					+ "currentHp" + "\" of the affected unit correctly.",
					c.getCurrentHp(), 0);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testUseSpecialMonk() {
		Monk a = new Monk("Hero", 100, 3, 3);
		Cavalry c = new Cavalry();
		c.setCurrentHp(((int) (Math.random() * 100)));
		try {
			Method m2 = Hero.class.getMethod("useSpecial", SupportUnit.class);
			m2.invoke(a, c);
			assertEquals("The use of the " + a.getClass().getSimpleName()
					+ "'s special action should set the instance variable \""
					+ "specialActionCooldown" + "\" correctly.",
					a.getSpecialActionCooldown(), 2);
			assertEquals("The use of the " + a.getClass().getSimpleName()
					+ "'s special action should set the instance variable \""
					+ "currentHp" + "\" of the affected unit correctly.",
					c.getCurrentHp(), c.getMaxHp());
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testUseSpecialWarchiefOnCav() {
		Warchief a = new Warchief("Hero", 100, 3, 3, 1);
		Cavalry c = new Cavalry();
		try {
			Method m2 = Hero.class.getMethod("useSpecial", SupportUnit.class);
			m2.invoke(a, c);
			assertEquals("The use of the " + a.getClass().getSimpleName()
					+ "'s special action should set the instance variable \""
					+ "specialActionCooldown" + "\" correctly.",
					a.getSpecialActionCooldown(), 3);
			String[] names = { "level", "maxActions", "actionsAvailable" };
			Object[] values = { 3, 5, 5 };
			checkValuesUpgrade(c, names, values, 2);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testUseSpecialWarchiefOnFootman() {
		Warchief a = new Warchief("Hero", 100, 3, 3, 1);
		Footman c = new Footman();
		try {
			Method m2 = Hero.class.getMethod("useSpecial", SupportUnit.class);
			m2.invoke(a, c);
			assertEquals("The use of the " + a.getClass().getSimpleName()
					+ "'s special action should set the instance variable \""
					+ "specialActionCooldown" + "\" correctly.",
					a.getSpecialActionCooldown(), 3);
			String[] names = { "level", "maxHp", "currentHp" };
			Object[] values = { 3, 300, 300 };

			checkValuesUpgrade(c, names, values, 2);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testUseSpecialWarchiefOnArcher() {
		Warchief a = new Warchief("Hero", 100, 3, 3, 1);
		Archer c = new Archer();
		try {
			Method m2 = Hero.class.getMethod("useSpecial", SupportUnit.class);
			m2.invoke(a, c);
			assertEquals("The use of the " + a.getClass().getSimpleName()
					+ "'s special action should set the instance variable \""
					+ "specialActionCooldown" + "\" correctly.",
					a.getSpecialActionCooldown(), 3);
			String[] names = { "level", "range" };
			Object[] values = { 3, 5 };

			checkValuesUpgrade(c, names, values, 2);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testUseSpecialDiplomat() {

		Diplomat a = new Diplomat("Hero", 100, 3, 3);
		Archer c = new Archer();
		try {
			Method m2 = Hero.class.getMethod("useSpecial", SupportUnit.class);
			m2.invoke(a, c);
			assertEquals("The use of the " + a.getClass().getSimpleName()
					+ "'s special action should set the instance variable \""
					+ "specialActionCooldown" + "\" correctly.",
					a.getSpecialActionCooldown(), 4);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testRecruitExistsBarracks() {
		Method m = null;
		try {

			m = Barracks.class.getDeclaredMethod("recruit", String.class);
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Barracks\" should contain a method called \"recruit\" that takes a String as a parameter.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(),
					false);
		}
		assertTrue(
				"Method \"useSpecial\" in class \"Barracks\" should be SupportUnit.",
				m.getReturnType().equals(SupportUnit.class));
	}

	@Test(timeout = 3000)
	public void testBarracksRecruitInvalid() {

		Barracks c = new Barracks();
		c.setCanRecruit(false);
		try {
			Method m2 = Barracks.class.getMethod("recruit", String.class);
			Object o = m2.invoke(c, "Cavalry");
			fail("Barracks can only recruit once per turn, an InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Barracks can only recruit once per turn, an InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testBarracksRecruitCav1() {

		Barracks c = new Barracks();
		try {
			Method m2 = Barracks.class.getMethod("recruit", String.class);
			Object o = m2.invoke(c, "Cavalry");
			assertEquals(
					"Whenever a barracks recruits per turn, it should no longer be able to recruit correctly.",
					c.isCanRecruit(), false);
			assertEquals(
					"A Barracks should recruit a unit type according to the passed input",
					"Cavalry", o.getClass().getSimpleName());
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testBarracksRecruitCav2() {

		Barracks c = new Barracks();
		c.setLevel(2);
		try {
			Method m2 = Barracks.class.getMethod("recruit", String.class);
			Object o = m2.invoke(c, "Cavalry");
			assertEquals(
					"Whenever a barracks recruits per turn, it should no longer be able to recruit correctly.",
					c.isCanRecruit(), false);
			assertEquals(
					"A Barracks should recruit a unit type according to the passed input",
					"Cavalry", o.getClass().getSimpleName());
			String[] names = { "level", "maxActions", "actionsAvailable" };
			Object[] values = { 2, 4, 4 };
			checkValuesUpgradeBarracks(o, names, values, 2);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testBarracksRecruitCav3() {

		Barracks c = new Barracks();
		c.setLevel(3);
		try {
			Method m2 = Barracks.class.getMethod("recruit", String.class);
			Object o = m2.invoke(c, "Cavalry");
			assertEquals(
					"Whenever a barracks recruits per turn, it should no longer be able to recruit correctly.",
					c.isCanRecruit(), false);
			assertEquals(
					"A Barracks should recruit a unit type according to the passed input",
					"Cavalry", o.getClass().getSimpleName());
			String[] names = { "level", "maxActions", "actionsAvailable" };
			Object[] values = { 3, 5, 5 };
			checkValuesUpgradeBarracks(o, names, values, 3);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testBarracksRecruitArcher1() {

		Barracks c = new Barracks();
		try {
			Method m2 = Barracks.class.getMethod("recruit", String.class);
			Object o = m2.invoke(c, "Archer");
			assertEquals(
					"Whenever a barracks recruits per turn, it should no longer be able to recruit correctly.",
					c.isCanRecruit(), false);
			assertEquals(
					"A Barracks should recruit a unit type according to the passed input",
					"Archer", o.getClass().getSimpleName());
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testBarracksRecruitArcher2() {

		Barracks c = new Barracks();
		c.setLevel(2);
		try {
			Method m2 = Barracks.class.getMethod("recruit", String.class);
			Object o = m2.invoke(c, "Archer");
			assertEquals(
					"Whenever a barracks recruits per turn, it should no longer be able to recruit correctly.",
					c.isCanRecruit(), false);
			assertEquals(
					"A Barracks should recruit a unit type according to the passed input",
					"Archer", o.getClass().getSimpleName());
			String[] names = { "level", "range" };
			Object[] values = { 2, 4 };
			checkValuesUpgradeBarracks(o, names, values, 2);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testBarracksRecruitArcher3() {

		Barracks c = new Barracks();
		c.setLevel(3);
		try {
			Method m2 = Barracks.class.getMethod("recruit", String.class);
			Object o = m2.invoke(c, "Archer");
			assertEquals(
					"Whenever a barracks recruits per turn, it should no longer be able to recruit correctly.",
					c.isCanRecruit(), false);
			assertEquals(
					"A Barracks should recruit a unit type according to the passed input",
					"Archer", o.getClass().getSimpleName());
			String[] names = { "level", "range" };
			Object[] values = { 3, 5 };
			checkValuesUpgradeBarracks(o, names, values, 3);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testBarracksRecruitFootman1() {

		Barracks c = new Barracks();
		try {
			Method m2 = Barracks.class.getMethod("recruit", String.class);
			Object o = m2.invoke(c, "Footman");
			assertEquals(
					"Whenever a barracks recruits per turn, it should no longer be able to recruit correctly.",
					c.isCanRecruit(), false);
			assertEquals(
					"A Barracks should recruit a unit type according to the passed input",
					"Footman", o.getClass().getSimpleName());
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testBarracksRecruitFootman2() {

		Barracks c = new Barracks();
		c.setLevel(2);
		try {
			Method m2 = Barracks.class.getMethod("recruit", String.class);
			Object o = m2.invoke(c, "Footman");
			assertEquals(
					"Whenever a barracks recruits per turn, it should no longer be able to recruit correctly.",
					c.isCanRecruit(), false);
			assertEquals(
					"A Barracks should recruit a unit type according to the passed input",
					"Footman", o.getClass().getSimpleName());
			String[] names = { "level", "maxHp", "currentHp" };
			Object[] values = { 2, 250, 250 };
			checkValuesUpgradeBarracks(o, names, values, 2);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testBarracksRecruitFootman3() {

		Barracks c = new Barracks();
		c.setLevel(3);
		try {
			Method m2 = Barracks.class.getMethod("recruit", String.class);
			Object o = m2.invoke(c, "Footman");
			assertEquals(
					"Whenever a barracks recruits per turn, it should no longer be able to recruit correctly.",
					c.isCanRecruit(), false);
			assertEquals(
					"A Barracks should recruit a unit type according to the passed input",
					"Footman", o.getClass().getSimpleName());
			String[] names = { "level", "maxHp", "currentHp" };
			Object[] values = { 3, 300, 300 };
			checkValuesUpgradeBarracks(o, names, values, 2);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeUnitExistsInPlayer() {
		Method m = null;
		try {
			m = Player.class
					.getDeclaredMethod("upgradeUnit", SupportUnit.class);
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Player\" should have the method called \"upgradeUnit\" that takes a SupportUnit as a parameter.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(),
					false);
		}
		assertTrue(
				"Method \"upgradeUnit\" in class \"Player\" should be void.", m
						.getReturnType().equals(void.class));
	}

	@Test(timeout = 3000)
	public void testUpgradeUnitInPlayerNoManpower() {
		Player p = new Player("Hobala");
		p.setManpowerAmount(0);
		SupportUnit c = new Cavalry();
		p.getUnits().add(c);
		Method m;
		try {
			m = Player.class.getMethod("upgradeUnit", SupportUnit.class);
			m.invoke(p, c);
			fail("Not enough manpower available with player for upgrade, a NoAvailableResourcesException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(NoAvailableResourcesException.class.equals(e.getCause()
					.getClass())))
				fail("Not enough manpower available with player for upgrade, a NoAvailableResourcesException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeUnitInPlayerNoManpower2() {
		Player p = new Player("Hobala");
		p.setManpowerAmount(99);
		SupportUnit c = new Cavalry();
		c.setLevel(2);
		p.getUnits().add(c);
		Method m;
		try {
			m = Player.class.getMethod("upgradeUnit", SupportUnit.class);
			m.invoke(p, c);
			fail("Not enough manpower available with player for upgrade to level 3, a NoAvailableResourcesException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(NoAvailableResourcesException.class.equals(e.getCause()
					.getClass())))
				fail("Not enough manpower available with player for upgrade to level 3, a NoAvailableResourcesException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeUnitInPlayerNotPlayerSupportUnit() {
		Player p = new Player("Hobala");
		p.setManpowerAmount(1500);
		SupportUnit c = new Cavalry();
		Method m;
		try {
			m = Player.class.getMethod("upgradeUnit", SupportUnit.class);
			m.invoke(p, c);
			fail("Player can only upgrade his units, an InvalidTargetException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidTargetException.class.equals(e.getCause().getClass())))
				fail("Player can only upgrade his units, an InvalidTargetException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeUnitInPlayer() throws InvalidActionException {
		Player p = new Player("Hobala");
		int x = (int) (Math.random() * 5000 + 100);
		p.setManpowerAmount(x);
		SupportUnit c = new Cavalry();
		c.upgrade();
		p.getUnits().add(c);
		Method m;
		try {
			m = Player.class.getMethod("upgradeUnit", SupportUnit.class);
			m.invoke(p, c);
			assertEquals(
					"Player manpower should be decremented after upgrading a unit to level 3",
					x - 100, p.getManpowerAmount());
			String[] names = { "level", "maxActions", "actionsAvailable" };
			Object[] values = { 3, 5, 5 };
			checkValuesUpgrade(c, names, values, 2);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeUnitInPlayer2() {
		Player p = new Player("Hobala");
		int x = (int) (Math.random() * 5000 + 100);
		p.setManpowerAmount(x);
		SupportUnit c = new Cavalry();
		p.getUnits().add(c);
		Method m;
		try {
			m = Player.class.getMethod("upgradeUnit", SupportUnit.class);
			m.invoke(p, c);
			assertEquals(
					"Player manpower should be decremented after upgrading a unit to level 2",
					x - 50, p.getManpowerAmount());
			String[] names = { "level", "maxActions", "actionsAvailable" };
			Object[] values = { 2, 4, 4 };
			checkValuesUpgrade(c, names, values, 2);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeUnitInPlayer4() throws InvalidActionException {
		Player p = new Player("Hobala");
		int x = (int) (Math.random() * 5000 + 100);
		p.setManpowerAmount(x);
		SupportUnit c = new Archer();
		c.upgrade();
		p.getUnits().add(c);
		Method m;
		try {
			m = Player.class.getMethod("upgradeUnit", SupportUnit.class);
			m.invoke(p, c);
			assertEquals(
					"Player manpower should be decremented after upgrading a unit to level 3",
					x - 100, p.getManpowerAmount());

			String[] names = { "level", "range" };
			Object[] values = { 3, 5 };
			checkValuesUpgrade(c, names, values, 3);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeUnitInPlayer3() {
		Player p = new Player("Hobala");
		int x = (int) (Math.random() * 5000 + 100);
		p.setManpowerAmount(x);
		SupportUnit c = new Archer();
		p.getUnits().add(c);
		Method m;
		try {
			m = Player.class.getMethod("upgradeUnit", SupportUnit.class);
			m.invoke(p, c);
			assertEquals(
					"Player manpower should be decremented after upgrading a unit to level 2",
					x - 50, p.getManpowerAmount());
			String[] names = { "level", "range" };
			Object[] values = { 2, 4 };
			checkValuesUpgrade(c, names, values, 2);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeUnitInPlayer5() throws InvalidActionException {
		Player p = new Player("Hobala");
		int x = (int) (Math.random() * 5000 + 100);
		p.setManpowerAmount(x);
		SupportUnit c = new Footman();
		c.upgrade();
		p.getUnits().add(c);
		Method m;
		try {
			m = Player.class.getMethod("upgradeUnit", SupportUnit.class);
			m.invoke(p, c);
			assertEquals(
					"Player manpower should be decremented after upgrading a unit to level 3",
					x - 100, p.getManpowerAmount());

			String[] names = { "level", "currentHp", "maxHp" };
			Object[] values = { 3, 300, 300 };
			checkValuesUpgrade(c, names, values, 3);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeUnitInPlayer6() {
		Player p = new Player("Hobala");
		int x = (int) (Math.random() * 5000 + 100);
		p.setManpowerAmount(x);
		SupportUnit c = new Footman();
		p.getUnits().add(c);
		Method m;
		try {
			m = Player.class.getMethod("upgradeUnit", SupportUnit.class);
			m.invoke(p, c);
			assertEquals(
					"Player manpower should be decremented after upgrading a unit to level 2",
					x - 50, p.getManpowerAmount());
			String[] names = { "level", "currentHp", "maxHp" };
			Object[] values = { 2, 250, 250 };
			checkValuesUpgrade(c, names, values, 2);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeBuildingExistsInPlayer() {
		Method m = null;
		try {
			m = Player.class.getDeclaredMethod("upgradeBuilding",
					Building.class);
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Player\" should have the method called \"upgradeBuilding\" that takes a SupportUnit as a parameter.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(),
					false);
		}
		assertTrue(
				"Method \"upgradeBuilding\" in class \"Player\" should be void.",
				m.getReturnType().equals(void.class));
	}

	@Test(timeout = 3000)
	public void testUpgradeBuildingInPlayerNoGold() {
		Player p = new Player("Hobala");
		p.setGoldAmount(0);
		Building c = new Tower();
		p.getBuildings().add(c);
		Method m;
		try {
			m = Player.class.getMethod("upgradeBuilding", Building.class);
			m.invoke(p, c);
			fail("Not enough gold available with player for upgrade, a NoAvailableResourcesException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(NoAvailableResourcesException.class.equals(e.getCause()
					.getClass())))
				fail("Not enough gold available with player for upgrade, a NoAvailableResourcesException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeBuildingInPlayerNoGold2() {
		Player p = new Player("Hobala");
		p.setGoldAmount(99);
		Building c = new Tower();
		c.setLevel(2);
		p.getBuildings().add(c);
		Method m;
		try {
			m = Player.class.getMethod("upgradeBuilding", Building.class);
			m.invoke(p, c);
			fail("Not enough gold available with player for upgrade to level 3, a NoAvailableResourcesException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(NoAvailableResourcesException.class.equals(e.getCause()
					.getClass())))
				fail("Not enough gold available with player for upgrade to level 3, a NoAvailableResourcesException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeBuildingInPlayerNotPlayerBuilding() {
		Player p = new Player("Hobala");
		p.setManpowerAmount(1500);
		Building c = new Tower();
		Method m;
		try {
			m = Player.class.getMethod("upgradeBuilding", Building.class);
			m.invoke(p, c);
			fail("Player can only upgrade his buildings, an InvalidTargetException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidTargetException.class.equals(e.getCause().getClass())))
				fail("Player can only upgrade his units, an InvalidTargetException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeBuildingInPlayer() throws InvalidActionException {
		Player p = new Player("Hobala");
		int x = (int) (Math.random() * 5000 + 100);
		p.setGoldAmount(x);
		Building c = new Tower();
		c.upgrade();
		p.getBuildings().add(c);
		Method m;
		try {
			m = Player.class.getMethod("upgradeBuilding", Building.class);
			m.invoke(p, c);
			assertEquals(
					"Player gold should be decremented after upgrading a building to level 3",
					x - 100, p.getGoldAmount());
			String[] names = { "level", "range" };
			Object[] values = { 3, 5 };
			checkValuesUpgrade(c, names, values, 3);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeBuildingInPlayer2() throws InvalidActionException {
		Player p = new Player("Hobala");
		int x = (int) (Math.random() * 5000 + 100);
		p.setGoldAmount(x);
		Building c = new Tower();
		p.getBuildings().add(c);
		Method m;
		try {
			m = Player.class.getMethod("upgradeBuilding", Building.class);
			m.invoke(p, c);
			assertEquals(
					"Player gold should be decremented after upgrading a building to level 3",
					x - 50, p.getGoldAmount());
			String[] names = { "level", "range" };
			Object[] values = { 2, 4 };
			checkValuesUpgrade(c, names, values, 2);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeBuildingInPlayer3() throws InvalidActionException {
		Player p = new Player("Hobala");
		int x = (int) (Math.random() * 5000 + 100);
		p.setGoldAmount(x);
		Building c = new Wall();
		c.upgrade();
		p.getBuildings().add(c);
		Method m;
		try {
			m = Player.class.getMethod("upgradeBuilding", Building.class);
			m.invoke(p, c);
			assertEquals(
					"Player gold should be decremented after upgrading a building to level 3",
					x - 100, p.getGoldAmount());
			String[] names = { "level", "currentHp", "maxHp" };
			Object[] values = { 3, 1000, 1000 };
			checkValuesUpgrade(c, names, values, 3);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeBuildingInPlayer4() throws InvalidActionException {
		Player p = new Player("Hobala");
		int x = (int) (Math.random() * 5000 + 100);
		p.setGoldAmount(x);
		Building c = new Wall();
		p.getBuildings().add(c);
		Method m;
		try {
			m = Player.class.getMethod("upgradeBuilding", Building.class);
			m.invoke(p, c);
			assertEquals(
					"Player gold should be decremented after upgrading a building to level 3",
					x - 50, p.getGoldAmount());
			String[] names = { "level", "currentHp", "maxHp" };
			Object[] values = { 2, 750, 750 };
			checkValuesUpgrade(c, names, values, 2);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeBuildingInPlayer5() throws InvalidActionException {
		Player p = new Player("Hobala");
		int x = (int) (Math.random() * 5000 + 100);
		p.setGoldAmount(x);
		Building c = new Barracks();
		c.upgrade();
		p.getBuildings().add(c);
		Method m;
		try {
			m = Player.class.getMethod("upgradeBuilding", Building.class);
			m.invoke(p, c);
			assertEquals(
					"Player gold should be decremented after upgrading a building to level 3",
					x - 100, p.getGoldAmount());
			String[] names = { "level" };
			Object[] values = { 3 };
			checkValuesUpgrade(c, names, values, 3);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeBuildingInPlayer6() throws InvalidActionException {
		Player p = new Player("Hobala");
		int x = (int) (Math.random() * 5000 + 100);
		p.setGoldAmount(x);
		Building c = new Barracks();
		p.getBuildings().add(c);
		Method m;
		try {
			m = Player.class.getMethod("upgradeBuilding", Building.class);
			m.invoke(p, c);
			assertEquals(
					"Player gold should be decremented after upgrading a building to level 3",
					x - 50, p.getGoldAmount());
			String[] names = { "level" };
			Object[] values = { 2 };
			checkValuesUpgrade(c, names, values, 2);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testRecruitExistsInPlayer() {
		Method m = null;
		try {
			m = Player.class.getDeclaredMethod("recruit", Barracks.class,
					String.class);
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Player\" should have the method called \"recruit\" that takes a SupportUnit as a parameter.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(),
					false);
		}
		assertTrue(
				"Method \"recruit\" in class \"Player\" should return a SupportUnit.",
				m.getReturnType().equals(SupportUnit.class));
	}

	@Test(timeout = 3000)
	public void testRecruitInPlayerNoManpower() {
		Player p = new Player("Hobala");
		p.setManpowerAmount(0);
		Building c = new Barracks();
		p.getBuildings().add(c);
		Method m;
		try {
			m = Player.class.getMethod("recruit", Barracks.class, String.class);
			m.invoke(p, c, "Cavalry");
			fail("Not enough manpower available with player for upgrade, a NoAvailableResourcesException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(NoAvailableResourcesException.class.equals(e.getCause()
					.getClass())))
				fail("Not enough gold available with player for upgrade, a NoAvailableResourcesException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testRecruitInPlayerNotPlayerBarracks() {
		Player p = new Player("Hobala");
		p.setManpowerAmount(1500);
		Building c = new Barracks();
		Method m;
		try {
			m = Player.class.getMethod("recruit", Barracks.class, String.class);
			m.invoke(p, c, "Cavalry");
			fail("Player can only recruit from his barracks, an InvalidTargetException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidTargetException.class.equals(e.getCause().getClass())))
				fail("Player can only upgrade his units, an InvalidTargetException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testRecruitInPlayerCav1() throws InvalidActionException {
		Player p = new Player("Hobala");
		int x = (int) (Math.random() * 5000 + 100);
		p.setManpowerAmount(x);
		Building c = new Barracks();
		p.getBuildings().add(c);
		Method m;
		try {
			m = Player.class.getMethod("recruit", Barracks.class, String.class);
			Object o = m.invoke(p, c, "Cavalry");
			assertEquals(
					"Player manpower should be decremented after recruiting a unit",
					x - 100, p.getManpowerAmount());
			assertTrue("Recruited unit should be added to Player units", p
					.getUnits().contains(o));
			String[] names = { "level", "maxActions", "actionsAvailable" };
			Object[] values = { 1, 3, 3 };
			checkValuesUpgradeBarracks(o, names, values, 1);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testRecruitInPlayerCav2() throws InvalidActionException {
		Player p = new Player("Hobala");
		int x = (int) (Math.random() * 5000 + 100);
		p.setManpowerAmount(x);
		Building c = new Barracks();
		c.setLevel(2);
		p.getBuildings().add(c);
		Method m;
		try {
			m = Player.class.getMethod("recruit", Barracks.class, String.class);
			Object o = m.invoke(p, c, "Cavalry");
			assertEquals(
					"Player manpower should be decremented after recruiting a unit",
					x - 100, p.getManpowerAmount());
			assertTrue("Recruited unit should be added to Player units", p
					.getUnits().contains(o));
			String[] names = { "level", "maxActions", "actionsAvailable" };
			Object[] values = { 2, 4, 4 };
			checkValuesUpgradeBarracks(o, names, values, 2);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testRecruitInPlayerCav3() throws InvalidActionException {
		Player p = new Player("Hobala");
		int x = (int) (Math.random() * 5000 + 100);
		p.setManpowerAmount(x);
		Building c = new Barracks();
		c.setLevel(3);
		p.getBuildings().add(c);
		Method m;
		try {
			m = Player.class.getMethod("recruit", Barracks.class, String.class);
			Object o = m.invoke(p, c, "Cavalry");
			assertEquals(
					"Player manpower should be decremented after recruiting a unit",
					x - 100, p.getManpowerAmount());
			assertTrue("Recruited unit should be added to Player units", p
					.getUnits().contains(o));
			String[] names = { "level", "maxActions", "actionsAvailable" };
			Object[] values = { 3, 5, 5 };
			checkValuesUpgradeBarracks(o, names, values, 3);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testRecruitInPlayerFootman1() throws InvalidActionException {
		Player p = new Player("Hobala");
		int x = (int) (Math.random() * 5000 + 100);
		p.setManpowerAmount(x);
		Building c = new Barracks();
		p.getBuildings().add(c);
		Method m;
		try {
			m = Player.class.getMethod("recruit", Barracks.class, String.class);
			Object o = m.invoke(p, c, "Footman");
			assertEquals(
					"Player manpower should be decremented after recruiting a unit",
					x - 100, p.getManpowerAmount());
			assertTrue("Recruited unit should be added to Player units", p
					.getUnits().contains(o));
			String[] names = { "level", "currentHp", "maxHp" };
			Object[] values = { 1, 200, 200 };
			checkValuesUpgradeBarracks(o, names, values, 1);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testRecruitInPlayerFootman2() throws InvalidActionException {
		Player p = new Player("Hobala");
		int x = (int) (Math.random() * 5000 + 100);
		p.setManpowerAmount(x);
		Building c = new Barracks();
		c.setLevel(2);
		p.getBuildings().add(c);
		Method m;
		try {
			m = Player.class.getMethod("recruit", Barracks.class, String.class);
			Object o = m.invoke(p, c, "Footman");
			assertEquals(
					"Player manpower should be decremented after recruiting a unit",
					x - 100, p.getManpowerAmount());
			assertTrue("Recruited unit should be added to Player units", p
					.getUnits().contains(o));
			String[] names = { "level", "currentHp", "maxHp" };
			Object[] values = { 2, 250, 250 };
			checkValuesUpgradeBarracks(o, names, values, 2);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testRecruitInPlayerFootman3() throws InvalidActionException {
		Player p = new Player("Hobala");
		int x = (int) (Math.random() * 5000 + 100);
		p.setManpowerAmount(x);
		Building c = new Barracks();
		c.setLevel(3);
		p.getBuildings().add(c);
		Method m;
		try {
			m = Player.class.getMethod("recruit", Barracks.class, String.class);
			Object o = m.invoke(p, c, "Footman");
			assertEquals(
					"Player manpower should be decremented after recruiting a unit",
					x - 100, p.getManpowerAmount());
			assertTrue("Recruited unit should be added to Player units", p
					.getUnits().contains(o));
			String[] names = { "level", "currentHp", "maxHp" };
			Object[] values = { 3, 300, 300 };
			checkValuesUpgradeBarracks(o, names, values, 3);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testRecruitInPlayerArcher1() throws InvalidActionException {
		Player p = new Player("Hobala");
		int x = (int) (Math.random() * 5000 + 100);
		p.setManpowerAmount(x);
		Building c = new Barracks();
		p.getBuildings().add(c);
		Method m;
		try {
			m = Player.class.getMethod("recruit", Barracks.class, String.class);
			Object o = m.invoke(p, c, "Archer");
			assertEquals(
					"Player manpower should be decremented after recruiting a unit",
					x - 100, p.getManpowerAmount());
			assertTrue("Recruited unit should be added to Player units", p
					.getUnits().contains(o));
			String[] names = { "level", "range" };
			Object[] values = { 1, 3 };
			checkValuesUpgradeBarracks(o, names, values, 1);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testRecruitInPlayerArcher2() throws InvalidActionException {
		Player p = new Player("Hobala");
		int x = (int) (Math.random() * 5000 + 100);
		p.setManpowerAmount(x);
		Building c = new Barracks();
		c.setLevel(2);
		p.getBuildings().add(c);
		Method m;
		try {
			m = Player.class.getMethod("recruit", Barracks.class, String.class);
			Object o = m.invoke(p, c, "Archer");
			assertEquals(
					"Player manpower should be decremented after recruiting a unit",
					x - 100, p.getManpowerAmount());
			assertTrue("Recruited unit should be added to Player units", p
					.getUnits().contains(o));
			String[] names = { "level", "range" };
			Object[] values = { 2, 4 };
			checkValuesUpgradeBarracks(o, names, values, 2);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testRecruitInPlayerArcher3() throws InvalidActionException {
		Player p = new Player("Hobala");
		int x = (int) (Math.random() * 5000 + 100);
		p.setManpowerAmount(x);
		Building c = new Barracks();
		c.setLevel(3);
		p.getBuildings().add(c);
		Method m;
		try {
			m = Player.class.getMethod("recruit", Barracks.class, String.class);
			Object o = m.invoke(p, c, "Archer");
			assertEquals(
					"Player manpower should be decremented after recruiting a unit",
					x - 100, p.getManpowerAmount());
			assertTrue("Recruited unit should be added to Player units", p
					.getUnits().contains(o));
			String[] names = { "level", "range" };
			Object[] values = { 3, 5 };
			checkValuesUpgradeBarracks(o, names, values, 3);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testBuildTowerExistsInPlayer() {
		Method m = null;
		try {
			m = Player.class.getDeclaredMethod("buildTower", Hero.class);
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Player\" should have the method called \"buildTower\" that takes a Hero as a parameter.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(),
					false);
		}
		assertTrue(
				"Method \"buildTower\" in class \"Player\" should return a Tower.",
				m.getReturnType().equals(Tower.class));
	}

	@Test(timeout = 3000)
	public void testBuildTowerInPlayerNoGold() {
		Player p = new Player("Hobala");
		p.setGoldAmount(0);
		Hero c = new Monk("Hero", 3, 3, 3);
		p.getUnits().add(c);
		Method m;
		try {
			m = Player.class.getDeclaredMethod("buildTower", Hero.class);
			m.invoke(p, c);
			fail("Not enough gold available with player for build, a NoAvailableResourcesException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(NoAvailableResourcesException.class.equals(e.getCause()
					.getClass())))
				fail("Not enough gold available with player for build, a NoAvailableResourcesException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testBuildTowerInPlayerNotPlayerHero() {
		Player p = new Player("Hobala");
		Hero c = new Monk("Hero", 3, 3, 3);
		Method m;
		try {
			m = Player.class.getDeclaredMethod("buildTower", Hero.class);
			m.invoke(p, c);
			fail("Player can only build using his hero, an InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Player can only build using his hero, an InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testBuildTowerInPlayerNoActions() {
		Player p = new Player("Hobala");
		p.setGoldAmount(1000);
		Hero c = new Monk("Hero", 3, 3, 3);
		c.setActionsAvailable(0);
		p.getUnits().add(c);
		Method m;
		try {
			m = Player.class.getDeclaredMethod("buildTower", Hero.class);
			m.invoke(p, c);
			fail("Not enough actions with hero for build, a NotEnoughActionsException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(NotEnoughActionsException.class.equals(e.getCause()
					.getClass())))
				fail("Not enough actions with hero for build, a NotEnoughActionsException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testBuildTowerInPlayer() {
		Player p = new Player("Hobala");
		int x = (int) (Math.random() * 5000 + 100);
		p.setGoldAmount(x);
		Hero c = new Monk("Hero", 3, 3, 3);
		p.getUnits().add(c);
		Method m;
		try {
			m = Player.class.getDeclaredMethod("buildTower", Hero.class);
			Object o = m.invoke(p, c);
			assertEquals("Player gold should be decremented after building",
					x - 100, p.getGoldAmount());
			assertTrue("Building should be added to Player buildings", p
					.getBuildings().contains(o));
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testBuildWallExistsInPlayer() {
		Method m = null;
		try {
			m = Player.class.getDeclaredMethod("buildWall", Hero.class);
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Player\" should have the method called \"buildWall\" that takes a Hero as a parameter.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(),
					false);
		}
		assertTrue(
				"Method \"buildWall\" in class \"Player\" should return a Wall.",
				m.getReturnType().equals(Wall.class));
	}

	@Test(timeout = 3000)
	public void testBuildWallInPlayerNoGold() {
		Player p = new Player("Hobala");
		p.setGoldAmount(0);
		Hero c = new Monk("Hero", 3, 3, 3);
		p.getUnits().add(c);
		Method m;
		try {
			m = Player.class.getDeclaredMethod("buildWall", Hero.class);
			m.invoke(p, c);
			fail("Not enough gold available with player for build, a NoAvailableResourcesException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(NoAvailableResourcesException.class.equals(e.getCause()
					.getClass())))
				fail("Not enough gold available with player for build, a NoAvailableResourcesException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testBuildWallInPlayerNotPlayerHero() {
		Player p = new Player("Hobala");
		Hero c = new Monk("Hero", 3, 3, 3);
		Method m;
		try {
			m = Player.class.getDeclaredMethod("buildWall", Hero.class);
			m.invoke(p, c);
			fail("Player can only build using his hero, an InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Player can only build using his hero, an InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testBuildWallInPlayerNoActions() {
		Player p = new Player("Hobala");
		p.setGoldAmount(1000);
		Hero c = new Monk("Hero", 3, 3, 3);
		c.setActionsAvailable(0);
		p.getUnits().add(c);
		Method m;
		try {
			m = Player.class.getDeclaredMethod("buildWall", Hero.class);
			m.invoke(p, c);
			fail("Not enough actions with hero for build, a NotEnoughActionsException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(NotEnoughActionsException.class.equals(e.getCause()
					.getClass())))
				fail("Not enough actions with hero for build, a NotEnoughActionsException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testBuildWallInPlayer() {
		Player p = new Player("Hobala");
		int x = (int) (Math.random() * 5000 + 100);
		p.setGoldAmount(x);
		Hero c = new Monk("Hero", 3, 3, 3);
		p.getUnits().add(c);
		Method m;
		try {
			m = Player.class.getDeclaredMethod("buildWall", Hero.class);
			Object o = m.invoke(p, c);
			assertEquals("Player gold should be decremented after building",
					x - 100, p.getGoldAmount());
			assertTrue("Building should be added to Player buildings", p
					.getBuildings().contains(o));
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testUseSpecialExistsInPlayer() {
		Method m = null;
		try {
			m = Player.class.getDeclaredMethod("useSpecial", Hero.class,
					SupportUnit.class);
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Player\" should have the method called \"useSpecial\" that takes a Hero as a parameter.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(),
					false);
		}
		assertTrue(
				"Method \"useSpecial\" in class \"Player\" should be a void method.",
				m.getReturnType().equals(void.class));
	}

	@Test(timeout = 3000)
	public void testUseSpecialInPlayerNotPlayerHero() {
		Player p = new Player("Hobala");
		Hero h = new Monk("Hero", 3, 3, 3);
		SupportUnit c = new Cavalry();
		p.getUnits().add(c);
		Method m;
		try {
			m = Player.class.getDeclaredMethod("useSpecial", Hero.class,
					SupportUnit.class);
			m.invoke(p, h, c);
			fail("Player can only use the special of his hero, an InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Player can only use the special of his hero, an InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testUseSpecialInPlayerCooldown() {
		Player p = new Player("Hobala");
		Hero h = new Monk("Hero", 3, 3, 3);
		h.setSpecialActionCooldown(3);
		SupportUnit c = new Cavalry();
		p.getUnits().add(c);
		p.getUnits().add(h);
		Method m;
		try {
			m = Player.class.getDeclaredMethod("useSpecial", Hero.class,
					SupportUnit.class);
			m.invoke(p, h, c);
			fail("Hero special is on cooldown, an InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Hero special is on cooldown, an InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testUseSpecialInPlayerInvalidTarget() {
		Player p = new Player("Hobala");
		Hero h = new Monk("Hero", 3, 3, 3);
		SupportUnit c = new Cavalry();
		p.getUnits().add(h);
		Method m;
		try {
			m = Player.class.getDeclaredMethod("useSpecial", Hero.class,
					SupportUnit.class);
			m.invoke(p, h, c);
			fail("Monk should only be able to use special on player's units, an InvalidTargetException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidTargetException.class.equals(e.getCause().getClass())))
				fail("Monk should only be able to use special on player's units, an InvalidTargetException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testUseSpecialInPlayerInvalidTarget2() {
		Player p = new Player("Hobala");
		Hero h = new Warchief("Hero", 3, 3, 3, 1);
		SupportUnit c = new Cavalry();
		p.getUnits().add(h);
		Method m;
		try {
			m = Player.class.getDeclaredMethod("useSpecial", Hero.class,
					SupportUnit.class);
			m.invoke(p, h, c);
			fail("Warchief should only be able to use special on player's units, an InvalidTargetException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidTargetException.class.equals(e.getCause().getClass())))
				fail("Warchief should only be able to use special on player's units, an InvalidTargetException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testUseSpecialInPlayerInvalidTarget3() {
		Player p = new Player("Hobala");
		Hero h = new Assassin("Hero", 3, 3, 3, 1);
		SupportUnit c = new Cavalry();
		p.getUnits().add(h);
		p.getUnits().add(c);
		Method m;
		try {
			m = Player.class.getDeclaredMethod("useSpecial", Hero.class,
					SupportUnit.class);
			m.invoke(p, h, c);
			fail("Assassin should not be able to use special on player's units, an InvalidTargetException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidTargetException.class.equals(e.getCause().getClass())))
				fail("Assassin should not be able to use special on player's units, an InvalidTargetException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testUseSpecialInPlayerInvalidTarget4() {
		Player p = new Player("Hobala");
		Hero h = new Diplomat("Hero", 3, 3, 3);
		SupportUnit c = new Cavalry();
		p.getUnits().add(h);
		p.getUnits().add(c);
		Method m;
		try {
			m = Player.class.getDeclaredMethod("useSpecial", Hero.class,
					SupportUnit.class);
			m.invoke(p, h, c);
			fail("Diplomat should not be able to use special on player's units, an InvalidTargetException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidTargetException.class.equals(e.getCause().getClass())))
				fail("Diplomat should not be able to use special on player's units, an InvalidTargetException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testUseSpecialInPlayer() {
		Player p = new Player("Hobala");
		Hero h = new Monk("Hero", 3, 3, 3);
		SupportUnit c = new Cavalry();
		c.setCurrentHp(1);
		p.getUnits().add(h);
		p.getUnits().add(c);
		Method m;
		try {
			m = Player.class.getDeclaredMethod("useSpecial", Hero.class,
					SupportUnit.class);
			m.invoke(p, h, c);
			assertEquals(
					"Monk's special action should be used and conditions updated.",
					c.getMaxHp(), c.getCurrentHp());
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testUseSpecialInPlayer2() {
		Player p = new Player("Hobala");
		Hero h = new Warchief("Hero", 3, 3, 3, 1);
		SupportUnit c = new Cavalry();
		c.setCurrentHp(1);
		p.getUnits().add(h);
		p.getUnits().add(c);
		Method m;
		try {
			m = Player.class.getDeclaredMethod("useSpecial", Hero.class,
					SupportUnit.class);
			m.invoke(p, h, c);
			assertEquals(
					"Warchief's special action should be used and conditions updated.",
					3, c.getLevel());
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testCheckGameOverExistsGame() {
		Method m = null;
		try {

			m = Game.class.getDeclaredMethod("checkGameOver");
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Game\" should contain a method called \"checkGameOver\" that takes no parameters.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(),
					false);
		}
		assertTrue(
				"Method \"checkGameOver\" in class \"Game\" should be Player.",
				m.getReturnType().equals(Player.class));
	}

	@Test(timeout = 3000)
	public void testCheckGameOverNoWin() {
		Game g = setupGameAndConditions();
		Method m = null;
		try {
			m = Game.class.getDeclaredMethod("checkGameOver");
			Object o = m.invoke(g);
			assertEquals(
					"If both players palaces are not destroyed, then no player has won.",
					null, o);
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Game\" should contain a method called \"checkGameOver\" that takes no parameters.",
					false);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | SecurityException e) {
			fail(e.getCause().getClass() + " occurred.");
		}
	}

	@Test(timeout = 3000)
	public void testCheckGameOverP1Win() {
		Game g = setupGameAndConditions();
		g.player2.getBuildings().clear();
		Method m = null;
		try {
			m = Game.class.getDeclaredMethod("checkGameOver");
			Object o = m.invoke(g);
			assertEquals(
					"If player2's palace is destroyed, then player1 has won.",
					g.player1, o);
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Game\" should contain a method called \"checkGameOver\" that takes no parameters.",
					false);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | SecurityException e) {
			fail(e.getCause().getClass() + " occurred.");
		}
	}

	@Test(timeout = 3000)
	public void testCheckGameOverP2Win() {
		Game g = setupGameAndConditions();
		g.player1.getBuildings().clear();
		Method m = null;
		try {
			m = Game.class.getDeclaredMethod("checkGameOver");
			Object o = m.invoke(g);
			assertEquals(
					"If player1's palace is destroyed, then player2 has won.",
					g.player2, o);
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Game\" should contain a method called \"checkGameOver\" that takes no parameters.",
					false);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | SecurityException e) {
			fail(e.getCause().getClass() + " occurred.");
		}
	}

	@Test(timeout = 3000)
	public void testSetMapExistsGame() {
		Method m = null;
		try {
			m = Game.class.getDeclaredMethod("setMap", Hero.class, Hero.class);
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Game\" should contain a method called \"setMap\" that takes 2 Heroes as parameters.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(),
					false);
		}
		assertTrue("Method \"setMap\" in class \"Game\" should be void.", m
				.getReturnType().equals(void.class));
	}

	@Test(timeout = 100000)
	public void testSetMapGame() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			m = Game.class.getDeclaredMethod("setMap", Hero.class, Hero.class);
			m.invoke(g, h1, h2);
			assertTrue(
					"The first player's units should include the first hero.",
					p1.getUnits().contains(h1));
			assertTrue(
					"The second player's units should include the second hero.",
					p2.getUnits().contains(h2));
			assertTrue("The map should be initialized", g.map != null);
			assertEquals("The map should be have a length of 10", g.map.length,
					10);
			assertEquals("The map should be have a height of 10", g.map.length,
					10);
			assertTrue(
					"The cell at the top left should contain the first player's Palace",
					g.map[0][0] instanceof BuildingCell
							&& ((BuildingCell) g.map[0][0]).getBuilding() instanceof Palace
							&& p1.getBuildings().contains(
									((BuildingCell) g.map[0][0]).getBuilding()));
			assertTrue(
					"The cell at the bottom right should contain the second player's Palace",
					g.map[9][9] instanceof BuildingCell
							&& ((BuildingCell) g.map[9][9]).getBuilding() instanceof Palace
							&& p2.getBuildings().contains(
									((BuildingCell) g.map[9][9]).getBuilding()));
			assertTrue(
					"The cell at the (0,1) should contain the first player's Barracks",
					g.map[0][1] instanceof BuildingCell
							&& ((BuildingCell) g.map[0][1]).getBuilding() instanceof Barracks
							&& p1.getBuildings().contains(
									((BuildingCell) g.map[0][1]).getBuilding()));
			assertTrue(
					"The cell at the bottom right should contain the second player's Barracks",
					g.map[9][7] instanceof BuildingCell
							&& ((BuildingCell) g.map[9][7]).getBuilding() instanceof Barracks
							&& p2.getBuildings().contains(
									((BuildingCell) g.map[9][7]).getBuilding()));

			assertTrue(
					"The cell at the (0,3) should contain the first player's Tower",
					g.map[0][3] instanceof BuildingCell
							&& ((BuildingCell) g.map[0][3]).getBuilding() instanceof Tower
							&& p1.getBuildings().contains(
									((BuildingCell) g.map[0][3]).getBuilding()));
			assertTrue(
					"The cell at the bottom right should contain the second player's Tower",
					g.map[9][6] instanceof BuildingCell
							&& ((BuildingCell) g.map[9][6]).getBuilding() instanceof Tower
							&& p2.getBuildings().contains(
									((BuildingCell) g.map[9][6]).getBuilding()));
			assertTrue(
					"The cell at the (1,0) should contain the first player's Hero",
					g.map[1][0] instanceof UnitCell
							&& ((UnitCell) g.map[1][0]).getUnit() instanceof Hero
							&& ((UnitCell) g.map[1][0]).getUnit() == h1);
			assertTrue(
					"The cell at the (1,1) should contain the first player's Cavalry Unit",
					g.map[1][1] instanceof UnitCell
							&& ((UnitCell) g.map[1][1]).getUnit() instanceof Cavalry
							&& p1.getUnits().contains(
									((UnitCell) g.map[1][1]).getUnit()));
			assertTrue(
					"The cell at the (1,2) should contain the first player's Cavalry Unit",
					g.map[1][2] instanceof UnitCell
							&& ((UnitCell) g.map[1][2]).getUnit() instanceof Footman
							&& p1.getUnits().contains(
									((UnitCell) g.map[1][2]).getUnit()));
			assertTrue(
					"The cell at the (1,3) should contain the first player's Cavalry Unit",
					g.map[1][3] instanceof UnitCell
							&& ((UnitCell) g.map[1][3]).getUnit() instanceof Archer
							&& p1.getUnits().contains(
									((UnitCell) g.map[1][3]).getUnit()));

			assertTrue(
					"The cell at the (8,9) should contain the second player's Hero",
					g.map[8][9] instanceof UnitCell
							&& ((UnitCell) g.map[8][9]).getUnit() instanceof Hero
							&& ((UnitCell) g.map[8][9]).getUnit() == h2);
			assertTrue(
					"The cell at the (8,8) should contain the second player's Cavalry Unit",
					g.map[8][8] instanceof UnitCell
							&& ((UnitCell) g.map[8][8]).getUnit() instanceof Cavalry
							&& p2.getUnits().contains(
									((UnitCell) g.map[8][8]).getUnit()));
			assertTrue(
					"The cell at the (8,7) should contain the second player's Cavalry Unit",
					g.map[8][7] instanceof UnitCell
							&& ((UnitCell) g.map[8][7]).getUnit() instanceof Footman
							&& p2.getUnits().contains(
									((UnitCell) g.map[8][7]).getUnit()));
			assertTrue(
					"The cell at the (8,6) should contain the second player's Cavalry Unit",
					g.map[8][6] instanceof UnitCell
							&& ((UnitCell) g.map[8][6]).getUnit() instanceof Archer
							&& p2.getUnits().contains(
									((UnitCell) g.map[8][6]).getUnit()));

			int goldcount = 0;
			int manpowerCount = 0;

			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (g.map[i][j] instanceof ResourceCell) {
						ResourceCell rc = (ResourceCell) g.map[i][j];
						if (rc.getType() == ResourceType.MANPOWER)
							manpowerCount++;
						else
							goldcount++;
						assertEquals(
								"Resource cells should contain 200 of the resource they hold",
								200, rc.getAmount());
					}
				}
			}
			assertEquals("There should be 5 cells holding manpower", 5,
					manpowerCount);
			assertEquals("There should be 5 cells holding gold", 5, goldcount);

		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred.");
		}
	}

	@Test(timeout = 3000)
	public void testEndTurnExistsGame() {
		Method m = null;
		try {

			m = Game.class.getDeclaredMethod("endTurn");
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Game\" should contain a method called \"endTurn\" that takes no parameters.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(),
					false);
		}
		assertTrue("Method \"endTurn\" in class \"Game\" should be void.", m
				.getReturnType().equals(void.class));
	}

	@Test(timeout = 3000)
	public void testEndTurnPlayer1() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);

			depleteConditions(g);
			g.currentPlayer = p2;
			m = Game.class.getDeclaredMethod("endTurn");
			m.invoke(g);
			for (Unit u : g.currentPlayer.getUnits()) {
				assertEquals(
						"EndTurn should reset the actions for all the units.",
						u.getActionsAvailable(), u.getMaxActions());
				if (u instanceof Hero) {
					assertEquals(
							"EndTurn should decremenet the cooldown for the hero's special action.",
							2, h1.getSpecialActionCooldown());
				}
			}
			for (Building b : g.currentPlayer.getBuildings()) {
				if (b instanceof Tower)
					assertTrue(
							"Towers should be able to attack whenever a player's turn arrives.",
							((Tower) b).isCanAttack());
				else if (b instanceof Barracks)
					assertTrue(
							"Barracks should be able to recruit whenever a player's turn arrives.",
							((Barracks) b).isCanRecruit());

			}
			assertEquals(
					"Whenever player2 ends their turn the current player should be player1.",
					p1, g.currentPlayer);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred.");
		}
	}

	@Test(timeout = 3000)
	public void testEndTurnPlayer2() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		g.currentPlayer = p2;
		Method m = null;
		try {
			layUnits(g, h1, h2);

			depleteConditions(g);
			g.currentPlayer = p1;
			m = Game.class.getDeclaredMethod("endTurn");
			m.invoke(g);
			for (Unit u : g.currentPlayer.getUnits()) {
				assertEquals(
						"EndTurn should reset the actions for all the units.",
						u.getActionsAvailable(), u.getMaxActions());
				if (u instanceof Hero) {
					assertEquals(
							"EndTurn should decremenet the cooldown for the hero's special action.",
							2, h2.getSpecialActionCooldown());
				}
			}
			for (Building b : g.currentPlayer.getBuildings()) {
				if (b instanceof Tower)
					assertTrue(
							"Towers should be able to attack whenever a player's turn arrives.",
							((Tower) b).isCanAttack());
				else if (b instanceof Barracks)
					assertTrue(
							"Barracks should be able to recruit whenever a player's turn arrives.",
							((Barracks) b).isCanRecruit());

			}
			assertEquals(
					"Whenever player1 ends their turn the current player should be player2.",
					p2, g.currentPlayer);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred.");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeInGameNotApplicable() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);

			m = Game.class.getDeclaredMethod("upgrade", int.class, int.class);
			g.map[3][3] = new ResourceCell(ResourceType.MANPOWER, 200);
			m.invoke(g, 3, 3);
			fail("Player can only target UnitCells or BuildingCells for upgrades. InvalidTargetException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidTargetException.class.equals(e.getCause().getClass())))
				fail("Player can only target UnitCells or BuildingCells for upgrades. InvalidTargetException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeExistsGame() {
		Method m = null;
		try {

			m = Game.class.getDeclaredMethod("upgrade", int.class, int.class);
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Game\" should contain a method called \"upgrade\" that takes 2 integers as input.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(),
					false);
		}
		assertTrue("Method \"upgrade\" in class \"Game\" should be void.", m
				.getReturnType().equals(void.class));
	}

	@Test(timeout = 3000)
	public void testUpgradeInGameNotApplicable2() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);

			m = Game.class.getDeclaredMethod("upgrade", int.class, int.class);
			g.map[3][3] = new EmptyCell();
			m.invoke(g, 3, 3);
			fail("Player can only target UnitCells or BuildingCells for upgrades. InvalidTargetException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidTargetException.class.equals(e.getCause().getClass())))
				fail("Player can only target UnitCells or BuildingCells for upgrades.  InvalidTargetException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeInGameNotApplicable3() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);

			m = Game.class.getDeclaredMethod("upgrade", int.class, int.class);
			m.invoke(g, 1, 0);
			fail("Player can only target UnitCells that contain SupportUnits or BuildingCells for upgrades. InvalidTargetException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidTargetException.class.equals(e.getCause().getClass())))
				fail("Player can only target UnitCells or BuildingCells for upgrades.  InvalidTargetException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeInGameUnit() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);

			m = Game.class.getDeclaredMethod("upgrade", int.class, int.class);
			m.invoke(g, 1, 3);
			assertEquals(
					"Player manpower should be decremented after upgrading a unit",
					650, g.currentPlayer.getManpowerAmount());
			String[] names = { "level", "range" };
			Object[] values = { 2, 4 };
			checkValuesUpgrade(((UnitCell) g.map[1][3]).getUnit(), names,
					values, 2);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeInGameUnit2() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);

			m = Game.class.getDeclaredMethod("upgrade", int.class, int.class);
			m.invoke(g, 1, 1);
			assertEquals(
					"Player manpower should be decremented after upgrading a unit",
					650, g.currentPlayer.getManpowerAmount());
			String[] names = { "level", "maxActions" };
			Object[] values = { 2, 4 };
			checkValuesUpgrade(((UnitCell) g.map[1][1]).getUnit(), names,
					values, 2);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeInGameBuilding() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);

			m = Game.class.getDeclaredMethod("upgrade", int.class, int.class);
			m.invoke(g, 0, 3);
			assertEquals(
					"Player gold should be decremented after upgrading a unit",
					650, g.currentPlayer.getGoldAmount());
			String[] names = { "level" };
			Object[] values = { 2 };
			checkValuesUpgrade(((BuildingCell) g.map[0][3]).getBuilding(),
					names, values, 2);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testUpgradeInGameBuilding2() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);

			m = Game.class.getDeclaredMethod("upgrade", int.class, int.class);
			m.invoke(g, 0, 1);
			assertEquals(
					"Player gold should be decremented after upgrading a building",
					650, g.currentPlayer.getGoldAmount());
			String[] names = { "level" };
			Object[] values = { 2 };
			checkValuesUpgrade(((BuildingCell) g.map[0][1]).getBuilding(),
					names, values, 2);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testRecruitUnitExistsGame() {
		Method m = null;
		try {

			m = Game.class.getDeclaredMethod("recruitUnit", int.class,
					int.class, String.class);
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Game\" should contain a method called \"recruitUnit\" that takes 2 integers and a String as input.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(),
					false);
		}
		assertTrue("Method \"recruitUnit\" in class \"Game\" should be void.",
				m.getReturnType().equals(void.class));
	}

	@Test(timeout = 3000)
	public void testRecruitUnitInGameNotApplicable() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);

			m = Game.class.getDeclaredMethod("recruitUnit", int.class,
					int.class, String.class);
			g.map[3][3] = new EmptyCell();
			m.invoke(g, 3, 3, "Cavalry");
			fail("Player can only recruit from building cells that contain barracks. InvalidTargetException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidTargetException.class.equals(e.getCause().getClass())))
				fail("Player can only recruit from building cells that contain barracks. InvalidTargetException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testRecruitUnitInGameNotApplicable2() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);

			m = Game.class.getDeclaredMethod("recruitUnit", int.class,
					int.class, String.class);
			g.map[3][3] = new UnitCell(new Cavalry());
			m.invoke(g, 3, 3, "Cavalry");
			fail("Player can only recruit from building cells that contain barracks. InvalidTargetException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidTargetException.class.equals(e.getCause().getClass())))
				fail("Player can only recruit from building cells that contain barracks. InvalidTargetException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testRecruitUnitInGameNotApplicable3() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);

			m = Game.class.getDeclaredMethod("recruitUnit", int.class,
					int.class, String.class);
			g.map[3][3] = new ResourceCell(ResourceType.MANPOWER, 200);
			m.invoke(g, 3, 3, "Cavalry");
			fail("Player can only recruit from building cells that contain barracks. InvalidTargetException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidTargetException.class.equals(e.getCause().getClass())))
				fail("Player can only recruit from building cells that contain barracks. InvalidTargetException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testRecruitUnitInGameNotApplicable4() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);

			m = Game.class.getDeclaredMethod("recruitUnit", int.class,
					int.class, String.class);
			g.map[3][3] = new BuildingCell(new Tower());
			m.invoke(g, 3, 3, "Cavalry");
			fail("Player can only recruit from building cells that contain barracks. InvalidTargetException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidTargetException.class.equals(e.getCause().getClass())))
				fail("Player can only recruit from building cells that contain barracks. InvalidTargetException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testRecruitUnitInGameNotApplicable5() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			Barracks b = new Barracks();
			p1.getBuildings().add(b);
			int x = (int) (Math.random() * 3) + 3;
			int y = (int) (Math.random() * 3) + 3;
			layUnits(g, h1, h2);

			m = Game.class.getDeclaredMethod("recruitUnit", int.class,
					int.class, String.class);
			g.map[x][y] = new BuildingCell(b);
			g.map[x][y + 1] = new UnitCell(new Cavalry());
			m.invoke(g, x, y, "Cavalry");
			fail("Player can only recruit from building cells that contain barracks. InvalidTargetException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidTargetException.class.equals(e.getCause().getClass())))
				fail("Player can only recruit from building cells that contain barracks. InvalidTargetException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testRecruitUnitInGameSuccess() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			Barracks b = new Barracks();
			p1.getBuildings().add(b);
			int x = (int) (Math.random() * 3) + 3;
			int y = (int) (Math.random() * 3) + 3;
			layUnits(g, h1, h2);
			m = Game.class.getDeclaredMethod("recruitUnit", int.class,
					int.class, String.class);
			g.map[x][y] = new BuildingCell(b);
			g.map[x][y + 1] = new EmptyCell();
			m.invoke(g, x, y, "Cavalry");
			assertTrue(
					"New Unit should be spawned to the right of the barracks.",
					g.map[x][y + 1] instanceof UnitCell
							&& ((UnitCell) g.map[x][y + 1]).getUnit() instanceof Cavalry);
			assertEquals(
					"New Unit should have its location attribute set to its spawn location.",
					new Point(x, y + 1), ((UnitCell) g.map[x][y + 1]).getUnit()
							.getLocation());
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testRecruitUnitInGameSuccess2() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			Barracks b = new Barracks();
			p1.getBuildings().add(b);
			int x = (int) (Math.random() * 3) + 3;
			int y = (int) (Math.random() * 3) + 3;
			layUnits(g, h1, h2);
			m = Game.class.getDeclaredMethod("recruitUnit", int.class,
					int.class, String.class);
			g.map[x][y] = new BuildingCell(b);
			g.map[x][y + 1] = new EmptyCell();
			m.invoke(g, x, y, "Archer");
			assertTrue(
					"New Unit should be spawned to the right of the barracks.",
					g.map[x][y + 1] instanceof UnitCell
							&& ((UnitCell) g.map[x][y + 1]).getUnit() instanceof Archer);
			assertEquals(
					"New Unit should have its location attribute set to its spawn location.",
					new Point(x, y + 1), ((UnitCell) g.map[x][y + 1]).getUnit()
							.getLocation());
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testBuildExistsGame() {
		Method m = null;
		try {

			m = Game.class.getDeclaredMethod("build", int.class, int.class,
					int.class, int.class, String.class);
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Game\" should contain a method called \"build\" that takes 4 integers and a String as input.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(),
					false);
		}
		assertTrue("Method \"build\" in class \"Game\" should be void.", m
				.getReturnType().equals(void.class));
	}

	@Test(timeout = 3000)
	public void testBuildInGameNotValid() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);

			g.currentPlayer = p2;
			m = Game.class.getDeclaredMethod("build", int.class, int.class,
					int.class, int.class, String.class);
			g.map[7][9] = new EmptyCell();
			m.invoke(g, 8, 9, 7, 9, "Palace");
			fail("Player can only build walls and towers. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Player can only build walls and towers. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testBuildInGameNotValid2() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);

			g.currentPlayer = p2;
			m = Game.class.getDeclaredMethod("build", int.class, int.class,
					int.class, int.class, String.class);
			g.map[7][9] = new EmptyCell();
			m.invoke(g, 8, 9, 7, 9, "Barracks");
			fail("Player can only build walls and towers. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Player can only build walls and towers. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testBuildInGameNotEmpty() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);

			g.currentPlayer = p2;
			m = Game.class.getDeclaredMethod("build", int.class, int.class,
					int.class, int.class, String.class);
			g.map[7][9] = new ResourceCell(ResourceType.GOLD, 1);
			m.invoke(g, 8, 9, 7, 9, "Tower");
			fail("Player can only build on EmptyCells. InvalidTargetException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidTargetException.class.equals(e.getCause().getClass())))
				fail("Player can only build on EmptyCells. InvalidTargetException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testBuildInGameNotEmpty2() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);

			g.currentPlayer = p2;
			m = Game.class.getDeclaredMethod("build", int.class, int.class,
					int.class, int.class, String.class);
			g.map[7][9] = new UnitCell(new Cavalry());
			m.invoke(g, 8, 9, 7, 9, "Tower");
			fail("Player can only build on EmptyCells. InvalidTargetException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidTargetException.class.equals(e.getCause().getClass())))
				fail("Player can only build on EmptyCells. InvalidTargetException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testBuildInGameNotEmpty3() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);

			g.currentPlayer = p2;
			m = Game.class.getDeclaredMethod("build", int.class, int.class,
					int.class, int.class, String.class);
			g.map[7][9] = new BuildingCell(new Wall());
			m.invoke(g, 8, 9, 7, 9, "Tower");
			fail("Player can only build on EmptyCells. InvalidTargetException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidTargetException.class.equals(e.getCause().getClass())))
				fail("Player can only build on EmptyCells. InvalidTargetException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testBuildInGameNotAdjacent() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);

			g.currentPlayer = p2;
			m = Game.class.getDeclaredMethod("build", int.class, int.class,
					int.class, int.class, String.class);
			g.map[6][9] = new EmptyCell();
			m.invoke(g, 8, 9, 6, 9, "Tower");
			fail("Player can only build on adjacent Cells. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Player can only build on adjacent Cells. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testBuildInGameNotAdjacent2() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);

			g.currentPlayer = p2;
			m = Game.class.getDeclaredMethod("build", int.class, int.class,
					int.class, int.class, String.class);
			g.map[5][7] = new EmptyCell();
			g.map[5][5] = new UnitCell(h2);
			m.invoke(g, 5, 5, 5, 7, "Tower");
			fail("Player can only build on adjacent Cells. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Player can only build on adjacent Cells. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testBuildInGameNotHero() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);

			g.currentPlayer = p2;
			m = Game.class.getDeclaredMethod("build", int.class, int.class,
					int.class, int.class, String.class);
			g.map[9][5] = new EmptyCell();
			m.invoke(g, 9, 6, 9, 5, "Tower");
			fail("Player can only build using heroes. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Player can only build using heroes. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testBuildInGameNotHero2() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);

			g.currentPlayer = p2;
			m = Game.class.getDeclaredMethod("build", int.class, int.class,
					int.class, int.class, String.class);
			g.map[8][5] = new EmptyCell();
			m.invoke(g, 8, 6, 9, 5, "Tower");
			fail("Player can only build using heroes. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Player can only build using heroes. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testBuildInGameNotPacifist() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);

			m = Game.class.getDeclaredMethod("build", int.class, int.class,
					int.class, int.class, String.class);
			g.map[2][0] = new EmptyCell();
			m.invoke(g, 1, 0, 2, 0, "Tower");
			fail("Player can only build using pacifist heroes. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Player can only build using pacifist heroes. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testBuildInGameSuccess() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);

			g.currentPlayer = p2;
			m = Game.class.getDeclaredMethod("build", int.class, int.class,
					int.class, int.class, String.class);
			g.map[7][8] = new EmptyCell();
			m.invoke(g, 8, 9, 7, 8, "Tower");
			assertTrue(
					"The player should be able to build diagonally adjacent to the hero.",
					g.map[7][8] instanceof BuildingCell
							&& ((BuildingCell) g.map[7][8]).getBuilding() instanceof Tower);
			assertTrue(
					"The built tower should be added to the map.",
					g.map[7][8] instanceof BuildingCell
							&& ((BuildingCell) g.map[7][8]).getBuilding() instanceof Tower);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testBuildInGameSuccess2() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);

			g.currentPlayer = p2;
			m = Game.class.getDeclaredMethod("build", int.class, int.class,
					int.class, int.class, String.class);
			g.map[5][5] = new UnitCell(h2);
			g.map[5][6] = new EmptyCell();
			m.invoke(g, 5, 5, 5, 6, "Wall");
			assertTrue(
					"The player should be able to build horizontally adjacent to the hero.",
					g.map[5][6] instanceof BuildingCell
							&& ((BuildingCell) g.map[5][6]).getBuilding() instanceof Wall);
			assertTrue(
					"The built wall should be added to the map.",
					g.map[5][6] instanceof BuildingCell
							&& ((BuildingCell) g.map[5][6]).getBuilding() instanceof Wall);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testBuildInGameSuccess3() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);

			g.currentPlayer = p2;
			m = Game.class.getDeclaredMethod("build", int.class, int.class,
					int.class, int.class, String.class);
			g.map[7][9] = new EmptyCell();
			m.invoke(g, 8, 9, 7, 9, "Wall");
			assertTrue(
					"The player should be able to build vertically adjacent to the hero.",
					g.map[7][9] instanceof BuildingCell
							&& ((BuildingCell) g.map[7][9]).getBuilding() instanceof Wall);
			assertTrue(
					"The built wall should be added to the map.",
					g.map[7][9] instanceof BuildingCell
							&& ((BuildingCell) g.map[7][9]).getBuilding() instanceof Wall);
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testUseSpecialExistsGame() {
		Method m = null;
		try {

			m = Game.class.getDeclaredMethod("useSpecial", int.class,
					int.class, int.class, int.class);
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Game\" should contain a method called \"useSpecial\" that takes 4 integers as input.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(),
					false);
		}
		assertTrue("Method \"useSpecial\" in class \"Game\" should be void.", m
				.getReturnType().equals(void.class));
	}

	@Test(timeout = 3000)
	public void testUseSpecialInGameNotHero() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);

			g.map[5][0] = new EmptyCell();
			m = Game.class.getDeclaredMethod("useSpecial", int.class,
					int.class, int.class, int.class);
			m.invoke(g, 5, 0, 7, 9);
			fail("Player can only use special using heroes. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Player can only use special using heroes. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testUseSpecialInGameNotHero2() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);

			g.map[5][0] = new ResourceCell(ResourceType.GOLD, 1);
			m = Game.class.getDeclaredMethod("useSpecial", int.class,
					int.class, int.class, int.class);
			m.invoke(g, 5, 0, 7, 9);
			fail("Player can only use special using heroes. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Player can only use special using heroes. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testUseSpecialInGameNotHero3() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);

			m = Game.class.getDeclaredMethod("useSpecial", int.class,
					int.class, int.class, int.class);
			m.invoke(g, 0, 3, 7, 9);
			fail("Player can only use special using heroes. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Player can only use special using heroes. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testUseSpecialInGameNotHero4() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);

			m = Game.class.getDeclaredMethod("useSpecial", int.class,
					int.class, int.class, int.class);
			m.invoke(g, 1, 3, 7, 9);
			fail("Player can only use special using heroes. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Player can only use special using heroes. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testUseSpecialInGameNotSupportUnit() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);

			g.map[2][0] = new UnitCell(h2);
			m = Game.class.getDeclaredMethod("useSpecial", int.class,
					int.class, int.class, int.class);
			m.invoke(g, 1, 0, 2, 0);
			fail("Player can only use special actions targetting support units. InvalidTargetException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidTargetException.class.equals(e.getCause().getClass())))
				fail("Player can only use special actions targetting support units. InvalidTargetException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testUseSpecialInGameNotSupportUnit2() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);

			Building t = new Tower();
			p2.getBuildings().add(t);
			g.map[2][0] = new BuildingCell(t);
			m = Game.class.getDeclaredMethod("useSpecial", int.class,
					int.class, int.class, int.class);
			m.invoke(g, 1, 0, 2, 0);
			fail("Player can only use special actions targetting support units. InvalidTargetException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidTargetException.class.equals(e.getCause().getClass())))
				fail("Player can only use special actions targetting support units. InvalidTargetException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testUseSpecialInGameNotSupportUnit3() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);

			g.map[2][0] = new EmptyCell();
			m = Game.class.getDeclaredMethod("useSpecial", int.class,
					int.class, int.class, int.class);
			m.invoke(g, 1, 0, 2, 0);
			fail("Player can only use special actions targetting support units. InvalidTargetException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidTargetException.class.equals(e.getCause().getClass())))
				fail("Player can only use special actions targetting support units. InvalidTargetException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testUseSpecialInGameNotSupportUnit4() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);

			g.map[2][0] = new ResourceCell(ResourceType.GOLD, 1);
			m = Game.class.getDeclaredMethod("useSpecial", int.class,
					int.class, int.class, int.class);
			m.invoke(g, 1, 0, 2, 0);
			fail("Player can only use special actions targetting support units. InvalidTargetException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidTargetException.class.equals(e.getCause().getClass())))
				fail("Player can only use special actions targetting support units. InvalidTargetException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testUseSpecialInGameNotWithinRange() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);
			m = Game.class.getDeclaredMethod("useSpecial", int.class,
					int.class, int.class, int.class);
			m.invoke(g, 1, 0, 8, 6);
			fail("Player can only use special actions on targets within their range. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Player can only use special actions on targets within their range. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testUseSpecialInGameSuccess() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);
			g.map[9][8] = new UnitCell(h1);
			m = Game.class.getDeclaredMethod("useSpecial", int.class,
					int.class, int.class, int.class);
			SupportUnit u = (SupportUnit) ((UnitCell) g.map[8][6]).getUnit();
			m.invoke(g, 9, 8, 8, 6);
			assertTrue(
					"When an assassin uses their special this should kill the target unit.",
					u.getCurrentHp() == 0);
			assertTrue(
					"When an assassin uses their special the killed unit should be removed from map.",
					g.map[8][6] instanceof EmptyCell);
			assertEquals(
					"When an assassin uses their special their cooldown should be set.",
					3, h1.getSpecialActionCooldown());

		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testUseSpecialInGameSuccess2() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);
			g.map[0][2] = new UnitCell(h2);
			g.currentPlayer = p2;
			m = Game.class.getDeclaredMethod("useSpecial", int.class,
					int.class, int.class, int.class);
			SupportUnit u = (SupportUnit) ((UnitCell) g.map[1][3]).getUnit();
			m.invoke(g, 0, 2, 1, 3);
			assertTrue(
					"When a diplomat uses their special the target unit should be removed from the opponent player's team.",
					!p1.getUnits().contains(u));
			assertTrue(
					"When a diplomat uses their special the target unit should be added to the player's team.",
					p2.getUnits().contains(u));
			assertEquals(
					"When a diplomat uses their special their cooldown should be set.",
					4, h2.getSpecialActionCooldown());

		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testMoveUpExistsGame() {
		Method m = null;
		try {

			m = Game.class.getDeclaredMethod("moveUp", int.class, int.class);
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Game\" should contain a method called \"moveUp\" that takes 2 integers as input.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(),
					false);
		}
		assertTrue("Method \"moveUp\" in class \"Game\" should be void.", m
				.getReturnType().equals(void.class));
	}

	@Test(timeout = 3000)
	public void testMoveUpInGameNotUnit() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		g.currentPlayer = p2;
		Method m = null;
		try {
			layUnits(g, h1, h2);
			m = Game.class.getDeclaredMethod("moveUp", int.class, int.class);
			m.invoke(g, 9, 6);
			fail("Player can only move units. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Player can only move units. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testMoveUpInGameNotUnit2() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		g.currentPlayer = p2;
		Method m = null;
		try {
			layUnits(g, h1, h2);
			m = Game.class.getDeclaredMethod("moveUp", int.class, int.class);
			g.map[5][0] = new EmptyCell();
			m.invoke(g, 5, 0);
			fail("Player can only move units. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Player can only move units. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testMoveUpInGameNotUnit3() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		g.currentPlayer = p2;
		Method m = null;
		try {
			layUnits(g, h1, h2);
			m = Game.class.getDeclaredMethod("moveUp", int.class, int.class);
			g.map[5][0] = new ResourceCell(ResourceType.GOLD, 1);
			m.invoke(g, 5, 0);
			fail("Player can only move units. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Player can only move units. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testMoveUpInGameNotPlayerUnit() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		g.currentPlayer = p2;
		Method m = null;
		try {
			layUnits(g, h1, h2);
			m = Game.class.getDeclaredMethod("moveUp", int.class, int.class);
			m.invoke(g, 1, 1);
			fail("Player can only move his units. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Player can only move his units. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testMoveUpInGameNotPlayerUnit2() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		g.currentPlayer = p2;
		Method m = null;
		try {
			layUnits(g, h1, h2);
			m = Game.class.getDeclaredMethod("moveUp", int.class, int.class);
			m.invoke(g, 1, 0);
			fail("Player can only move his units. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Player can only move his units. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testMoveUpInGameNoActions() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		g.currentPlayer = p2;
		Method m = null;
		try {
			layUnits(g, h1, h2);
			h2.setActionsAvailable(0);
			m = Game.class.getDeclaredMethod("moveUp", int.class, int.class);
			m.invoke(g, 8, 9);
			fail("Player can only move units with at least 1 action available. NotEnoughActionsException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(NotEnoughActionsException.class.equals(e.getCause()
					.getClass())))
				fail("Player can only move units with at least 1 action available. NotEnoughActionsException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testMoveUpInGameOutOfBounds() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		g.currentPlayer = p2;
		Method m = null;
		try {
			layUnits(g, h1, h2);
			g.map[0][9] = new UnitCell(h2);
			m = Game.class.getDeclaredMethod("moveUp", int.class, int.class);
			m.invoke(g, 0, 9);
			fail("Player cannot move outside of bounds. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Player cannot move outside of bounds. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testMoveUpInGameNotValidCell() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		g.currentPlayer = p2;
		Method m = null;
		try {
			layUnits(g, h1, h2);
			m = Game.class.getDeclaredMethod("moveUp", int.class, int.class);
			g.map[7][9] = new BuildingCell(new Tower());
			m.invoke(g, 8, 9);
			fail("Player can only move to Empty or Resource Cells. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Player can only move to Empty or Resource Cells. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testMoveUpInGameNotValidCell2() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		g.currentPlayer = p2;
		Method m = null;
		try {
			layUnits(g, h1, h2);
			m = Game.class.getDeclaredMethod("moveUp", int.class, int.class);
			g.map[7][9] = new UnitCell(new Cavalry());
			m.invoke(g, 8, 9);
			fail("Player can only move to Empty or Resource Cells. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Player can only move to Empty or Resource Cells. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testMoveUpSuccess() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		g.currentPlayer = p2;
		Method m = null;
		try {
			int x = (int) (Math.random() * 10) + 1;
			h2.setMaxActions(x);
			h2.setActionsAvailable(x);
			layUnits(g, h1, h2);
			m = Game.class.getDeclaredMethod("moveUp", int.class, int.class);
			g.map[7][9] = new EmptyCell();
			m.invoke(g, 8, 9);
			assertTrue(
					"map should be updated where the cell moved to contains the moving unit",
					g.map[7][9] instanceof UnitCell
							&& ((UnitCell) g.map[7][9]).getUnit() == h2);
			assertTrue(
					"map should be updated where the cell moved from is now empty",
					g.map[8][9] instanceof EmptyCell);
			assertEquals(
					"Moving unit location should be updated after successfull move",
					new Point(7, 9), h2.getLocation());
			assertEquals(
					"Moving unit actions available should be updated after successfull move",
					x - 1, h2.getActionsAvailable());
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			fail(e.getCause().getClass() + " occurred");

		}
	}

	@Test(timeout = 3000)
	public void testMoveUpSuccessResourceCell() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		g.currentPlayer = p2;
		Method m = null;
		try {
			int x = (int) (Math.random() * 10) + 1;
			h2.setMaxActions(x);
			h2.setActionsAvailable(x);
			layUnits(g, h1, h2);
			m = Game.class.getDeclaredMethod("moveUp", int.class, int.class);
			g.map[7][9] = new ResourceCell(ResourceType.MANPOWER, 200);
			m.invoke(g, 8, 9);
			assertTrue(
					"map should be updated where the cell moved to contains the moving unit",
					g.map[7][9] instanceof UnitCell
							&& ((UnitCell) g.map[7][9]).getUnit() == h2);
			assertTrue(
					"map should be updated where the cell moved from is now empty",
					g.map[8][9] instanceof EmptyCell);
			assertEquals(
					"Moving unit location should be updated after successfull move",
					new Point(7, 9), h2.getLocation());
			assertEquals(
					"Moving unit actions available should be updated after successfull move",
					x - 1, h2.getActionsAvailable());
			assertEquals(
					"Current Player Manpower should be increased when a moving unit enters a resource cell with gold",
					900, p2.getManpowerAmount());
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");

		}
	}

	@Test(timeout = 3000)
	public void testMoveDownExistsGame() {
		Method m = null;
		try {

			m = Game.class.getDeclaredMethod("moveDown", int.class, int.class);
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Game\" should contain a method called \"moveDown\" that takes 2 integers as input.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(),
					false);
		}
		assertTrue("Method \"moveDown\" in class \"Game\" should be void.", m
				.getReturnType().equals(void.class));
	}

	@Test(timeout = 3000)
	public void testMoveDownInGameNotUnit() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);
			m = Game.class.getDeclaredMethod("moveDown", int.class, int.class);
			m.invoke(g, 0, 3);
			fail("Player can only move units. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Player can only move units. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testMoveDownInGameNotUnit2() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);
			m = Game.class.getDeclaredMethod("moveDown", int.class, int.class);
			g.map[5][0] = new EmptyCell();
			m.invoke(g, 5, 0);
			fail("Player can only move units. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Player can only move units. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testMoveDownInGameNotUnit3() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);
			m = Game.class.getDeclaredMethod("moveDown", int.class, int.class);
			g.map[5][0] = new ResourceCell(ResourceType.GOLD, 1);
			m.invoke(g, 5, 0);
			fail("Player can only move units. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Player can only move units. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testMoveDownInGameNotPlayerUnit() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);
			m = Game.class.getDeclaredMethod("moveDown", int.class, int.class);
			m.invoke(g, 8, 9);
			fail("Player can only move his units. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Player can only move his units. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testMoveDownInGameNotPlayerUnit2() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);
			m = Game.class.getDeclaredMethod("moveDown", int.class, int.class);
			m.invoke(g, 8, 6);
			fail("Player can only move his units. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Player can only move his units. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testMoveDownInGameNoActions() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);
			h1.setActionsAvailable(0);
			m = Game.class.getDeclaredMethod("moveDown", int.class, int.class);
			m.invoke(g, 1, 0);
			fail("Player can only move units with at least 1 action available. NotEnoughActionsException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(NotEnoughActionsException.class.equals(e.getCause()
					.getClass())))
				fail("Player can only move units with at least 1 action available. NotEnoughActionsException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testMoveDownInGameOutOfBounds() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);
			g.map[9][0] = new UnitCell(h1);
			m = Game.class.getDeclaredMethod("moveDown", int.class, int.class);
			m.invoke(g, 9, 0);
			fail("Player cannot move outside of bounds. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Player cannot move outside of bounds. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testMoveDownInGameNotValidCell() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);
			m = Game.class.getDeclaredMethod("moveDown", int.class, int.class);
			g.map[2][0] = new BuildingCell(new Tower());
			m.invoke(g, 1, 0);
			fail("Player can only move to Empty or Resource Cells. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Player can only move to Empty or Resource Cells. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testMoveDownInGameNotValidCell2() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);
			m = Game.class.getDeclaredMethod("moveDown", int.class, int.class);
			g.map[2][0] = new UnitCell(new Cavalry());
			m.invoke(g, 1, 0);
			fail("Player can only move to Empty or Resource Cells. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Player can only move to Empty or Resource Cells. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testMoveDownSuccess() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			int x = (int) (Math.random() * 10) + 1;
			h1.setMaxActions(x);
			h1.setActionsAvailable(x);
			layUnits(g, h1, h2);
			m = Game.class.getDeclaredMethod("moveDown", int.class, int.class);
			g.map[2][0] = new EmptyCell();
			m.invoke(g, 1, 0);
			assertTrue(
					"map should be updated where the cell moved to contains the moving unit",
					g.map[2][0] instanceof UnitCell
							&& ((UnitCell) g.map[2][0]).getUnit() == h1);
			assertTrue(
					"map should be updated where the cell moved from is now empty",
					g.map[1][0] instanceof EmptyCell);
			assertEquals(
					"Moving unit location should be updated after successfull move",
					new Point(2, 0), h1.getLocation());
			assertEquals(
					"Moving unit actions available should be updated after successfull move",
					x - 1, h1.getActionsAvailable());
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");

		}
	}

	@Test(timeout = 3000)
	public void testMoveDownSuccessResourceCell() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			int x = (int) (Math.random() * 10) + 1;
			h1.setMaxActions(x);
			h1.setActionsAvailable(x);
			layUnits(g, h1, h2);
			m = Game.class.getDeclaredMethod("moveDown", int.class, int.class);
			g.map[2][0] = new ResourceCell(ResourceType.GOLD, 200);
			m.invoke(g, 1, 0);
			assertTrue(
					"map should be updated where the cell moved to contains the moving unit",
					g.map[2][0] instanceof UnitCell
							&& ((UnitCell) g.map[2][0]).getUnit() == h1);
			assertTrue(
					"map should be updated where the cell moved from is now empty",
					g.map[1][0] instanceof EmptyCell);
			assertEquals(
					"Moving unit location should be updated after successfull move",
					new Point(2, 0), h1.getLocation());
			assertEquals(
					"Moving unit actions available should be updated after successfull move",
					x - 1, h1.getActionsAvailable());
			assertEquals(
					"Current Player Gold should be increased when a moving unit enters a resource cell with gold",
					900, p1.getGoldAmount());
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");

		}
	}

	@Test(timeout = 3000)
	public void testMoveRightExistsGame() {
		Method m = null;
		try {

			m = Game.class.getDeclaredMethod("moveRight", int.class, int.class);
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Game\" should contain a method called \"moveRight\" that takes 2 integers as input.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(),
					false);
		}
		assertTrue("Method \"moveRight\" in class \"Game\" should be void.", m
				.getReturnType().equals(void.class));
	}

	@Test(timeout = 3000)
	public void testMoveRightSuccess() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			int x = (int) (Math.random() * 10) + 1;
			layUnits(g, h1, h2);
			Unit u = ((UnitCell) g.map[1][3]).getUnit();
			u.setMaxActions(x);
			u.setActionsAvailable(x);
			m = Game.class.getDeclaredMethod("moveRight", int.class, int.class);
			g.map[1][4] = new EmptyCell();
			m.invoke(g, 1, 3);
			assertTrue(
					"map should be updated where the cell moved to contains the moving unit",
					g.map[1][4] instanceof UnitCell
							&& ((UnitCell) g.map[1][4]).getUnit() == u);
			assertTrue(
					"map should be updated where the cell moved from is now empty",
					g.map[1][3] instanceof EmptyCell);
			assertEquals(
					"Moving unit location should be updated after successfull move",
					new Point(1, 4), u.getLocation());
			assertEquals(
					"Moving unit actions available should be updated after successfull move",
					x - 1, u.getActionsAvailable());
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");

		}
	}

	@Test(timeout = 3000)
	public void testMoveRightSuccessResourceCell() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			int x = (int) (Math.random() * 10) + 1;
			layUnits(g, h1, h2);
			Unit u = ((UnitCell) g.map[1][3]).getUnit();
			u.setMaxActions(x);
			u.setActionsAvailable(x);
			m = Game.class.getDeclaredMethod("moveRight", int.class, int.class);
			g.map[1][4] = new ResourceCell(ResourceType.GOLD, 200);
			m.invoke(g, 1, 3);
			assertTrue(
					"map should be updated where the cell moved to contains the moving unit",
					g.map[1][4] instanceof UnitCell
							&& ((UnitCell) g.map[1][4]).getUnit() == u);
			assertTrue(
					"map should be updated where the cell moved from is now empty",
					g.map[1][3] instanceof EmptyCell);
			assertEquals(
					"Moving unit location should be updated after successfull move",
					new Point(1, 4), u.getLocation());
			assertEquals(
					"Moving unit actions available should be updated after successfull move",
					x - 1, u.getActionsAvailable());
			assertEquals(
					"Current Player gold should be increased when a moving unit enters a resource cell with gold",
					900, p1.getGoldAmount());
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");

		}
	}

	@Test(timeout = 3000)
	public void testMoveLeftExistsGame() {
		Method m = null;
		try {

			m = Game.class.getDeclaredMethod("moveLeft", int.class, int.class);
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Game\" should contain a method called \"moveLeft\" that takes 2 integers as input.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(),
					false);
		}
		assertTrue("Method \"moveLeft\" in class \"Game\" should be void.", m
				.getReturnType().equals(void.class));
	}

	@Test(timeout = 3000)
	public void testMoveLeftSuccess() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		g.currentPlayer = p2;
		Method m = null;
		try {
			int x = (int) (Math.random() * 10) + 1;
			layUnits(g, h1, h2);
			Unit u = ((UnitCell) g.map[8][6]).getUnit();
			u.setMaxActions(x);
			u.setActionsAvailable(x);
			m = Game.class.getDeclaredMethod("moveLeft", int.class, int.class);
			g.map[8][5] = new EmptyCell();
			m.invoke(g, 8, 6);
			assertTrue(
					"map should be updated where the cell moved to contains the moving unit",
					g.map[8][5] instanceof UnitCell
							&& ((UnitCell) g.map[8][5]).getUnit() == u);
			assertTrue(
					"map should be updated where the cell moved from is now empty",
					g.map[8][6] instanceof EmptyCell);
			assertEquals(
					"Moving unit location should be updated after successfull move",
					new Point(8, 5), u.getLocation());
			assertEquals(
					"Moving unit actions available should be updated after successfull move",
					x - 1, u.getActionsAvailable());
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");

		}
	}

	@Test(timeout = 3000)
	public void testMoveLeftSuccessResourceCell() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		g.currentPlayer = p2;
		Method m = null;
		try {
			int x = (int) (Math.random() * 10) + 1;
			layUnits(g, h1, h2);
			Unit u = ((UnitCell) g.map[8][6]).getUnit();
			u.setMaxActions(x);
			u.setActionsAvailable(x);
			m = Game.class.getDeclaredMethod("moveLeft", int.class, int.class);
			g.map[8][5] = new ResourceCell(ResourceType.MANPOWER, 200);
			m.invoke(g, 8, 6);
			assertTrue(
					"map should be updated where the cell moved to contains the moving unit",
					g.map[8][5] instanceof UnitCell
							&& ((UnitCell) g.map[8][5]).getUnit() == u);
			assertTrue(
					"map should be updated where the cell moved from is now empty",
					g.map[8][6] instanceof EmptyCell);
			assertEquals(
					"Moving unit location should be updated after successfull move",
					new Point(8, 5), u.getLocation());
			assertEquals(
					"Moving unit actions available should be updated after successfull move",
					x - 1, u.getActionsAvailable());
			assertEquals(
					"Current Player Manpower should be increased when a moving unit enters a resource cell with gold",
					900, p2.getManpowerAmount());
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");

		}
	}

	@Test(timeout = 3000)
	public void testAttackExistsGame() {
		Method m = null;
		try {

			m = Game.class.getDeclaredMethod("attack", int.class, int.class,
					int.class, int.class);
		} catch (NoSuchMethodException e) {
			assertTrue(
					"Class \"Game\" should contain a method called \"moveLeft\" that takes 2 integers as input.",
					false);
		} catch (SecurityException e) {
			assertTrue(e.getClass().getName() + " occurred: " + e.getMessage(),
					false);
		}
		assertTrue("Method \"moveLeft\" in class \"Game\" should be void.", m
				.getReturnType().equals(void.class));
	}

	@Test(timeout = 3000)
	public void testAttackInGameNotAttacker() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);
			g.map[5][0] = new BuildingCell(new Barracks());
			m = Game.class.getDeclaredMethod("attack", int.class, int.class,
					int.class, int.class);
			m.invoke(g, 5, 0, 5, 1);
			fail("Player can only attack using valid attacking units or towers. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Player can only attack using valid attacking units or towers. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testAttackInGameNotAttacker2() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);
			g.map[5][0] = new EmptyCell();
			m = Game.class.getDeclaredMethod("attack", int.class, int.class,
					int.class, int.class);
			m.invoke(g, 5, 0, 5, 1);
			fail("Player can only attack using valid attacking units or towers. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Player can only attack using valid attacking units or towers. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testAttackInGameNotAttacker3() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);
			g.map[5][0] = new ResourceCell(ResourceType.GOLD, 1);
			m = Game.class.getDeclaredMethod("attack", int.class, int.class,
					int.class, int.class);
			m.invoke(g, 5, 0, 5, 1);
			fail("Player can only attack using valid attacking units or towers. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Player can only attack using valid attacking units or towers. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testAttackInGameNotAttacker4() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		g.currentPlayer = p2;
		Method m = null;
		try {
			layUnits(g, h1, h2);
			m = Game.class.getDeclaredMethod("attack", int.class, int.class,
					int.class, int.class);
			m.invoke(g, 8, 9, 8, 8);
			fail("Only Aggressor type heroes can attack. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Only Aggressor type heroes can attack. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testAttackInGameNotPlayerAttacker() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);
			m = Game.class.getDeclaredMethod("attack", int.class, int.class,
					int.class, int.class);
			m.invoke(g, 8, 9, 8, 8);
			fail("Player can only attack with their units or towers. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Player can only attack with their units or towers. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testAttackInGameNotPlayerAttacker2() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);
			m = Game.class.getDeclaredMethod("attack", int.class, int.class,
					int.class, int.class);
			m.invoke(g, 9, 6, 8, 8);
			fail("Player can only attack with their units or towers. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Player can only attack with their units or towers. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testAttackInGameTowerCannotAttack() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);
			Tower t = (Tower) ((BuildingCell) g.map[9][6]).getBuilding();
			t.setCanAttack(false);
			m = Game.class.getDeclaredMethod("attack", int.class, int.class,
					int.class, int.class);
			m.invoke(g, 9, 6, 8, 8);
			fail("Towers can only attack once per turn. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Towers can only attack once per turn. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testAttackInGameUnitNotEnoughActions() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		h1.setActionsAvailable(0);
		Method m = null;
		try {
			layUnits(g, h1, h2);
			m = Game.class.getDeclaredMethod("attack", int.class, int.class,
					int.class, int.class);
			m.invoke(g, 1, 0, 2, 0);
			fail("Units can only attack if they have at least 1 action available. NotEnoughActionsException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(NotEnoughActionsException.class.equals(e.getCause()
					.getClass())))
				fail("Units can only attack if they have at least 1 action available. NotEnoughActionsException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testAttackInGameUnitNotValidTarget() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);
			g.map[2][0] = new EmptyCell();
			m = Game.class.getDeclaredMethod("attack", int.class, int.class,
					int.class, int.class);
			m.invoke(g, 1, 0, 2, 0);
			fail("Units can only attack valid enemy units or buildings. InvalidTargetException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidTargetException.class.equals(e.getCause().getClass())))
				fail("Units can only attack valid enemy units or buildings. InvalidTargetException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testAttackInGameUnitNotValidTarget2() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);
			g.map[2][0] = new ResourceCell(ResourceType.GOLD, 1);
			m = Game.class.getDeclaredMethod("attack", int.class, int.class,
					int.class, int.class);
			m.invoke(g, 1, 0, 2, 0);
			fail("Units can only attack valid enemy units or buildings. InvalidTargetException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidTargetException.class.equals(e.getCause().getClass())))
				fail("Units can only attack valid enemy units or buildings. InvalidTargetException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testAttackInGameUnitNotWithinRange() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 30, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);
			g.map[6][0] = new UnitCell(h2);
			m = Game.class.getDeclaredMethod("attack", int.class, int.class,
					int.class, int.class);
			m.invoke(g, 1, 0, 6, 0);
			fail("Units can only attack enemy units or buildings that are within range. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Units can only attack enemy units or buildings that are within range. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testAttackInGameBuildingNotWithinRange() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 30, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);
			Barracks b = new Barracks();
			p2.getBuildings().add(b);
			g.map[6][0] = new BuildingCell(b);
			m = Game.class.getDeclaredMethod("attack", int.class, int.class,
					int.class, int.class);
			m.invoke(g, 1, 0, 6, 0);
			fail("Units can only attack enemy units or buildings that are within range. InvalidActionException should be thrown.");
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			if (!(InvalidActionException.class.equals(e.getCause().getClass())))
				fail("Units can only attack enemy units or buildings that are within range. InvalidActionException should be thrown.");
		}
	}

	@Test(timeout = 3000)
	public void testAttackInGameBuildingSuccess() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 30, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);
			Barracks b = new Barracks();
			int initHp = b.getCurrentHp();
			p2.getBuildings().add(b);
			g.map[3][0] = new BuildingCell(b);
			m = Game.class.getDeclaredMethod("attack", int.class, int.class,
					int.class, int.class);
			m.invoke(g, 1, 0, 3, 0);
			assertEquals(
					"Attacking a valid target within range should decrease its currentHp",
					initHp - ((Assassin) h1).getAttackDmg(), b.getCurrentHp());
			assertEquals(
					"Attacking a valid target within range should set the attacking units actions available to 0",
					0, h1.getActionsAvailable());
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testAttackInGameUnitSuccess() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 30, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);
			Cavalry c = new Cavalry();
			int initHp = c.getCurrentHp();
			p2.getUnits().add(c);
			g.map[3][0] = new UnitCell(c);
			m = Game.class.getDeclaredMethod("attack", int.class, int.class,
					int.class, int.class);
			m.invoke(g, 1, 0, 3, 0);
			assertEquals(
					"Attacking a valid target within range should decrease its currentHp",
					initHp - ((Assassin) h1).getAttackDmg(), c.getCurrentHp());
			assertEquals(
					"Attacking a valid target within range should set the attacking units actions available to 0",
					0, h1.getActionsAvailable());
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testAttackInGameUnitSuccessTower() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 30, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);
			Cavalry c = new Cavalry();
			int initHp = c.getCurrentHp();
			p2.getUnits().add(c);
			g.map[0][5] = new UnitCell(c);
			Tower t = (Tower) ((BuildingCell) g.map[0][3]).getBuilding();
			m = Game.class.getDeclaredMethod("attack", int.class, int.class,
					int.class, int.class);
			m.invoke(g, 0, 3, 0, 5);
			assertEquals(
					"Attacking a valid target within range should decrease its currentHp",
					initHp - 50, c.getCurrentHp());
			assertEquals(
					"Attacking a valid target within range using a tower, should set isCanAttack to false",
					false, t.isCanAttack());
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testAttackInGameBuildingSuccessTower() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 30, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);
			Barracks c = new Barracks();
			int initHp = c.getCurrentHp();
			p2.getBuildings().add(c);
			g.map[0][5] = new BuildingCell(c);
			Tower t = (Tower) ((BuildingCell) g.map[0][3]).getBuilding();
			m = Game.class.getDeclaredMethod("attack", int.class, int.class,
					int.class, int.class);
			m.invoke(g, 0, 3, 0, 5);
			assertEquals(
					"Attacking a valid target within range should decrease its currentHp",
					initHp - 50, c.getCurrentHp());
			assertEquals(
					"Attacking a valid target within range using a tower, should set isCanAttack to false",
					false, t.isCanAttack());
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testAttackInGameBuildingSuccessDestroyed() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 30, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);
			Barracks b = new Barracks();
			b.setCurrentHp(1);
			int initHp = b.getCurrentHp();
			Unit u = ((UnitCell) g.map[1][3]).getUnit();
			p2.getBuildings().add(b);
			g.map[1][5] = new BuildingCell(b);
			m = Game.class.getDeclaredMethod("attack", int.class, int.class,
					int.class, int.class);
			m.invoke(g, 1, 3, 1, 5);
			assertEquals(
					"Attacking a valid target within range should decrease its currentHp",
					0, b.getCurrentHp());
			assertEquals(
					"Attacking a valid target within range should set the attacking units actions available to 0",
					0, u.getActionsAvailable());
			assertTrue(
					"Whenever an attacked unit or building currentHp reaches 0, it should be removed from the map and replaced with an EmptyCell.",
					g.map[1][5] instanceof EmptyCell);
			assertTrue(
					"Whenever an attacked unit or building currentHp reaches 0, it should be removed from the players list of units or buildings.",
					!p2.getBuildings().contains(b));
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	@Test(timeout = 3000)
	public void testAttackInGameUnitSuccessTowerKilled() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 30, 3, 3);
		Game g = new Game(p1, p2);
		Method m = null;
		try {
			layUnits(g, h1, h2);
			Cavalry c = new Cavalry();
			c.setCurrentHp(50);
			p2.getUnits().add(c);
			g.map[0][5] = new UnitCell(c);
			Tower t = (Tower) ((BuildingCell) g.map[0][3]).getBuilding();
			m = Game.class.getDeclaredMethod("attack", int.class, int.class,
					int.class, int.class);
			m.invoke(g, 0, 3, 0, 5);
			assertEquals(
					"Attacking a valid target within range should decrease its currentHp",
					0, c.getCurrentHp());
			assertEquals(
					"Attacking a valid target within range using a tower, should set isCanAttack to false",
					false, t.isCanAttack());
			assertTrue(
					"Whenever an attacked unit or building currentHp reaches 0, it should be removed from the map and replaced with an EmptyCell.",
					g.map[0][5] instanceof EmptyCell);
			assertTrue(
					"Whenever an attacked unit or building currentHp reaches 0, it should be removed from the players list of units or buildings.",
					!p2.getUnits().contains(c));
		} catch (NoSuchMethodException | SecurityException
				| IllegalAccessException | IllegalArgumentException e) {
			fail(e.getCause().getClass() + " occurred");
		} catch (InvocationTargetException e) {
			fail(e.getCause().getClass() + " occurred");
		}
	}

	private void checkValuesUpgrade(Object createdObject, String[] names,
			Object[] values, int level) throws NoSuchMethodException,
			SecurityException, IllegalArgumentException, IllegalAccessException {

		for (int i = 0; i < names.length; i++) {

			Field f = null;
			Class curr = createdObject.getClass();
			String currName = names[i];
			Object currValue = values[i];

			while (f == null) {

				if (curr == Object.class)
					fail("Class " + createdObject.getClass().getSimpleName()
							+ " should have the instance variable \""
							+ currName + "\".");
				try {
					f = curr.getDeclaredField(currName);
				} catch (NoSuchFieldException e) {
					curr = curr.getSuperclass();
				}
			}
			f.setAccessible(true);

			assertEquals("The upgrade of the "
					+ createdObject.getClass().getSimpleName() + " to level "
					+ level + " should set the instance variable \"" + currName
					+ "\" correctly.", currValue, f.get(createdObject));

		}
	}

	private void checkValuesUpgradeBarracks(Object createdObject,
			String[] names, Object[] values, int level)
			throws NoSuchMethodException, SecurityException,
			IllegalArgumentException, IllegalAccessException {

		for (int i = 0; i < names.length; i++) {

			Field f = null;
			Class curr = createdObject.getClass();
			String currName = names[i];
			Object currValue = values[i];

			while (f == null) {

				if (curr == Object.class)
					fail("Class " + createdObject.getClass().getSimpleName()
							+ " should have the instance variable \""
							+ currName + "\".");
				try {
					f = curr.getDeclaredField(currName);
				} catch (NoSuchFieldException e) {
					curr = curr.getSuperclass();
				}
			}
			f.setAccessible(true);

			assertEquals("The recruitment of the "
					+ createdObject.getClass().getSimpleName()
					+ " should be based on the barracks level " + level
					+ " and should set the instance variable \"" + currName
					+ "\" correctly.", currValue, f.get(createdObject));

		}
	}

	private static Game setupGameAndConditions() {
		Player p1 = new Player("p1");
		Player p2 = new Player("p2");
		Hero h1 = new Assassin("Ass1", 3, 3, 3, 20);
		Hero h2 = new Diplomat("Dip2", 3, 3, 3);
		Game g = new Game(p1, p2);
		p1.getUnits().add(h1);
		p2.getUnits().add(h2);
		Palace pal1 = new Palace();
		Palace pal2 = new Palace();
		p1.getBuildings().add(pal1);
		p2.getBuildings().add(pal2);
		return g;
	}

	private static void depleteConditions(Game g) {
		for (Unit u : g.currentPlayer.getUnits()) {
			u.setActionsAvailable(0);
			if (u instanceof Hero)
				((Hero) u).setSpecialActionCooldown(3);
		}
		for (Building b : g.currentPlayer.getBuildings()) {
			if (b instanceof Tower)
				((Tower) b).setCanAttack(false);
			else if (b instanceof Barracks)
				((Barracks) b).setCanRecruit(false);
		}
	}

	private static void layUnits(Game g, Hero h1, Hero h2) {
		Player player1 = g.player1;
		Player player2 = g.player2;
		Cavalry c = new Cavalry();
		Footman f = new Footman();
		Archer a = new Archer();
		Barracks b = new Barracks();
		Tower t = new Tower();
		Palace p = new Palace();
		player1.getBuildings().add(b);
		player1.getBuildings().add(t);
		player1.getBuildings().add(p);
		player1.getUnits().add(h1);
		player1.getUnits().add(c);
		player1.getUnits().add(f);
		player1.getUnits().add(a);
		g.map = new Cell[10][10];

		g.map[0][0] = new BuildingCell(p);
		g.map[0][1] = new BuildingCell(b);
		g.map[0][3] = new BuildingCell(t);
		g.map[1][0] = new UnitCell(h1);
		h1.setLocation(new Point(1, 0));
		g.map[1][1] = new UnitCell(c);
		c.setLocation(new Point(1, 1));
		g.map[1][2] = new UnitCell(f);
		f.setLocation(new Point(1, 2));
		g.map[1][3] = new UnitCell(a);
		a.setLocation(new Point(1, 3));

		Cavalry c2 = new Cavalry();
		Footman f2 = new Footman();
		Archer a2 = new Archer();
		Barracks b2 = new Barracks();
		Tower t2 = new Tower();
		Palace p2 = new Palace();
		player2.getBuildings().add(b2);
		player2.getBuildings().add(t2);
		player2.getBuildings().add(p2);
		player2.getUnits().add(h2);
		player2.getUnits().add(c2);
		player2.getUnits().add(f2);
		player2.getUnits().add(a2);

		g.map[9][9] = new BuildingCell(p2);
		g.map[9][7] = new BuildingCell(b2);
		g.map[9][6] = new BuildingCell(t2);
		g.map[8][9] = new UnitCell(h2);
		h2.setLocation(new Point(8, 9));
		g.map[8][8] = new UnitCell(c2);
		c2.setLocation(new Point(8, 8));
		g.map[8][7] = new UnitCell(f2);
		f2.setLocation(new Point(8, 7));
		g.map[8][6] = new UnitCell(a2);
		a2.setLocation(new Point(8, 6));
	}

}
