package model.units;

import java.awt.Point;

import engine.Player;
import model.world.Cell;

public abstract class Unit {

	private int maxHp;
	private int currentHp;
	private int range;
	private int maxActions;
	private int actionsAvailable;
	private Cell target;
	private Point location;
    public Player getOwner() {
		return owner;
	}

	private Player owner;

	public Unit(int maxHp, int maxActions, int range) {
		this.maxHp = maxHp;
		this.range = range;
		this.maxActions = maxActions;
		this.currentHp = maxHp;
		this.actionsAvailable = maxActions;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getCurrentHp() {
		return currentHp;
	}

	public void setCurrentHp(int currentHp) {
		if (currentHp < 0)
			this.currentHp = 0;
		else if (currentHp >= maxHp)
			this.currentHp = maxHp;
		else
			this.currentHp = currentHp;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getMaxActions() {
		return maxActions;
	}

	public void setMaxActions(int maxActions) {
		this.maxActions = maxActions;
	}

	public int getActionsAvailable() {
		return actionsAvailable;
	}

	public void setActionsAvailable(int actionsAvailable) {
		this.actionsAvailable = actionsAvailable;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public Cell getTarget() {
		return target;
	}

	public void setTarget(Cell target) {
		this.target = target;
	}
	
}
