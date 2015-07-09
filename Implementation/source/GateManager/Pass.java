/**
 * Pass.java
 * 2015/07/08 
 **/

package GateManager;

public abstract class Pass{
    abstract public Station getEntrainingPoint();
    abstract public boolean isInStation();
    abstract public int getCharge();
    //abstract public void passThrough();
}

