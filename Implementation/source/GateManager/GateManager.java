/**
 * GateManager.java
 * 2015/07/06
 **/

package GateManager;

public class GateManager {
    
    static Station station;
    static boolean isEntrance; // true:entrance false:exit
    static Gate gate;
    
    static public void openGateCheck(Ticket ticket) {
        if ( isEntrance ) {
            if ( ticket.getEntrainingPoint() == station ) {
                TicketReceiver.cutTicket();
                TicketReceiver.putoutTicket();
                gate.openGate();
            } else {
                System.out.println("illegal entraining point.");
                gate.closeGate();
            }
        } else {
            int fare = station.getFare(ticket.getEntrainingPoint());
            if ( fare <= ticket.getCharge() ) {
                gate.openGate();
            } else {
                System.out.println("たりない");
            }
        }
    }
    static public void openGateCheck(ICCard iccard) {
        if ( isEntrance ) {
            if ( iccard.getEntrainingPoint() == null ) {
                ICPanel.updateEntrainingPoint(station);
                gate.openGate();
            } else {
                System.out.println("ICCard is in the station");
                gate.closeGate();
            }
        } else {
            int fare = station.getFare(iccard.getEntrainingPoint());
            if ( fare <= iccard.getCharge() ) {
                gate.openGate();
                ICPanel.deductCharge(fare);
            } else {
                gate.closeGate();
                System.out.println("たりない");
            }
        }
    }
    
    // set Gate State
    static public void setEnvironment(Station s, boolean ent) {
        station = s;
        isEntrance = ent;
        gate = new Gate();
    }
}

class Gate {
    public void openGate() {
        System.out.println("open gate");
    }
    public void closeGate() {
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
