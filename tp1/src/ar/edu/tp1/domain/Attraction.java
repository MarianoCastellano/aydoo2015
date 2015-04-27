package ar.edu.tp1.domain;

public class Attraction {

	private Integer id;
	private Float cost;
	private Float x;
	private Float y;
	private Float visitTime;
	private AttractionType type;
	private Integer capacity;

	public Attraction(Integer id, Float x, Float y, Float cost, Float visitTime, AttractionType type, Integer capacity) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.cost = cost;
		this.visitTime = visitTime;
		this.type = type;
		this.capacity = capacity;
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

	public Float getX() {
		return x;
	}

	public Float getY() {
		return y;
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
	public boolean equals(Object obj) {
		if (this.getId() == null) {
			return this == obj;
		} else {
			Attraction attraction = (Attraction) obj;
			return this.getId().equals(attraction.getId());
		}
	}
}