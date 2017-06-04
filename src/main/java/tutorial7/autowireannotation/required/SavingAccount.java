package tutorial7.autowireannotation.required;

import org.springframework.stereotype.Component;

/** 
 * If @Component is disabled then Default constructor of HDFCBank runs 
 */
@Component
public class SavingAccount {
	public String getAccountType() {
		return "Saving Account";
	}
}
