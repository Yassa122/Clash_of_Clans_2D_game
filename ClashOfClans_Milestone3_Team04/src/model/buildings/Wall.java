package model.buildings;

import exceptions.InvalidActionException;

public class Wall extends Building{

	public Wall() {
		super(500);
	}

	@Override
	public void upgrade() throws InvalidActionException {
		super.upgrade();
		this.setMaxHp(this.getMaxHp() + 250);
		this.setCurrentHp(this.getCurrentHp() + 250);
	}

}
