package ar.edu.tp1.domain;

import java.util.List;

public class Suggestion {

	private List<Attraction> attractionsSuggested;

	public Suggestion(List<Attraction> attractionsSuggested) {
		this.attractionsSuggested = attractionsSuggested;
	}

	public List<Attraction> getAttractionsSuggested() {
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