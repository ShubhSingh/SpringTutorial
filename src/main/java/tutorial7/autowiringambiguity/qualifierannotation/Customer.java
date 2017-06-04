package tutorial7.autowiringambiguity.qualifierannotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Customer {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("tutorial7/autowiringambiguity/qualifierannotation/beans.xml");
		
		Bank bank = context.getBean("hdfc", Bank.class);
		
		System.out.println(bank.showStatus());
		System.out.println(bank.getAccType().getAccountType());
		
		context.close();
	}
}