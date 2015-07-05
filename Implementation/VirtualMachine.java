/*
 * VirtualMachine.java
 * 2015/07/05 
 */
 
import java.util.ArrayList;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

class VirtualMachine {
    enum State {
        MENU,
        CREATE_STATION,
        CREATE_ICCARD,
        CREATE_TICKET,
        THROUGH_GATE
    }
    static State state;
    static ArrayList<ICCard>  iccards  = new ArrayList<ICCard>();
    static ArrayList<Ticket>  tickets  = new ArrayList<Ticket>();
    static ArrayList<Station> stations = new ArrayList<Station>();
    static ArrayList<String>  choices  = new ArrayList<String>();
    
    private static final int TEST_MAX = 256;
    
    public static void main(String[] args) {
        boolean running = true;
        
        initialize();
        
        while ( running ) {
            
            switch ( state ) {
                case MENU:
                    {
                        int input;
                        
                        displayStats();
                        displayChoices();
                        
                        input = getUserInputNum(0,4);
                        
                        switch ( inputNum ) {
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
                                changeState(State.THROUGH_GATE);
                                break;
                        }
                    }
                    break;
                case CREATE_STATION:
                    System.out.println("input the station name.");
                    inputStr = getUserInputStr();
                    stations.add(new Station(inputStr));
                    System.out.println("create station \""+inputStr+"\"");
                    changeState(State.MENU);
                    break;
                case CREATE_TICKET:
                    System.out.println("input an entraining point");
                    displayStations();
                    inputNum = getUserInputNum(0, stations.size());
                    System.out.println("input a cost");
                    inputNum = getUserInputNum(0, Integer.MAX_VALUE);
                    tickets.add(new Ticket(inputNum, stations.get(inputNum)));
                    break;
                case CREATE_ICCARD:
                    break;
            }
        }
        System.out.println("exit");
    }
    
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
    }
    
    //// input methods ////
    private static int getUserInputNum(int min, int max) {
        int input;
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
        getUserInputNum(Integer.MAX_VALUE,Integer.MIN_VALUE);
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
        for ( Station station : stations ) {
            System.out.println(" "+i+":");
            System.out.println("  name:"+station);
            i++;
        }
    }
    private static void displayICCards() {
        System.out.println("iccards:");
        int i = 0;
        for ( ICCard iccard : iccards ) {
            System.out.println(" "+i+":");
            System.out.println("  charge:"+iccard.getCharge());
            System.out.println("  entrainingPoint:"+iccard.getEntrainingPoint());
            i++;
        }
    }
    private static void displayTickets() {
        System.out.println("tickets:");
        int i = 0;
        for ( Ticket ticket: tickets) {
            System.out.println(" "+i+":");
            System.out.println("  cost:"+ticket.getCost());
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

class Station {
    private String name;
    
    public Station(String n) {
        name = n;
    }
    
    // to debug
    public String toString() {
        return name;
    }
}

abstract class Pass{
}

class Ticket extends Pass {
    private int cost;
    private Station entrainingPoint;
    // private boolean isInStation;
    
    public Station getEntrainingPoint() {
        return entrainingPoint;
    }
    public int getCost() {
        return cost;
    }
    
    public Ticket(int c, Station ep ) {
        cost = c;
        entrainingPoint = ep;
        // isInStation = false;
    }
    
}

class ICCard extends Pass {
    private int chargeAmount;
    private Station entrainingPoint;
    
    // unused
    private Station commuterPassStart;
    private Station commuterPassEnd;
    // private boolean isInStation;
    
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
        entrainingPoint = station;
    }
    public Station getEntrainingPoint() {
        return entrainingPoint;
    }
    
    public ICCard(int charge) {
        chargeAmount = charge;
        // isInStation = false;
    }
    
}


///////  sorry! unimplemented from here!!!

class GateManager {
    
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


class ICCardModifyer {
}

class ConsoleScreen {
}

class CashVent {
}

class CashReceiver {
}
