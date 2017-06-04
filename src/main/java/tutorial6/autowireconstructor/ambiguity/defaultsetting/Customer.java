package tutorial6.autowireconstructor.ambiguity.defaultsetting;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Customer {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("tutorial6/autowireconstructor/ambiguity/defaultsetting/beans.xml");
		Bank bank = context.getBean("sbi", Bank.class);
		
		System.out.println(bank.showStatus());
		
		context.close();
	}
}