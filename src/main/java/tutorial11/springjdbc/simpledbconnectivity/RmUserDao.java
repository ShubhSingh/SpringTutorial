package tutorial11.springjdbc.simpledbconnectivity;

import java.sql.Types;

import org.springframework.jdbc.core.JdbcTemplate;

import tutorial11.springjdbc.IRmUserDao;
import tutorial11.springjdbc.RmUser;

public class RmUserDao implements IRmUserDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void deleteUser(int uid) {
		String delQuery = "delete from TESTSCHEMA.RMUSER where userid = ?";
		int count = jdbcTemplate.update(delQuery, new Object[] { uid });
		if(count!=0)
			System.out.println("User deleted successfully.");
		else
			System.out.println("Couldn't delete user with given id as it doesn't exist");
	}

	public int insertUser(RmUser user) {
		String inserQuery = "insert into TESTSCHEMA.RMUSER (username, password, enabled , userid) values (?, ?, ?, ?) ";
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
