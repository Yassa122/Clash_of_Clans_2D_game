package model.units;

import exceptions.InvalidActionException;
import exceptions.InvalidTargetException;

public class Warchief extends Hero {

	private int attackDmg;

	public Warchief(String name, int maxHp, int maxActions, int range,
			int attackDmg) {
		super(name, HeroType.AGGRESSOR, maxHp, maxActions, range);
		this.attackDmg = attackDmg;
	}

	public int getAttackDmg() {
		return attackDmg;
	}

	@Override
	public void useSpecial(SupportUnit u) throws InvalidActionException {
		while (u.getLevel() != 3) {
			u.upgrade();
		}
		setSpecialActionCooldown(3);
	}
	public String toString() {
		return "Hero: "+this.getName()+'\n'+
				"HP: " + this.getCurrentHp() + '\n'+
				"Max Actions: " + this.getActionsAvailable()+'\n'+
				 "Range: " + this.getRange()+'\n'+
				 " Damage: "+this.getAttackDmg()
				 ;
		

	}

}
