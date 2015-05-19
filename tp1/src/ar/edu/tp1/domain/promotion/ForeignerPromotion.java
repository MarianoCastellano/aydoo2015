package ar.edu.tp1.domain.promotion;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import ar.edu.tp1.domain.Position;
import ar.edu.tp1.domain.attraction.Attraction;
import ar.edu.tp1.domain.attraction.Suggestion;

public class ForeignerPromotion implements Promotable {

	private Date startDate;
	private Date endDate;
	private Position position;

	public ForeignerPromotion(Date startDate, Date endDate, Position position) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.position = position;
	}

	public Date getEndDate() {
		return endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Position getPosition() {
		return position;
	}

	@Override
	public Float calculateCost(Suggestion suggestion) {
		Float costTotal = suggestion.calculateCostTotalForAttractions();
		if (isActive()) {
			Set<Attraction> attractionsSuggested = suggestion.getAttractionsSuggested();
			Iterator<Attraction> iteratorAttractionsSuggested = attractionsSuggested.iterator();

			while (iteratorAttractionsSuggested.hasNext()) {
				Attraction attraction = iteratorAttractionsSuggested.next();

				if (attraction.getPosition().distanceTo(this.position) >= 200) {
					return costTotal / 2;
				}
			}
		}
		return costTotal;
	}

	private boolean isActive() {
		Date today = new Date();
		return today.after(this.startDate) && today.before(this.endDate);
	}

	@Override
	public Boolean isCombinable() {
		return Boolean.FALSE;
	}
}