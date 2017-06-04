package tutorial5.setasconstructor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Customer {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("tutorial5/setasconstructor/beans.xml");
		
		Bank bank = context.getBean("sbi", Bank.class);
		System.out.println(bank.showStatus());
		
		context.close();
	}
}