package resourceinjection;

import java.io.InputStream;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
/**
 * 
 * @author Apurav
 *
 */
public class SpringResourceTest {
	public static void main(String[] args) throws Exception {

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"resourceinjection/resourceContext.xml");
		/**
		 * The FileSystemApplicationContext simply forces all attached
		 * FileSystemResource instances to treat all location paths as relative,
		 * whether they start with a leading slash or not. In practice, this
		 * means the following are equivalent: ApplicationContext ctx = new
		 * FileSystemXmlApplicationContext("conf/context.xml");
		 * ApplicationContext ctx = new
		 * FileSystemXmlApplicationContext("/conf/context.xml");
		 */

		/**
		 * A point to note here is that since the ApplicationContext also
		 * implements theResourceLoader interface so it can also be used to get
		 * a resource. The default implementation for application context
		 * depends on the type of application context, in this case
		 * ClasspathResource
		 */
		InputStream inputStream = null;
		Scanner scanner = null;
		try {
			Resource classPathResource = applicationContext
					.getResource("resourceinjection/sample2.txt");
			inputStream = classPathResource.getInputStream();
			scanner = new Scanner(inputStream);
			while (scanner.hasNext()) {
				System.out.println(scanner.nextLine());
			}
			scanner.close();

			ResourceInjection resourceInjection = applicationContext.getBean(
					"resourceInjection", ResourceInjection.class);
			// returns the static resource set in the resourceContext.xml.
			Resource springBeanInjectedResource = resourceInjection
					.getTextFile();
			inputStream = springBeanInjectedResource.getInputStream();
			scanner = new Scanner(inputStream);
			while (scanner.hasNext()) {
				System.out.println(scanner.nextLine());
			}
			scanner.close();
			/**
			 * this returns a resource on run time based on certain condition or
			 * logic. This is accomplished by injecting /*a resource loader in
			 * the bean and then using it to get the resource. See method body
			 */
			Resource dynamicResourceViaResourceLoader = resourceInjection
					.loadDynamicResource();
			inputStream = dynamicResourceViaResourceLoader.getInputStream();
			scanner = new Scanner(inputStream);
			while (scanner.hasNext()) {
				System.out.println(scanner.nextLine());
			}
			scanner.close();
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
		applicationContext.close();
	}

}
