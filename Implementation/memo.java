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
    static public void check(ICCard iccard) {
        // calc
        // then
        Gate.open();
        ICPanel.deduct();
        else
        Gate.close();
        Display.warn();
    }
    
    public void check(Ticket ticket) {
        // calc
    }
}

through_gate$B$GMW$kF~NO(B
$B!&(BIC$B%+!<%I$J$N$+@ZId$J$N$+(B
$B!&;H$&@ZId(BorIC$B%+!<%I(B
$B!&F~>l$+=P>l$+(B
$B!&2?1X$+(B



$B2~;%$,308~$-(B
    $B$b$H$b$H$"$k>pJs(B:
        $B$3$3$,2?1X$+(B
        hoge$B1X$+$i$$$/$i$+!J!)!K(B
    $BF~NO$K$h$C$F$b$i$($k>pJs(B:
        $B$I$3$+$iF~>l$7$?$+(B
        $B$$$/$iJ'$($k$+(B
    $B$=$l$K$h$C$FH/@8$9$k=PNO(B:
        $B%P!<$N3+JD(B
        $B@ZId$N2s<}(B
        IC$B%+!<%I$N;D3[$N8:;;(B
        $BDL9T$G$-$J$$>l9g$N%(%i!<I=<((B
$B2~;%$,Fb8~$-(B
    $B$b$H$b$H$"$k>pJs(B:
        $B$3$3$,2?1X$+(B
    $BF~NO$K$h$C$F$b$i$($k>pJs(B:
        $B@ZId$N:n@.F|;~!!!J9MN8$7$J$$(B
        IC$B%+!<%I$N;D3[(B
    $B$=$l$K$h$C$FH/@8$9$k=PNO(B
        $B%P!<$N3+JD(B
        $B@ZId(B/IC$B%+!<%I$K>h<V1X$r5-O?(B
        $B%(%i!<$N>l9g$N$R$g$8(B

