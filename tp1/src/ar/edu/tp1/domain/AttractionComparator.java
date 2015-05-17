package ar.edu.tp1.domain;

import java.util.Comparator;

public class AttractionComparator implements Comparator<Attraction> {

	@Override
	public int compare(Attraction origin, Attraction destination) {
		return origin.distanceTo(destination).intValue();
	}

}