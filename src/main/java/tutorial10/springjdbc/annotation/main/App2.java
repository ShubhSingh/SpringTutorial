package tutorial10.springjdbc.annotation.main;

import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import tutorial10.springjdbc.annotation.config.JavaConfig;
import tutorial10.springjdbc.annotation.dao.OfferDAO;
import tutorial10.springjdbc.annotation.model.Offer;

public class App2
{
    public static void main( String[] args ) {

        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

        OfferDAO offerDAO = context.getBean(OfferDAO.class);

        Offer offer1 = new Offer(generateId(), "Jose", "jskno@gmail.com", "Coding java spring");
        Offer offer2 = new Offer(generateId(), "Raquel", "raquel@gmail.com", "Coding bi");

        if(offerDAO.createOffer(offer1)) {
            System.out.println("Created offer : " + offer1);
        }
        if(offerDAO.createOffer(offer2)) {
            System.out.println("Created offer : " + offer2);
        }

        ((AnnotationConfigApplicationContext)context).close();
    }
    
    private static int generateId() {
		return new Random().nextInt(999);
	}
}
