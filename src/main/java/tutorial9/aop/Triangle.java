package tutorial9.aop;

public class Triangle {
	private String name;

	public String getName() {
		System.out.println("-------- Triangle's getter called. ---------");
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("-------- Triangle's setter called. ---------");
	}
}
