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

