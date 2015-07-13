package GateManager;

public class Monitor {
	public void shortageMessage(Pass pass){
		System.out.println("Monitor:\t"+pass+"Shortage of Money\t");
	}
	public void wrongDataMessage(Pass pass){
		System.out.println("Monitor:\t"+pass+"Wrong Data\t");
	}
	public void passMessage(Pass pass){
		System.out.println("Pass:\t\t"+pass);
		
	}
}
