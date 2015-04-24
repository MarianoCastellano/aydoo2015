package ar.edu.tp1.test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.tp1.domain.Attraction;
import ar.edu.tp1.domain.AttractionType;
import ar.edu.tp1.domain.PercentagePromotion;
import ar.edu.tp1.domain.SecretaryTourism;
import ar.edu.tp1.domain.User;

public class PromotionTest {

	@Test
	public void suggestedVisitsShouldSuggestsPromotionsWhenPromotionIsActive() {
		User joseph = new User(1000, 3600, AttractionType.LANDSCAPE, 0);

		SecretaryTourism tierraMedia = new SecretaryTourism(createAttractions());
		addPromotions(tierraMedia);

		Set<Attraction> attractionsSuggested = tierraMedia.suggestedVisits(joseph);

		Assert.assertEquals(2, attractionsSuggested.size());
	}

	private Set<Attraction> createAttractions() {
		Set<Attraction> attractions = new HashSet<Attraction>();
		Attraction landscape = new Attraction(10, 20, 500, 3600, AttractionType.LANDSCAPE, 100);
		attractions.add(landscape);
		return attractions;
	}

	private void addPromotions(SecretaryTourism tierraMedia) {
		Set<Attraction> attractions = new HashSet<Attraction>();
		Attraction landscape = new Attraction(10, 20, 500, 3600, AttractionType.LANDSCAPE, 100);
		Attraction tasing = new Attraction(20, 20, 1500, 3600, AttractionType.TASING, 100);
		attractions.add(landscape);
		attractions.add(tasing);

		PercentagePromotion promotionOne = new PercentagePromotion(startDate(), endDate(), attractions, 10);

		tierraMedia.addPromotion(promotionOne);
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