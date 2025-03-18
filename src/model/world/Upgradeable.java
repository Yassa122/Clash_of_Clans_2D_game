package model.world;

import exceptions.InvalidActionException;

public interface Upgradeable {
	
	void upgrade() throws InvalidActionException;

}
