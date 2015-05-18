package ar.edu.tp1.test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.tp1.domain.Position;
import ar.edu.tp1.domain.attraction.Attraction;
import ar.edu.tp1.domain.attraction.AttractionType;
import ar.edu.tp1.domain.attraction.Suggestion;
import ar.edu.tp1.domain.promotion.AbsolutePromotion;
import ar.edu.tp1.domain.promotion.AxBPromotion;
import ar.edu.tp1.domain.promotion.FamilyPackagePromotion;
import ar.edu.tp1.domain.promotion.ForeignerPromotion;
import ar.edu.tp1.domain.promotion.PercentagePromotion;
import ar.edu.tp1.domain.promotion.Promotable;

public class PromotionTest {

	@Test
	public void applyAbsolutePromotionShouldDiscountCostTotal() {
		Promotable promotable = new AbsolutePromotion(startDate(), endDate(), createAttractions(), 500f);
		Suggestion suggestion = createSuggestions();

		Float costTotal = promotable.calculateCost(suggestion);

		Assert.assertEquals(0f, costTotal, 0.001);
	}

	@Test
	public void applyAbsolutePromotionShouldNotDiscountCostTotal() {
		Promotable promotable = new AbsolutePromotion(startDate(), endDate(), createOthersAttractions(), 500f);
		Suggestion suggestion = createSuggestions();

		Float costTotal = promotable.calculateCost(suggestion);

		Assert.assertEquals(500f, costTotal, 0.001);
	}

	@Test
	public void applyAxBPromotionShouldAddFreeAttraction() {
		Promotable promotable = new AxBPromotion(startDate(), endDate(), createAttractions(), createFreeAttraction());
		Suggestion suggestion = createSuggestions();

		promotable.calculateCost(suggestion);

		Assert.assertEquals(2, suggestion.getAttractionsSuggested().size());
	}

	@Test
	public void applyAxBPromotionShouldNotAddFreeAttraction() {
		Promotable promotable = new AxBPromotion(startDate(), endDate(), createOthersAttractions(),
				createFreeAttraction());
		Suggestion suggestion = createSuggestions();

		promotable.calculateCost(suggestion);

		Assert.assertEquals(1, suggestion.getAttractionsSuggested().size());
	}

	@Test
	public void applyPorcentualPromotionShouldDiscountCostTotal() {
		Promotable promotable = new PercentagePromotion(startDate(), endDate(), createAttractions(), 50f);
		Suggestion suggestion = createSuggestions();

		Float costTotal = promotable.calculateCost(suggestion);

		Assert.assertEquals(250f, costTotal, 0.001);
	}

	@Test
	public void applyPorcentualPromotionShouldNotDiscountCostTotal() {
		Promotable promotable = new PercentagePromotion(startDate(), endDate(), createOthersAttractions(), 50f);
		Suggestion suggestion = createSuggestions();

		Float costTotal = promotable.calculateCost(suggestion);

		Assert.assertEquals(500f, costTotal, 0.001);
	}

	@Test
	public void applyFamilyPackagePromotionForOneTicketsShouldNotDiscountCostTotal() {
		Integer purchasedTickets = 1;

		Promotable promotable = new FamilyPackagePromotion(startDate(), endDate());
		Suggestion suggestion = createSuggestionsForFamilyPackagePromotionWithTickets(purchasedTickets);

		Float costTotal = promotable.calculateCost(suggestion);

		Assert.assertEquals(10f, costTotal, 0.001);
	}

	@Test
	public void applyFamilyPackagePromotionForTwoTicketsShouldNotDiscountCostTotal() {
		Integer purchasedTickets = 2;

		Promotable promotable = new FamilyPackagePromotion(startDate(), endDate());
		Suggestion suggestion = createSuggestionsForFamilyPackagePromotionWithTickets(purchasedTickets);

		Float costTotal = promotable.calculateCost(suggestion);

		Assert.assertEquals(20f, costTotal, 0.001);
	}

	@Test
	public void applyFamilyPackagePromotionForThreeTicketsShouldNotDiscountCostTotal() {
		Integer purchasedTickets = 3;

		Promotable promotable = new FamilyPackagePromotion(startDate(), endDate());
		Suggestion suggestion = createSuggestionsForFamilyPackagePromotionWithTickets(purchasedTickets);

		Float costTotal = promotable.calculateCost(suggestion);

		Assert.assertEquals(30f, costTotal, 0.001);
	}

	@Test
	public void applyFamilyPackagePromotionForFourTicketsShouldDiscountCostTotal() {
		Integer purchasedTickets = 4;

		Promotable promotable = new FamilyPackagePromotion(startDate(), endDate());
		Suggestion suggestion = createSuggestionsForFamilyPackagePromotionWithTickets(purchasedTickets);

		Float costTotal = promotable.calculateCost(suggestion);

		Assert.assertEquals(36f, costTotal, 0.001);
	}

	@Test
	public void applyFamilyPackagePromotionForFiveTicketsShouldDiscountCostTotal() {
		Integer purchasedTickets = 5;

		Promotable promotable = new FamilyPackagePromotion(startDate(), endDate());
		Suggestion suggestion = createSuggestionsForFamilyPackagePromotionWithTickets(purchasedTickets);

		Float costTotal = promotable.calculateCost(suggestion);

		Assert.assertEquals(43f, costTotal, 0.001);
	}

	@Test
	public void applyFamilyPackagePromotionForSixTicketsShouldDiscountCostTotal() {
		Integer purchasedTickets = 6;

		Promotable promotable = new FamilyPackagePromotion(startDate(), endDate());
		Suggestion suggestion = createSuggestionsForFamilyPackagePromotionWithTickets(purchasedTickets);

		Float costTotal = promotable.calculateCost(suggestion);

		Assert.assertEquals(50f, costTotal, 0.001);
	}

	@Test
	public void applyForeignerPromotionShouldDiscountCostTotal() {
		Promotable promotable = new ForeignerPromotion(startDate(), endDate(), new Position(0f, 0f));
		Suggestion suggestion = createSuggestionsForForeigner();

		Float costTotal = promotable.calculateCost(suggestion);

		Assert.assertEquals(250f, costTotal, 0.001);
	}

	@Test
	public void applyForeignerPromotionShouldNotDiscountCostTotal() {
		Promotable promotable = new ForeignerPromotion(startDate(), endDate(), new Position(400f, 200f));
		Suggestion suggestion = createSuggestionsForForeigner();

		Float costTotal = promotable.calculateCost(suggestion);

		Assert.assertEquals(500f, costTotal, 0.001);
	}

	private Attraction createFreeAttraction() {
		Position position = new Position(20f, 40f);
		Attraction landscape = new Attraction(new Integer(2), position, 500f, 100f, AttractionType.LANDSCAPE,
				new Integer(100));
		return landscape;
	}

	private Suggestion createSuggestions() {
		return new Suggestion(createAttractions());
	}

	private Suggestion createSuggestionsForForeigner() {
		return new Suggestion(createAttractionsForForeignerPromotion());
	}

	private Suggestion createSuggestionsForFamilyPackagePromotionWithTickets(Integer purchasedTickets) {
		return new Suggestion(createAttractionsForFamilyPackagePromotion(purchasedTickets));
	}

	private Set<Attraction> createAttractions() {
		Position position = new Position(10f, 20f);
		Set<Attraction> attractions = new HashSet<Attraction>();
		Attraction landscape = new Attraction(new Integer(1), position, 500f, 100f, AttractionType.LANDSCAPE,
				new Integer(100));
		attractions.add(landscape);
		return attractions;
	}

	private Set<Attraction> createAttractionsForForeignerPromotion() {
		Position position = new Position(400f, 200f);
		Set<Attraction> attractions = new HashSet<Attraction>();
		Attraction landscape = new Attraction(new Integer(1), position, 500f, 100f, AttractionType.LANDSCAPE,
				new Integer(100));
		attractions.add(landscape);
		return attractions;
	}

	private Set<Attraction> createAttractionsForFamilyPackagePromotion(Integer purchasedTickets) {
		Position position = new Position(10f, 20f);
		Set<Attraction> attractions = new HashSet<Attraction>();
		Attraction landscape = new Attraction(new Integer(1), position, 10f, 100f, AttractionType.LANDSCAPE,
				new Integer(100));
		for (int i = 0; i < purchasedTickets; i++) {
			landscape.purchaseTicket();
		}
		attractions.add(landscape);
		return attractions;
	}

	private Set<Attraction> createOthersAttractions() {
		Position position = new Position(40f, 120f);
		Set<Attraction> attractions = new HashSet<Attraction>();
		Attraction landscape = new Attraction(new Integer(3), position, 1500f, 100f, AttractionType.LANDSCAPE,
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