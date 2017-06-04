package tutorial8.readpropertyfile;

public class Airtel implements TelecomProvider {

	public String currentOffer;
	
	@Override
	public String showStatus() {
		return "Airtel is Active.";
	}

	@Override
	public String getCurrentOffer() {
		return currentOffer;
	}

	public void setCurrentOffer(String currentOffer) {
		this.currentOffer = currentOffer;
	}

}
