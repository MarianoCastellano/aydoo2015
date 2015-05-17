package ar.edu.tp1.domain;

import java.util.Date;
import java.util.Set;

public class AbsolutePromotion implements Promotable {

	private Set<Attraction> attractions;
	private Date startDate;
	private Date endDate;
	private Float costTotal;

	public AbsolutePromotion(Date startDate, Date endDate, Set<Attraction> attractions, Float costTotal) {
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

	public Set<Attraction> getAttractions() {
		return attractions;
	}

	@Override
	public Float calculateCost(Suggestion suggestion) {
		Float costTotal = suggestion.calculateCostTotalForAttractions();
		if (isActive() && isAppliedPromotion(suggestion)) {
			return costTotal - this.costTotal;
		}
		return costTotal;
	}

	private boolean isAppliedPromotion(Suggestion suggestion) {
		return this.attractions.containsAll(suggestion.getAttractionsSuggested());
	}

	private boolean isActive() {
		Date today = new Date();
		return today.after(this.startDate) && today.before(this.endDate);
	}

}