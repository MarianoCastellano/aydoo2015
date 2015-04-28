package ar.edu.tp1.domain;

import java.util.Set;

public class Suggestion {

	private Set<Attraction> attractionsSuggested;

	public Suggestion(Set<Attraction> attractionsSuggested) {
		this.attractionsSuggested = attractionsSuggested;
	}

	public Set<Attraction> getAttractionsSuggested() {
		return attractionsSuggested;
	}

	public void addAttractionForSuggested(Attraction attraction) {
		this.attractionsSuggested.add(attraction);
	}

	public Float getTotalCost() {
		Float totalCost = 0f;
		for (Attraction attraction : attractionsSuggested) {
			totalCost += attraction.getCost();
		}
		return totalCost;
	}

}