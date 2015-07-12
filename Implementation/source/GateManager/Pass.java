/**
 * Pass.java
 * 2015/07/08 
 **/

package GateManager;

public abstract class Pass{
    int passType;
    
    abstract public Station getEntrainingPoint();
    abstract public boolean isInStation();
    abstract public int getCharge();
    abstract public int getPassType();
    
    // このへんからおかしい
    abstract public void deductCharge(int fare);
    abstract public void enterStation();
    abstract public void updateEntrainingPoint(Station station);
    
    //abstract public void passThrough();
}

