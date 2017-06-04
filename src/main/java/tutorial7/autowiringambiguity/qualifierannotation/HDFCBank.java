package tutorial7.autowiringambiguity.qualifierannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("hdfc")
public class HDFCBank implements Bank {

	@Autowired
	@Qualifier("currentAccount")
	private AccountType accType;
	
	@Override
	public String showStatus() {
		return "HDFC Bank is active.";
	}

	@Override
	public AccountType getAccType() {
		return accType;
	}

}
