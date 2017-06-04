package tutorial3.setbeanproperty.annotation.injectfield;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("hdfc")
public class HDFCBank implements Bank {

	@Autowired
	private CurrentAccount current;
	
	public CurrentAccount getCurrent() {
		return current;
	}

	@Override
	public String showStatus() {
		return "HDFC Bank is active.";
	}

}
