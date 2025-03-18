package model.units;

import exceptions.InvalidActionException;
import exceptions.InvalidTargetException;

public abstract class Hero extends Unit {

	private String name;
	private int specialActionCooldown;
	private HeroType type;

	public Hero(String name, HeroType type, int maxHp, int maxActions, int range) {
		super(maxHp, maxActions, range);
		this.name = name;
		this.type = type;
	}

	public int getSpecialActionCooldown() {
		return specialActionCooldown;
	}

	public void setSpecialActionCooldown(int specialActionCooldown) {
		this.specialActionCooldown = specialActionCooldown;
	}

	public String getName() {
		return name;
	}

	public HeroType getType() {
		return type;
	}

	public abstract void useSpecial(SupportUnit u) throws InvalidActionException;

}
