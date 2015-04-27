package ar.edu.tp1.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SecretaryTourism {

	private List<Attraction> attractions;
	private List<Promotable> promotions;

	public SecretaryTourism(List<Attraction> attractions) {
		this.attractions = attractions;
		promotions = new ArrayList<Promotable>();
	}

	public void addPromotion(Promotable promotion) {
		this.promotions.add(promotion);
	}

	public List<Promotable> getPromotions() {
		return promotions;
	}

	public List<Suggestion> suggestedVisits(User user) {

		List<Suggestion> suggestions = new ArrayList<Suggestion>();

		for (int i = 0; i < 2; i++) {
			Suggestion suggestion = suggestVisits(user);

			applyPromotions(user, suggestion);

			suggestions.add(suggestion);

			Collections.shuffle(this.attractions);
		}

		return suggestions;
	}

	private void applyPromotions(User user, Suggestion suggestion) {
		Iterator<Promotable> iteratorPromotions = this.promotions.iterator();

		while (iteratorPromotions.hasNext()) {
			Promotable promotion = iteratorPromotions.next();

			promotion.applyPromotion(user, suggestion);
		}
	}

	private Suggestion suggestVisits(User user) {
		Iterator<Attraction> iteratorAttractions = this.attractions.iterator();

		List<Attraction> attractionsSuggested = new ArrayList<Attraction>();

		while (iteratorAttractions.hasNext()) {
			Attraction attraction = iteratorAttractions.next();

			if (attraction.allowUser(user)) {
				attractionsSuggested.add(attraction);
			}
		}

		return new Suggestion(attractionsSuggested);
	}

}