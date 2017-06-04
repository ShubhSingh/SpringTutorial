package tutorial5.listasconstructor;

import java.util.List;

public class SBIBank implements Bank {

	public SBIBank(List<String> members) {
		System.out.println("List of members in SBI bank.");
		for (String member : members) {
			System.out.println(member);
		}
	}
	@Override
	public String showStatus() {
		return "SBI is active.";
	}
	
}
