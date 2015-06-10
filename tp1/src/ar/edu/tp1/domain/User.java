package ar.edu.tp1.domain;

import ar.edu.tp1.domain.attraction.Attraction;
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

	public Float getSpeed() {
		return speed;
	}

	public AttractionType getFavoriteAttraction() {
		return favoriteAttraction;
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

	private boolean hasMoneyEnough(Float money) {
		return getMoney() >= money;
	}

	private boolean hasTimeEnough(Float time) {
		return getTimeRemaining() >= time;
	}

	private boolean isFavoriteAttraction(AttractionType type) {
		return getFavoriteAttraction().equals(type);
	}

	public boolean isValidAttraction(Attraction attraction) {
		return this.hasMoneyEnough(attraction.getCost()) && this.hasTimeEnough(attraction.getVisitTime())
				&& this.isFavoriteAttraction(attraction.getType()) && attraction.hasCapacity();
	}
}