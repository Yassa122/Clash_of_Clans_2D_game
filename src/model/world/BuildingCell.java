package model.world;

import model.buildings.Building;

public class BuildingCell extends Cell {

	private Building building;

	public BuildingCell(Building building) {
		this.building = building;
	}

	public Building getBuilding() {
		return building;
	}

}
