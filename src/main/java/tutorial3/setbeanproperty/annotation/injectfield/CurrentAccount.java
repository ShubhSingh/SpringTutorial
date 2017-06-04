package tutorial3.setbeanproperty.annotation.injectfield;

import org.springframework.stereotype.Component;

@Component
public class CurrentAccount {
	public String getAccountType() {
		return "Current Account";
	}
}
