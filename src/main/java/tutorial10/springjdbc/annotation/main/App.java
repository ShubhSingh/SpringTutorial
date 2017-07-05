package tutorial10.springjdbc.annotation.main;

import tutorial10.springjdbc.annotation.config.JavaConfig;
import tutorial10.springjdbc.annotation.dao.OfferDAO;
import tutorial10.springjdbc.annotation.model.Offer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import java.util.List;

public class App 
{
    public static void main( String[] args ) {

        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

        OfferDAO offerDAO = context.getBean(OfferDAO.class);
        
        Offer offer2 = new Offer(4, "Raquel", "raquel@gmail.com", "Coding bi");
        if(offerDAO.createOffer(offer2)) {
            System.out.println("Created offer : " + offer2);
        }

        Offer offerToDelete = offerDAO.getOfferById(4);
        if(offerToDelete != null) {
            offerDAO.deleteOffer(offerToDelete.getId());
            System.out.println("\nOffer deleted: " + offerToDelete);
        }

        System.out.println("\nFirst query :\n");
        try {
            List<Offer> offers1 = offerDAO.getOffers();
            offers1.stream().forEach(offer -> System.out.println(offer));
        } catch (CannotGetJdbcConnectionException ex) {
            System.out.println(" First: " + ex.getMessage());
        } catch (DataAccessException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getClass());
        }

        System.out.println("\nSecond query : ");
        List<Offer> offers2 = offerDAO.getOffersByName("Sue");
        offers2.stream().forEach(offer -> System.out.println(offer));

        System.out.println("\nThird query : ");
        Offer offer3 = offerDAO.getOfferById(1);
        System.out.println(offer3);


        ((AnnotationConfigApplicationContext)context).close();
    }
}
