/**
 * PassReceiver.java
 * 2015/07/08
 **/
package GateManager;

interface PassReceiver {
    static public void insert(Pass pass) {
        GateManager.openGateCheck(pass);
    }
}

