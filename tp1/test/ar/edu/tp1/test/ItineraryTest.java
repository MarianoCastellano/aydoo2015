package ar.edu.tp1.test;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.tp1.domain.Attraction;
import ar.edu.tp1.domain.SecretaryTourism;
import ar.edu.tp1.domain.User;

public class ItineraryTest {

	@Test
	public void suggestedVisitsShouldSuggestedWhenMoneyIsGreaterThanCost() {
		User joseph = new User(1000);

		SecretaryTourism tierraMedia = new SecretaryTourism();
		Set<Attraction> attractionsSuggested = tierraMedia.suggestedVisits(joseph);

		Assert.assertEquals(1, attractionsSuggested.size());
	}
}