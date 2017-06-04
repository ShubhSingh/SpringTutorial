package tutorial4.beanscopesingleton.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Run this class twice to check output with prototype scope and singleton(default) scope
 * by changing it in beans.xml
 * 
 * <bean id="offers" class="tutorial4.beanscope.OfferAirtel"></bean>
 * 
 * or
 * 
 * <bean id="offers" class="tutorial4.beanscope.OfferAirtel" scope="prototype"></bean>
 */
public class CustomerAirtel {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("tutorial4/beanscopesingleton/annotation/beans.xml");
		
		OfferAirtel offer1 = (OfferAirtel) context.getBean("offers");
		System.out.println(offer1.getOffer());
		offer1.setOffer("10% discount on 3g data pack.");
		System.out.println("offer1: " + offer1.getOffer());
		
		OfferAirtel offer2 = (OfferAirtel) context.getBean("offers");
		System.out.println("offer2: " + offer2.getOffer());
		
		System.out.println("Memory address of offer1: "+ offer1);
		System.out.println("Memory address of offer2: "+ offer2);
		
		if(offer1 == offer2) {
			System.out.println("Memory address is same");
		}
		context.close();
	}
}