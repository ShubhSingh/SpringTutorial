package tutorial1.ioc;

public class SBIBank implements Bank {

	@Override
	public int getBalance() {
		return 756;
	}

	@Override
	public String showStatus() {
		return "SBI Bank is Active.";
	}

}
