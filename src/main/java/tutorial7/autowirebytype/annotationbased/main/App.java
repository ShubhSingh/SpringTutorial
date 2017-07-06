package tutorial7.autowirebytype.annotationbased.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tutorial7.autowirebytype.annotationbased.beans.Logger;

public class App 
{
    public static void main( String[] args ) {

        ApplicationContext context = new ClassPathXmlApplicationContext("tutorial7/autowirebytype/annotationbased/main/application-context.xml");

        Logger logger = (Logger) context.getBean("logger");
        logger.writeConsole("Hello there");
        logger.writeFile("Hello again !!");

        ((ClassPathXmlApplicationContext) context).close();
    }
}
