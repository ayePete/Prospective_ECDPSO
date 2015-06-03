package controller;

import java.util.ArrayList;
import java.util.List;

public class Particle {
	/**
	 * Method to compute the product of a {@code double} value and the
	 * {@code List<Integer>} difference between two positions.
	 * 
	 * @param {@code double} x
	 * @param {@code List<Integer>} diff
	 * @return {@code double} product
	 */
	public static double multiply(double x, List<Integer> diff) {
		return x * diff.size();
	}

	/**
	 * Method to compute the difference between two positions, A and B , (A - B)
	 * defined as the list of indices of edges in B which are not in A.
	 * 
	 * @param {@code EdgeSet} <b>position1:</b> The first position, A
	 * @param {@code EdgeSet} <b>position2:</b> The second position, B
	 * @return {@code List<Integer>} <b>differences:</b> The difference between
	 *         the two positions
	 */
	public static List<Integer> subtractPositions(EdgeSet position1,
			EdgeSet position2) {
		List<Integer> differences = new ArrayList<Integer>();
		for (int i = 0; i < position2.size(); i++) {
			int j = 0;
			for (; j < position1.size(); j++) {
				if (position2.getEdge(i).equals(position1.getEdge(j)))
					break;
			}
			if (j == position1.size())
				differences.add(i);
		}
		return differences;
	}

	private double previousFitness;
	private EdgeSet pbest;
	private EdgeSet position;

	private int velocity;

	public Particle(EdgeSet initPosition, int velo) {
		position = initPosition.clone();
		pbest = initPosition.clone();
		velocity = velo;
		previousFitness = position.fitness();
	}

	public double fitness() {
		return position.fitness();
	}

	/**
	 * @return {@code EdgeSet} the pbest
	 */
	public EdgeSet getPbest() {
		return pbest;
	}

	/**
	 * @return {@code EdgeSet} the position
	 */
	public EdgeSet getPosition() {
		return position;
	}

	/**
	 * @return {@code double} the previousFitness
	 */
	public double getPreviousFitness() {
		return previousFitness;
	}

	/**
	 * @return {@code int} the velocity
	 */
	public int getVelocity() {
		return velocity;
	}

	/**
	 * @param <b>pbest</b> the {@code EdgeSet} pbest to set
	 */
	public void setPbest(EdgeSet pbest) {
		this.pbest = pbest.clone();
	}

	/**
	 * @param <b>position</b> the {@code EdgeSet} position to set
	 */
	public void setPosition(EdgeSet position) {
		this.position = position.clone();
	}

	/**
	 * @param <b>previousFitness</b> the {@code double} previousFitness to set
	 */
	public void setPreviousFitness(double previousFitness) {
		this.previousFitness = previousFitness;
	}

	/**
	 * @param <b>velocity</b> the {@code int} velocity to set
	 */
	public void setVelocity(int vel) {
		if (vel > position.getExpectedSize())
			this.velocity = position.getExpectedSize();
		else
			this.velocity = vel;
	}

	@Override
	public String toString() {
		return position.toString();
	}

}
