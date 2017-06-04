package tutorial3.settingbeanpropertiesDI.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Customer {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("tutorial3/settingbeanpropertiesDI/annotation/beans.xml");
		
		Bank bank = context.getBean("hdfc", Bank.class);
		
		System.out.println(bank.showStatus());
		System.out.println(bank.getCurrent().getAccountType());
		
		context.close();
	}
}