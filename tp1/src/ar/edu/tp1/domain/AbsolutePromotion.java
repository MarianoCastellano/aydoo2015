package ar.edu.tp1.domain;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AbsolutePromotion implements Promotable {

	private List<Attraction> attractions;
	private Date startDate;
	private Date endDate;
	private Float costTotal;

	public AbsolutePromotion(Date startDate, Date endDate, List<Attraction> attractions, Float costTotal) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.attractions = attractions;
		this.costTotal = costTotal;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Float getCostTotal() {
		return costTotal;
	}

	public void setCostTotal(Float costTotal) {
		this.costTotal = costTotal;
	}

	public List<Attraction> getAttractions() {
		return attractions;
	}

	@Override
	public void applyPromotion(User user, Suggestion suggestion) {
		if (isActive()) {

			List<Attraction> attractionsSuggested = suggestion.getAttractionsSuggested();

			Iterator<Attraction> iteratorAttractionSuggested = attractionsSuggested.iterator();

			Boolean promotionApplied = Boolean.FALSE;

			while (iteratorAttractionSuggested.hasNext() && !promotionApplied) {
				Attraction attraction = iteratorAttractionSuggested.next();

				if (this.attractions.contains(attraction)) {
					user.discountMoney(this.costTotal);
					promotionApplied = Boolean.TRUE;
				}
			}
		}
	}

	private boolean isActive() {
		Date today = new Date();
		return today.after(this.startDate) && today.before(this.endDate);
	}

}