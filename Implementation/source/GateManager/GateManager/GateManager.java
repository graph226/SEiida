/**
 * GateManager.java
 * 2015/07/06
 **/

package GateManager;

public class GateManager {
    
    Station station;
    boolean isEntrance; // true:entrance false:exit
    Gate gate;
    
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
        System.out.println("putout ticket");
    }
}


interface PassReceiver {
 /*   abstract static public void insert(Pass pass) {
    //    GateManager.openGateCheck(pass);
    }*/
}

class TicketReceiver implements PassReceiver {
}

class ICPanel implements PassReceiver {
}

class Gate {
    static public void closeGate() {
        System.out.println("close gate");
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
