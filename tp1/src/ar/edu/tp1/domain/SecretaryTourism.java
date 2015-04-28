package ar.edu.tp1.domain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SecretaryTourism {

	private Set<Attraction> attractions;
	private Set<Promotable> promotions;

	public SecretaryTourism(Set<Attraction> attractions) {
		this.attractions = attractions;
		promotions = new HashSet<Promotable>();
	}

	public void addPromotion(Promotable promotion) {
		this.promotions.add(promotion);
	}

	public Set<Promotable> getPromotions() {
		return promotions;
	}

	public Set<Suggestion> suggestVisits(User user) {
		Set<Suggestion> suggestions = new HashSet<Suggestion>();

		Iterator<Attraction> iteratorAttractions = this.attractions.iterator();

		while (iteratorAttractions.hasNext()) {
			Attraction attractionForSuggest = (Attraction) iteratorAttractions.next();

			Suggestion suggestion = suggestVisitsForAttraction(user, attractionForSuggest);

			this.applyPromotions(user, suggestion);

			this.addSuggestion(suggestions, suggestion);
		}

		return suggestions;
	}

	private void addSuggestion(Set<Suggestion> suggestions, Suggestion suggestion) {
		Set<Attraction> attractionsSuggested = suggestion.getAttractionsSuggested();

		if (!attractionsSuggested.isEmpty()) {
			suggestions.add(suggestion);
		}
	}

	private void applyPromotions(User user, Suggestion suggestion) {
		Iterator<Promotable> iteratorPromotions = this.promotions.iterator();

		while (iteratorPromotions.hasNext()) {
			Promotable promotion = iteratorPromotions.next();

			promotion.applyPromotion(user, suggestion);
		}
	}

	private Suggestion suggestVisitsForAttraction(User user, Attraction attractionForSuggest) {
		Iterator<Attraction> iteratorAttractions = this.attractions.iterator();

		Set<Attraction> attractionsSuggested = new HashSet<Attraction>();

		if (attractionForSuggest.allowUser(user)) {
			attractionsSuggested.add(attractionForSuggest);

			while (iteratorAttractions.hasNext()) {
				Attraction attraction = iteratorAttractions.next();

				if (attraction.allowUser(user)) {
					attractionsSuggested.add(attraction);
				}
			}
		}

		return new Suggestion(attractionsSuggested);
	}

}