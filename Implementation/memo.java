class VirtualUI {
    public static void main(String[] args) {
        ICCard[] iccard = new ICCard[10];
        switch( input ) {
            case 1:
                break;
            case 2:
                break;
        }
    }
}


class GateInputBoundary {
    public void icCardTouched(ICCard iccard) {
        GateManager.check(iccard);
    }
    public void ticketInserted(Ticket ticket) {
        GateManager.check(ticket);
    }
}

class GateManager {
    public void check(ICCard iccard) {
        // calc
        // then
        Gate.open();
        else
        Gate.close();
        ICPanel.warn();
    }
    
    public void check(Ticket ticket) {
        // calc
    }
}


