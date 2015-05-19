package ar.edu.tp1.domain.promotion;

import java.util.Date;
import java.util.Set;

import ar.edu.tp1.domain.attraction.Attraction;
import ar.edu.tp1.domain.attraction.Suggestion;

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
	public Float calculateCost(Suggestion suggestion) {
		Float costTotal = suggestion.calculateCostTotalForAttractions();
		if (isActive() && isAppliedPromotion(suggestion)) {
			return (this.porcentage / 100) * costTotal;
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

	@Override
	public Boolean isCombinable() {
		return Boolean.TRUE;
	}
}