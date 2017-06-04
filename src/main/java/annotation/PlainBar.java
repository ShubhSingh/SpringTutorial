package annotation;

/**
 * 
 * @author Apurav
 *
 */
public class PlainBar {
	private Foo foo;
	
	private Foo foo2;
	
	public void setFoo(Foo foo) {
		this.foo = foo;
	}
	public void  printFooName(){
		System.out.println(foo.getName());
		System.out.println(foo2.getName());
	}
	
}
