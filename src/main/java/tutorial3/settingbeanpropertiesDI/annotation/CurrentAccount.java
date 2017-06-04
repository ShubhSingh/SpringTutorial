package tutorial3.settingbeanpropertiesDI.annotation;

import org.springframework.stereotype.Component;

@Component
public class CurrentAccount {
	public String getAccountType() {
		return "Current Account";
	}
}
