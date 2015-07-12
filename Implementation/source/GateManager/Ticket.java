/**
 * Ticket.java
 * 2015/07/08 
 **/

package GateManager;

public class Ticket extends Pass{
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
    
    
    // ぶっちゃけた話もうただのエラー回避
    public void updateEntrainingPoint(Station station) {
    }
    public void deductCharge(int fare) {
    }
    
    
    
    public Ticket(int c, Station ep ,boolean stat) {
        charge = c;
        entrainingPoint = ep;
        isInStationStat = stat;
    }
    public Ticket() {
    }
    
}

