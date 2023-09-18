package model.units;

public class Assassin extends Hero {
	
	private int attackDmg;

	public Assassin(String name, int maxHp, int maxActions,
			int range, int attackDmg) {
		super(name, HeroType.AGGRESSOR, maxHp, maxActions, range);
		this.attackDmg = attackDmg;
	}

	public int getAttackDmg() {
		return attackDmg;
	}

	@Override
	public void useSpecial(SupportUnit u) {
		u.setCurrentHp(0);
		setSpecialActionCooldown(3);
	}
	public String toString() {
		return "Hero: "+this.getName()+'\n'+
				"HP: " + this.getCurrentHp() + '\n'+
				"Max Actions: " + this.getActionsAvailable()+'\n'+
				 "Range: " + this.getRange()+'\n'+
				 "Damage: "+this.getAttackDmg()
				 ;
		

	}

}
