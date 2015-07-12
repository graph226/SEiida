/**
 * VirtualEnvironment.java
 * 2015/07/05 
 **/

package VirtualEnvironment;

import java.util.ArrayList;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import GateManager.*;

class VirtualEnvironment {
    enum State {
        MENU,
        CREATE_STATION,
        CREATE_ICCARD,
        CREATE_TICKET,
        THROUGH_GATE
    }
    static State state;
    static ArrayList<VirtualICCard>  iccards  = new ArrayList<VirtualICCard>();
    static ArrayList<VirtualTicket>  tickets  = new ArrayList<VirtualTicket>();
    static ArrayList<VirtualStation> stations = new ArrayList<VirtualStation>();
    static ArrayList<String>  choices  = new ArrayList<String>();
    static boolean running = true;
    
    private static final int TEST_MAX = 256;
    
    public static void main(String[] args) {
        
        initialize();
        
        while ( running ) {
            
            switch ( state ) {
                case MENU:
                    menuProcess();
                    break;
                case CREATE_STATION:
                    createStationProcess();
                    break;
                case CREATE_TICKET:
                    createTicketProcess();
                    break;
                case CREATE_ICCARD:
                    createICCardProcess();
                    break;
                case THROUGH_GATE:
                    throughGateProcess();
                    break;
            }
        }
        System.out.println("exit");
    }
    
    
    //// main process
    private static void menuProcess() {
        int input;
        
        displayStats();
        displayChoices();
        
        input = getUserInputNum(0,choices.size());
        
        switch ( input ) {
            case 0:
                running = false;
                break;
            case 1:
                changeState(State.CREATE_STATION);
                break;
            case 2:
                if ( !stations.isEmpty() ) {
                    changeState(State.CREATE_TICKET);
                } else {
                    System.out.println("there is no station.");
                    System.out.println("please create a station.");
                }
                break;
            case 3:
                changeState(State.CREATE_ICCARD);
                break;
            case 4:
                if ( stations.isEmpty() ) {
                    System.out.println("there is no station.");
                    System.out.println("please create a station.");
                } else if ( tickets.isEmpty() && iccards.isEmpty() ) {
                    System.out.println("there is no tickets or iccards.");
                    System.out.println("please create a ticket or a iccard.");
                } else {
                    changeState(State.THROUGH_GATE);
                }
                break;
        }
    }
    private static void createStationProcess() {
        String input;
        System.out.println("input the station name.");
        input = getUserInputStr();
        stations.add(new VirtualStation(input));
        System.out.println("create station \""+input+"\"");
        changeState(State.MENU);
    }
    private static void createTicketProcess() {
        int inputStation;
        int inputCharge;
        System.out.println("input an entraining point");
        displayStations();
        inputStation = getUserInputNum(0, stations.size());
        System.out.println("input a charge");
        inputCharge = getUserInputNum();
        tickets.add(new VirtualTicket(inputCharge, stations.get(inputStation)));
        changeState(State.MENU);
    }
    private static void createICCardProcess() {
        int input;
        System.out.println("input charge ampunt.");
        input = getUserInputNum();
        iccards.add(new VirtualICCard(input));
        changeState(State.MENU);
    }
    private static void throughGateProcess() {
        int input;
        int index;
        Pass pass = null;
        VirtualStation station;
        boolean isEntrance;
        
        // choose entrance or exit
        System.out.println("choose entrance gate or exit gate ");
        System.out.println("0:entrance , 1:exit ");
        input = getUserInputNum(0,2);
        if ( input == 0 ) {
            isEntrance = true;
        } else {
            isEntrance = false;
        }
        
        // choose ticket or ICCard
        System.out.println("choose ticket or ICCard.");
        System.out.println("0:ticket, 1:iccard");
        input = getUserInputNum(0,2);
        switch( input ) {
            case 0:
                System.out.println("choose ticket");
                displayTickets();
                index = getUserInputNum(0,tickets.size());
                pass = (Pass)tickets.get(index);
                break;
            case 1:
                System.out.println("choose ICCard");
                displayICCards();
                index = getUserInputNum(0,iccards.size());
                pass = (Pass)iccards.get(index);
                break;
            default:
                System.err.println("mysterious error caused");
        }
        
        // choose station
        System.out.println("choose station");
        displayStations();
        index = getUserInputNum(0,stations.size());
        station = stations.get(index);
        
        throughGate(isEntrance, pass, station);
        
        changeState(State.MENU);
    }
    ////
    
    //// the most important thing that i should implement.
    private static void throughGate(boolean isEntrance, Pass pass, Station station) {
        
    }
    ////
    
    private static void initialize() {
        changeState(State.MENU);
    }
    
    private static void changeState(State nextState) {
        state = nextState;
        switch(nextState) {
            case MENU:
                choices.clear();
                choices.add("exit");
                choices.add("create station");
                choices.add("create ticket");
                choices.add("create ICcard");
                choices.add("through gate");
                break;
            case CREATE_STATION:
                break;
            case CREATE_ICCARD:
                break;
            case CREATE_TICKET:
                break;
            case THROUGH_GATE:
                break;
        }
        System.out.println();
    }
    
    //// input methods ////
    private static int getUserInputNum(int min, int max) {
        int input;
        max--;
        do {
            System.out.print(">>");
            try {
                input = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
            } catch (IOException e) {
                System.out.println("cause input error.");
                System.out.println("please try again.");
                input = -1;
            } catch (NumberFormatException e) {
                System.out.println("please input a number.");
                input = -1;
            }
            if ( input > max || input < min ) {
                System.out.println("please choose in range from " + min + " to "+max+".");
                input = -1;
            }
        } while ( input == -1 ) ;
        return input;
    }
    private static int getUserInputNum() {
        return getUserInputNum(0,Integer.MAX_VALUE);
    }
    
    private static String getUserInputStr() {
        String input;
        do {
            System.out.print(">>");
            try {
                input = new BufferedReader(new InputStreamReader(System.in)).readLine();
            } catch (IOException e){
                System.out.println("cause input error.");
                System.out.println("please try again.");
                input = null;
            }
        } while ( input == null );
        return input;
    }
    ////
    
    //// display methods ////
    private static void displayStats() {
        switch( state ) {
            case MENU:
                displayStations();
                displayICCards();
                displayTickets();
                System.out.println();
                break;
        }
    }
    
    private static void displayStations() {
        System.out.println("stations:");
        int i = 0;
        for ( VirtualStation station : stations ) {
            System.out.println(" "+i+":");
            System.out.println("  name:"+station);
            i++;
        }
    }
    private static void displayICCards() {
        System.out.println("iccards:");
        int i = 0;
        for ( VirtualICCard iccard : iccards ) {
            System.out.println(" "+i+":");
            System.out.println("  charge:"+iccard.getCharge());
            System.out.println("  entrainingPoint:"+iccard.getEntrainingPoint());
            i++;
        }
    }
    private static void displayTickets() {
        System.out.println("tickets:");
        int i = 0;
        for ( VirtualTicket ticket: tickets) {
            System.out.println(" "+i+":");
            System.out.println("  charge:"+ticket.getCharge());
            System.out.println("  entrainingPoint:"+ticket.getEntrainingPoint());
            i++;
        }
    }
    
    private static void displayChoices() {
        int i = 0;
        for ( String choice : choices ) {
            if ( i != 0 ) System.out.print(", ");
            System.out.print(i+":"+choice);
            i++;
        }
        System.out.println();
    }
    ////
    
}

//// virtual objects
class VirtualStation extends Station{
    private String name;
    public VirtualStation(String n) {
        name = n;
    }
    public String toString() {
        return name;
    }
}
class VirtualTicket extends Ticket{
    private int charge;
    private VirtualStation entrainingPoint;
    private boolean isInStationStat;
    
    public VirtualStation getEntrainingPoint() {
        return entrainingPoint;
    }
    
    public VirtualTicket(int c, VirtualStation ep) {
        charge = c;
        entrainingPoint = ep;
        isInStationStat = false;
    }
    public VirtualTicket(int c, VirtualStation ep ,boolean stat) {
        charge = c;
        entrainingPoint = ep;
        isInStationStat = stat;
    }
}
class VirtualICCard extends ICCard{
    private int chargeAmount;
    private VirtualStation entrainingPoint;
    
    public VirtualStation getEntrainingPoint() {
        return entrainingPoint;
    }
    
    public VirtualICCard(int charge) {
        chargeAmount = charge;
        entrainingPoint = null;
    }
    
}

