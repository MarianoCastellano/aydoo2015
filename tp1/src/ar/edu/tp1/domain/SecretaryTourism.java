package ar.edu.tp1.domain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SecretaryTourism {

	private Set<Attraction> attractions;

	public SecretaryTourism(Set<Attraction> attractions) {
		this.attractions = attractions;
	}

	public Set<Attraction> suggestedVisits(User user) {
		Set<Attraction> attractionsSuggested = new HashSet<Attraction>(this.attractions);

		Iterator<Attraction> iteratorAttractions = attractionsSuggested.iterator();

		while (iteratorAttractions.hasNext()) {
			Attraction attraction = iteratorAttractions.next();

			if (!isValidForAttraction(user, attraction)) {
				iteratorAttractions.remove();
			}
		}

		return attractionsSuggested;
	}

	private boolean isValidForAttraction(User user, Attraction attraction) {
		return attraction.hasMoneyEnough(user.getMoney()) && attraction.hasTimeEnough(user.getTimeRemaining());
	}

}