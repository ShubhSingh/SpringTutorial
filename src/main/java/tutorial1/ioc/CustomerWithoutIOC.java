package tutorial1.ioc;

/** 
 * What if a customer wants to check status and balance for his bank account.
 * So developer create an object of SBIBank class and call it's methods.
 * 
 * What if customer wants to check balance of his other bank account i.e. HDFCBank instead?
 * 
 * Without Spring IOC we'll need to change code and initialize like below.
 * 	Bank bank = new HDFCBank();
 * 
 * But this is tightly coupled.
 */
public class CustomerWithoutIOC {

	public static void main(String[] args) {

		Bank bank = new SBIBank();
		
		System.out.println(bank.showStatus());
		System.out.println("Account Balance is: "+ bank.getBalance());
	}

}
