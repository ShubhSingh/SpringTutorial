package tutorial9.aop.afteradvice;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("tutorial9/aop/afteradvice/beans.xml");
		ShapeService shapeService = context.getBean("shapeService", ShapeService.class);
		
		System.out.println(shapeService.getTriangle().getName());
		System.out.println("----------");
		shapeService.getCircle().setName("Green Circle");
		System.out.println(shapeService.getCircle().getName());
		shapeService.getCircle().setNameAndReturn("Blue Circle");
		context.close();
	}
}