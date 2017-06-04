package tutorial4.beaninitdestroymethods.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("sbi")
@Scope("prototype")
public class SBIBank implements Bank {

	@Override
	public String showStatus() {
		return "SBI is active.";
	}
	
	@PostConstruct
	public void start() {
		System.out.println("Started");
	}
	
	@PreDestroy
	public void end() {
		System.out.println("Ended");
	}

}
