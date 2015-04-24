package ar.edu.tp1.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.tp1.domain.Attraction;
import ar.edu.tp1.domain.AttractionType;
import ar.edu.tp1.domain.SecretaryTourism;
import ar.edu.tp1.domain.User;

public class SuggestVisitsTest {

	@Test
	public void suggestedVisitsShouldSuggestedWhenHasMoneyEnough() {
		User joseph = new User(1000, 3600, AttractionType.LANDSCAPE);

		SecretaryTourism tierraMedia = new SecretaryTourism(createAttractions());
		Set<Attraction> attractionsSuggested = tierraMedia.suggestedVisits(joseph);

		Assert.assertEquals(1, attractionsSuggested.size());
	}

	@Test
	public void suggestedVisitsShouldSuggestedWhenHasTimeEnough() {
		User joseph = new User(1000, 3600, AttractionType.LANDSCAPE);

		SecretaryTourism tierraMedia = new SecretaryTourism(createAttractions());
		Set<Attraction> attractionsSuggested = tierraMedia.suggestedVisits(joseph);

		Assert.assertEquals(1, attractionsSuggested.size());
	}

	@Test
	public void suggestedVisitsShouldSuggestedWhenIsFavoriteAttraction() {
		User joseph = new User(1000, 3600, AttractionType.LANDSCAPE);

		SecretaryTourism tierraMedia = new SecretaryTourism(createAttractions());
		Set<Attraction> attractionsSuggested = tierraMedia.suggestedVisits(joseph);

		Assert.assertEquals(1, attractionsSuggested.size());
	}

	private Set<Attraction> createAttractions() {
		Set<Attraction> attractions = new HashSet<Attraction>();
		Attraction landscape = new Attraction(10, 20, 500, 3600, AttractionType.LANDSCAPE);
		Attraction tasing = new Attraction(20, 20, 1500, 3600, AttractionType.TASING);
		Attraction adventure = new Attraction(55, 33, 2000, 3600, AttractionType.ADVENTURE);
		attractions.add(landscape);
		attractions.add(tasing);
		attractions.add(adventure);
		return attractions;
	}
}