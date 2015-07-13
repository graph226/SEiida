/**
 * TicketReceiver.java
 * 2015/07/08
 **/

package GateManager;

public class TicketReceiver {
    static Ticket ticket;
    static public void insert(Ticket in) {
        ticket = in;
        GateManager.openGateCheck(ticket);
    }
    static public void cutTicket() {
        ticket.enterStation();
    }
    static public void putoutTicket() {
        System.out.println("putout ticket");
    }
}


