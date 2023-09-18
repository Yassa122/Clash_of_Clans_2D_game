package model.buildings;

import model.units.Unit;
import model.world.BuildingCell;
import model.world.Cell;
import model.world.UnitCell;
import exceptions.InvalidActionException;
import exceptions.InvalidTargetException;

public class Tower extends Building {

	private boolean canAttack;
	private int range;

	public Tower() {
		super(200);
		this.range = 3;
		canAttack = true;
	}

	public boolean isCanAttack() {
		return canAttack;
	}

	public void setCanAttack(boolean canAttack) {
		this.canAttack = canAttack;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	@Override
	public void upgrade() throws InvalidActionException {
		super.upgrade();
		this.setRange(this.getRange() + 1);
	}
	public String toString() {
		return "Tower: "+super.toString()+",Can attack: "+isCanAttack()+",range:"+getRange()+"]";
	}

}
