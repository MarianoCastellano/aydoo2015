package ar.edu.tp1.domain.promotion;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import ar.edu.tp1.domain.attraction.Attraction;
import ar.edu.tp1.domain.attraction.Suggestion;

public class FamilyPackagePromotion implements Promotable {

	private final Integer MINIMUM_PURCHASED_TICKETS = 4;
	private final Double ADDITIONAL_DISCOUNT = 0.3;
	private final Double GENERAL_DISCOUNT = 0.1;

	private Date startDate;
	private Date endDate;
	private Integer purchasedTickets;

	public FamilyPackagePromotion(Date startDate, Date endDate, Integer purchasedTickets) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.purchasedTickets = purchasedTickets;
	}

	@Override
	public Float calculateCost(Suggestion suggestion) {
		Float costTotal = suggestion.calculateCostTotalForAttractions();
		if (isActive()) {
			costTotal *= purchasedTickets;
			Set<Attraction> attractionsSuggested = suggestion.getAttractionsSuggested();
			Iterator<Attraction> iteratorAttractionsSuggested = attractionsSuggested.iterator();

			Float discount = 0f;
			while (iteratorAttractionsSuggested.hasNext()) {
				Attraction attraction = iteratorAttractionsSuggested.next();

				discount = getDiscountsForAttraction(discount, attraction);
			}
			return costTotal - discount;
		}
		return costTotal;
	}

	private Float getDiscountsForAttraction(Float discount, Attraction attraction) {
		if (purchasedTickets.equals(new Integer(MINIMUM_PURCHASED_TICKETS))) {
			discount += getGeneralDiscount(attraction).floatValue();
		}

		if (purchasedTickets.intValue() > MINIMUM_PURCHASED_TICKETS) {
			Integer ticketsRemaining = purchasedTickets - MINIMUM_PURCHASED_TICKETS;
			discount += getGeneralDiscount(attraction).floatValue();
			discount += getAdditionalDiscount(attraction, ticketsRemaining).floatValue();
		}
		return discount;
	}

	private Double getGeneralDiscount(Attraction attraction) {
		return attraction.getCost() * GENERAL_DISCOUNT * MINIMUM_PURCHASED_TICKETS;
	}

	private Double getAdditionalDiscount(Attraction attraction, Integer ticketsRemaining) {
		return attraction.getCost() * ticketsRemaining * ADDITIONAL_DISCOUNT;
	}

	private boolean isActive() {
		Date today = new Date();
		return today.after(this.startDate) && today.before(this.endDate);
	}

	@Override
	public Boolean isCombinable() {
		return Boolean.TRUE;
	}
}