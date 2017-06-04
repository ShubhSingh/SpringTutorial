package tutorial1.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
 * What if a customer wants to check status and balance for his bank account.
 * So developer create an object of SBIBank class and call it's methods.
 * 
 * What if customer wants to check balance of his other bank account i.e. HDFCBank instead?
 * 
 * With Spring IOC we'll not need to change anything in code. Instead we'll update 
 * beans.xml with new value like below.
 * 
 * 	<bean id="hdfc" class="tutorial1.ioc.HDFCBank"></bean>
 * 
 * This is loosely coupled.
 */
public class CustomerWithIOC {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("tutorial1/ioc/beans.xml");
		
		Bank bank = context.getBean("sbi", Bank.class);
		
		System.out.println(bank.showStatus());
		System.out.println("Account Balance is: "+ bank.getBalance());
		
		context.close();
	}
}