package ar.edu.tp1.domain;

public class Position {

	private Float x;
	private Float y;

	public Position(Float x, Float y) {
		this.x = x;
		this.y = y;
	}

	public Float getX() {
		return x;
	}

	public Float getY() {
		return y;
	}

	public Double distanceTo(Position destination) {
		double originX = this.getX();
		double originY = this.getY();
		double destinationX = destination.getX();
		double destinationY = destination.getY();

		return Math.sqrt(Math.pow(destinationX - originX, 2) + Math.pow(destinationY - originY, 2));
	}
}