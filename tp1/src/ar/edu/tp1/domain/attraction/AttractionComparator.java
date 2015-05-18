package ar.edu.tp1.domain.attraction;

import java.util.Comparator;

import ar.edu.tp1.domain.Position;

public class AttractionComparator implements Comparator<Position> {

	@Override
	public int compare(Position origin, Position destination) {
		return origin.distanceTo(destination).intValue();
	}

}