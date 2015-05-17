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
import ar.edu.tp1.domain.AxBPromotion;
import ar.edu.tp1.domain.PercentagePromotion;
import ar.edu.tp1.domain.Promotable;
import ar.edu.tp1.domain.Suggestion;

public class PromotionTest {

	@Test
	public void applyAbsolutePromotionShouldDiscountCostTotal() {
		Promotable promotable = new AbsolutePromotion(startDate(), endDate(), createAttractions(), 500f);
		Suggestion suggestion = createSuggestions();

		promotable.applyPromotion(suggestion);

		Float costTotal = suggestion.getCostTotal();

		Assert.assertEquals(0f, costTotal, 0.001);
	}

	@Test
	public void applyAbsolutePromotionShouldNotDiscountCostTotal() {
		Promotable promotable = new AbsolutePromotion(startDate(), endDate(), createOthersAttractions(), 500f);
		Suggestion suggestion = createSuggestions();

		promotable.applyPromotion(suggestion);

		Float costTotal = suggestion.getCostTotal();

		Assert.assertEquals(500f, costTotal, 0.001);
	}

	@Test
	public void applyAxBPromotionShouldAddFreeAttraction() {
		Promotable promotable = new AxBPromotion(startDate(), endDate(), createAttractions(), createFreeAttraction());
		Suggestion suggestion = createSuggestions();

		promotable.applyPromotion(suggestion);

		Assert.assertEquals(2, suggestion.getAttractionsSuggested().size());
	}

	@Test
	public void applyAxBPromotionShouldNotAddFreeAttraction() {
		Promotable promotable = new AxBPromotion(startDate(), endDate(), createOthersAttractions(),
				createFreeAttraction());
		Suggestion suggestion = createSuggestions();

		promotable.applyPromotion(suggestion);

		Assert.assertEquals(1, suggestion.getAttractionsSuggested().size());
	}

	@Test
	public void applyPorcentualPromotionShouldDiscountCostTotal() {
		Promotable promotable = new PercentagePromotion(startDate(), endDate(), createAttractions(), 50f);
		Suggestion suggestion = createSuggestions();

		promotable.applyPromotion(suggestion);

		Float costTotal = suggestion.getCostTotal();

		Assert.assertEquals(250f, costTotal, 0.001);
	}

	@Test
	public void applyPorcentualPromotionShouldNotDiscountCostTotal() {
		Promotable promotable = new PercentagePromotion(startDate(), endDate(), createOthersAttractions(), 50f);
		Suggestion suggestion = createSuggestions();

		promotable.applyPromotion(suggestion);

		Float costTotal = suggestion.getCostTotal();

		Assert.assertEquals(500f, costTotal, 0.001);
	}

	private Attraction createFreeAttraction() {
		Attraction landscape = new Attraction(new Integer(2), 20f, 40f, 500f, 100f, AttractionType.LANDSCAPE,
				new Integer(100));
		return landscape;
	}

	private Suggestion createSuggestions() {
		return new Suggestion(createAttractions());
	}

	private Set<Attraction> createAttractions() {
		Set<Attraction> attractions = new HashSet<Attraction>();
		Attraction landscape = new Attraction(new Integer(1), 10f, 20f, 500f, 100f, AttractionType.LANDSCAPE,
				new Integer(100));
		attractions.add(landscape);
		return attractions;
	}

	private Set<Attraction> createOthersAttractions() {
		Set<Attraction> attractions = new HashSet<Attraction>();
		Attraction landscape = new Attraction(new Integer(3), 40f, 120f, 1500f, 100f, AttractionType.LANDSCAPE,
				new Integer(100));
		attractions.add(landscape);
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