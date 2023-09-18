package model.units;

import exceptions.InvalidActionException;

public class Footman extends SupportUnit {

	public Footman() {
		super(200, 2, 1, 25);
	}
	
	@Override
	public void upgrade() throws InvalidActionException {
		super.upgrade();
		this.setMaxHp(this.getMaxHp() + 50);
		this.setCurrentHp(this.getCurrentHp() + 50);
	}
	public String toString() {
		return "Footman {" + "HP: " + this.getCurrentHp() + ",Damage: " + this.getAttackDmg()
				+ ", Actions: " + this.getActionsAvailable()+" }";

	}
}
