package tutorial4.beaninitdestroymethods;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
 * In Bean Lifecycle we can define custom init and destroy method.
 * If beanscope is prototype then destroy method don't run.
 */
public class Customer {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("tutorial4/beaninitdestroymethods/beans.xml");
		
		Bank bank = context.getBean("sbi", Bank.class);
		System.out.println(bank.showStatus());
		
		context.close();
	}
}