package tutorial3.settingbeanpropertiesDI.innerbean;

public class SBIBank implements Bank {

	public SBIBank() {
	}

	@Override
	public int getBalance() {
		return 756;
	}

	@Override
	public String showStatus() {
		return "Hi, SBI Bank is Active.";
	}

	@Override
	public void setCurrent(CurrentAccount current) {
		
	}

	@Override
	public CurrentAccount getCurrent() {
		return null;
	}

}
