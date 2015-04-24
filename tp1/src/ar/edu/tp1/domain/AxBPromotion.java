package ar.edu.tp1.domain;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class AxBPromotion implements Promotable {

	private Set<Attraction> attractions;
	private Date startDate;
	private Date endDate;
	private Attraction attractionFree;

	public AxBPromotion(Date startDate, Date endDate, Set<Attraction> attractions, Attraction attractionFree) {
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

	public void setAttractions(Set<Attraction> attractions) {
		this.attractions = attractions;
	}

	@Override
	public void applyPromotion(User user, Set<Attraction> attractionsSuggested) {
		if (isActive()) {
			attractionsSuggested.add(attractionFree);
		}
	}

	@Override
	public boolean applyToUser(User user, Set<Attraction> attractionsSuggested) {

		Iterator<Attraction> iteratorAttractionsSuggested = attractionsSuggested.iterator();

		boolean apply = true;

		while (iteratorAttractionsSuggested.hasNext() && apply) {
			Attraction attraction = iteratorAttractionsSuggested.next();

			Iterator<Attraction> iteratorAttractions = this.attractions.iterator();

			while (iteratorAttractions.hasNext() && apply) {
				Attraction attractionPurchased = iteratorAttractions.next();

				if (isSameAttraction(attraction, attractionPurchased)) {
					apply = false;
				}
			}
		}

		return apply;
	}

	private boolean isSameAttraction(Attraction attraction, Attraction attractionPurchased) {
		return attraction.getX() == attractionPurchased.getX() && attraction.getY() == attractionPurchased.getY();
	}

	private boolean isActive() {
		Date today = new Date();
		return today.after(this.startDate) && today.before(this.endDate);
	}

	public Set<Attraction> getAttractions() {
		return attractions;
	}

}