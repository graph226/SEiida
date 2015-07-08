/**
 * GateManager.java
 * 2015/07/06
 **/

package GateManager;

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
    
    public GateManager(Station station, boolean isEntrance) {
        station = station;
        isEntrance = isEntrance;
        gate = new Gate();
    }
}

class TicketVent {
    public void putoutTicket() {
    }
}

/*
class PassReceiver {
    public void insert(Pass pass) {
        GateManager.openGateCheck(pass);
    }
}*/

class TicketReceiver {
}

class ICPanel {
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
