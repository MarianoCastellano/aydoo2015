package ar.edu.tp1.domain;

import java.util.Set;

public interface Promotable {

	boolean applyToUser(User user, Set<Attraction> attractionsSuggested);

	void applyPromotion(User user, Set<Attraction> attractionsPromotion);

}