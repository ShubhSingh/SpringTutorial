package tutorial6.autowireproperty.byType;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Customer {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("tutorial6/autowireproperty/byType/beans.xml");
		Bank bank = context.getBean("sbi", Bank.class);
		
		System.out.println(bank.showStatus());
		System.out.println(bank.getSaving().getSavingAcc());
		System.out.println(bank.getCurrent().getCurrentAcc());
		
		context.close();
	}
}