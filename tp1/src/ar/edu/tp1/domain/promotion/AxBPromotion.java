package ar.edu.tp1.domain.promotion;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import ar.edu.tp1.domain.attraction.Attraction;
import ar.edu.tp1.domain.attraction.Suggestion;

public class AxBPromotion implements Promotable {

	private Set<Attraction> attractions;
	private Date startDate;
	private Date endDate;
	private Attraction attractionFree;

	public AxBPromotion(Date startDate, Date endDate, Set<Attraction> attractions, Attraction attractionFree) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.attractions = attractions;
		this.attractionFree = attractionFree;
	}

	@Override
	public Float calculateCost(Suggestion suggestion) {
		if (isActive()) {
			Set<Attraction> attractionsSuggested = suggestion.getAttractionsSuggested();
			Iterator<Attraction> iteratorAttractionsSuggested = attractionsSuggested.iterator();

			while (iteratorAttractionsSuggested.hasNext()) {
				Attraction attraction = iteratorAttractionsSuggested.next();

				Iterator<Attraction> iteratorAttractions = this.attractions.iterator();

				while (iteratorAttractions.hasNext()) {
					Attraction attractionPurchased = iteratorAttractions.next();

					if (isSameAttraction(attraction, attractionPurchased)) {
						Float cost = suggestion.calculateCostTotalForAttractions();
						this.attractionFree.setCost(0f);
						suggestion.addAttractionForSuggested(this.attractionFree);
						return cost;
					}
				}
			}
		}
		return suggestion.calculateCostTotalForAttractions();
	}

	private boolean isSameAttraction(Attraction attraction, Attraction attractionPurchased) {
		return attraction.getId().equals(attractionPurchased.getId());
	}

	private boolean isActive() {
		Date today = new Date();
		return today.after(this.startDate) && today.before(this.endDate);
	}

	@Override
	public Boolean isCombinable() {
		return Boolean.TRUE;
	}
}