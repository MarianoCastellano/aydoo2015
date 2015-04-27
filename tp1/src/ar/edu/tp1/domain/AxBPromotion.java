package ar.edu.tp1.domain;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AxBPromotion implements Promotable {

	private List<Attraction> attractions;
	private Date startDate;
	private Date endDate;
	private Attraction attractionFree;

	public AxBPromotion(Date startDate, Date endDate, List<Attraction> attractions, Attraction attractionFree) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.attractions = attractions;
		this.attractionFree = attractionFree;
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

	public Attraction getAttractionFree() {
		return attractionFree;
	}

	public void setAttractionFree(Attraction attractionFree) {
		this.attractionFree = attractionFree;
	}

	public void setAttractions(List<Attraction> attractions) {
		this.attractions = attractions;
	}

	public List<Attraction> getAttractions() {
		return attractions;
	}

	@Override
	public void applyPromotion(User user, Suggestion suggestion) {
		if (isActive()) {
			List<Attraction> attractionsSuggested = suggestion.getAttractionsSuggested();
			Iterator<Attraction> iteratorAttractionsSuggested = attractionsSuggested.iterator();

			Boolean promotionApplied = Boolean.FALSE;

			while (iteratorAttractionsSuggested.hasNext() && !promotionApplied) {
				Attraction attraction = iteratorAttractionsSuggested.next();

				Iterator<Attraction> iteratorAttractions = this.attractions.iterator();

				while (iteratorAttractions.hasNext() && !promotionApplied) {
					Attraction attractionPurchased = iteratorAttractions.next();

					if (isSameAttraction(attraction, attractionPurchased) && this.attractionFree.allowUser(user)) {
						suggestion.addAttractionForSuggested(this.attractionFree);
						promotionApplied = Boolean.TRUE;
					}
				}
			}
		}
	}

	private boolean isSameAttraction(Attraction attraction, Attraction attractionPurchased) {
		return attraction.getId().equals(attractionPurchased.getId());
	}

	private boolean isActive() {
		Date today = new Date();
		return today.after(this.startDate) && today.before(this.endDate);
	}

}