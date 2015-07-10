/**
 * Ticket.java
 * 2015/07/08 
 **/

package GateManager;

public class Ticket extends Pass {
	private int charge;
	private Station entrainingPoint;
	private boolean isInStationStat;

	public Station getEntrainingPoint() {
		return entrainingPoint;
	}

	public int getCharge() {
		return charge;
	}

	public boolean isInStation() {
		return isInStationStat;
	}

	public Ticket(int c, Station ep, boolean stat) {
		charge = c;
		entrainingPoint = ep;
		isInStationStat = stat;
	}

	public Ticket() {
	}

}
