package ar.edu.tp1.domain;

import java.util.Date;
import java.util.Set;

public class AbsolutePromotion implements Promotable {

	private Set<Attraction> attractions;
	private Date startDate;
	private Date endDate;
	private float costTotal;

	public AbsolutePromotion(Date startDate, Date endDate, Set<Attraction> attractions, float costTotal) {
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

	public float getCostTotal() {
		return costTotal;
	}

	public void setCostTotal(float costTotal) {
		this.costTotal = costTotal;
	}

	@Override
	public void applyPromotion(User user, Set<Attraction> attractionsSuggested) {
		if (isActive()) {
			for (Attraction attraction : attractions) {
				if (isValidForAttraction(user, attraction)) {
					attractionsSuggested.add(attraction);
					user.discountMoney(this.costTotal);
				}
			}
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

	@Override
	public boolean applyToUser(User user, Set<Attraction> attractionsSuggested) {
		return true;
	}

	public Set<Attraction> getAttractions() {
		return attractions;
	}

}