/**
 * Ticket.java
 * 2015/07/08 
 **/

package GateManager;

public class Ticket {
    private int charge;
    private Station entrainingPoint;
    private boolean isInStationStat;
    
    int passType = 0;
    
    public Station getEntrainingPoint() {
        return entrainingPoint;
    }
    public int getCharge() {
        return charge;
    }
    public boolean isInStation() {
        return isInStationStat;
    }
    public void enterStation() {
        isInStationStat = true;
    }
    public int getPassType() {
        return passType;
    }
    
    
    public Ticket(int c, Station ep ,boolean stat) {
        charge = c;
        entrainingPoint = ep;
        isInStationStat = stat;
    }
    public Ticket() {
    }
    
}

