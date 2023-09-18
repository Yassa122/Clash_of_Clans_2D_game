package model.units;

import exceptions.InvalidActionException;

public class Cavalry extends SupportUnit {

	public Cavalry() {
		super(150, 3, 1, 30);
	}

	@Override
	public void upgrade() throws InvalidActionException {
		super.upgrade();
		this.setMaxActions(this.getMaxActions() + 1);
		this.setActionsAvailable(this.getActionsAvailable() + 1);
	}

	@Override
	public String toString() {
		return "Cavalry {" +'\n'+
	"HP: " + this.getCurrentHp() + "\n"+
	", Damage: " + this.getAttackDmg()
				+"\n"+
	", Actions: " + this.getActionsAvailable()+" }";

	}
}
