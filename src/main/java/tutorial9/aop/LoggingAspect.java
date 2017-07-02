package tutorial9.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	
	/**
	 * Runs advice only before getName method of Circle class
	 */
	@Before("execution(public String tutorial9.aop.Circle.getName())")
	public void loggingAdvice( ) {
		System.out.println("Logging Advice run. Before getName method of Circle.");
	}
	
	/**
	 * Shows use of aop wild cards.
	 */
	@Before("execution(* get*(..))")
	public void anotherAdvice( ) {
		System.out.println("Another Advice run before any kind of getter method.");
	}
	
	/**
	 * Second advice having same pointcut as third advice
	 */
	@Before("allGetters()")
	public void secondAdvice( ) {
		System.out.println("Second Advice run before all getter methods.");
	}
	
	/**
	 * Third advice having same pointcut as second advice
	 */
	@Before("allGetters()")
	public void thirdAdvice( ) {
		System.out.println("Third Advice run before all getter methods.");
	}
	
	/**
	 * Dummy method holding the common pointcut to apply to more than one advice.
	 */
	@Pointcut("execution(* get*(..))")
	public void allGetters() {}
	
	/**
	 * Pointcut expression to apply to an advice irrespective of access modifier, return type, method name and arguments of Triangle class.
	 */
	@Pointcut("execution(* tutorial9.aop.Triangle.*(..))")
	public void allTriangleMethods() {}
	
	/**
	 * Runs advice before all methods of Triangle class.
	 */
	@Before("allTriangleMethods()")
	public void securityAdvice( ) {
		System.out.println("Security Advice run. Before any method of Triangle called.");
	}
	
	/**
	 * Pointcut expression to apply to an advice irrespective of access modifier, return type, method name and arguments.
	 */
	@Pointcut("execution(* *(..))")
	public void anyMethod() {}
	
	/**
	 * Pointcut expression to apply to an advice irrespective of access modifier, return type, method name and arguments of Circle class.
	 * Another way of defining pointcut expression rather than execute is within.
	 */
	@Pointcut("within(tutorial9.aop.Circle)")
	public void allCircleMethods() {}
	
	/**
	 * Runs advice before all methods of Circle class.
	 */
	@Before("allCircleMethods()")
	public void transactionAdvice( ) {
		System.out.println("Transaction Advice run. Before all methods of Circle.");
	}
	
	/**
	 * Pointcut expression to apply to all the methods of all the classes in tuturial9.aop package.
	 */
	@Pointcut("within(tutorial9.aop.*)")
	public void allMethodsInPackage() {}
	
	/**
	 * Pointcut expression to apply to all the methods of all the classes in tuturial9.aop package and all it's sub packages.
	 */
	@Pointcut("within(tutorial9.aop..*)")
	public void allMethodsInPackageAndSubPackage() {}
	
	/**
	 * Pointcut expression to apply to all the methods that takes Cicle class as parameter.
	 * args takes class names and interface names as parameter.
	 */
	@Pointcut("args(tutorial9.aop.Circle)")
	public void allMethodsWithCircle() {}
	
	/**
	 * Runs advice before all getters and all circle methods. This is best practice for combining pointcuts.
	 */
	@Before("allGetters() && allCircleMethods()")
	public void fourthAdvice( ) {
		System.out.println("Fourth Advice run.");
	}
	
	/**
	 * Using JoinPoint to access Circle class object in advice.
	 */
	@Before("allCircleMethods()")
	public void fifthAdvice(JoinPoint joinPoint) {
		System.out.println(joinPoint.toString());
		Circle c = (Circle) joinPoint.getTarget();
	}
	
	/**
	 * Runs advice before all methods that takes String argument.
	 */
	@Before("args(String)")
	public void stringArgumentMethods() {
		System.out.println("A method that takes String argument has been called.");
	}
	
	/**
	 * Runs advice before all methods that takes String argument and also access it's value in advice.
	 */
	@Before("args(name)")
	public void stringArgumentValue(String name) {
		System.out.println("A method that takes String argument has been called. The value is: " + name);
	}
	
	/**
	 * after advice runs after setName method of circle instead of method completes or not.
	 */
	@After("args(name)")
	public void nextAdvice(String name) {
		System.out.println("After Advice is called.");
	}
	
	/**
	 * AfterReturning advice runs after setName method of circle only when setName method executes successfully and return.
	 */
	@AfterReturning("args(name)")
	public void moreAdvice(String name) {
		System.out.println("After Returning Advice is called.");
	}
	
	/**
	 * AfterReturning advice runs after setName method of circle only when setName method executes successfully and return.
	 */
	@AfterReturning("args(name)")
	public void oneMoreAdvice(String name) {
		System.out.println("After Returning Advice is called.");
	}
}
