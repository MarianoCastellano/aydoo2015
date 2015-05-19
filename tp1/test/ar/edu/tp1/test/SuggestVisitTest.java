package ar.edu.tp1.test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.tp1.domain.Position;
import ar.edu.tp1.domain.SecretaryTourism;
import ar.edu.tp1.domain.User;
import ar.edu.tp1.domain.attraction.Attraction;
import ar.edu.tp1.domain.attraction.AttractionType;
import ar.edu.tp1.domain.attraction.Suggestion;
import ar.edu.tp1.domain.promotion.ForeignerPromotion;

public class SuggestVisitTest {
	
	@Test
	public void suggestedVisitsShouldNotSuggestedWhenHasNotMoneyEnough() {
		User joseph = new User(0f, 3600f, AttractionType.LANDSCAPE, 0f, new Position(0f, 0f));

		SecretaryTourism tierraMedia = new SecretaryTourism(createAttractions());
		Set<Suggestion> suggestions = tierraMedia.suggestVisits(joseph);

		Assert.assertEquals(0, suggestions.size());
	}
	
	@Test
	public void suggestedVisitsShouldNotSuggestedWhenHasNotTimeEnough() {
		User joseph = new User(1000f, 0f, AttractionType.LANDSCAPE, 0f, new Position(0f, 0f));

		SecretaryTourism tierraMedia = new SecretaryTourism(createAttractions());
		Set<Suggestion> suggestions = tierraMedia.suggestVisits(joseph);

		Assert.assertEquals(0, suggestions.size());
	}
	
	@Test
	public void suggestedVisitsShouldNotSuggestedWhenHasNotCapacity() {
		User joseph = new User(1000f, 3600f, AttractionType.ADVENTURE, 0f, new Position(0f, 0f));

		SecretaryTourism tierraMedia = new SecretaryTourism(createAttractionsWithoutCapacity());
		Set<Suggestion> suggestions = tierraMedia.suggestVisits(joseph);

		Assert.assertEquals(0, suggestions.size());
	}

	@Test
	public void suggestedVisitsShouldSuggestedWhenHasMoneyEnough() {
		User joseph = new User(1000f, 3600f, AttractionType.LANDSCAPE, 0f, new Position(0f, 0f));

		SecretaryTourism tierraMedia = new SecretaryTourism(createAttractions());
		Set<Suggestion> suggestions = tierraMedia.suggestVisits(joseph);

		Suggestion suggestion = suggestions.iterator().next();

		Assert.assertEquals(2, suggestion.getAttractionsSuggested().size());
	}

	@Test
	public void suggestedVisitsShouldSuggestedWhenHasTimeEnough() {
		User joseph = new User(1000f, 3600f, AttractionType.LANDSCAPE, 0f, new Position(0f, 0f));

		SecretaryTourism tierraMedia = new SecretaryTourism(createAttractions());
		Set<Suggestion> suggestions = tierraMedia.suggestVisits(joseph);

		Suggestion suggestion = suggestions.iterator().next();

		Assert.assertEquals(2, suggestion.getAttractionsSuggested().size());
	}

	@Test
	public void suggestedVisitsShouldSuggestedWhenIsFavoriteAttraction() {
		User joseph = new User(1000f, 3600f, AttractionType.LANDSCAPE, 0f, new Position(0f, 0f));

		SecretaryTourism tierraMedia = new SecretaryTourism(createAttractions());
		Set<Suggestion> suggestions = tierraMedia.suggestVisits(joseph);

		Suggestion suggestion = suggestions.iterator().next();

		Assert.assertEquals(2, suggestion.getAttractionsSuggested().size());
	}

	@Test
	public void suggestedVisitsShouldSuggestedWhenHasCapacity() {
		User joseph = new User(1000f, 3600f, AttractionType.LANDSCAPE, 0f, new Position(0f, 0f));

		SecretaryTourism tierraMedia = new SecretaryTourism(createAttractions());
		Set<Suggestion> suggestions = tierraMedia.suggestVisits(joseph);

		Suggestion suggestion = suggestions.iterator().next();

		Assert.assertEquals(2, suggestion.getAttractionsSuggested().size());
	}
	
	@Test
	public void suggestedVisitsShouldApplyPromotionUncombinable() {
		User joseph = new User(1000f, 3600f, AttractionType.LANDSCAPE, 0f, new Position(180f, 180f));

		SecretaryTourism tierraMedia = new SecretaryTourism(createAttractions());
		tierraMedia.addPromotion(new ForeignerPromotion(startDate(), endDate(), new Position(200f, 200f)));
		Set<Suggestion> suggestions = tierraMedia.suggestVisits(joseph);

		Suggestion suggestion = suggestions.iterator().next();

		Assert.assertEquals(300f, suggestion.getCostTotal(), 0.001);
	}

	private Set<Attraction> createAttractions() {
		Set<Attraction> attractions = new HashSet<Attraction>();
		Attraction landscape = new Attraction(new Integer(1), new Position(10f, 20f), 500f, 3600f, AttractionType.LANDSCAPE, new Integer(100));
		Attraction tasing = new Attraction(new Integer(2), new Position(20f, 20f), 1500f, 3600f, AttractionType.TASING, new Integer(100));
		Attraction adventure = new Attraction(new Integer(3), new Position(55f, 33f), 2000f, 3600f, AttractionType.ADVENTURE, new Integer(100));
		Attraction otherLandscape = new Attraction(new Integer(4), new Position(22f, 100f), 100f, 120f, AttractionType.LANDSCAPE, new Integer(100));

		attractions.add(landscape);
		attractions.add(tasing);
		attractions.add(adventure);
		attractions.add(otherLandscape);
		return attractions;
	}
	
	private Set<Attraction> createAttractionsWithoutCapacity() {
		Set<Attraction> attractions = new HashSet<Attraction>();
		Attraction landscape = new Attraction(new Integer(1), new Position(10f, 20f), 500f, 3600f, AttractionType.LANDSCAPE, new Integer(0));
		Attraction tasing = new Attraction(new Integer(2), new Position(20f, 20f), 1500f, 3600f, AttractionType.TASING, new Integer(0));
		Attraction adventure = new Attraction(new Integer(3), new Position(55f, 33f), 2000f, 3600f, AttractionType.ADVENTURE, new Integer(0));
		Attraction otherLandscape = new Attraction(new Integer(4), new Position(22f, 100f), 100f, 120f, AttractionType.LANDSCAPE, new Integer(0));

		attractions.add(landscape);
		attractions.add(tasing);
		attractions.add(adventure);
		attractions.add(otherLandscape);
		return attractions;
	}
	
	private Date startDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		return calendar.getTime();
	}

	private Date endDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);
		return calendar.getTime();
	}
}