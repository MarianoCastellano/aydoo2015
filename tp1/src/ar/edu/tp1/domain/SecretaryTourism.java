package ar.edu.tp1.domain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SecretaryTourism {

	private Set<Attraction> attractions;

	public SecretaryTourism() {
		this.attractions = createAttractions();
	}

	public Set<Attraction> suggestedVisits(User user) {
		Set<Attraction> attractionsSuggested = new HashSet<Attraction>(this.attractions);

		Iterator<Attraction> iteratorAttractions = attractionsSuggested.iterator();

		while (iteratorAttractions.hasNext()) {
			Attraction attraction = iteratorAttractions.next();

			if (!attraction.canVisit(user.getMoney())) {
				iteratorAttractions.remove();
			}
		}

		return attractionsSuggested;
	}

	private Set<Attraction> createAttractions() {
		this.attractions = new HashSet<Attraction>();
		Attraction landscape = new Attraction(500);
		Attraction tasing = new Attraction(1500);
		Attraction adventure = new Attraction(2000);
		this.attractions.add(landscape);
		this.attractions.add(tasing);
		this.attractions.add(adventure);
		return this.attractions;
	}
}