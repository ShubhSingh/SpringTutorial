package tutorial3.settingbeanpropertiesDI.innerbean;

public interface Bank {
	public int getBalance();
	public String showStatus();
	public void setCurrent(CurrentAccount current);
	public CurrentAccount getCurrent();
}
