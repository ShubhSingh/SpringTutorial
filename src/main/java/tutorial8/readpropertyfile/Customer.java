package tutorial8.readpropertyfile;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Customer {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("tutorial8/readpropertyfile/beans.xml");
		TelecomProvider provider = context.getBean("airtel", TelecomProvider.class);
		System.out.println(provider.showStatus());
		System.out.println(provider.getCurrentOffer());
		
		context.close();
	}
}