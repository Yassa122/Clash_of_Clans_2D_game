package model.world;

public class ResourceCell extends Cell {

	private ResourceType type;
	private int amount;

	public ResourceCell(ResourceType t, int a) {
		super();
		type = t;
		amount = a;
	}

	public ResourceType getType() {
		return type;
	}

	public int getAmount() {
		return amount;
	}

}
