package tutorial8.spel.annotation.main;

import tutorial8.spel.annotation.beans.Robot;
import tutorial8.spel.annotation.config.JavaSpringConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args ) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaSpringConfig.class);

        Robot robot = context.getBean(Robot.class);
        robot.speak();
        robot.talk();

        ((AnnotationConfigApplicationContext) context).close();
    }
}
