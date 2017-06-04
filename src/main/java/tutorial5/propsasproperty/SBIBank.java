package tutorial5.propsasproperty;

import java.util.Map;


public class SBIBank implements Bank {

	private Map<String, String> members;
	
	public Map<String, String> getMembers() {
		return members;
	}

	public void setMembers(Map<String, String> members) {
		this.members = members;
	}
	
	@Override
	public String toString() {
		return "SBIBank [members=" + members + "]";
	}

	@Override
	public String showStatus() {
		return "SBI is active.";
	}
	
}
