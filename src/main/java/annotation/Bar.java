package annotation;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
/**
 * 
 * @author Apurav
 *
 */
public class Bar {
	@Autowired
	@Qualifier(value="secondaryFoo")
	private Foo foo;
	
	@Resource(name="foo")
	private Foo foo2;
	
	//@Required
	public void setFoo(Foo foo) {
		this.foo = foo;
	}
	public void  printFooName(){
		System.out.println(foo.getName());
		System.out.println(foo2.getName());
	}
	
}
