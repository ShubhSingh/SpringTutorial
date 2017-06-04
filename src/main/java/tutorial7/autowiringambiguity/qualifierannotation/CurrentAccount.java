package tutorial7.autowiringambiguity.qualifierannotation;

import org.springframework.stereotype.Component;

@Component("currentAccount")
public class CurrentAccount implements AccountType {
	@Override
	public String getAccountType() {
		return "Current Account";
	}
}
