package annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 
 * @author Apurav
 *
 */
public class TestFooBar {

	public static void main(String[] args) throws InterruptedException {


		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"annotation/annotation.xml");
		Bar bar = applicationContext.getBean("bar", Bar.class);
		bar.printFooName();
		applicationContext.registerShutdownHook();
		applicationContext.close(); 
	}

}
