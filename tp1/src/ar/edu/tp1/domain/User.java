package ar.edu.tp1.domain;

public class User {

	private float money;
	private float timeRemaining;
	private AttractionType favoriteAttraction;

	public User(float money, float timeRemaining, AttractionType favoriteAttraction) {
		this.money = money;
		this.timeRemaining = timeRemaining;
		this.favoriteAttraction = favoriteAttraction;
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