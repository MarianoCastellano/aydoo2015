package ar.edu.tp1.test;

import java.util.ArrayList;
import java.util.List;

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
		List<Suggestion> suggestions = tierraMedia.suggestedVisits(joseph);

		Suggestion suggestion = suggestions.iterator().next();

		Assert.assertEquals(1, suggestion.getAttractionsSuggested().size());
	}

	@Test
	public void suggestedVisitsShouldSuggestedWhenHasTimeEnough() {
		User joseph = new User(1000f, 3600f, AttractionType.LANDSCAPE, 0f);

		SecretaryTourism tierraMedia = new SecretaryTourism(createAttractions());
		List<Suggestion> suggestions = tierraMedia.suggestedVisits(joseph);

		Suggestion suggestion = suggestions.iterator().next();

		Assert.assertEquals(1, suggestion.getAttractionsSuggested().size());
	}

	@Test
	public void suggestedVisitsShouldSuggestedWhenIsFavoriteAttraction() {
		User joseph = new User(1000f, 3600f, AttractionType.LANDSCAPE, 0f);

		SecretaryTourism tierraMedia = new SecretaryTourism(createAttractions());
		List<Suggestion> suggestions = tierraMedia.suggestedVisits(joseph);

		Suggestion suggestion = suggestions.iterator().next();

		Assert.assertEquals(1, suggestion.getAttractionsSuggested().size());
	}

	@Test
	public void suggestedVisitsShouldSuggestedWhenHasCapacity() {
		User joseph = new User(1000f, 3600f, AttractionType.LANDSCAPE, 0f);

		SecretaryTourism tierraMedia = new SecretaryTourism(createAttractions());
		List<Suggestion> suggestions = tierraMedia.suggestedVisits(joseph);

		Suggestion suggestion = suggestions.iterator().next();

		Assert.assertEquals(1, suggestion.getAttractionsSuggested().size());
	}

	private List<Attraction> createAttractions() {
		List<Attraction> attractions = new ArrayList<Attraction>();
		Attraction landscape = new Attraction(new Integer(1), 10f, 20f, 500f, 3600f, AttractionType.LANDSCAPE,
				new Integer(100));
		Attraction tasing = new Attraction(new Integer(2), 20f, 20f, 1500f, 3600f, AttractionType.TASING, new Integer(
				100));
		Attraction adventure = new Attraction(new Integer(3), 55f, 33f, 2000f, 3600f, AttractionType.ADVENTURE,
				new Integer(100));
		attractions.add(landscape);
		attractions.add(tasing);
		attractions.add(adventure);
		return attractions;
	}
}