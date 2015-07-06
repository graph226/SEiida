/**
 * GateManager.java
 * 2015/07/06
 **/

package GateManager;

class Station {
    private String name;
    
    public Station(String n) {
        name = n;
    }
}

abstract class Pass{
    abstract public Station getEntrainingPoint();
    abstract public boolean isInStation();
}

class Ticket extends Pass {
    private int cost;
    private Station entrainingPoint;
    private boolean isInStationStat;
    
    public Station getEntrainingPoint() {
        return entrainingPoint;
    }
    public int getCost() {
        return cost;
    }
    public boolean isInStation() {
        return isInStationStat;
    }
    
    public Ticket(int c, Station ep ,boolean stat) {
        cost = c;
        entrainingPoint = ep;
        isInStationStat = stat;
    }
    
}

class ICCard extends Pass {
    private int chargeAmount;
    private Station entrainingPoint;
    
    // unused
    private Station commuterPassStart;
    private Station commuterPassEnd;
    
    public int getCharge() {
        return chargeAmount;
    }
    public void deductCharge(int deductAmount) {
        chargeAmount -= deductAmount;
    }
    public void updateCharge(int charge) {
        chargeAmount = charge;
    }
    public void updateEntrainingPoint(Station station) {
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
    
}

public class GateManager {
    
    Station station;
    boolean isEntrance; // true:entrance false:exit
    TicketReceiver ticketReceiver;
    ICPanel icPanel;
    Gate gate;
    
    public void deductICCharge(int deductAmount) {
        
    }
    
    static public void openGateCheck(Pass pass) {
        
    }
}

class TicketVent {
    public void putoutTicket() {
    }
}

class PassReceiver {
    public void insert(Pass pass) {
        GateManager.openGateCheck(pass);
    }
}

class TicketReceiver extends PassReceiver {
    // insert ticket
    public void insert(Pass pass) {
        super.insert(pass);
    }
}

class ICPanel extends PassReceiver {
    // touch ICCard
    public void insert(Pass pass) {
        super.insert(pass);
    }
}

class Gate {
    public void closeGate() {
    }
}

//// 

class ICCardModifyer {
}

class ConsoleScreen {
}

class CashVent {
}

class CashReceiver {
}
