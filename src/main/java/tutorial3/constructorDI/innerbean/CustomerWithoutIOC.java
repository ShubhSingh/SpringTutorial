package tutorial3.constructorDI.innerbean;

/** 
 * What if a customer wants to check status, balance and accountNo for his bank account 
 * along with the account type whether it's saving or current account.
 * 
 * Without Spring IOC we'll need to change code and initialize like below.
 * 	
 * SavingAccount saving = new SavingAccount();
 * Bank bank = new SBIBank(saving);
 */
public class CustomerWithoutIOC {

	public static void main(String[] args) {

		SavingAccount saving = new SavingAccount();
		Bank bank = new SBIBank(saving);
		
		System.out.println(bank.showStatus());
		System.out.println("Account Balance is: "+ bank.getBalance());
		System.out.println("Account type is: "+ saving.getAccountType());
	}

}

