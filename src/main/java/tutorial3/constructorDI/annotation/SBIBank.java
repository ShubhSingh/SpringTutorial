package tutorial3.constructorDI.annotation;

import org.springframework.stereotype.Component;

@Component("sbi")
public class SBIBank implements Bank {

	public SBIBank(SavingAccount saving) {
		System.out.println("Account type is: "+ saving.getAccountType());
	}

	@Override
	public String showStatus() {
		return "Hi, SBI Bank is Active.";
	}

}
