package tutorial10.springjdbc.annotation.main;

import tutorial10.springjdbc.annotation.config.JavaConfig;
import tutorial10.springjdbc.annotation.dao.OfferDAO;
import tutorial10.springjdbc.annotation.model.Offer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App4
{
    public static void main( String[] args ) {

        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

        OfferDAO offerDAO = context.getBean(OfferDAO.class);

        List<Offer> offers = new ArrayList<>();
        Offer offer1 = new Offer(generateId(), "Antonio", "antonio@gmail.com", "Let's do it");
        Offer offer2 = new Offer(generateId(), "Paco", "paco@gmail.com", "I'll see you tomorrow");
        Offer offer3 = new Offer(generateId(), "Laura", "laura@gmail.com", "Come on !");
        Offer offer4 = new Offer(generateId(), "Leonor", "leonor@gmail.com", "Smart coding");
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer3);
        offers.add(offer4);

        int[] rvals = offerDAO.create(offers);
        for (int value : rvals) {
            System.out.println("Update " + value + " rows");
        }

        List<Offer> allTheOffers = offerDAO.getOffers();
        allTheOffers.stream().forEach(offer -> System.out.println(offer));

        ((AnnotationConfigApplicationContext)context).close();
    }
    
    private static int generateId() {
		return new Random().nextInt(999);
	}
}
