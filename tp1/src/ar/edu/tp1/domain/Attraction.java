package ar.edu.tp1.domain;

public class Attraction {

	private float cost;

	public Attraction(float cost) {
		this.cost = cost;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public boolean canVisit(float money) {
		return money > this.cost;
	}

}