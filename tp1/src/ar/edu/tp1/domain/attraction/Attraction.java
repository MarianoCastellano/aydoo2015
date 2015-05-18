package ar.edu.tp1.domain.attraction;

import ar.edu.tp1.domain.Position;
import ar.edu.tp1.domain.User;

public class Attraction {

	private Integer id;
	private Float cost;
	private Position position;
	private Float visitTime;
	private AttractionType type;
	private Integer capacity;
	private Integer purchasedTickets;

	public Attraction(Integer id, Position position, Float cost, Float visitTime, AttractionType type, Integer capacity) {
		this.id = id;
		this.position = position;
		this.cost = cost;
		this.visitTime = visitTime;
		this.type = type;
		this.capacity = capacity;
		this.purchasedTickets = new Integer(0);
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public void setVisitTime(Float visitTime) {
		this.visitTime = visitTime;
	}

	public Float getVisitTime() {
		return visitTime;
	}

	public Position getPosition() {
		return position;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public void setType(AttractionType type) {
		this.type = type;
	}

	public AttractionType getType() {
		return type;
	}

	public Integer getId() {
		return id;
	}

	public void purchaseTicket() {
		this.purchasedTickets++;
	}

	public Integer getPurchaseTickets() {
		return this.purchasedTickets;
	}

	public boolean hasMoneyEnough(Float money) {
		return money >= this.cost;
	}

	public boolean hasTimeEnough(Float time) {
		return time >= this.visitTime;
	}

	public boolean IsFavoriteAttraction(AttractionType type) {
		return this.type.equals(type);
	}

	public boolean hasCapacity() {
		return this.capacity > 0;
	}

	public boolean allowUser(User user) {
		return this.hasMoneyEnough(user.getMoney()) && this.hasTimeEnough(user.getTimeRemaining())
				&& this.IsFavoriteAttraction(user.getFavoriteAttraction()) && this.hasCapacity();
	}

	@Override
	public int hashCode() {
		return (int) id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this.getId() == null) {
			return this == obj;
		} else {
			Attraction attraction = (Attraction) obj;
			return this.getId().equals(attraction.getId());
		}
	}

	public boolean isSameAttraction(Attraction attractionForSuggest) {
		return this.equals(attractionForSuggest);
	}

}