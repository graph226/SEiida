/**
 * GateManager.java
 * 2015/07/06
 **/

package GateManager;
import java.util.*;
public class GateManager {
    
    static Station station;
    static boolean isEntrance; // true:entrance false:exit
    static Gate gate=new Gate();
    static public void openGateCheck(Pass pass) {
    	if ( pass.getEntrainingPoint() == null ) {
                if(pass.getCharge()>=200){
                	ICPanel.updateEntrainingPoint(station);
                	gate.openGate();
                }else if(pass.getCharge()>=0){
                	gate.closeGate();
                }else{
                	System.out.println("Wrong Charge Error");
                }
                
        }else{
        	if(pass.getCharge()>=200){
        		pass.deductCharge(200);
        		pass.updateEntrainingPoint(null);
        		gate.openGate();
        	}else if(pass.getCharge()>=0){
        		gate.closeGate();
        	}else{
        		System.out.println("Wrong Charge Error");
        	}
        	
        }
    }
    
    // set Gate State
    static public void setEnvironment(Station s, boolean ent) {
        station = s;
        isEntrance = ent;
        gate = new Gate();
    }

    static public void main(String[] args){
    	ICPanel panel=new ICPanel();
    	//駅の場合
    	Station s_list[]={
    			new Station("Takadanobaba"),
    			new Station("Iidabashi"),
    			new Station("Shinjuku")
    	};
    	station=s_list[0];
    	Queue<ICCard> list=new LinkedList<ICCard>();
    	list.add(new ICCard(-200,s_list[2]));
    	list.add(new ICCard(0,s_list[2]));
    	list.add(new ICCard(200,s_list[2]));
    	list.add(new ICCard(1000,s_list[2]));
    	list.add(new ICCard(-200));
    	list.add(new ICCard(0));
    	list.add(new ICCard(200));
    	list.add(new ICCard(1000));
    	
    	while(!list.isEmpty()){
    		ICCard itr=list.poll();
    		ICPanel.insert(itr);
    	}
    	
    }
}

class Gate {
    public void openGate() {
        System.out.println("open gate");
    }
    public void closeGate() {
        System.out.println("close gate");
    }
}

//// 