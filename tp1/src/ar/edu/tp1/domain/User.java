package ar.edu.tp1.domain;

public class User {

	private float money;
	private float timeRemaining;
	private AttractionType favoriteAttraction;
	private float speed;

	public User(float money, float timeRemaining, AttractionType favoriteAttraction, float speed) {
		this.money = money;
		this.timeRemaining = timeRemaining;
		this.favoriteAttraction = favoriteAttraction;
		this.speed = speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getSpeed() {
		return speed;
	}

	public AttractionType getFavoriteAttraction() {
		return favoriteAttraction;
	}

	public void setFavoriteAttraction(AttractionType favoriteAttraction) {
		this.favoriteAttraction = favoriteAttraction;
	}

	public float getTimeRemaining() {
		return timeRemaining;
	}

	public float getMoney() {
		return money;
	}

}