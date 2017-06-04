package springjdbc.simpledbconnectivity;

import java.sql.Types;

import org.springframework.jdbc.core.JdbcTemplate;

import springjdbc.IUserDao;
import springjdbc.User;

/**
 * @author achauhan
 * 
 */
public class UserDao implements IUserDao {
	/*
	 * For reference visit:
	 * http://monstersandwich.blogspot.com/2010/04/spring-transactions
	 * -sample-applications.html
	 */
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void deleteUser(int uid) {
		String delQuery = "delete from newtable where user_id = ?";
		int count = jdbcTemplate.update(delQuery, new Object[] { uid });
		if(count!=0)
			System.out.println("User deleted successfully.");
		else
			System.out.println("Couldn't delete user with given id as it doesn't exist");
	}

	public int insertUser(User user) {
		String inserQuery = "insert into newtable (username, password, enabled , user_id) values (?, ?, ?, ?) ";
		Object[] params = new Object[] { user.getUserName(),
				user.getPassword(), user.isEnabled(), user.getUserId() };
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				Types.INTEGER };
		return jdbcTemplate.update(inserQuery, params, types);

	}

	public User selectUser(int uid) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

}
