package tutorial3.constructorDI.annotation;

import org.springframework.stereotype.Component;

@Component
public class SavingAccount {
	public String getAccountType() {
		return "Saving Account";
	}
}
