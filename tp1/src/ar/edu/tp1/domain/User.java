package ar.edu.tp1.domain;

import ar.edu.tp1.domain.attraction.AttractionType;

public class User {

	private Float money;
	private Float timeRemaining;
	private AttractionType favoriteAttraction;
	private Float speed;
	private Position position;

	public User(Float money, Float timeRemaining, AttractionType favoriteAttraction, Float speed, Position position) {
		this.money = money;
		this.timeRemaining = timeRemaining;
		this.favoriteAttraction = favoriteAttraction;
		this.speed = speed;
		this.position = position;
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

	public Position getPosition() {
		return position;
	}

}