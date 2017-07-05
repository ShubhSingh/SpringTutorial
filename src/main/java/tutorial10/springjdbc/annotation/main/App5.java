package tutorial10.springjdbc.annotation.main;

import tutorial10.springjdbc.annotation.config.JavaConfig;
import tutorial10.springjdbc.annotation.dao.OfferDAO;
import tutorial10.springjdbc.annotation.model.Offer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App5
{
    // Testing @Transactional annotation
    public static void main( String[] args ) {

        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

        OfferDAO offerDAO = context.getBean(OfferDAO.class);

        List<Offer> offers = new ArrayList<>();
        Offer offer1 = new Offer(generateId(), "Julio", "geronimo@gmail.com", "Let's play");
        Offer offer2 = new Offer(generateId(), "Mario", "luis@gmail.com", "I'll catch you tomorrow");

        offers.add(offer1);
        offers.add(offer2);

        int[] rvals = offerDAO.createForTx(offers);
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
