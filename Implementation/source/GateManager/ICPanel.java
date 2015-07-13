/**
 * ICPanel.java
 * 2015/07/08
 **/

package GateManager;

public class ICPanel {
    static ICCard iccard;
    static public void insert(ICCard in) {
        iccard = in;
        GateManager.openGateCheck(iccard);
    }
    static public void updateEntrainingPoint(Station station) {
        System.out.println("update entraining point");
        iccard.updateEntrainingPoint(station);
    }
    static public void deductCharge(int fare) {
        System.out.println("deduct charge");
        iccard.deductCharge(fare);
    }
}


