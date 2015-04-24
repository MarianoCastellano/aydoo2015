package ar.edu.tp1.test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.tp1.domain.AbsolutePromotion;
import ar.edu.tp1.domain.Attraction;
import ar.edu.tp1.domain.AttractionType;
import ar.edu.tp1.domain.PercentagePromotion;
import ar.edu.tp1.domain.Promotable;
import ar.edu.tp1.domain.SecretaryTourism;
import ar.edu.tp1.domain.User;

public class PromotionTest {

	@Test
	public void suggestedVisitsShouldSuggestsPromotionsWhenPromotionIsActive() {
		User joseph = new User(1000, 3600, AttractionType.LANDSCAPE, 0);

		SecretaryTourism tierraMedia = new SecretaryTourism(createAttractions());
		addPorcetagePromotions(tierraMedia);

		Set<Attraction> attractionsSuggested = tierraMedia.suggestedVisits(joseph);

		Assert.assertEquals(2, attractionsSuggested.size());
	}

	@Test
	public void suggestedVisitsShouldSuggestPromotionsWhenAbsolutePromotionIsActive() {
		User joseph = new User(1000, 3600, AttractionType.LANDSCAPE, 0);

		SecretaryTourism tierraMedia = new SecretaryTourism(createAttractions());
		addAbsolutePromotions(tierraMedia);

		Set<Attraction> attractionsSuggested = tierraMedia.suggestedVisits(joseph);

		Assert.assertEquals(2, attractionsSuggested.size());
	}

	private Set<Attraction> createAttractions() {
		Set<Attraction> attractions = new HashSet<Attraction>();
		Attraction landscape = new Attraction(10, 20, 500, 3600, AttractionType.LANDSCAPE, 100);
		attractions.add(landscape);
		return attractions;
	}

	private void addPorcetagePromotions(SecretaryTourism tierraMedia) {
		Set<Attraction> attractions = createAttractionsForPromotion();

		Promotable promotionOne = new PercentagePromotion(startDate(), endDate(), attractions, 10);

		tierraMedia.addPromotion(promotionOne);
	}

	private void addAbsolutePromotions(SecretaryTourism tierraMedia) {
		Set<Attraction> attractions = createAttractionsForPromotion();

		Promotable promotionOne = new AbsolutePromotion(startDate(), endDate(), attractions, 1000);

		tierraMedia.addPromotion(promotionOne);
	}

	private Set<Attraction> createAttractionsForPromotion() {
		Set<Attraction> attractions = new HashSet<Attraction>();
		Attraction landscape = new Attraction(12, 24, 500, 3600, AttractionType.LANDSCAPE, 110);
		Attraction tasing = new Attraction(20, 20, 1500, 3600, AttractionType.TASING, 100);
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