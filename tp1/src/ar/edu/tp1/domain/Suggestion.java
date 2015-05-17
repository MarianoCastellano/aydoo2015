package ar.edu.tp1.domain;

import java.util.Set;

public class Suggestion {

	private Set<Attraction> attractionsSuggested;
	private Float costTotal;

	public Suggestion(Set<Attraction> attractionsSuggested) {
		this.attractionsSuggested = attractionsSuggested;
		this.costTotal = getAttractionCostTotal();
	}

	public Set<Attraction> getAttractionsSuggested() {
		return attractionsSuggested;
	}

	public void addAttractionForSuggested(Attraction attraction) {
		this.attractionsSuggested.add(attraction);
	}

	public void setCostTotal(Float costTotal) {
		this.costTotal = costTotal;
	}

	public Float getCostTotal() {
		return costTotal;
	}

	public Float getAttractionCostTotal() {
		for (Attraction attraction : attractionsSuggested) {
			costTotal = attraction.getCost();
		}
		return costTotal;
	}

}