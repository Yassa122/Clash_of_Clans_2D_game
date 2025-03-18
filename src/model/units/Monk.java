package model.units;

import exceptions.InvalidActionException;
import exceptions.InvalidTargetException;

public class Monk extends Hero {

	public Monk(String name, int maxHp, int maxActions, int range) {
		super(name, HeroType.PACIFIST, maxHp, maxActions, range);
	}

	@Override
	public void useSpecial(SupportUnit u) throws InvalidActionException {
		u.setCurrentHp(u.getMaxHp());
		setSpecialActionCooldown(2);
	}
	
	public String toString() {
		return "Hero: "+this.getName()+'\n'+
				"HP: " + this.getCurrentHp() + '\n'+
				"Max Actions: " + this.getActionsAvailable()+'\n'+
				 "Range: " + this.getRange();

	}

}
