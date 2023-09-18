package model.buildings;

import exceptions.InvalidActionException;

public class Palace extends Building {

	public Palace() {
		super(1000);
	}

	@Override
	public void upgrade() throws InvalidActionException {
		super.upgrade();
		this.setMaxHp(this.getMaxHp() + 500);
		this.setCurrentHp(this.getCurrentHp() + 500);
	}
	public String toString() {
		return "Palace: "+super.toString()+"]";
	}

}
