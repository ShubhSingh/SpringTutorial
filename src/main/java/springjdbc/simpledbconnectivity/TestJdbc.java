package springjdbc.simpledbconnectivity;

import java.util.Random;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import springjdbc.IUserDao;
import springjdbc.User;

public class TestJdbc {
	public static void main(String[] args) throws ClassNotFoundException {
		
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"springjdbc/simpledbconnectivity/jdbcContext.xml");
		IUserDao dao = applicationContext.getBean("userDao", IUserDao.class);
		int userId = generateId();
		User user = new User("apurav", "1234", "T", userId);
		dao.insertUser(user);
		System.out.println("User inserted with id= " + userId);
		dao.deleteUser(userId);
		applicationContext.close();
	}

	private static int generateId() {
		return new Random().nextInt(999);
	}
}
