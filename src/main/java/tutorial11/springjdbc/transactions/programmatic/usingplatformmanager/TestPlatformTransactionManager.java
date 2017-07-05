package tutorial11.springjdbc.transactions.programmatic.usingplatformmanager;

import java.util.Random;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import tutorial11.springjdbc.IRmUserDao;
import tutorial11.springjdbc.RmUser;

public class TestPlatformTransactionManager {
	public static void main(String[] args) throws ClassNotFoundException {
		ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:tutorial11/springjdbc/transactions/programmatic/usingplatformmanager/platformTxManager.xml");
		IRmUserDao dao = applicationContext.getBean("userDao", IRmUserDao.class);
		RmUser user=new RmUser("shubh"+generateId(), "passowrd", "F", generateId());
		dao.insertUser(user);
		dao.deleteUser(2);
		
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