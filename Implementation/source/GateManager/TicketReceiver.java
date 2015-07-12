/**
 * TicketReceiver.java
 * 2015/07/08
 **/

package GateManager;

public class TicketReceiver implements PassReceiver {
    static Pass pass;
    static public void insert(Pass pass) {
        GateManager.openGateCheck(pass);
        pass = pass;
    }
    static public void cutTicket() {
        pass.enterStation();
    }
    static public void putoutTicket() {
        System.out.println("putout ticket");
    }
}


