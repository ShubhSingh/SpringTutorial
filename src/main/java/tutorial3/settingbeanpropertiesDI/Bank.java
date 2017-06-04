package tutorial3.settingbeanpropertiesDI;

public interface Bank {
	public int getBalance();
	public String showStatus();
	public void setCurrent(CurrentAccount current);
	public CurrentAccount getCurrent();
}
