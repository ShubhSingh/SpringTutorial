package tutorial4.beaninitdestroymethods;

public class SBIBank implements Bank {

	@Override
	public String showStatus() {
		return "SBI is active.";
	}
	
	public void start() {
		System.out.println("Started");
	}
	
	public void end() {
		System.out.println("Ended");
	}

}
