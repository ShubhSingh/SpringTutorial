package tutorial3.constructorDI.innerbean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
 * What if a customer wants to check status, balance and accountNo for his bank account 
 * along with the account type whether it's saving or current account.
 * 
 * With Spring IOC we'll not need to change anything in code. In beans.xml
 * we can use inner bean like below.
 * 
 * <bean id="sbi" class="tutorial3.constructorDI.innerbean.SBIBank">
 * <constructor-arg name="saving">
 * 		<bean id="savingAccount" class="tutorial3.constructorDI.innerbean.SavingAccount"></bean>
 * </constructor-arg>
 * </bean>
 */
public class CustomerWithIOC {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("tutorial3/constructorDI/innerbean/beans.xml");
		
		Bank bank = context.getBean("sbi", Bank.class);
		
		System.out.println(bank.showStatus());
		System.out.println("Account Balance is: "+ bank.getBalance());
		
		context.close();
	}
}