package tutorial8.spel;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Customer {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("tutorial8/spel/beans.xml");
		TelecomProvider provider = context.getBean("airtel", TelecomProvider.class);
		System.out.println(provider.showStatus());
		System.out.println(provider.getCurrentOffer());
		
		context.close();
	}
}