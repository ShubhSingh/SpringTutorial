package tutorial7.autowiringambiguity.qualifierannotation;

import org.springframework.stereotype.Component;

@Component("savingAccount")
public class SavingAccount implements AccountType {
	@Override
	public String getAccountType() {
		return "Saving Account";
	}
}
