package model.buildings;

import engine.Player;
import exceptions.InvalidActionException;
import model.world.Upgradeable;

public abstract class Building implements Upgradeable {

	private int maxHp;
	private int currentHp;
	private int level;
    public Player getOwner() {
		return owner;
	}

	private Player owner;

	public Building(int maxHp) {
		this.maxHp = maxHp;
		this.currentHp = maxHp;
		this.level = 1;
	}

	public int getCurrentHp() {
		return currentHp;
	}

	public void setCurrentHp(int currentHp) {
		if (currentHp < 0)
			this.currentHp = 0;
		else if (currentHp > maxHp)
			this.currentHp = maxHp;
		else
			this.currentHp = currentHp;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	@Override
	public void upgrade() throws InvalidActionException {
		if (this.level == 3) {
			throw new InvalidActionException("Cannot upgrade past level 3");
		}
		this.level++;
	}

	@Override
	public String toString() {
		return String.format(" [Max HP: %d, Current HP: %d, Level: %d", maxHp, currentHp, level);
	}

}
