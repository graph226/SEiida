/**
 * GateManager.java
 * 2015/07/06
 **/

package GateManager;

public class GateManager {
    
    static Station station;
    static boolean isEntrance; // true:entrance false:exit
    static Gate gate;
    
    static public void openGateCheck(Pass pass) {
        if ( isEntrance ) {
            if ( pass.getEntrainingPoint() == null ) {
                ICPanel.updateEntrainingPoint(station);
                gate.openGate();
            } else if ( pass.getEntrainingPoint() == station ) {
                if ( pass.getPassType() == 0 ) {
                    TicketReceiver.cutTicket();
                    TicketReceiver.putoutTicket();
                }
                gate.openGate();
            } else {
                gate.closeGate();
                System.out.println("変なところから入らないで");
            }
        } else {
            int fare = station.getFare(pass.getEntrainingPoint());
            if ( fare <= pass.getCharge() ) {
                gate.openGate();
                switch ( pass.getPassType() ) {
                    case 0:
                        // do nothing
                        break;
                    case 1:
                        ICPanel.deductCharge(fare);
                        break;
                }
            } else {
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
