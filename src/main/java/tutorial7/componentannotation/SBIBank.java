package tutorial7.componentannotation;

import org.springframework.stereotype.Component;

@Component("sbi")
public class SBIBank implements Bank {

	@Override
	public String showStatus() {
		return "SBI is active.";
	}
	
}
