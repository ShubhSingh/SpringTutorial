package tutorial5.setasconstructor;

import java.util.Set;

public class SBIBank implements Bank {

	public SBIBank(Set<String> members) {
		System.out.println("Set of members in SBI bank.");
		for (String member : members) {
			System.out.println(member);
		}
	}
	@Override
	public String showStatus() {
		return "SBI is active.";
	}
	
}
