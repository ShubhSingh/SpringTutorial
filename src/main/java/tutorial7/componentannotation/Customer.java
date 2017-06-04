package tutorial7.componentannotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Customer {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("tutorial7/componentannotation/beans.xml");
		
		Bank bank1 = context.getBean("sbi", Bank.class);
		System.out.println(bank1.showStatus());
		
		/* default bean id HDFCBank */
		Bank bank2 = context.getBean("HDFCBank", Bank.class);
		System.out.println(bank2.showStatus());
		
		context.close();
	}
}