package tutorial7.autowireannotation;

import org.springframework.beans.factory.annotation.Autowired;

public class HDFCBank implements Bank {

	/* Default autowire by type */
	@Autowired
	HDFCBank(SavingAccount saving) {
		System.out.println(saving.getAccountType());
	}
	
	@Override
	public String showStatus() {
		return "HDFC is active.";
	}
	
}
