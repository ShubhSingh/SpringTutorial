package tutorial3.constructorDI.innerbean;

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
