package tutorial3.constructorDI.innerbean;

/** 
 * SBIBank class has account type as SavinngAccount which it initializes in
 * it's constructor and then print it in showStatus method using getAccountType method later.
 */ 
public class SBIBank implements Bank {

	private SavingAccount saving;
	
	public SBIBank(SavingAccount saving) {
		this.saving = saving;
		System.out.println("Account type is: "+ saving.getAccountType());
	}
	
	public SBIBank() {
	}

	@Override
	public int getBalance() {
		return 756;
	}

	@Override
	public String showStatus() {
		return "Hi, SBI Bank is Active. Account type is: "+ saving.getAccountType();
	}

}
