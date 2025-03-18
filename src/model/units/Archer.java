package model.units;

import exceptions.InvalidActionException;

public class Archer extends SupportUnit {

	public Archer() {
		super(100, 2, 3, 35);
	}
	
	@Override
	public void upgrade() throws InvalidActionException {
		super.upgrade();
		this.setRange(this.getRange() + 1);
	}
	public String toString() {
		return "Archer {" + "HP: " + this.getCurrentHp() + ", Attack Dmg: " + this.getAttackDmg()
				+ ",Actions: " + this.getActionsAvailable()+" level:"+this.getLevel()+" }";

	}
}
