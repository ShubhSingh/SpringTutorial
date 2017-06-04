package springjdbc.transactions.declarative.annotations;

import java.util.Random;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import springjdbc.IUserDao;
import springjdbc.User;
/**
 * 
 * @author Apurav
 *
 */

public class TestAnnotationTransactions {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("springjdbc/transactions/declarative/annotations/annotationTransactionContext.xml");
		IUserDao dao = applicationContext.getBean("userDao", IUserDao.class);
		User user=new User("apurav"+generateId(), "passowrd", "F", generateId());
		dao.insertUser(user);
		dao.deleteUser(user.getUserId());
		
		/*throws a checked Exception that is not automatically rolled back.Contrary to this is the RuntimeException
		which are automatically rolled back. See next try catch block. We can control the default roll back behavior by setting properties in xml
		SEE txAdviceWithRollBackSettings bean and txAdvice bean definitions*/
		try{
			dao.updateUser(user);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		try{
			/*throws a runtime exception which will be automatically rolled back
			 * We can control the default roll back behavior by setting properties in xml. 
			 * SEE txAdviceWithRollBackSettings bean  and txAdvice bean definitions*/
			dao.selectUser(2);
		}catch (Exception e) {
			e.printStackTrace();
		}
		applicationContext.close();
	}
	private static int generateId(){
		return new Random().nextInt(500);
	}
}
