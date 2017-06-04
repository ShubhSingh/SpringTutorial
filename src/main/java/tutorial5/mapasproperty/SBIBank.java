package tutorial5.mapasproperty;

import java.util.Map;


public class SBIBank implements Bank {

	@Override
	public String toString() {
		return "SBIBank [members=" + members + "]";
	}

	private Map<String, String> members;
	
	public Map<String, String> getMembers() {
		return members;
	}

	public void setMembers(Map<String, String> members) {
		this.members = members;
	}

	@Override
	public String showStatus() {
		return "SBI is active.";
	}
	
}
