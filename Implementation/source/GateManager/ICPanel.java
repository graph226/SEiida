/**
 * ICPanel.java
 * 2015/07/08
 **/

package GateManager;

public class ICPanel implements PassReceiver {
    static Pass pass;
    static public void insert(Pass p) {
        pass = p;
        GateManager.openGateCheck(pass);
    }
    static public void updateEntrainingPoint(Station station) {
        System.out.println("update entraining point");
        pass.updateEntrainingPoint(station);
    }
    static public void deductCharge(int fare) {
        System.out.println("deduct charge");
        pass.deductCharge(fare);
    }
}


