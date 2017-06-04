package tutorial8.spel;

public class OffersGenerator {
	
	String offerIND, offerUS;

	public OffersGenerator() {
		this.offerIND = "No current offers in India.";
		this.offerUS = "Black Friday deals in USA.";
	}
	
	public String getOfferIND() {
		return offerIND;
	}

	public String getOfferUS() {
		return offerUS;
	}
}
