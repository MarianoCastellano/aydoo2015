package ar.edu.tp1.domain;

public class Attraction {

	private float cost;
	private float x;
	private float y;
	private float visitTime;

	public Attraction(float x, float y, float cost, float visitTime) {
		this.x = x;
		this.y = y;
		this.cost = cost;
		this.visitTime = visitTime;
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

	public boolean hasMoneyEnough(float money) {
		return money >= this.cost;
	}

	public boolean hasTimeEnough(float time) {
		return time >= this.visitTime;
	}

}