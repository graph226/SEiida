/**
 * Station.java
 * 2015/07/05
 **/

package GateManager;

public class Station {
    private String name;
    
    public int getFare(Station station) {
        return 120;
    }
    
    public Station(String n) {
        name = n;
    }
    public String toString() {
        return name;
    }
    
    public Station() {
    }
}

