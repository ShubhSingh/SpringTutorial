package tutorial3.settingbeanpropertiesDI.innerbean;

/** 
 * Now HDFCBank class has CurrentAccount object and it's value will be injected
 * by setting bean properties in beans.xml.
*/
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
