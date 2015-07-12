/**
 * ICCard.java
 * 2015/07/08 
 **/

package GateManager;

public class ICCard extends Pass{
    private int chargeAmount;
    private Station entrainingPoint;
    
    // unused
    private Station commuterPassStart;
    private Station commuterPassEnd;
    
    int passType = 1;
    
    public int getCharge() {
        return chargeAmount;
    }
    public void deductCharge(int fare) {
        chargeAmount -= fare;
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
    public int getPassType() {
        return passType;
    }
    public void enterStation() {
    }
    
    public ICCard(int charge,Station station) {
        chargeAmount = charge;
        entrainingPoint = station;
    }
    public ICCard(int charge) {
    	 chargeAmount = charge;
         entrainingPoint = null;
    
    }
    
}

