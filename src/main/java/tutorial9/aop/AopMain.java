package tutorial9.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("tutorial9/aop/beans.xml");
		ShapeService shapeService = context.getBean("shapeService", ShapeService.class);
		
		System.out.println(shapeService.getTriangle().getName());
		System.out.println("----------");
		shapeService.getCircle().setName("Green Circle");
		System.out.println(shapeService.getCircle().getName());
		
		context.close();
	}
}