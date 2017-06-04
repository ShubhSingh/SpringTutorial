package tutorial3.settingbeanpropertiesDI.innerbean;

/** 
 * A customer wants to show status and get balance for his bank account.
 * Now SBIBank class constructor takes SavingAccount as argument and initialize
 * it's object.
 * 
 * Without Spring IOC he'll need to change code and initialize like below.
 * 	
 * CurrentAccount current = new CurrentAccount();
 * Bank bank = new HDFCBank();
 * bank.setCurrent(current);
 */
public class CustomerWithoutIOC {

	public static void main(String[] args) {

		CurrentAccount current = new CurrentAccount();
		Bank bank = new HDFCBank();
		bank.setCurrent(current);
		
		System.out.println(bank.showStatus());
		System.out.println("Account Balance is: "+ bank.getBalance());
	}

}
