package engine;

import java.util.ArrayList;

import model.buildings.Barracks;
import model.buildings.Building;
import model.buildings.Tower;
import model.buildings.Wall;
import model.units.Assassin;
import model.units.Diplomat;
import model.units.Hero;
import model.units.Monk;
import model.units.SupportUnit;
import model.units.Unit;
import model.units.Warchief;
import exceptions.InvalidActionException;
import exceptions.InvalidTargetException;
import exceptions.NoAvailableResourcesException;
import exceptions.NotEnoughActionsException;

public class Player {

	public void setName(String name) {
		this.name = name;
	}

	private String name;
	private ArrayList<Unit> units;
	private ArrayList<Building> buildings;
	private int goldAmount;
	private int manpowerAmount;
    private Hero selectedHero; // new member variable to hold the selected Hero


	public Player(String name) {
		this.name = name;
		this.goldAmount = 700;
		this.manpowerAmount = 700;
		this.units = new ArrayList<Unit>();
		this.buildings = new ArrayList<Building>();
	}
	
	 public void setSelectedHero(Hero selectedHero) {
	        this.selectedHero = selectedHero;
	    }

	    public Hero getSelectedHero() {
	        return this.selectedHero;
	    }

	public int getGoldAmount() {
		return goldAmount;
	}

	public void setGoldAmount(int goldAmount) {
		this.goldAmount = goldAmount;
	}

	public int getManpowerAmount() {
		return manpowerAmount;
	}

	public void setManpowerAmount(int manpowerAmount) {
		this.manpowerAmount = manpowerAmount;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Unit> getUnits() {
		return units;
	}

	public ArrayList<Building> getBuildings() {
		return buildings;
	}

	public void upgradeUnit(SupportUnit u)
			throws NoAvailableResourcesException, InvalidTargetException,
			InvalidActionException {
		int neededManpower = u.getLevel() * 50;
		if (manpowerAmount < neededManpower)
			throw new NoAvailableResourcesException();
		else if (!units.contains(u))
			throw new InvalidTargetException();
		else {
			u.upgrade();
			manpowerAmount -= neededManpower;
		}
	}

	public void upgradeBuilding(Building b) throws InvalidTargetException,
			NoAvailableResourcesException, InvalidActionException {
		int neededGold = b.getLevel() * 50;
		if (goldAmount < neededGold)
			throw new NoAvailableResourcesException();
		if (!buildings.contains(b))
			throw new InvalidTargetException();
		else {
			b.upgrade();
			goldAmount -= neededGold;
		}
	}

	public SupportUnit recruit(Barracks b, String s)
			throws InvalidTargetException, NoAvailableResourcesException,
			InvalidActionException {
		if (!buildings.contains(b))
			throw new InvalidTargetException();
		if (manpowerAmount < 100)
			throw new NoAvailableResourcesException();
		SupportUnit u = b.recruit(s);
		manpowerAmount -= 100;
		units.add(u);
		return u;
	}

	public Tower buildTower(Hero h) throws InvalidActionException,
			NoAvailableResourcesException, NotEnoughActionsException {
		if (!units.contains(h))
			throw new InvalidActionException();
		if (goldAmount < 100)
			throw new NoAvailableResourcesException();
		if (h.getActionsAvailable() < 1)
			throw new NotEnoughActionsException();
		Tower t = new Tower();
		buildings.add(t);
		goldAmount -= 100;
		return t;
	}

	public Wall buildWall(Hero h) throws InvalidActionException,
			NoAvailableResourcesException, NotEnoughActionsException {
		if (!units.contains(h))
			throw new InvalidActionException();
		if (goldAmount < 100)
			throw new NoAvailableResourcesException();
		if (h.getActionsAvailable() < 1)
			throw new NotEnoughActionsException();
		Wall t = new Wall();
		buildings.add(t);
		goldAmount -= 100;
		h.setActionsAvailable(h.getActionsAvailable() - 1);
		return t;
	}

	public void useSpecial(Hero h, SupportUnit u) throws InvalidActionException, InvalidTargetException {
		if (!units.contains(h))
			throw new InvalidActionException();
		if (h.getSpecialActionCooldown() > 0)
			throw new InvalidActionException();
		if((h instanceof Diplomat || h instanceof Assassin) && units.contains(u))
			throw new InvalidTargetException();
		if((h instanceof Warchief || h instanceof Monk) && !units.contains(u))
			throw new InvalidTargetException();
		h.useSpecial(u);
	}

}
