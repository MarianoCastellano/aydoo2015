package ar.edu.tp1.domain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SecretaryTourism {

	private Set<Attraction> attractions;
	private Set<PercentagePromotion> promotions;

	public SecretaryTourism(Set<Attraction> attractions) {
		this.attractions = attractions;
		promotions = new HashSet<PercentagePromotion>();
	}

	public void addPromotion(PercentagePromotion promotion) {
		this.promotions.add(promotion);
	}

	public Set<PercentagePromotion> getPromotions() {
		return promotions;
	}

	public Set<Attraction> suggestedVisits(User user) {
		Set<Attraction> attractionsSuggested = new HashSet<Attraction>();

		suggestVisits(user, attractionsSuggested);

		suggestPromotions(user, attractionsSuggested);

		return attractionsSuggested;
	}

	private void suggestPromotions(User user, Set<Attraction> attractionsSuggested) {
		Iterator<PercentagePromotion> iteratorPromotions = this.promotions.iterator();

		while (iteratorPromotions.hasNext()) {
			PercentagePromotion promotion = iteratorPromotions.next();

			if (promotion.applyToUser(user, attractionsSuggested)) {
				promotion.applyPromotion(user, attractionsSuggested);
			}

		}
	}

	private void suggestVisits(User user, Set<Attraction> attractionsSuggested) {
		Iterator<Attraction> iteratorAttractions = this.attractions.iterator();

		while (iteratorAttractions.hasNext()) {
			Attraction attraction = iteratorAttractions.next();

			if (isValidForAttraction(user, attraction)) {
				attractionsSuggested.add(attraction);
			}
		}
	}

	private boolean isValidForAttraction(User user, Attraction attraction) {
		return attraction.hasMoneyEnough(user.getMoney()) && attraction.hasTimeEnough(user.getTimeRemaining())
				&& attraction.IsFavoriteAttraction(user.getFavoriteAttraction()) && attraction.hasCapacity();
	}
}