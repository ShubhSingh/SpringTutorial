package tutorial3.settingbeanpropertiesDI;

/** 
 * What if a customer wants to check status, balance and accountNo for his bank account 
 * along with the account type whether it's saving or current account.
 * 
 * Without Spring IOC we'll need to change code and initialize like below.
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
