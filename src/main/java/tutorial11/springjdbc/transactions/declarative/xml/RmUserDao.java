package tutorial11.springjdbc.transactions.declarative.xml;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import tutorial11.springjdbc.IRmUserDao;
import tutorial11.springjdbc.RmUser;

public class RmUserDao implements IRmUserDao {
/*For reference visit:
*	http://monstersandwich.blogspot.com/2010/04/spring-transactions-sample-applications.html
**/
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private ApplicationContext applicationContext;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void deleteUser(int uid) {
	String delQuery = "delete from TESTSCHEMA.RMUSER where userid = ?";
	jdbcTemplate.update(delQuery, new Object[]{uid});

	}

	public int insertUser(RmUser user) {
		String inserQuery = "insert into TESTSCHEMA.RMUSER (username, password, enabled , userid) values (?, ?, ?, ?) ";
		Object[] params = new Object[]{user.getUserName(), user.getPassword(),user.isEnabled(),user.getUserId()};
		int[] types = new int[]{Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.INTEGER};
		int number =  jdbcTemplate.update(inserQuery,params,types);
		IRmUserDao dao = applicationContext.getBean("userDao", IRmUserDao.class);
		
		//!!!!!!!!!!!!!!! IMPORTANT !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		/*To test the transaction propagation behavior call another transacted method.
		 * So in this case when you call selectUser, transaction behavior as described 
		 * in xml can be practically seen*/ 
		dao.selectUser(3);
		/////////////////// IMPORTANT/////////////////////////////
		
		return number;
	}

	public RmUser selectUser(int uid) {
		// for all the RuntimeExceptions the transactions will be automatically
		// rolled back
		throw new RuntimeException("An intentional runtime exception");

	}

	public int updateUser(RmUser user) throws Exception {
		/*
		 * for checked exceptions, transactions are not rolled back by default.
		 * The rolled back behavior can be controlled by mentioning properties
		 * in xml file. Please check
		 */
		throw new Exception("An intentional checked exception");
	}

}
