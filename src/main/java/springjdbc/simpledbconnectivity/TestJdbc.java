package springjdbc.simpledbconnectivity;

import java.util.Random;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import springjdbc.IRmUserDao;
import springjdbc.RmUser;

public class TestJdbc {
	public static void main(String[] args) throws ClassNotFoundException {
		
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"springjdbc/simpledbconnectivity/jdbcContext.xml");
		IRmUserDao dao = applicationContext.getBean("userDao", IRmUserDao.class);
		int userId = generateId();
		RmUser user = new RmUser("karan", "1234", "T", userId);
		dao.insertUser(user);
		System.out.println("User inserted with id= " + userId);
		dao.deleteUser(userId);
		applicationContext.close();
	}

	private static int generateId() {
		return new Random().nextInt(999);
	}
}
