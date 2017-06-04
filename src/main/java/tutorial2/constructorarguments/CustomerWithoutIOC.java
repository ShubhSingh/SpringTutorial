package tutorial2.constructorarguments;

/** 
 * What if a customer wants to check status and balance for his bank account.
 * But now SBIBank class constructor takes 2 arguments like customerName and brachCode.
 * 
 * Without Spring IOC we'll need to change code and initialize like below.
 * 	
 * Bank bank = new SBIBank("Ramesh", 124);
 */
public class CustomerWithoutIOC {

	public static void main(String[] args) {

		Bank bank = new SBIBank("Ramesh", 124);
		
		System.out.println(bank.showStatus());
		System.out.println("Account Balance is: "+ bank.getBalance());
	}

}

