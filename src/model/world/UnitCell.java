package model.world;

import model.units.Unit;

public class UnitCell extends Cell {
	
	private Unit unit;

	public UnitCell(Unit u) {
		this.unit = u;
	}

	public Unit getUnit() {
		return unit;
	}

}
