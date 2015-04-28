package ar.edu.tp1.domain;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class PercentagePromotion implements Promotable {

	private Set<Attraction> attractions;
	private Date startDate;
	private Date endDate;
	private Float porcentage;

	public PercentagePromotion(Date startDate, Date endDate, Set<Attraction> attractions, Float porcentage) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.attractions = attractions;
		this.porcentage = porcentage;
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

	public Float getPorcentage() {
		return porcentage;
	}

	public void setPorcentage(Float porcentage) {
		this.porcentage = porcentage;
	}

	public Set<Attraction> getAttractions() {
		return attractions;
	}

	@Override
	public void applyPromotion(User user, Suggestion suggestion) {
		if (isActive()) {

			Set<Attraction> attractionsSuggested = suggestion.getAttractionsSuggested();

			Iterator<Attraction> iteratorAttractionSuggested = attractionsSuggested.iterator();

			Boolean promotionApplied = Boolean.FALSE;

			while (iteratorAttractionSuggested.hasNext() && !promotionApplied) {
				Attraction attraction = iteratorAttractionSuggested.next();

				if (this.attractions.contains(attraction)) {
					float porcentage = (this.porcentage / 100) * suggestion.getTotalCost();
					user.discountMoney(porcentage);
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