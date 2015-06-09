package ar.edu.tp1.domain.attraction;

import java.util.Set;

public class Suggestion {

	private Set<Attraction> attractionsSuggested;
	private Float costTotal;

	public Suggestion(Set<Attraction> attractionsSuggested) {
		this.attractionsSuggested = attractionsSuggested;
		this.costTotal = 0f;
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

	public Float calculateCostTotalForAttractions() {
		Float costTotal = getCostTotal();
		if (getCostTotal() == 0) {
			for (Attraction attraction : getAttractionsSuggested()) {
				costTotal += attraction.getCost();
			}
		}
		return costTotal;
	}

}