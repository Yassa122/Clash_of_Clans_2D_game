package model.units;

import exceptions.InvalidActionException;
import exceptions.InvalidTargetException;

public class Diplomat extends Hero {
	
	public Diplomat(String name, int maxHp, int maxActions,
			int range) {
		super(name, HeroType.PACIFIST, maxHp, maxActions, range);
	}

	@Override
	public void useSpecial(SupportUnit u) throws InvalidActionException {
		setSpecialActionCooldown(4);
	}
	public String toString() {
		return "Hero: "+this.getName()+"\n"+
				"HP: " + this.getCurrentHp() + "\n"+
				"Max Actions: " + this.getActionsAvailable()+"\n"+
				 "Range: " + this.getRange();

	}
}
