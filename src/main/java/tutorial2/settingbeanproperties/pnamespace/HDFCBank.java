package tutorial2.settingbeanproperties.pnamespace;

public class HDFCBank implements Bank {

	@Override
	public int getBalance() {
		return 450;
	}

	@Override
	public String showStatus() {
		return "HDFC Bank is active.";
	}

	@Override
	public void setAccountNo(int i) {
	}

	@Override
	public int getAccountNo() {
		return 0;
	}

}
