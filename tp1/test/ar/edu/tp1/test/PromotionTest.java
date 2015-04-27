package ar.edu.tp1.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.tp1.domain.AbsolutePromotion;
import ar.edu.tp1.domain.Attraction;
import ar.edu.tp1.domain.AttractionType;
import ar.edu.tp1.domain.AxBPromotion;
import ar.edu.tp1.domain.PercentagePromotion;
import ar.edu.tp1.domain.Promotable;
import ar.edu.tp1.domain.SecretaryTourism;
import ar.edu.tp1.domain.Suggestion;
import ar.edu.tp1.domain.User;

public class PromotionTest {

	@Test
	public void suggestedVisitsShouldSuggestsPromotionsWhenPromotionIsActive() {
		User joseph = new User(1000f, 3600f, AttractionType.LANDSCAPE, 0f);

		SecretaryTourism tierraMedia = new SecretaryTourism(createAttractions());
		addPorcetagePromotions(tierraMedia);

		List<Suggestion> suggestions = tierraMedia.suggestedVisits(joseph);

		Suggestion suggestion = suggestions.iterator().next();

		Assert.assertEquals(1, suggestion.getAttractionsSuggested().size());
	}

	@Test
	public void suggestedVisitsShouldSuggestsPromotionsWhenAbsolutePromotionIsActive() {
		User joseph = new User(1000f, 3600f, AttractionType.LANDSCAPE, 0f);

		SecretaryTourism tierraMedia = new SecretaryTourism(createAttractions());
		addAbsolutePromotions(tierraMedia);

		List<Suggestion> suggestions = tierraMedia.suggestedVisits(joseph);

		Suggestion suggestion = suggestions.iterator().next();

		Assert.assertEquals(1, suggestion.getAttractionsSuggested().size());
	}

	@Test
	public void suggestedVisitsShouldSuggestsPromotionsWhenAxBPromotionIsActive() {
		User joseph = new User(1000f, 3600f, AttractionType.LANDSCAPE, 0f);

		SecretaryTourism tierraMedia = new SecretaryTourism(createAttractionsForPromotion());
		addAxBPromotions(tierraMedia);

		List<Suggestion> suggestions = tierraMedia.suggestedVisits(joseph);

		Suggestion suggestion = suggestions.iterator().next();

		Assert.assertEquals(2, suggestion.getAttractionsSuggested().size());
	}

	private List<Attraction> createAttractions() {
		List<Attraction> attractions = new ArrayList<Attraction>();
		Attraction landscape = new Attraction(new Integer(1), 10f, 20f, 500f, 100f, AttractionType.LANDSCAPE,
				new Integer(100));
		attractions.add(landscape);
		return attractions;
	}

	private void addPorcetagePromotions(SecretaryTourism tierraMedia) {
		List<Attraction> attractions = createAttractionsForPromotion();

		Promotable porcentagePromotion = new PercentagePromotion(startDate(), endDate(), attractions, 10f);

		tierraMedia.addPromotion(porcentagePromotion);
	}

	private void addAbsolutePromotions(SecretaryTourism tierraMedia) {
		List<Attraction> attractions = createAttractionsForPromotion();

		Promotable absolutePromotion = new AbsolutePromotion(startDate(), endDate(), attractions, 1000f);

		tierraMedia.addPromotion(absolutePromotion);
	}

	private void addAxBPromotions(SecretaryTourism tierraMedia) {
		List<Attraction> attractions = createAttractionsForPromotion();

		Attraction tasing = new Attraction(new Integer(2), 10f, 20f, 20f, 120f, AttractionType.LANDSCAPE, new Integer(1));

		Promotable abPromotion = new AxBPromotion(startDate(), endDate(), attractions, tasing);

		tierraMedia.addPromotion(abPromotion);
	}

	private List<Attraction> createAttractionsForPromotion() {
		List<Attraction> attractions = new ArrayList<Attraction>();
		Attraction landscape = new Attraction(new Integer(3), 12f, 24f, 500f, 3600f, AttractionType.LANDSCAPE, new Integer(110));
		Attraction tasing = new Attraction(new Integer(4), 20f, 20f, 1500f, 3600f, AttractionType.TASING, new Integer(100));
		attractions.add(landscape);
		attractions.add(tasing);
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