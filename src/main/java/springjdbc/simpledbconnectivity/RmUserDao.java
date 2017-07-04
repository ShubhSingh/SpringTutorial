package springjdbc.simpledbconnectivity;

import java.sql.Types;

import org.springframework.jdbc.core.JdbcTemplate;

import springjdbc.IRmUserDao;
import springjdbc.RmUser;

public class RmUserDao implements IRmUserDao {
	/*
	 * For reference visit:
	 * http://monstersandwich.blogspot.com/2010/04/spring-transactions-sample-applications.html
	 */
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void deleteUser(int uid) {
		String delQuery = "delete from TESTSCHEMA.RMUSER where user_id = ?";
		int count = jdbcTemplate.update(delQuery, new Object[] { uid });
		if(count!=0)
			System.out.println("User deleted successfully.");
		else
			System.out.println("Couldn't delete user with given id as it doesn't exist");
	}

	public int insertUser(RmUser user) {
		String inserQuery = "insert into TESTSCHEMA.RMUSER (username, password, enabled , user_id) values (?, ?, ?, ?) ";
		Object[] params = new Object[] { user.getUserName(),
				user.getPassword(), user.isEnabled(), user.getUserId() };
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				Types.INTEGER };
		return jdbcTemplate.update(inserQuery, params, types);

	}

	public RmUser selectUser(int uid) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateUser(RmUser user) {
		// TODO Auto-generated method stub
		return 0;
	}

}
