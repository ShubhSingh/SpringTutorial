package tutorial7.autowireannotation.required;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("hdfc")
public class HDFCBank implements Bank {

	HDFCBank() {
	}
	
	/** 
	 * required=false tells that if SavingAccount bean is not available then use default constructor 
	 */
	@Autowired(required=false)
	HDFCBank(SavingAccount saving) {
		System.out.println(saving.getAccountType());
	}
	
	@Override
	public String showStatus() {
		return "HDFC is active.";
	}
	
}
