package ar.edu.tp1.domain;

public class User {

	private float money;
	private float timeRemaining;

	public User(float money, float timeRemaining) {
		this.money = money;
		this.timeRemaining = timeRemaining;
	}

	public void discountTime(float time) {
		this.timeRemaining -= time;
	}

	public float getTimeRemaining() {
		return timeRemaining;
	}

	public float getMoney() {
		return money;
	}

}