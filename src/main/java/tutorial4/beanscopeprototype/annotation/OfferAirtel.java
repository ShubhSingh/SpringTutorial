package tutorial4.beanscopeprototype.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("offers")
@Scope("prototype")
public class OfferAirtel {

	private String offer = "No current offer";

	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}

}
