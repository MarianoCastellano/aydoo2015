package ar.edu.tp1.domain.attraction;

import ar.edu.tp1.domain.Position;

public class Attraction {

	private Integer id;
	private Float cost;
	private Position position;
	private Float visitTime;
	private AttractionType type;
	private Integer capacity;

	public Attraction(Integer id, Position position, Float cost, Float visitTime, AttractionType type, Integer capacity) {
		this.id = id;
		this.position = position;
		this.cost = cost;
		this.visitTime = visitTime;
		this.type = type;
		this.capacity = capacity;
	}

	public Integer getCapacity() {
		return capacity;
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

	public AttractionType getType() {
		return type;
	}

	public Integer getId() {
		return id;
	}

	public boolean hasCapacity() {
		return getCapacity() > 0;
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

}