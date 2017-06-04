package annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
/**
 * 
 * @author Apurav
 *
 */
public class Foo {
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@PostConstruct
	public void init() {
		System.out.println("bean successfully initialized");
	}
	@PreDestroy
	public void cleanUp() {
		System.out.println("clean up called");
	}
}
