/**
 * ICCard.java
 * 2015/07/08 
 **/

package GateManager;

public class ICCard extends Pass {
	private int chargeAmount;
	private Station entrainingPoint;

	// unused
	private Station commuterPassStart;
	private Station commuterPassEnd;

	public int getCharge() {
		return chargeAmount;
	}

	static public void deductCharge(int deductAmount) {
		System.out.println("");
	}

	public void updateCharge(int charge) {
		chargeAmount = charge;
	}

	public void updateEntrainingPoint(Station station) {
		entrainingPoint = station;
	}

	public Station getEntrainingPoint() {
		return entrainingPoint;
	}

	public boolean isInStation() {
		return entrainingPoint != null;
	}

	public ICCard(int charge) {
		chargeAmount = charge;
		entrainingPoint = null;
	}

	public ICCard() {

	}

}
