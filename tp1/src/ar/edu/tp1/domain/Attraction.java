package ar.edu.tp1.domain;

public class Attraction {

	private float cost;
	private float x;
	private float y;
	private float visitTime;
	private AttractionType type;
	private int capacity;

	public Attraction(float x, float y, float cost, float visitTime, AttractionType type, int capacity) {
		this.x = x;
		this.y = y;
		this.cost = cost;
		this.visitTime = visitTime;
		this.type = type;
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void setVisitTime(float visitTime) {
		this.visitTime = visitTime;
	}

	public float getVisitTime() {
		return visitTime;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public void setType(AttractionType type) {
		this.type = type;
	}

	public AttractionType getType() {
		return type;
	}

	public boolean hasMoneyEnough(float money) {
		return money >= this.cost;
	}

	public boolean hasTimeEnough(float time) {
		return time >= this.visitTime;
	}

	public boolean IsFavoriteAttraction(AttractionType type) {
		return this.type.equals(type);
	}

	public boolean hasCapacity() {
		return this.capacity > 0;
	}
}