package model.units;

import exceptions.InvalidActionException;
import model.world.Upgradeable;

public abstract class SupportUnit extends Unit implements Upgradeable{
	
	private int attackDmg;
	private int level;

	public SupportUnit(int maxHp, int maxActions, int range, int attackDmg) {
		super(maxHp, maxActions, range);
		this.attackDmg = attackDmg;
		this.level = 1;
	}

	public int getAttackDmg() {
		return attackDmg;
	}

	public void setAttackDmg(int attackDmg) {
		this.attackDmg = attackDmg;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public void upgrade() throws InvalidActionException {
		if(this.level == 3)
			throw new InvalidActionException("Cannot upgrade units past level 3.");
		this.level++;
	}
	
}
