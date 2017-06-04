package tutorial7.componentannotation;

import org.springframework.stereotype.Component;

@Component
public class HDFCBank implements Bank {

	@Override
	public String showStatus() {
		return "HDFC is active.";
	}
	
}
