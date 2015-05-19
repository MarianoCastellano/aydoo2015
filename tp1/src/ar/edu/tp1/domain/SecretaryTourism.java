package ar.edu.tp1.domain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ar.edu.tp1.domain.attraction.Attraction;
import ar.edu.tp1.domain.attraction.Suggestion;
import ar.edu.tp1.domain.promotion.Promotable;

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
		Promotable promotionUncombinable = findPromotionUncombinable();

		if (promotionUncombinable != null) {
			applyPromotionUncombinables(suggestion, promotionUncombinable);
		} else {
			applyPromotionCombinables(suggestion);
		}
	}

	private void applyPromotionUncombinables(Suggestion suggestion, Promotable promotionUncombinable) {
		applyCostTotal(suggestion, promotionUncombinable);
	}

	private void applyCostTotal(Suggestion suggestion, Promotable promotionUncombinable) {
		Float calculateCost = promotionUncombinable.calculateCost(suggestion);

		suggestion.setCostTotal(calculateCost);
	}

	private void applyPromotionCombinables(Suggestion suggestion) {
		Iterator<Promotable> iteratorPromotions = this.promotions.iterator();

		while (iteratorPromotions.hasNext()) {
			Promotable promotion = iteratorPromotions.next();

			applyCostTotal(suggestion, promotion);
		}
	}

	private Promotable findPromotionUncombinable() {
		Iterator<Promotable> iterator = this.promotions.iterator();
		while (iterator.hasNext()) {
			Promotable promotable = (Promotable) iterator.next();

			if (!promotable.isCombinable()) {
				return promotable;
			}
		}
		return null;
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