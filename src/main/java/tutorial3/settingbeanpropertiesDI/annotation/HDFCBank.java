package tutorial3.settingbeanpropertiesDI.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("hdfc")
public class HDFCBank implements Bank {

	private CurrentAccount current;
	
	public CurrentAccount getCurrent() {
		return current;
	}

	@Autowired
	public void setCurrent(CurrentAccount current) {
		this.current = current;
	}

	@Override
	public String showStatus() {
		return "HDFC Bank is active.";
	}

}
