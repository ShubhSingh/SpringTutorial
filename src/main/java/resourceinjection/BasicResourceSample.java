package resourceinjection;

import java.io.InputStream;
import java.util.Scanner;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
/**
 * @author Apurav
 *
 */
public class BasicResourceSample {
	/**
	 * At the core, following are the utilities that can be used to get a
	 * resource. The Resource object returned by the following classes is a
	 * simple and handly object containing all the info of the resource 1. Using
	 * a url like http, ftp, file etc. We can use URLResource. This utility
	 * wraps the java.net.URL 2. Getting a file system resource using
	 * FileSystemResource. This wraps the java.io.File 3. ClasspathResource is
	 * used to get a resource from the classpath.
	 * 
	 */
	public static void main(String[] args) throws Exception {

		InputStream inputStream = null;
		Resource resource = null;
		//////////////UrlResource sample/////////////////
		resource = new UrlResource("file:///C:/sample.txt");
		try {
			inputStream = resource.getInputStream();
			Scanner scanner0 = new Scanner(inputStream);
			while (scanner0.hasNext()) {
				System.out.println(scanner0.nextLine());
			}
			scanner0.close();
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}

		//////////////FileSystemResource sample////////////

		try {
			resource = new FileSystemResource(
					"src/resourceinjection/sample.txt");
			inputStream = resource.getInputStream();
			Scanner scanner = new Scanner(inputStream);
			while (scanner.hasNext()) {
				System.out.println(scanner.nextLine());
			}
			scanner.close();
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
 
		///////ClassPathResource sample////////////
		resource = new ClassPathResource("resourceinjection/sample.txt");
		try {
			inputStream = resource.getInputStream();
			Scanner scanner2 = new Scanner(inputStream);
			while (scanner2.hasNext()) {
				System.out.println(scanner2.nextLine());
			}
			scanner2.close();
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}

	}

}
