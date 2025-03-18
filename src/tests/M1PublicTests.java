package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.awt.Point;

import org.junit.Test;

@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
public class M1PublicTests {

	String barracksPath = "model.buildings.Barracks";
	String buildingPath = "model.buildings.Building";
	String palacePath = "model.buildings.Palace";
	String towerPath = "model.buildings.Tower";
	String wallPath = "model.buildings.Wall";

	String buildingCellPath = "model.world.BuildingCell";
	String cellPath = "model.world.Cell";
	String emptyCellPath = "model.world.EmptyCell";
	String resourceCellPath = "model.world.ResourceCell";
	String resourceTypePath = "model.world.ResourceType";
	String unitCellPath = "model.world.UnitCell";
	String upgradeablePath = "model.world.Upgradeable";

	String unitPath = "model.units.Unit";
	String supportUnitPath = "model.units.SupportUnit";
	String heroPath = "model.units.Hero";
	String cavalryPath = "model.units.Cavalry";
	String footmanPath = "model.units.Footman";
	String archerPath = "model.units.Archer";
	String warchiefPath = "model.units.Warchief";
	String assassinPath = "model.units.Assassin";
	String diplomatPath = "model.units.Diplomat";
	String heroTypePath = "model.units.HeroType";
	String monkPath = "model.units.Monk";

	String gamePath = "engine.Game";
	String playerPath = "engine.Player";

	String gameActionExceptionPath = "exceptions.GameActionException";
	String invalidActionsExceptionPath = "exceptions.InvalidActionException";
	String invalidTargetExceptionPath = "exceptions.InvalidTargetException";
	String movementExceptionPath = "exceptions.MovementException";
	String noAvailableResourcesExceptionPath = "exceptions.NoAvailableResourcesException";
	String notEnoughActionsExceptionPath = "exceptions.NotEnoughActionsException";

	@Test(timeout = 1000)
	public void testHeroTypeClassIsEnum() throws Exception {
		testIsEnum(Class.forName(heroTypePath));
	}

	@Test(timeout = 1000)
	public void testEnumValuesHeroType() {
		String[] inputs = { "PACIFIST", "AGGRESSOR" };
		testEnumValues("ResourceType", heroTypePath, inputs);
	}

	@Test(timeout = 1000)
	public void testDefaultConstructorClassUnit() throws Exception {
		Class[] inputs = {};
		testConstructorDoesnotExist(Class.forName(unitPath), inputs);
	}

	@Test(timeout = 1000)
	public void testConstructorClassUnit() throws Exception {
		Class[] inputs = { int.class, int.class, int.class };
		testConstructorExists(Class.forName(unitPath), inputs);
	}

	@Test(timeout = 1000)
	public void testIsUnitAnAbstractClass() throws Exception {
		testClassIsAbstract(Class.forName(unitPath));
	}

	@Test(timeout = 100)
	public void testUnitInstanceVariableMaxHpPresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(unitPath), "maxHp", true);
	}

	@Test(timeout = 100)
	public void testUnitInstanceVariableMaxHpPrivate() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(unitPath), "maxHp");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableMaxHpIsNotStaticInClassUnit()
			throws Exception {
		testVariableIsNotStatic(unitPath, "maxHp");
	}

	@Test(timeout = 100)
	public void testUnitInstanceVariableCurrentHpPresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(unitPath), "currentHp",
				true);
	}

	@Test(timeout = 100)
	public void testUnitInstanceVariableCurrentHpPrivate() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(unitPath), "currentHp");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableCurrentHpIsNotStaticInClassUnit()
			throws Exception {
		testVariableIsNotStatic(unitPath, "currentHp");
	}

	@Test(timeout = 100)
	public void testUnitInstanceVariableRangePresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(unitPath), "range", true);
	}

	@Test(timeout = 100)
	public void testUnitInstanceVariableRangePrivate() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(unitPath), "range");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableRangeIsNotStaticInClassUnit()
			throws Exception {
		testVariableIsNotStatic(unitPath, "range");
	}

	@Test(timeout = 100)
	public void testUnitInstanceVariableMaxActionsPresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(unitPath), "maxActions",
				true);
	}

	@Test(timeout = 100)
	public void testUnitInstanceVariableMaxActionsPrivate() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(unitPath), "maxActions");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableMaxActionsIsNotStaticInClassUnit()
			throws Exception {
		testVariableIsNotStatic(unitPath, "maxActions");
	}

	@Test(timeout = 100)
	public void testUnitInstanceVariableActionsAvailablePresent()
			throws Exception {
		testInstanceVariableIsPresent(Class.forName(unitPath),
				"actionsAvailable", true);
	}

	@Test(timeout = 100)
	public void testUnitInstanceVariableActionsAvailablePrivate()
			throws Exception {
		testInstanceVariableIsPrivate(Class.forName(unitPath),
				"actionsAvailable");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableActionsAvailableIsNotStaticInClassUnit()
			throws Exception {
		testVariableIsNotStatic(unitPath, "actionsAvailable");
	}

	@Test(timeout = 100)
	public void testUnitInstanceVariableTargetPresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(unitPath), "target", true);
	}

	@Test(timeout = 100)
	public void testUnitInstanceVariableTargetPrivate() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(unitPath), "target");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableTargetIsNotStaticInClassUnit()
			throws Exception {
		testVariableIsNotStatic(unitPath, "target");
	}

	@Test(timeout = 100)
	public void testUnitInstanceVariableLocationPresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(unitPath), "location", true);
	}

	@Test(timeout = 100)
	public void testUnitInstanceVariableLocationPrivate() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(unitPath), "location");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableLocationIsNotStaticInClassUnit()
			throws Exception {
		testVariableIsNotStatic(unitPath, "location");
	}

	@Test(timeout = 1000)
	public void testGetterForInstanceVariableMaxHpExistsInClassUnit()
			throws Exception {
		testGetterMethodExistsInClass(Class.forName(unitPath), "getMaxHp",
				int.class, true);
	}

	@Test(timeout = 1000)
	public void testGetterForInstanceVariableCurrentHpExistsInClassUnit()
			throws Exception {
		testGetterMethodExistsInClass(Class.forName(unitPath), "getCurrentHp",
				int.class, true);
	}

	@Test(timeout = 1000)
	public void testGetterForInstanceVariableMaxActionsExistsInClassUnit()
			throws Exception {
		testGetterMethodExistsInClass(Class.forName(unitPath), "getMaxActions",
				int.class, true);
	}

	@Test(timeout = 1000)
	public void testGetterForInstanceVariableActionsAvailableExistsInClassUnit()
			throws Exception {
		testGetterMethodExistsInClass(Class.forName(unitPath),
				"getActionsAvailable", int.class, true);
	}

	@Test(timeout = 1000)
	public void testGetterForInstanceVariableRangeExistsInClassUnit()
			throws Exception {
		testGetterMethodExistsInClass(Class.forName(unitPath), "getRange",
				int.class, true);
	}

	@Test(timeout = 1000)
	public void testGetterForInstanceVariableTargetExistsInClassUnit()
			throws Exception {
		testGetterMethodExistsInClass(Class.forName(unitPath), "getTarget",
				Class.forName(cellPath), true);
	}

	@Test(timeout = 1000)
	public void testGetterForInstanceVariableLocationExistsInClassUnit()
			throws Exception {
		testGetterMethodExistsInClass(Class.forName(unitPath), "getLocation",
				Point.class, true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableRangeInClassUnitSetter()
			throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(unitPath), "setRange",
				int.class, true);
	}

	@Test(timeout = 1000)
	public void testSetterLogicForInstanceVariableRangeInClassUnit()
			throws Exception {
		int r = (int) (Math.random() * 10) + 1;
		Constructor<?> constructor = Class.forName(cavalryPath)
				.getConstructor();
		Object cavaObject = constructor.newInstance();

		testSetterLogic(cavaObject, "range", r, r, int.class);
	}

	@Test(timeout = 100)
	public void testInstanceVariableCurrentHpInClassUnitSetter()
			throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(unitPath), "setCurrentHp",
				int.class, true);
	}

	@Test(timeout = 1000)
	public void testSetterLogicForInstanceVariableCurrentHpInClassUnit()
			throws Exception {
		int r = (int) (Math.random() * 1067) + 1;
		Constructor<?> constructor = Class.forName(cavalryPath)
				.getConstructor();
		Object cavaObject = constructor.newInstance();

		testSetterLogic(cavaObject, "currentHp", r, r, int.class);
	}

	@Test(timeout = 100)
	public void testInstanceVariableMaxHpInClassUnitSetter()
			throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(unitPath), "setMaxHp",
				int.class, true);
	}

	@Test(timeout = 1000)
	public void testSetterLogicForInstanceVariableMaxHpInClassUnit()
			throws Exception {
		int r = (int) (Math.random() * 1067) + 1;
		Constructor<?> constructor = Class.forName(cavalryPath)
				.getConstructor();
		Object cavaObject = constructor.newInstance();

		testSetterLogic(cavaObject, "maxHp", r, r, int.class);
	}

	@Test(timeout = 100)
	public void testInstanceVariableMaxActionsInClassUnitSetter()
			throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(unitPath), "setMaxActions",
				int.class, true);
	}

	@Test(timeout = 1000)
	public void testSetterLogicForInstanceVariableMaxActionsInClassUnit()
			throws Exception {
		int r = (int) (Math.random() * 12) + 1;
		Constructor<?> constructor = Class.forName(cavalryPath)
				.getConstructor();
		Object cavaObject = constructor.newInstance();

		testSetterLogic(cavaObject, "maxActions", r, r, int.class);
	}

	@Test(timeout = 100)
	public void testInstanceVariableActionsAvailableInClassUnitSetter()
			throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(unitPath),
				"setActionsAvailable", int.class, true);
	}

	@Test(timeout = 1000)
	public void testSetterLogicForInstanceVariableActionsAvailableInClassUnit()
			throws Exception {
		int r = (int) (Math.random() * 12) + 1;
		Constructor<?> constructor = Class.forName(cavalryPath)
				.getConstructor();
		Object cavaObject = constructor.newInstance();

		testSetterLogic(cavaObject, "actionsAvailable", r, r, int.class);
	}

	@Test(timeout = 100)
	public void testInstanceVariableTargetInClassUnitSetter()
			throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(unitPath), "setTarget",
				Class.forName(cellPath), true);
	}

	@Test(timeout = 1000)
	public void testSetterLogicForInstanceVariableTargetInClassUnit()
			throws Exception {
		Constructor<?> constructor = Class.forName(cavalryPath)
				.getConstructor();
		Object cavaObject = constructor.newInstance();
		Constructor<?> cellConstructor = Class.forName(emptyCellPath)
				.getConstructor();
		Object c = cellConstructor.newInstance();
		testSetterLogic(cavaObject, "target", c, c, Class.forName(cellPath));
	}

	@Test(timeout = 100)
	public void testInstanceVariableLocationInClassUnitSetter()
			throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(unitPath), "setLocation",
				Point.class, true);
	}

	@Test(timeout = 1000)
	public void testSetterLogicForInstanceVariableLocationInClassUnit()
			throws Exception {
		Constructor<?> constructor = Class.forName(cavalryPath)
				.getConstructor();
		Object cavaObject = constructor.newInstance();
		int x = (int) (Math.random() * 10);
		int y = (int) (Math.random() * 10);
		Point p = new Point(x, y);
		testSetterLogic(cavaObject, "location", p, p, Point.class);
	}

	@Test(timeout = 1000)
	public void testDefaultConstructorClassSupportUnit() throws Exception {
		Class[] inputs = {};
		testConstructorDoesnotExist(Class.forName(supportUnitPath), inputs);
	}

	@Test(timeout = 1000)
	public void testConstructorClassSupportUnit() throws Exception {
		Class[] inputs = { int.class, int.class, int.class, int.class };
		testConstructorExists(Class.forName(supportUnitPath), inputs);
	}

	@Test(timeout = 1000)
	public void testIsSupportUnitAnAbstractClass() throws Exception {
		testClassIsAbstract(Class.forName(supportUnitPath));
	}

	@Test(timeout = 100)
	public void testSupportUnitInstanceVariableAttackDmgPresent()
			throws Exception {
		testInstanceVariableIsPresent(Class.forName(supportUnitPath),
				"attackDmg", true);
	}

	@Test(timeout = 100)
	public void testSupportUnitInstanceVariableAttackDmgPrivate()
			throws Exception {
		testInstanceVariableIsPrivate(Class.forName(supportUnitPath),
				"attackDmg");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableAttackDmgIsNotStaticInClassSupportUnit()
			throws Exception {
		testVariableIsNotStatic(supportUnitPath, "attackDmg");
	}

	@Test(timeout = 100)
	public void testSupportUnitInstanceVariableLevelPresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(supportUnitPath), "level",
				true);
	}

	@Test(timeout = 100)
	public void testSupportUnitInstanceVariableLevelPrivate() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(supportUnitPath), "level");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableLevelIsNotStaticInClassSupportUnit()
			throws Exception {
		testVariableIsNotStatic(supportUnitPath, "level");
	}

	@Test(timeout = 100)
	public void testInstanceVariableLevelInClassSupportUnitSetter()
			throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(supportUnitPath),
				"setLevel", int.class, true);
	}

	@Test(timeout = 1000)
	public void testGetterForInstanceVariableLevelExistsInClassSupportUnit()
			throws Exception {
		testGetterMethodExistsInClass(Class.forName(supportUnitPath),
				"getLevel", int.class, true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableAttackDmgInClassSupportUnitSetter()
			throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(supportUnitPath),
				"setAttackDmg", int.class, true);
	}

	@Test(timeout = 1000)
	public void testSetterLogicForInstanceVariableAttackDmgInClassSupportUnit()
			throws Exception {
		Constructor<?> constructor = Class.forName(cavalryPath)
				.getConstructor();
		Object cavaObject = constructor.newInstance();
		int x = (int) (Math.random() * 120);
		testSetterLogic(cavaObject, "attackDmg", x, x, int.class);
	}

	@Test(timeout = 1000)
	public void testGetterForInstanceVariableAttackDmgExistsInClassSupportUnit()
			throws Exception {
		testGetterMethodExistsInClass(Class.forName(supportUnitPath),
				"getAttackDmg", int.class, true);
	}

	@Test(timeout = 1000)
	public void testGetterLogicForInstanceVariableAttackDmgInClassSupportUnit()
			throws Exception {
		int random = (int) (Math.random() * 120);

		Constructor<?> constructor = Class.forName(cavalryPath)
				.getConstructor();
		Object cav = constructor.newInstance();
		Field fd = Class.forName(supportUnitPath).getDeclaredField("attackDmg");
		fd.setAccessible(true);
		fd.set(cav, random);
		testGetterLogic(cav, "attackDmg", random);
	}

	@Test(timeout = 1000)
	public void testConstructorClassCavalry() throws Exception {
		Class[] inputs = {};
		testConstructorExists(Class.forName(cavalryPath), inputs);
	}

	@Test(timeout = 1000)
	public void testConstructorClassFootman() throws Exception {
		Class[] inputs = {};
		testConstructorExists(Class.forName(footmanPath), inputs);
	}

	@Test(timeout = 1000)
	public void testConstructorClassArcher() throws Exception {
		Class[] inputs = {};
		testConstructorExists(Class.forName(archerPath), inputs);
	}

	@Test(timeout = 1000)
	public void testConstructorInitializationClassCavalry() throws Exception {
		Constructor<?> constructorTower = Class.forName(cavalryPath)
				.getConstructor();

		Object cavaObject = constructorTower.newInstance();
		String[] names = { "maxHp", "currentHp", "level", "attackDmg",
				"maxActions", "actionsAvailable", "range" };
		Object[] values = { 150, 150, 1, 30, 3, 3, 1 };

		testConstructorInitialization(cavaObject, names, values);
	}

	@Test(timeout = 1000)
	public void testConstructorInitializationClassFootman() throws Exception {
		Constructor<?> constructorTower = Class.forName(footmanPath)
				.getConstructor();

		Object footman = constructorTower.newInstance();
		String[] names = { "maxHp", "currentHp", "level", "attackDmg",
				"maxActions", "actionsAvailable", "range" };
		Object[] values = { 200, 200, 1, 25, 2, 2, 1 };

		testConstructorInitialization(footman, names, values);
	}

	@Test(timeout = 1000)
	public void testConstructorInitializationClassArcher() throws Exception {
		Constructor<?> constructor = Class.forName(archerPath).getConstructor();

		Object archer = constructor.newInstance();
		String[] names = { "maxHp", "currentHp", "level", "attackDmg",
				"maxActions", "actionsAvailable", "range" };
		Object[] values = { 100, 100, 1, 35, 2, 2, 3 };

		testConstructorInitialization(archer, names, values);
	}

	@Test(timeout = 1000)
	public void testDefaultConstructorClassHero() throws Exception {
		Class[] inputs = {};
		testConstructorDoesnotExist(Class.forName(heroPath), inputs);
	}

	@Test(timeout = 1000)
	public void testConstructorClassHero() throws Exception {
		Class[] inputs = { String.class, Class.forName(heroTypePath),
				int.class, int.class, int.class };
		testConstructorExists(Class.forName(heroPath), inputs);
	}

	@Test(timeout = 1000)
	public void testIsHeroAnAbstractClass() throws Exception {
		testClassIsAbstract(Class.forName(heroPath));
	}

	@Test(timeout = 100)
	public void testHeroInstanceVariableNamePresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(heroPath), "name", true);
	}

	@Test(timeout = 100)
	public void testHeroInstanceVariableNamePrivate() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(heroPath), "name");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableNameIsNotStaticInClassHero()
			throws Exception {
		testVariableIsNotStatic(heroPath, "name");
	}

	@Test(timeout = 100)
	public void testHeroInstanceVariableSpecialActionCooldownPresent()
			throws Exception {
		testInstanceVariableIsPresent(Class.forName(heroPath),
				"specialActionCooldown", true);
	}

	@Test(timeout = 100)
	public void testHeroInstanceVariableSpecialActionCooldownPrivate()
			throws Exception {
		testInstanceVariableIsPrivate(Class.forName(heroPath),
				"specialActionCooldown");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableSpecialActionCooldownIsNotStaticInClassHero()
			throws Exception {
		testVariableIsNotStatic(heroPath, "specialActionCooldown");
	}

	@Test(timeout = 100)
	public void testHeroInstanceVariableTypePresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(heroPath), "type", true);
	}

	@Test(timeout = 100)
	public void testHeroInstanceVariableTypePrivate() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(heroPath), "type");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableTypeIsNotStaticInClassHero()
			throws Exception {
		testVariableIsNotStatic(heroPath, "type");
	}

	@Test(timeout = 100)
	public void testInstanceVariableNameInClassHeroSetter()
			throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(heroPath), "setName",
				String.class, false);
	}

	@Test(timeout = 1000)
	public void testGetterForInstanceVariableAttackDmgExistsInClassHero()
			throws Exception {
		testGetterMethodExistsInClass(Class.forName(heroPath), "getName",
				String.class, true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableSpecialActionCooldownInClassHeroSetter()
			throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(heroPath),
				"setSpecialActionCooldown", int.class, true);
	}

	@Test(timeout = 1000)
	public void testGetterForInstanceVariableSpecialActionCooldownExistsInClassHero()
			throws Exception {
		testGetterMethodExistsInClass(Class.forName(heroPath),
				"getSpecialActionCooldown", int.class, true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableTypeInClassHeroSetter()
			throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(heroPath), "setType",
				Class.forName(heroTypePath), false);
	}

	@Test(timeout = 1000)
	public void testGetterForInstanceVariableTypeExistsInClassHero()
			throws Exception {
		testGetterMethodExistsInClass(Class.forName(heroPath), "getType",
				Class.forName(heroTypePath), true);
	}

	@Test(timeout = 1000)
	public void testConstructorClassMonk() throws Exception {
		Class[] inputs = { String.class, int.class, int.class, int.class };
		testConstructorExists(Class.forName(monkPath), inputs);
	}

	@Test(timeout = 1000)
	public void testConstructorInitializationClassMonk() throws Exception {
		Constructor<?> constructor = Class.forName(monkPath).getConstructor(
				String.class, int.class, int.class, int.class);

		String n = "Hero@" + (int) (Math.random() * 1000);
		int mh = (int) (Math.random() * 1000);
		int ma = (int) (Math.random() * 1000);
		int r = (int) (Math.random() * 10);
		Object monk = constructor.newInstance(n, mh, ma, r);
		Object t = Enum.valueOf((Class<Enum>) Class.forName(heroTypePath),
				"PACIFIST");

		String[] names = { "name", "maxHp", "currentHp", "maxActions",
				"actionsAvailable", "range", "type", "specialActionCooldown" };
		Object[] values = { n, mh, mh, ma, ma, r, t, 0 };

		testConstructorInitialization(monk, names, values);
	}

	@Test(timeout = 1000)
	public void testConstructorClassDiplomat() throws Exception {
		Class[] inputs = { String.class, int.class, int.class, int.class };
		testConstructorExists(Class.forName(diplomatPath), inputs);
	}

	@Test(timeout = 1000)
	public void testConstructorInitializationClassDiplomat() throws Exception {
		Constructor<?> constructor = Class.forName(diplomatPath)
				.getConstructor(String.class, int.class, int.class, int.class);

		String n = "Hero@" + (int) (Math.random() * 1000);
		int mh = (int) (Math.random() * 1000);
		int ma = (int) (Math.random() * 1000);
		int r = (int) (Math.random() * 10);
		Object monk = constructor.newInstance(n, mh, ma, r);
		Object t = Enum.valueOf((Class<Enum>) Class.forName(heroTypePath),
				"PACIFIST");

		String[] names = { "name", "maxHp", "currentHp", "maxActions",
				"actionsAvailable", "range", "type", "specialActionCooldown" };
		Object[] values = { n, mh, mh, ma, ma, r, t, 0 };

		testConstructorInitialization(monk, names, values);
	}

	@Test(timeout = 1000)
	public void testConstructorClassWarchief() throws Exception {
		Class[] inputs = { String.class, int.class, int.class, int.class,
				int.class };
		testConstructorExists(Class.forName(warchiefPath), inputs);
	}

	@Test(timeout = 1000)
	public void testConstructorInitializationClassWarchief() throws Exception {
		Constructor<?> constructor = Class.forName(warchiefPath)
				.getConstructor(String.class, int.class, int.class, int.class,
						int.class);

		String n = "Hero@" + (int) (Math.random() * 1000);
		int mh = (int) (Math.random() * 1000);
		int ma = (int) (Math.random() * 1000);
		int a = (int) (Math.random() * 1000);
		int r = (int) (Math.random() * 10);
		Object monk = constructor.newInstance(n, mh, ma, r, a);
		Object t = Enum.valueOf((Class<Enum>) Class.forName(heroTypePath),
				"AGGRESSOR");

		String[] names = { "name", "maxHp", "currentHp", "maxActions",
				"actionsAvailable", "range", "type", "specialActionCooldown",
				"attackDmg" };
		Object[] values = { n, mh, mh, ma, ma, r, t, 0, a };

		testConstructorInitialization(monk, names, values);
	}

	@Test(timeout = 1000)
	public void testConstructorClassAssassin() throws Exception {
		Class[] inputs = { String.class, int.class, int.class, int.class,
				int.class };
		testConstructorExists(Class.forName(assassinPath), inputs);
	}

	@Test(timeout = 1000)
	public void testConstructorInitializationClassAssassin() throws Exception {
		Constructor<?> constructor = Class.forName(assassinPath)
				.getConstructor(String.class, int.class, int.class, int.class,
						int.class);

		String n = "Hero@" + (int) (Math.random() * 1000);
		int mh = (int) (Math.random() * 1000);
		int ma = (int) (Math.random() * 1000);
		int a = (int) (Math.random() * 1000);
		int r = (int) (Math.random() * 10);
		Object monk = constructor.newInstance(n, mh, ma, r, a);
		Object t = Enum.valueOf((Class<Enum>) Class.forName(heroTypePath),
				"AGGRESSOR");

		String[] names = { "name", "maxHp", "currentHp", "maxActions",
				"actionsAvailable", "range", "type", "specialActionCooldown",
				"attackDmg" };
		Object[] values = { n, mh, mh, ma, ma, r, t, 0, a };

		testConstructorInitialization(monk, names, values);
	}

	@Test(timeout = 100)
	public void testWarchiefInstanceVariableAttackDmgPresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(warchiefPath), "attackDmg",
				true);
	}

	@Test(timeout = 100)
	public void testWarchiefInstanceVariableAttackDmgPrivate() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(warchiefPath), "attackDmg");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableAttackDmgIsNotStaticInClassWarchief()
			throws Exception {
		testVariableIsNotStatic(warchiefPath, "attackDmg");
	}

	@Test(timeout = 100)
	public void testAssassinInstanceVariableAttackDmgPresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(assassinPath), "attackDmg",
				true);
	}

	@Test(timeout = 100)
	public void testAssassinInstanceVariableAttackDmgPrivate() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(assassinPath), "attackDmg");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableAttackDmgIsNotStaticInClassAssassin()
			throws Exception {
		testVariableIsNotStatic(assassinPath, "attackDmg");
	}

	@Test(timeout = 1000)
	public void testClassSupportUnitImplementsUpgradeable() throws Exception {
		testClassImplementsInterface(Class.forName(supportUnitPath),
				Class.forName(upgradeablePath));
	}

	@Test(timeout = 1000)
	public void testDefaultConstructorClassBuilding() throws Exception {
		Class[] inputs = {};
		testConstructorDoesnotExist(Class.forName(buildingPath), inputs);
	}

	@Test(timeout = 1000)
	public void testConstructorClassBuilding() throws Exception {
		Class[] inputs = { int.class };
		testConstructorExists(Class.forName(buildingPath), inputs);
	}

	@Test(timeout = 1000)
	public void testIsBuildingAnAbstractClass() throws Exception {
		testClassIsAbstract(Class.forName(buildingPath));
	}

	@Test(timeout = 1000)
	public void testClassBuildingImplementsUpgradeable() throws Exception {
		testClassImplementsInterface(Class.forName(buildingPath),
				Class.forName(upgradeablePath));
	}

	@Test(timeout = 100)
	public void testBuildingInstanceVariableMaxHpPresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(buildingPath), "maxHp",
				true);
	}

	@Test(timeout = 100)
	public void testBuildingInstanceVariableMaxHpPrivate() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(buildingPath), "maxHp");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableMaxHpIsNotStaticInClassBuilding()
			throws Exception {
		testVariableIsNotStatic(buildingPath, "maxHp");
	}

	@Test(timeout = 100)
	public void testBuildingInstanceVariableCurrentHpPresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(buildingPath), "currentHp",
				true);
	}

	@Test(timeout = 100)
	public void testBuildingInstanceVariableCurrentHpPrivate() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(buildingPath), "currentHp");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableCurrentHpIsNotStaticInClassBuilding()
			throws Exception {
		testVariableIsNotStatic(buildingPath, "currentHp");
	}

	@Test(timeout = 100)
	public void testBuildingInstanceVariableLevelPresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(buildingPath), "level",
				true);
	}

	@Test(timeout = 100)
	public void testBuildingInstanceVariableLevelPrivate() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(buildingPath), "level");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableLevelIsNotStaticInClassBuilding()
			throws Exception {
		testVariableIsNotStatic(buildingPath, "level");
	}

	@Test(timeout = 1000)
	public void testGetterForInstanceVariableLevelExistsInClassBuilding()
			throws Exception {
		testGetterMethodExistsInClass(Class.forName(buildingPath), "getLevel",
				int.class, true);
	}

	@Test(timeout = 1000)
	public void testGetterForInstanceVariableMaxHpExistsInClassBuilding()
			throws Exception {
		testGetterMethodExistsInClass(Class.forName(buildingPath), "getMaxHp",
				int.class, true);
	}

	@Test(timeout = 1000)
	public void testGetterForInstanceVariableCurrentHpExistsInClassBuilding()
			throws Exception {
		testGetterMethodExistsInClass(Class.forName(buildingPath),
				"getCurrentHp", int.class, true);
	}

	@Test(timeout = 1000)
	public void testGetterLogicForInstanceVariableMaxHpInClassBuilding()
			throws Exception {
		int random = (int) (Math.random() * 1000);

		Constructor<?> constructor = Class.forName(towerPath).getConstructor();
		Object tower = constructor.newInstance();
		Field fd = Class.forName(buildingPath).getDeclaredField("maxHp");
		fd.setAccessible(true);
		fd.set(tower, random);
		testGetterLogic(tower, "maxHp", random);
	}

	@Test(timeout = 1000)
	public void testGetterLogicForInstanceVariableLevelInClassBuilding()
			throws Exception {
		int random = (int) (Math.random() * 2) + 1;

		Constructor<?> constructor = Class.forName(towerPath).getConstructor();
		Object tower = constructor.newInstance();
		Field fd = Class.forName(buildingPath).getDeclaredField("level");
		fd.setAccessible(true);
		fd.set(tower, random);
		testGetterLogic(tower, "level", random);
	}

	@Test(timeout = 1000)
	public void testGetterLogicForInstanceVariableCurrentHpInClassBuilding()
			throws Exception {
		int random = (int) (Math.random() * 1000);

		Constructor<?> constructor = Class.forName(towerPath).getConstructor();
		Object tower = constructor.newInstance();
		Field fd = Class.forName(buildingPath).getDeclaredField("currentHp");
		fd.setAccessible(true);
		fd.set(tower, random);
		testGetterLogic(tower, "currentHp", random);
	}

	@Test(timeout = 100)
	public void testInstanceVariableMaxHpInClassBuildingSetter()
			throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(buildingPath), "setMaxHp",
				int.class, true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableCurrentHpInClassBuildingSetter()
			throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(buildingPath),
				"setCurrentHp", int.class, true);
	}

	@Test(timeout = 100)
	public void testInstanceVariableLevelInClassBuildingSetter()
			throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(buildingPath), "setLevel",
				int.class, true);
	}

	@Test(timeout = 1000)
	public void testSetterLogicForInstanceVariableLevelInClassBuilding()
			throws Exception {
		int r = (int) (Math.random() * 2) + 1;
		Constructor<?> constructor = Class.forName(towerPath).getConstructor();
		Object tower = constructor.newInstance();

		testSetterLogic(tower, "level", r, r, int.class);
	}

	@Test(timeout = 1000)
	public void testSetterLogicForInstanceVariableMaxHpInClassBuilding()
			throws Exception {
		int r = (int) (Math.random() * 2000);
		Constructor<?> constructor = Class.forName(towerPath).getConstructor();
		Object tower = constructor.newInstance();

		testSetterLogic(tower, "maxHp", r, r, int.class);
	}

	@Test(timeout = 1000)
	public void testSetterLogicForInstanceVariableCurrentHp0InClassBuilding()
			throws Exception {
		Constructor<?> constructor = Class.forName(towerPath).getConstructor();
		Object tower = constructor.newInstance();

		testSetterLogic(tower, "currentHp", -2, 0, int.class);
	}

	@Test(timeout = 1000)
	public void testSetterLogicForInstanceVariableCurrentHpMaxInClassBuilding()
			throws Exception {
		Constructor<?> constructor = Class.forName(towerPath).getConstructor();
		Object tower = constructor.newInstance();
		int r = (int) (Math.random() * 1000);
		Field fd = Class.forName(buildingPath).getDeclaredField("maxHp");
		fd.setAccessible(true);
		int v = (int) fd.get(tower);
		testSetterLogic(tower, "currentHp", v + r, v, int.class);
	}

	@Test(timeout = 1000)
	public void testSetterLogicForInstanceVariableCurrentHpNormInClassBuilding()
			throws Exception {
		Field fd = Class.forName(buildingPath).getDeclaredField("maxHp");
		fd.setAccessible(true);
		Constructor<?> constructor = Class.forName(towerPath).getConstructor();
		Object tower = constructor.newInstance();
		int v = (int) fd.get(tower);
		int r = (int) (Math.random() * v);
		testSetterLogic(tower, "currentHp", v - r, v - r, int.class);
	}

	@Test(timeout = 1000)
	public void testDefaultConstructorClassTower() throws Exception {
		Class[] inputs = {};
		testConstructorExists(Class.forName(towerPath), inputs);
	}

	@Test(timeout = 1000)
	public void testClassIsSubclassTower() throws Exception {
		testClassIsSubclass(Class.forName(towerPath),
				Class.forName(buildingPath));
	}

	@Test(timeout = 100)
	public void testTowerInstanceVariableRangePresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(towerPath), "range", true);
	}

	@Test(timeout = 100)
	public void testTowerInstanceVariableRangePrivate() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(towerPath), "range");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableRangeIsNotStaticInClassTower()
			throws Exception {
		testVariableIsNotStatic(towerPath, "range");
	}

	@Test(timeout = 100)
	public void testTowerInstanceVariableCanAttackPresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(towerPath), "canAttack",
				true);
	}

	@Test(timeout = 100)
	public void testTowerInstanceVariableCanAttackPrivate() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(towerPath), "canAttack");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableCanAttackIsNotStaticInClassTower()
			throws Exception {
		testVariableIsNotStatic(towerPath, "canAttack");
	}

	@Test(timeout = 1000)
	public void testGetterForInstanceVariableCanAttackExistsInClassTower()
			throws Exception {
		testGetterMethodExistsInClass(Class.forName(towerPath), "isCanAttack",
				boolean.class, true);
	}

	@Test(timeout = 1000)
	public void testGetterLogicForInstanceVariableCanAttackInClassTower()
			throws Exception {
		Constructor<?> constructor = Class.forName(towerPath).getConstructor();
		Object tower = constructor.newInstance();
		Field fd = Class.forName(towerPath).getDeclaredField("canAttack");
		fd.setAccessible(true);
		fd.set(tower, false);
		testGetterLogic(tower, "canAttack", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableCanAttackInClassBarracksSetter()
			throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(towerPath), "setCanAttack",
				boolean.class, true);
	}

	@Test(timeout = 1000)
	public void testSetterLogicForInstanceVariableCanAttackInClassTower()
			throws Exception {
		Constructor<?> constructor = Class.forName(towerPath).getConstructor();
		Object tower = constructor.newInstance();

		testSetterLogic(tower, "canAttack", false, false, boolean.class);
	}

	@Test(timeout = 1000)
	public void testGetterForInstanceVariableRangeExistsInClassTower()
			throws Exception {
		testGetterMethodExistsInClass(Class.forName(towerPath), "getRange",
				int.class, true);
	}

	@Test(timeout = 1000)
	public void testGetterLogicForInstanceVariableRangeInClassTower()
			throws Exception {
		Constructor<?> constructor = Class.forName(towerPath).getConstructor();
		Object tower = constructor.newInstance();
		Field fd = Class.forName(towerPath).getDeclaredField("range");
		fd.setAccessible(true);
		int x = (int) (Math.random() * 3);
		fd.set(tower, x);
		testGetterLogic(tower, "range", x);
	}

	@Test(timeout = 100)
	public void testInstanceVariableRangeInClassTowerSetter()
			throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(towerPath), "setRange",
				int.class, true);
	}

	@Test(timeout = 1000)
	public void testSetterLogicForInstanceVariableRangeInClassTower()
			throws Exception {
		Constructor<?> constructor = Class.forName(towerPath).getConstructor();
		Object tower = constructor.newInstance();
		int x = (int) (Math.random() * 3);

		testSetterLogic(tower, "range", x, x, int.class);
	}

	@Test(timeout = 1000)
	public void testSetterLogicForInstanceVariableCanAttack2InClassTower()
			throws Exception {
		Constructor<?> constructor = Class.forName(towerPath).getConstructor();
		Object tower = constructor.newInstance();

		testSetterLogic(tower, "canAttack", true, true, boolean.class);
	}

	@Test(timeout = 1000)
	public void testDefaultConstructorClassWall() throws Exception {
		Class[] inputs = {};
		testConstructorExists(Class.forName(wallPath), inputs);
	}

	@Test(timeout = 1000)
	public void testClassIsSubclassWall() throws Exception {
		testClassIsSubclass(Class.forName(wallPath),
				Class.forName(buildingPath));
	}

	@Test(timeout = 1000)
	public void testDefaultConstructorClassPalace() throws Exception {
		Class[] inputs = {};
		testConstructorExists(Class.forName(palacePath), inputs);
	}

	@Test(timeout = 1000)
	public void testClassIsSubclassPalace() throws Exception {
		testClassIsSubclass(Class.forName(palacePath),
				Class.forName(buildingPath));
	}

	@Test(timeout = 1000)
	public void testDefaultConstructorClassBarracks() throws Exception {
		Class[] inputs = {};
		testConstructorExists(Class.forName(barracksPath), inputs);
	}

	@Test(timeout = 1000)
	public void testClassIsSubclassBarracks() throws Exception {
		testClassIsSubclass(Class.forName(barracksPath),
				Class.forName(buildingPath));
	}

	@Test(timeout = 100)
	public void testBarracksInstanceVariableCanRecruitPresent()
			throws Exception {
		testInstanceVariableIsPresent(Class.forName(barracksPath),
				"canRecruit", true);
	}

	@Test(timeout = 100)
	public void testBarracksInstanceVariableCanRecruitPrivate()
			throws Exception {
		testInstanceVariableIsPrivate(Class.forName(barracksPath), "canRecruit");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableCanRecruitIsNotStaticInClassBarracks()
			throws Exception {
		testVariableIsNotStatic(barracksPath, "canRecruit");
	}

	@Test(timeout = 1000)
	public void testGetterForInstanceVariableCanRecruitExistsInClassBarracks()
			throws Exception {
		testGetterMethodExistsInClass(Class.forName(barracksPath),
				"isCanRecruit", boolean.class, true);
	}

	@Test(timeout = 1000)
	public void testGetterLogicForInstanceVariableCanRecruitInClassBarracks()
			throws Exception {
		Constructor<?> constructor = Class.forName(barracksPath)
				.getConstructor();
		Object barracks = constructor.newInstance();
		Field fd = Class.forName(barracksPath).getDeclaredField("canRecruit");
		fd.setAccessible(true);
		fd.set(barracks, false);
		testGetterLogic(barracks, "canRecruit", false);
	}

	@Test(timeout = 100)
	public void testInstanceVariableCanRecruitInClassBarracksSetter()
			throws ClassNotFoundException {
		testSetterMethodExistsInClass(Class.forName(barracksPath),
				"setCanRecruit", boolean.class, true);
	}

	@Test(timeout = 1000)
	public void testSetterLogicForInstanceVariableCanRecruitInClassBarracks()
			throws Exception {
		Constructor<?> constructor = Class.forName(barracksPath)
				.getConstructor();
		Object barracks = constructor.newInstance();

		testSetterLogic(barracks, "canRecruit", false, false, boolean.class);
	}

	@Test(timeout = 1000)
	public void testSetterLogicForInstanceVariableCanRecruit2InClassBarracks()
			throws Exception {
		Constructor<?> constructor = Class.forName(barracksPath)
				.getConstructor();
		Object barracks = constructor.newInstance();

		testSetterLogic(barracks, "canRecruit", true, true, boolean.class);
	}

	@Test(timeout = 1000)
	public void testConstructorInitializationClassTower() throws Exception {
		Constructor<?> constructorTower = Class.forName(towerPath)
				.getConstructor();

		Object tower = constructorTower.newInstance();
		String[] names = { "maxHp", "currentHp", "level", "range", "canAttack" };
		Object[] values = { 200, 200, 1, 3, true };

		testConstructorInitialization(tower, names, values);
	}

	@Test(timeout = 1000)
	public void testConstructorInitializationClassPalace() throws Exception {
		Constructor<?> constructorPalace = Class.forName(palacePath)
				.getConstructor();

		Object palace = constructorPalace.newInstance();
		String[] names = { "maxHp", "currentHp", "level" };
		Object[] values = { 1000, 1000, 1 };

		testConstructorInitialization(palace, names, values);
	}

	@Test(timeout = 1000)
	public void testConstructorInitializationClassBarracks() throws Exception {
		Constructor<?> constructorBarracks = Class.forName(barracksPath)
				.getConstructor();

		Object barracks = constructorBarracks.newInstance();
		String[] names = { "maxHp", "currentHp", "level", "canRecruit" };
		Object[] values = { 400, 400, 1, true };

		testConstructorInitialization(barracks, names, values);
	}

	@Test(timeout = 1000)
	public void testConstructorInitializationClassWall() throws Exception {
		Constructor<?> constructorWall = Class.forName(wallPath)
				.getConstructor();

		Object wall = constructorWall.newInstance();
		String[] names = { "maxHp", "currentHp", "level" };
		Object[] values = { 500, 500, 1 };

		testConstructorInitialization(wall, names, values);
	}

	@Test(timeout = 100)
	public void testEmptyConstructorGameActionException() throws Exception {

		Class[] inputs = {};
		testConstructorExists(Class.forName(gameActionExceptionPath), inputs);
	}

	@Test(timeout = 100)
	public void testConstructorGameActionException() throws Exception {

		Class[] inputs = { String.class };
		testConstructorExists(Class.forName(gameActionExceptionPath), inputs);
	}

	@Test(timeout = 100)
	public void testClassIsAbstractGameActionException() throws Exception {
		testClassIsAbstract(Class.forName(gameActionExceptionPath));
	}

	@Test(timeout = 1000)
	public void testClassIsSubclassGameActionException() throws Exception {
		testClassIsSubclass(Class.forName(gameActionExceptionPath),
				Exception.class);
	}

	@Test(timeout = 100)
	public void testEmptyConstructorInvalidActionsException() throws Exception {

		Class[] inputs = {};
		testConstructorExists(Class.forName(invalidActionsExceptionPath),
				inputs);
	}

	@Test(timeout = 100)
	public void testConstructorInvalidActionException() throws Exception {

		Class[] inputs = { String.class };
		testConstructorExists(Class.forName(invalidActionsExceptionPath),
				inputs);
	}

	@Test(timeout = 1000)
	public void testClassIsSubclassInvalidActionException() throws Exception {
		testClassIsSubclass(Class.forName(invalidActionsExceptionPath),
				Class.forName(gameActionExceptionPath));
	}

	@Test(timeout = 100)
	public void testEmptyConstructorInvalidTargetException() throws Exception {

		Class[] inputs = {};
		testConstructorExists(Class.forName(invalidTargetExceptionPath), inputs);
	}

	@Test(timeout = 100)
	public void testConstructorInvalidTargetException() throws Exception {

		Class[] inputs = { String.class };
		testConstructorExists(Class.forName(invalidTargetExceptionPath), inputs);
	}

	@Test(timeout = 1000)
	public void testClassIsSubclassInvalidTargetException() throws Exception {
		testClassIsSubclass(Class.forName(invalidTargetExceptionPath),
				Class.forName(gameActionExceptionPath));
	}

	@Test(timeout = 100)
	public void testEmptyConstructorMovementException() throws Exception {

		Class[] inputs = {};
		testConstructorExists(Class.forName(movementExceptionPath), inputs);
	}

	@Test(timeout = 100)
	public void testConstructorMovementException() throws Exception {

		Class[] inputs = { String.class };
		testConstructorExists(Class.forName(movementExceptionPath), inputs);
	}

	@Test(timeout = 1000)
	public void testClassIsSubclassMovementException() throws Exception {
		testClassIsSubclass(Class.forName(movementExceptionPath),
				Class.forName(gameActionExceptionPath));
	}

	@Test(timeout = 100)
	public void testEmptyConstructorNoAvailableResourcesException()
			throws Exception {

		Class[] inputs = {};
		testConstructorExists(Class.forName(noAvailableResourcesExceptionPath),
				inputs);
	}

	@Test(timeout = 100)
	public void testConstructorNoAvailableResourcesException() throws Exception {

		Class[] inputs = { String.class };
		testConstructorExists(Class.forName(noAvailableResourcesExceptionPath),
				inputs);
	}

	@Test(timeout = 1000)
	public void testClassIsSubclassNoAvailableResourcesException()
			throws Exception {
		testClassIsSubclass(Class.forName(noAvailableResourcesExceptionPath),
				Class.forName(gameActionExceptionPath));
	}

	@Test(timeout = 100)
	public void testEmptyConstructorNotEnoughActionsException()
			throws Exception {

		Class[] inputs = {};
		testConstructorExists(Class.forName(notEnoughActionsExceptionPath),
				inputs);
	}

	@Test(timeout = 100)
	public void testConstructorNotEnoughActionsException() throws Exception {

		Class[] inputs = { String.class };
		testConstructorExists(Class.forName(notEnoughActionsExceptionPath),
				inputs);
	}

	@Test(timeout = 1000)
	public void testClassIsSubclassNotEnoughActionsException() throws Exception {
		testClassIsSubclass(Class.forName(notEnoughActionsExceptionPath),
				Class.forName(gameActionExceptionPath));
	}

	@Test(timeout = 1000)
	public void testDefaultConstructorClassCell() throws Exception {
		Class[] inputs = {};
		testConstructorExists(Class.forName(cellPath), inputs);
	}

	@Test(timeout = 1000)
	public void testIsCellAnAbstractClass() throws Exception {
		testClassIsAbstract(Class.forName(cellPath));
	}

	@Test(timeout = 100)
	public void testConstructorUnitCell() throws Exception {
		Class[] inputs = { Class.forName(unitPath) };
		testConstructorExists(Class.forName(unitCellPath), inputs);
	}

	@Test(timeout = 1000)
	public void testCellIsSuperClassOfUnitCell() throws Exception {
		testClassIsSubclass(Class.forName(unitCellPath),
				Class.forName(cellPath));
	}

	@Test(timeout = 100)
	public void testUnitCellInstanceVariableUnitPresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(unitCellPath), "unit", true);
	}

	@Test(timeout = 100)
	public void testUnitCellInstanceVariableUnitPrivate() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(unitCellPath), "unit");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableUnitIsNotStaticInClassUnitCell()
			throws Exception {
		testVariableIsNotStatic(unitCellPath, "unit");
	}

	@Test(timeout = 1000)
	public void testConstructorInitializationClassUnitCell() throws Exception {
		Constructor<?> constructorUnitCell = Class.forName(unitCellPath)
				.getConstructor(Class.forName(unitPath));
		Constructor<?> constructorCavalry = Class.forName(cavalryPath)
				.getConstructor();
		Object c = constructorCavalry.newInstance();

		Object collectCell = constructorUnitCell.newInstance(c);

		String[] names = { "unit" };
		Object[] values = { c };

		testConstructorInitialization(collectCell, names, values);
	}

	@Test(timeout = 100)
	public void testConstructorResourceCell() throws Exception {
		Class[] inputs = { Class.forName(resourceTypePath), int.class };
		testConstructorExists(Class.forName(resourceCellPath), inputs);
	}

	@Test(timeout = 1000)
	public void testCellIsSuperClassOfResourceCell() throws Exception {
		testClassIsSubclass(Class.forName(resourceCellPath),
				Class.forName(cellPath));
	}

	@Test(timeout = 100)
	public void testResourceCellInstanceVariableTypePresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(resourceCellPath), "type",
				true);
	}

	@Test(timeout = 100)
	public void testResourceCellInstanceVariableAmountPresent()
			throws Exception {
		testInstanceVariableIsPresent(Class.forName(resourceCellPath),
				"amount", true);
	}

	@Test(timeout = 1000)
	public void testInstanceVariableAmountIsNotStaticInClassResourceCell()
			throws Exception {
		testVariableIsNotStatic(resourceCellPath, "amount");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableTypeIsNotStaticInClassResourceCell()
			throws Exception {
		testVariableIsNotStatic(resourceCellPath, "type");
	}

	@Test(timeout = 100)
	public void testResourceCellInstanceVariableAmountPrivate()
			throws Exception {
		testInstanceVariableIsPrivate(Class.forName(resourceCellPath), "amount");
	}

	@Test(timeout = 100)
	public void testResourceCellInstanceVariableTypePrivate() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(resourceCellPath), "type");
	}

	@Test(timeout = 1000)
	public void testConstructorInitializationClassResourceCell()
			throws Exception {
		Constructor<?> constructorResourceCell = Class
				.forName(resourceCellPath).getConstructor(
						Class.forName(resourceTypePath), int.class);

		int x = ((int) (Math.random() * 1000));
		Object resourceType = Enum.valueOf(
				(Class<Enum>) Class.forName(resourceTypePath), "MANPOWER");
		Object resourceCell = constructorResourceCell.newInstance(resourceType,
				x);

		String[] names = { "type", "amount" };
		Object[] values = { resourceType, x };

		testConstructorInitialization(resourceCell, names, values);
	}

	@Test(timeout = 1000)
	public void testConstructorInitialization2ClassResourceCell()
			throws Exception {
		Constructor<?> constructorResourceCell = Class
				.forName(resourceCellPath).getConstructor(
						Class.forName(resourceTypePath), int.class);

		int x = ((int) (Math.random() * 1000));
		Object resourceType = Enum.valueOf(
				(Class<Enum>) Class.forName(resourceTypePath), "GOLD");
		Object resourceCell = constructorResourceCell.newInstance(resourceType,
				x);

		String[] names = { "type", "amount" };
		Object[] values = { resourceType, x };

		testConstructorInitialization(resourceCell, names, values);
	}

	@Test(timeout = 1000)
	public void testCellIsSuperClassOfEmptyCell() throws Exception {
		testClassIsSubclass(Class.forName(emptyCellPath),
				Class.forName(cellPath));
	}

	@Test(timeout = 100)
	public void testConstructorEmptyCell() throws Exception {
		Class[] inputs = {};
		testConstructorExists(Class.forName(emptyCellPath), inputs);
	}

	@Test(timeout = 100)
	public void testConstructorBuildingCell() throws Exception {
		Class[] inputs = { Class.forName(buildingPath) };
		testConstructorExists(Class.forName(buildingCellPath), inputs);
	}

	@Test(timeout = 1000)
	public void testCellIsSuperClassOfBuildingCell() throws Exception {
		testClassIsSubclass(Class.forName(buildingCellPath),
				Class.forName(cellPath));
	}

	@Test(timeout = 100)
	public void testBuidlingCellInstanceVariableBuildingPresent()
			throws Exception {
		testInstanceVariableIsPresent(Class.forName(buildingCellPath),
				"building", true);
	}

	@Test(timeout = 100)
	public void testBuildingCellInstanceVariableBuildingPrivate()
			throws Exception {
		testInstanceVariableIsPrivate(Class.forName(buildingCellPath),
				"building");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableBuildingIsNotStaticInClassBuildingCell()
			throws Exception {
		testVariableIsNotStatic(buildingCellPath, "building");
	}

	@Test(timeout = 1000)
	public void testConstructorInitializationClassBuildingCell()
			throws Exception {
		Constructor<?> constructorBuildingCell = Class
				.forName(buildingCellPath).getConstructor(
						Class.forName(buildingPath));
		Constructor<?> constructorTower = Class.forName(towerPath)
				.getConstructor();
		Object c = constructorTower.newInstance();
		Object collectCell = constructorBuildingCell.newInstance(c);

		String[] names = { "building" };
		Object[] values = { c };

		testConstructorInitialization(collectCell, names, values);
	}

	@Test(timeout = 1000)
	public void testConstructorInitialization2ClassBuildingCell()
			throws Exception {
		Constructor<?> constructorBuildingCell = Class
				.forName(buildingCellPath).getConstructor(
						Class.forName(buildingPath));
		Constructor<?> constructorWall = Class.forName(wallPath)
				.getConstructor();
		Object c = constructorWall.newInstance();
		Object collectCell = constructorBuildingCell.newInstance(c);

		String[] names = { "building" };
		Object[] values = { c };

		testConstructorInitialization(collectCell, names, values);
	}

	@Test(timeout = 1000)
	public void testUpgrageableClassIsInterface() throws Exception {
		testIsInterface(Class.forName(upgradeablePath));
	}

	@Test(timeout = 1000)
	public void testResourceTypeClassIsEnum() throws Exception {
		testIsEnum(Class.forName(resourceTypePath));
	}

	@Test(timeout = 1000)
	public void testEnumValuesResourceType() {
		String[] inputs = { "GOLD", "MANPOWER" };
		testEnumValues("ResourceType", resourceTypePath, inputs);
	}

	@Test(timeout = 1000)
	public void testConstructorClassPlayer() throws Exception {
		Class[] inputs = { String.class };
		testConstructorExists(Class.forName(playerPath), inputs);
	}

	@Test(timeout = 100)
	public void testPlayerInstanceVariableNamePresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(playerPath), "name", true);
	}

	@Test(timeout = 100)
	public void testPlayerInstanceVariableNamePrivate() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(playerPath), "name");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableNameIsNotStaticInClassPlayer()
			throws Exception {
		testVariableIsNotStatic(playerPath, "name");
	}

	@Test(timeout = 100)
	public void testPlayerInstanceVariableGoldAmountPresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(playerPath), "goldAmount",
				true);
	}

	@Test(timeout = 100)
	public void testPlayerInstanceVariableGoldAmountPrivate() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(playerPath), "goldAmount");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableGoldAmountIsNotStaticInClassPlayer()
			throws Exception {
		testVariableIsNotStatic(playerPath, "goldAmount");
	}

	@Test(timeout = 100)
	public void testPlayerInstanceVariableManpowerAmountPresent()
			throws Exception {
		testInstanceVariableIsPresent(Class.forName(playerPath),
				"manpowerAmount", true);
	}

	@Test(timeout = 100)
	public void testPlayerInstanceVariableManpowerAmountPrivate()
			throws Exception {
		testInstanceVariableIsPrivate(Class.forName(playerPath),
				"manpowerAmount");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableManpowerAmountIsNotStaticInClassPlayer()
			throws Exception {
		testVariableIsNotStatic(playerPath, "manpowerAmount");
	}

	@Test(timeout = 100)
	public void testPlayerInstanceVariableBuildingsPresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(playerPath), "buildings",
				true);
	}

	@Test(timeout = 100)
	public void testPlayerInstanceVariableBuildingsPrivate() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(playerPath), "buildings");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableBuildingsIsNotStaticInClassPlayer()
			throws Exception {
		testVariableIsNotStatic(playerPath, "buildings");
	}

	@Test(timeout = 100)
	public void testPlayerInstanceVariableUnitsPresent() throws Exception {
		testInstanceVariableIsPresent(Class.forName(playerPath), "units", true);
	}

	@Test(timeout = 100)
	public void testPlayerInstanceVariableUnitsPrivate() throws Exception {
		testInstanceVariableIsPrivate(Class.forName(playerPath), "units");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableUnitsIsNotStaticInClassPlayer()
			throws Exception {
		testVariableIsNotStatic(playerPath, "units");
	}

	@Test(timeout = 1000)
	public void testConstructorInitializationClassPlayer() throws Exception {
		Constructor<?> constructor = Class.forName(playerPath).getConstructor(
				String.class);

		String n = "Player@" + (int) (Math.random() * 10000);
		Object pl = constructor.newInstance(n);
		String[] names = { "name", "manpowerAmount", "goldAmount" };
		Object[] values = { n, 700, 700 };

		testConstructorInitialization(pl, names, values);
	}

	@Test(timeout = 1000)
	public void testConstructorClassGame() throws Exception {
		Class[] inputs = { Class.forName(playerPath), Class.forName(playerPath) };
		testConstructorExists(Class.forName(gamePath), inputs);
	}

	@Test(timeout = 1000)
	public void testConstructorInitializationClassGame() throws Exception {
		Constructor<?> constructor = Class.forName(playerPath).getConstructor(
				String.class);

		String n1 = "Player@" + (int) (Math.random() * 10000);
		Object p1 = constructor.newInstance(n1);
		String n2 = "Player@" + (int) (Math.random() * 10000);
		Object p2 = constructor.newInstance(n1);
		Constructor<?> constructor2 = Class.forName(gamePath).getConstructor(
				Class.forName(playerPath), Class.forName(playerPath));

		Object g = constructor2.newInstance(p1, p2);
		String[] names = { "player1", "player2", "currentPlayer" };
		Object[] values = { p1, p2, p1 };
		testConstructorInitialization(g, names, values);
	}

	@Test(timeout = 1000)
	public void testLoadHeroesMethodMix() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, IOException,
			NoSuchFieldException {

		PrintWriter csvWriter = new PrintWriter("test_heros.csv");

		ArrayList<Object> heros = new ArrayList<Object>();
		Constructor<?> monkConstructor = Class.forName(monkPath)
				.getConstructor(String.class, int.class, int.class, int.class);
		Constructor<?> diplomatConstructor = Class.forName(diplomatPath)
				.getConstructor(String.class, int.class, int.class, int.class);
		Constructor<?> warchiefConstructor = Class.forName(warchiefPath)
				.getConstructor(String.class, int.class, int.class, int.class,
						int.class);
		Constructor<?> assassinConstructor = Class.forName(assassinPath)
				.getConstructor(String.class, int.class, int.class, int.class,
						int.class);

		for (int i = 0; i < 8; i++) {
			int maxHp = ((int) (Math.random() * 100) + 10);
			int maxAc = ((int) (Math.random() * 200) + 10);
			int range = ((int) (Math.random() * 5) + 5);
			int dmg = ((int) (Math.random() * 5) + 5);
			String name = "Hero_" + i;

			String type = "";
			if (i < 2) {
				type = "Diplomat";
				Object createdHero = diplomatConstructor.newInstance(name,
						maxHp, maxAc, range);
				heros.add(createdHero);

			} else if (i < 4) {
				type = "Monk";
				Object createdHero = monkConstructor.newInstance(name, maxHp,
						maxAc, range);
				heros.add(createdHero);
			} else if (i < 6) {
				type = "Warchief";
				Object createdHero = warchiefConstructor.newInstance(name,
						maxHp, maxAc, range, dmg);
				heros.add(createdHero);
			} else {
				type = "Assassin";
				Object createdHero = assassinConstructor.newInstance(name,
						maxHp, maxAc, range, dmg);
				heros.add(createdHero);
			}

			String line = name + "," + type + "," + maxHp + "," + maxAc + ","
					+ range + "," + dmg;
			csvWriter.println(line);
		}
		csvWriter.flush();
		csvWriter.close();

		Field fd = Class.forName(gamePath).getDeclaredField("availableHeroes");
		fd.setAccessible(true);
		fd.set((ArrayList<Object>) fd.get(null), new ArrayList<>());

		Method m = Class.forName(gamePath)
				.getMethod("loadHeroes", String.class);
		m.invoke(null, "test_heros.csv");

		ArrayList<Object> actualChampions = (ArrayList<Object>) fd.get(null);

		assertTrue(
				"Method loadHeroes in Game: the number of Heros Loaded is incorrect",
				actualChampions.size() == heros.size());
		for (int i = 0; i < actualChampions.size(); i++) {

			assertEquals("Wrong Hero type loaded", actualChampions.get(i)
					.getClass(), heros.get(i).getClass());
			assertTrue("Hero's name loaded incorrectly",
					checkHeroesNameEqual(actualChampions.get(i), heros.get(i)));
			assertTrue("Hero's HP loaded incorrectly",
					checkHeroesHPEqual(actualChampions.get(i), heros.get(i)));
			assertTrue(
					"Hero's actions loaded incorrectly",
					checkHeroesActionEqual(actualChampions.get(i), heros.get(i)));
		}

	}

	private static void testEnumValues(String name, String path, String[] value) {
		try {
			Class aClass = Class.forName(path);
			for (int i = 0; i < value.length; i++) {
				try {
					Enum.valueOf((Class<Enum>) aClass, value[i]);
				} catch (IllegalArgumentException e) {
					fail(aClass.getSimpleName() + " enum can be " + value[i]);
				}
			}
		} catch (ClassNotFoundException e1) {
			fail("There should be an enum called " + name + "in package "
					+ path);
		}
	}

	private void testIsEnum(Class aClass) {
		assertEquals(aClass.getName() + " should be an Enum", true,
				aClass.isEnum());
	}

	private void testClassIsAbstract(Class aClass) {
		assertTrue("You should not be able to create new instances from "
				+ aClass.getSimpleName() + " class.",
				Modifier.isAbstract(aClass.getModifiers()));
	}

	private void testIsInterface(Class aClass) {
		assertEquals(aClass.getName() + " should be a abstract", true,
				aClass.isInterface());
	}

	private void testConstructorExists(Class aClass, Class[] inputs) {
		boolean thrown = false;
		try {
			aClass.getConstructor(inputs);
		} catch (NoSuchMethodException e) {
			thrown = true;
		}
		if (inputs.length > 0) {
			String msg = "";
			int i = 0;
			do {
				msg += inputs[i].getSimpleName() + " and ";
				i++;
			} while (i < inputs.length);
			msg = msg.substring(0, msg.length() - 4);
			assertFalse(
					"Missing constructor with " + msg + " parameter"
							+ (inputs.length > 1 ? "s" : "") + " in "
							+ aClass.getSimpleName() + " class.", thrown);
		} else
			assertFalse(
					"Missing constructor with zero parameters in "
							+ aClass.getSimpleName() + " class.", thrown);
	}

	private void testClassIsSubclass(Class subClass, Class superClass) {
		assertEquals(
				subClass.getSimpleName() + " class should be a subclass from "
						+ superClass.getSimpleName() + ".", superClass,
				subClass.getSuperclass());
	}

	private void testClassImplementsInterface(Class aClass, Class iClass) {
		assertTrue("Class \"" + aClass.getSimpleName()
				+ "\" should implement \"" + iClass.getSimpleName()
				+ "\" interface.", iClass.isAssignableFrom(aClass));
	}

	private void testInstanceVariableOfType(Class aClass, String varName,
			Class expectedType) {
		Field f = null;
		boolean b = true;
		try {
			f = aClass.getDeclaredField(varName);
		} catch (NoSuchFieldException e) {
			b = false;
		}
		if (b) {
			Class varType = f.getType();
			assertEquals("The attribute " + varType.getSimpleName()
					+ " of instance variable: " + varName
					+ " should be of the type " + expectedType.getSimpleName(),
					expectedType, varType);
		} else {
			assertTrue(
					"The instance variable \"" + varName
							+ "\" should be declared in class "
							+ aClass.getSimpleName() + ".", false);
		}

	}

	private void testInstanceVariableOfTypeDoubleArray(Class aClass,
			String varName, Class expectedType) {
		Field f = null;
		try {
			f = aClass.getDeclaredField(varName);
		} catch (NoSuchFieldException e) {
			return;
		}
		Class varType = f.getType();
		assertEquals("the attribute: " + varType.getSimpleName()
				+ " should be of the type: " + expectedType.getSimpleName(),
				expectedType.getTypeName() + "[][]", varType.getTypeName());
	}

	private void testInstanceVariableIsPresent(Class aClass, String varName,
			boolean implementedVar) throws SecurityException {
		boolean thrown = false;
		try {
			aClass.getDeclaredField(varName);
		} catch (NoSuchFieldException e) {
			thrown = true;
		}
		if (implementedVar) {
			assertFalse("There should be \"" + varName
					+ "\" instance variable in class " + aClass.getSimpleName()
					+ ".", thrown);
		} else {
			assertTrue(
					"The instance variable \"" + varName
							+ "\" should not be declared in class "
							+ aClass.getSimpleName() + ".", thrown);
		}
	}

	private void testInstanceVariableIsPrivate(Class aClass, String varName)
			throws NoSuchFieldException, SecurityException {
		Field f = aClass.getDeclaredField(varName);
		boolean b = 2 == f.getModifiers();
		assertTrue("The \"" + varName + "\" instance variable in class "
				+ aClass.getSimpleName()
				+ " should not be accessed outside that class.", b);
	}

	private void testConstructorDoesnotExist(Class aClass, Class[] inputs) {
		boolean thrown = false;
		try {
			aClass.getConstructor(inputs);
		} catch (NoSuchMethodException e) {
			thrown = true;
		}
		if (inputs.length > 0) {
			String msg = "";
			int i = 0;
			do {
				msg += inputs[i].getSimpleName() + " and ";
				i++;
			} while (i < inputs.length);
			msg = msg.substring(0, msg.length() - 4);
			assertTrue("There should not be a  constructor with " + msg
					+ " parameter" + (inputs.length > 1 ? "s" : "") + " in "
					+ aClass.getSimpleName() + " class.", thrown);
		} else
			assertTrue(
					"Missing constructor with zero parameters in "
							+ aClass.getSimpleName() + " class.", thrown);
	}

	private void testGetterMethodExistsInClass(Class aClass, String methodName,
			Class returnedType, boolean readvariable) {
		Method m = null;
		boolean found = true;
		try {
			m = aClass.getDeclaredMethod(methodName);
		} catch (NoSuchMethodException e) {
			found = false;
		}

		String varName = "";
		if (returnedType == boolean.class)
			varName = methodName.substring(2, 3).toLowerCase()
					+ methodName.substring(3);
		else
			varName = methodName.substring(3, 4).toLowerCase()
					+ methodName.substring(4);
		if (readvariable) {
			assertTrue("The \"" + varName + "\" instance variable in class "
					+ aClass.getSimpleName() + " is a READ variable.", found);
			assertTrue("Incorrect return type for " + methodName
					+ " method in " + aClass.getSimpleName() + " class.", m
					.getReturnType().isAssignableFrom(returnedType));
		} else {
			assertFalse("The \"" + varName + "\" instance variable in class "
					+ aClass.getSimpleName() + " is not a READ variable.",
					found);
		}

	}

	private void testGetterLogic(Object createdObject, String name, Object value)
			throws Exception {

		Field f = null;
		Class curr = createdObject.getClass();

		while (f == null) {

			if (curr == Object.class)
				fail("Class " + createdObject.getClass().getSimpleName()
						+ " should have the instance variable \"" + name
						+ "\".");
			try {
				f = curr.getDeclaredField(name);
			} catch (NoSuchFieldException e) {
				curr = curr.getSuperclass();
			}

		}

		f.setAccessible(true);
		f.set(createdObject, value);

		Character c = name.charAt(0);

		String methodName = "get" + Character.toUpperCase(c)
				+ name.substring(1, name.length());

		if (value.getClass().equals(Boolean.class)
				&& !name.substring(0, 2).equals("is"))
			methodName = "is" + Character.toUpperCase(c)
					+ name.substring(1, name.length());
		else if (value.getClass().equals(Boolean.class)
				&& name.substring(0, 2).equals("is"))
			methodName = "is" + Character.toUpperCase(name.charAt(2))
					+ name.substring(3, name.length());

		Method m = createdObject.getClass().getMethod(methodName);
		assertEquals("The method \"" + methodName + "\" in class "
				+ createdObject.getClass().getSimpleName()
				+ " should return the correct value of variable \"" + name
				+ "\".", value, m.invoke(createdObject));

	}

	private void testSetterMethodExistsInClass(Class aClass, String methodName,
			Class inputType, boolean writeVariable) {

		Method[] methods = aClass.getDeclaredMethods();
		String varName = methodName.substring(3, 4).toLowerCase()
				+ methodName.substring(4);
		if (writeVariable) {
			assertTrue("The \"" + varName + "\" instance variable in class "
					+ aClass.getSimpleName() + " is a WRITE variable.",
					containsMethodName(methods, methodName));
		} else {
			assertFalse("The \"" + varName + "\" instance variable in class "
					+ aClass.getSimpleName() + " is not a WRITE variable.",
					containsMethodName(methods, methodName));
			return;
		}
		Method m = null;
		boolean found = true;
		try {
			m = aClass.getDeclaredMethod(methodName, inputType);
		} catch (NoSuchMethodException e) {
			found = false;
		}

		assertTrue(aClass.getSimpleName() + " class should have " + methodName
				+ " method that takes one " + inputType.getSimpleName()
				+ " parameter.", found);

		assertTrue("Incorrect return type for " + methodName + " method in "
				+ aClass.getSimpleName() + ".",
				m.getReturnType().equals(Void.TYPE));

	}

	private void testSetterLogic(Object createdObject, String name,
			Object setValue, Object expectedValue, Class type) throws Exception {

		Field f = null;
		Class curr = createdObject.getClass();

		while (f == null) {

			if (curr == Object.class)
				fail("Class " + createdObject.getClass().getSimpleName()
						+ " should have the instance variable \"" + name
						+ "\".");
			try {
				f = curr.getDeclaredField(name);
			} catch (NoSuchFieldException e) {
				curr = curr.getSuperclass();
			}

		}

		f.setAccessible(true);

		Character c = name.charAt(0);
		String methodName = "set" + Character.toUpperCase(c)
				+ name.substring(1, name.length());
		Method m = createdObject.getClass().getMethod(methodName, type);
		m.invoke(createdObject, setValue);

		assertEquals(
				"The method \"" + methodName + "\" in class "
						+ createdObject.getClass().getSimpleName()
						+ " should set the correct value of variable \"" + name
						+ "\".", expectedValue, f.get(createdObject));

	}

	private static boolean containsMethodName(Method[] methods, String name) {
		for (Method method : methods) {
			if (method.getName().equals(name))
				return true;
		}
		return false;
	}

	private void testConstructorInitialization(Object createdObject,
			String[] names, Object[] values) throws NoSuchMethodException,
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
			if (currName.equals("currentHp")
					|| currName.equals("currentActionPoints")) {

				assertEquals(
						"The constructor of the "
								+ createdObject.getClass().getSimpleName()
								+ " class should initialize the instance variable \""
								+ currName
								+ "\" correctly. It should be equals to the max initially.",
						currValue, f.get(createdObject));
			} else {
				assertEquals("The constructor of the "
						+ createdObject.getClass().getSimpleName()
						+ " class should initialize the instance variable \""
						+ currName + "\" correctly.", currValue,
						f.get(createdObject));
			}
		}

	}

	private boolean checkHeroesNameEqual(Object hero1, Object hero2)
			throws IllegalArgumentException, IllegalAccessException,
			ClassNotFoundException {
		Class curr1 = Class.forName(heroPath);

		Field name1 = null;

		try {
			name1 = curr1.getDeclaredField("name");
			name1.setAccessible(true);

			String n1 = (String) name1.get(hero1);
			String n2 = (String) name1.get(hero2);
			// assertTrue("Hero's name is loaded incorrectly",
			return n1.equals(n2);

		} catch (NoSuchFieldException e) {
			curr1 = curr1.getSuperclass();
			fail("Attributes name error");
			return false;
		}
	}

	private boolean checkHeroesHPEqual(Object hero1, Object hero2)
			throws IllegalArgumentException, IllegalAccessException,
			ClassNotFoundException {
		Class curr1 = Class.forName(unitPath);

		Field maxhp1 = null;

		try {
			maxhp1 = curr1.getDeclaredField("currentHp");
			maxhp1.setAccessible(true);

			int mh1 = (int) maxhp1.get(hero1);
			int mh2 = (int) maxhp1.get(hero2);
			return mh1 == mh2;

		} catch (NoSuchFieldException e) {
			curr1 = curr1.getSuperclass();
			fail("Attributes name error");
			return false;
		}

	}

	private boolean checkHeroesActionEqual(Object hero1, Object hero2)
			throws IllegalArgumentException, IllegalAccessException,
			ClassNotFoundException {
		Class curr1 = Class.forName(unitPath);

		Field maxActions1 = null;

		try {
			maxActions1 = Class.forName(unitPath)
					.getDeclaredField("maxActions");
			maxActions1.setAccessible(true);

			int ma1 = (int) maxActions1.get(hero1);
			int ma2 = (int) maxActions1.get(hero2);
			return ma1 == ma2;

		} catch (NoSuchFieldException e) {
			curr1 = curr1.getSuperclass();
			fail("Attributes name error");
			return false;
		}

	}

	public void testVariableIsNotStatic(String classPath, String varName)
			throws NoSuchFieldException, SecurityException,
			ClassNotFoundException {
		Field f = Class.forName(classPath).getDeclaredField(varName);
		int modifiers = f.getModifiers();
		assertTrue(
				f.getName() + " variable in class "
						+ Class.forName(classPath).getSimpleName()
						+ " should not be static",
				(!Modifier.isStatic(modifiers)));
	}
}
