package tutorial4.beanscopesingleton.annotation;

import org.springframework.stereotype.Component;

@Component("offers")
public class OfferAirtel {

	private String offer = "No current offer";

	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}

}
