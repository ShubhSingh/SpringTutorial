package tutorial2.constructorarguments;

public class HDFCBank implements Bank {

	@Override
	public int getBalance() {
		return 450;
	}

	@Override
	public String showStatus() {
		return "HDFC Bank is active.";
	}

}
