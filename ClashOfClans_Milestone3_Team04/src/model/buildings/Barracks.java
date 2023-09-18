package model.buildings;

import model.units.Archer;
import model.units.Cavalry;
import model.units.Footman;
import model.units.SupportUnit;
import exceptions.InvalidActionException;

public class Barracks extends Building {

	private boolean canRecruit;

	public Barracks() {
		super(400);
		canRecruit = true;
	}

	public boolean isCanRecruit() {
		return canRecruit;
	}

	public void setCanRecruit(boolean canRecruit) {
		this.canRecruit = canRecruit;
	}

	public SupportUnit recruit(String s) throws InvalidActionException {
		if (!this.canRecruit)
			throw new InvalidActionException(
					"Barracks can only recruit once per turn.");
		SupportUnit u = null;
		if (s.equals("Footman"))
			u = new Footman();
		else if (s.equals("Archer"))
			u = new Archer();
		else
			u = new Cavalry();
		while (u.getLevel() != this.getLevel()) {
			u.upgrade();
		}
		this.canRecruit = false;
		return u;
	}
	public String toString() {
		return "Barracks"+ super.toString()+"recruit: "+this.isCanRecruit()+"]";
	}

}
