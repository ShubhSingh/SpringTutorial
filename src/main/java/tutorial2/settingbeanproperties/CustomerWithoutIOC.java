package tutorial2.settingbeanproperties;

/** 
 * What if a customer wants to check status, balance and accountNo for his bank account.
 * 
 * Without Spring IOC we'll need to change code and initialize like below.
 * 	
 * Bank bank = new SBIBank("Ramesh", 124);
 * bank.setAccountNo(12345);
 */
public class CustomerWithoutIOC {

	public static void main(String[] args) {

		Bank bank = new SBIBank("Ramesh", 124);
		bank.setAccountNo(12345);

		System.out.println(bank.showStatus());
		System.out.println("Account Balance is: "+ bank.getBalance());
		System.out.println(bank);
		System.out.println("Account no is: "+bank.getAccountNo());
	}

}

