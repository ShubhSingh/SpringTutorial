package tutorial6.autowireconstructor.ambiguity;

public class SBIBank implements Bank {

	public SBIBank(SavingAccount saving) {
		System.out.println("Account type is: "+ saving.getAccountType());
	}

	@Override
	public String showStatus() {
		return "Hi, SBI Bank is Active.";
	}
}
