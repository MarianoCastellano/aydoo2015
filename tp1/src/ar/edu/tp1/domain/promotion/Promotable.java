package ar.edu.tp1.domain.promotion;

import ar.edu.tp1.domain.attraction.Suggestion;

public interface Promotable {

	Float calculateCost(Suggestion suggestion);

}