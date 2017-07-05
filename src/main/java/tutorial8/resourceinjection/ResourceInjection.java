package tutorial8.resourceinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class ResourceInjection {

	/**
	 * In case a bean needs a refernce to resource loader to load a resource
	 * dynamically, it can be autowired like this. The spring injects the defalt
	 * resourceloader of the current application context into this. You must be
	 * thinking that we can also inject the application Context object also
	 * since its also a resourceloader. Well you can, but we should not coz you
	 * will unnecessary inject the complete Application context object. So u can
	 * simply inject the handly resource loader object to carry the resource
	 * operations
	 */
	@Autowired
	private ResourceLoader resourceLoader;

	/**
	 * In case you want to inject resources that are static, u can directly inject
	 * that. See the resourceContext.xml. We have just set the path and using the javabeans property editor, spring will
	 * automatically resolve it to a resource object.
	 */
	private Resource textFile;

	public void setTextFile(Resource textFile) {
		this.textFile = textFile;
	}

	public ResourceLoader getResourceLoader() {
		return resourceLoader;
	}

	public Resource getTextFile() {
		return textFile;
	}
	
	public Resource loadDynamicResource(){
		//in case when resource will be loaded based on some condition
		boolean someCondition=true;
		if(someCondition){
			return resourceLoader.getResource("tutorial8/resourceinjection/sample2.txt");
		}else{
			return resourceLoader.getResource("tutorial8/resourceinjection/sample.txt");
		}
		
	}

}
