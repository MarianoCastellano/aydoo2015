package ar.edu.tp1.domain;

public class User {

	private Float money;
	private Float timeRemaining;
	private AttractionType favoriteAttraction;
	private Float speed;

	public User(Float money, Float timeRemaining, AttractionType favoriteAttraction, Float speed) {
		this.money = money;
		this.timeRemaining = timeRemaining;
		this.favoriteAttraction = favoriteAttraction;
		this.speed = speed;
	}

	public void setSpeed(Float speed) {
		this.speed = speed;
	}

	public Float getSpeed() {
		return speed;
	}

	public AttractionType getFavoriteAttraction() {
		return favoriteAttraction;
	}

	public void setFavoriteAttraction(AttractionType favoriteAttraction) {
		this.favoriteAttraction = favoriteAttraction;
	}

	public Float getTimeRemaining() {
		return timeRemaining;
	}

	public Float getMoney() {
		return money;
	}

	public void discountMoney(Float cost) {
		this.money -= cost;
	}

}