package tutorial3.constructorDI;

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
