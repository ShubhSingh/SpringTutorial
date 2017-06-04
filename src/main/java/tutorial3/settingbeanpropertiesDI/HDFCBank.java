package tutorial3.settingbeanpropertiesDI;

public class HDFCBank implements Bank {

	private CurrentAccount current;
	
	public CurrentAccount getCurrent() {
		return current;
	}

	public void setCurrent(CurrentAccount current) {
		this.current = current;
	}

	@Override
	public int getBalance() {
		return 450;
	}

	@Override
	public String showStatus() {
		return "HDFC Bank is active. Account Type is: "+ current.getAccountType();
	}

}
