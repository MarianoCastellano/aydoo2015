package ar.edu.tp1.domain;

import java.util.Date;
import java.util.Set;

public class PercentagePromotion {

	private Set<Attraction> attractions;
	private Date startDate;
	private Date endDate;
	private float porcentage;

	public PercentagePromotion(Date startDate, Date endDate, Set<Attraction> attractions, float porcentage) {
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

	public float getPorcentage() {
		return porcentage;
	}

	public void setPorcentage(float porcentage) {
		this.porcentage = porcentage;
	}

	public Set<Attraction> getAttractions() {
		return attractions;
	}

	public void applyPromotion(User user, Set<Attraction> attractionsSuggested) {
		if (isActive()) {

			float totalCost = 0;
			for (Attraction attractionPromotion : getAttractions()) {
				if (isValidForAttraction(user, attractionPromotion)) {

					totalCost += attractionPromotion.getCost();
					attractionsSuggested.add(attractionPromotion);
				}
			}

			float porcentage = this.porcentage * totalCost;
			user.discountMoney(porcentage);
		}
	}

	private boolean isActive() {
		Date today = new Date();
		return today.after(this.startDate) && today.before(this.endDate);
	}

	private boolean isValidForAttraction(User user, Attraction attraction) {
		return attraction.hasMoneyEnough(user.getMoney()) && attraction.hasTimeEnough(user.getTimeRemaining())
				&& attraction.IsFavoriteAttraction(user.getFavoriteAttraction()) && attraction.hasCapacity();
	}

	public boolean applyToUser(User user, Set<Attraction> attractionsSuggested) {
		return true;
	}

}