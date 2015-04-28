package ar.edu.tp1.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.tp1.domain.Attraction;
import ar.edu.tp1.domain.AttractionType;
import ar.edu.tp1.domain.SecretaryTourism;
import ar.edu.tp1.domain.Suggestion;
import ar.edu.tp1.domain.User;

public class SuggestVisitsTest {

	@Test
	public void suggestedVisitsShouldSuggestedWhenHasMoneyEnough() {
		User joseph = new User(1000f, 3600f, AttractionType.LANDSCAPE, 0f);

		SecretaryTourism tierraMedia = new SecretaryTourism(createAttractions());
		Set<Suggestion> suggestions = tierraMedia.suggestVisits(joseph);

		Suggestion suggestion = suggestions.iterator().next();

		Assert.assertEquals(2, suggestion.getAttractionsSuggested().size());
	}

	@Test
	public void suggestedVisitsShouldSuggestedWhenHasTimeEnough() {
		User joseph = new User(1000f, 3600f, AttractionType.LANDSCAPE, 0f);

		SecretaryTourism tierraMedia = new SecretaryTourism(createAttractions());
		Set<Suggestion> suggestions = tierraMedia.suggestVisits(joseph);

		Suggestion suggestion = suggestions.iterator().next();

		Assert.assertEquals(2, suggestion.getAttractionsSuggested().size());
	}

	@Test
	public void suggestedVisitsShouldSuggestedWhenIsFavoriteAttraction() {
		User joseph = new User(1000f, 3600f, AttractionType.LANDSCAPE, 0f);

		SecretaryTourism tierraMedia = new SecretaryTourism(createAttractions());
		Set<Suggestion> suggestions = tierraMedia.suggestVisits(joseph);

		Suggestion suggestion = suggestions.iterator().next();

		Assert.assertEquals(2, suggestion.getAttractionsSuggested().size());
	}

	@Test
	public void suggestedVisitsShouldSuggestedWhenHasCapacity() {
		User joseph = new User(1000f, 3600f, AttractionType.LANDSCAPE, 0f);

		SecretaryTourism tierraMedia = new SecretaryTourism(createAttractions());
		Set<Suggestion> suggestions = tierraMedia.suggestVisits(joseph);

		Suggestion suggestion = suggestions.iterator().next();

		Assert.assertEquals(2, suggestion.getAttractionsSuggested().size());
	}

	private Set<Attraction> createAttractions() {
		Set<Attraction> attractions = new HashSet<Attraction>();
		Attraction landscape = new Attraction(new Integer(1), 10f, 20f, 500f, 3600f, AttractionType.LANDSCAPE, new Integer(100));
		Attraction tasing = new Attraction(new Integer(2), 20f, 20f, 1500f, 3600f, AttractionType.TASING, new Integer(100));
		Attraction adventure = new Attraction(new Integer(3), 55f, 33f, 2000f, 3600f, AttractionType.ADVENTURE, new Integer(100));
		Attraction otherLandscape = new Attraction(new Integer(4), 22f, 100f, 100f, 120f, AttractionType.LANDSCAPE, new Integer(100));

		attractions.add(landscape);
		attractions.add(tasing);
		attractions.add(adventure);
		attractions.add(otherLandscape);
		return attractions;
	}
}