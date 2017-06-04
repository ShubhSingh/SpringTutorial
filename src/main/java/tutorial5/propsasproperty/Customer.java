package tutorial5.propsasproperty;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Customer {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("tutorial5/propsasproperty/beans.xml");
		
		Bank bank = context.getBean("sbi", Bank.class);
		System.out.println(bank.showStatus());
		System.out.println("List of members");
		System.out.println(bank.getMembers());
		
		context.close();
	}
}