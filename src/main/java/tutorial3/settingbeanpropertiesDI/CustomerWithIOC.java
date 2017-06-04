package tutorial3.settingbeanpropertiesDI;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
 * What if a customer wants to check status, balance and accountNo for his bank account 
 * along with the account type whether it's saving or current account.
 * 
 * With Spring IOC we'll not need to change anything in code. In beans.xml
 * we can refer to another bean property like below.
 * 
 *  <bean id="hdfc" class="tutorial3.settingbeanpropertiesDI.HDFCBank">
 *  	<property name="current" ref="currentAccount"></property>
 *  </bean>
 *  <bean id="currentAccount" class="tutorial3.settingbeanpropertiesDI.CurrentAccount"></bean>
 */
public class CustomerWithIOC {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("tutorial3/settingbeanpropertiesDI/beans.xml");
		
		Bank bank = context.getBean("hdfc", Bank.class);
		
		System.out.println(bank.showStatus());
		System.out.println("Account Balance is: "+ bank.getBalance());
		System.out.println(bank.getCurrent().getAccountType());
		
		context.close();
	}
}