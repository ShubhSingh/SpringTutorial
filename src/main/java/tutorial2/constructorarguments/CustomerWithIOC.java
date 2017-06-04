package tutorial2.constructorarguments;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
 * What if a customer wants to check status and balance for his bank account.
 * But now SBIBank class constructor takes 2 arguments like customerName and brachCode.
 * 
 * With Spring IOC we'll not need to change anything in code. Instead he'll update 
 * beans.xml with new constructor-arg like below.
 * 
 * 	<constructor-arg value="Ramesh" type="java.lang.String" name="customerName"></constructor-arg>
 *	<constructor-arg value="124" type="int" name="branchCode" />
 */
public class CustomerWithIOC {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("tutorial2/constructorarguments/beans.xml");
		
		Bank bank = context.getBean("sbi", Bank.class);
		
		System.out.println(bank.showStatus());
		System.out.println("Account Balance is: "+ bank.getBalance());
		
		context.close();
	}
}