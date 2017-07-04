package tutorial11.springjdbc.transactions.declarative.annotations;

import java.sql.Types;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import tutorial11.springjdbc.IRmUserDao;
import tutorial11.springjdbc.RmUser;

@Transactional
// bydefault @Transactional has readOnly false
public class AnnotatedRmUserDao implements IRmUserDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public void deleteUser(int uid) {
		String delQuery = "delete from TESTSCHEMA.RMUSER where userid = ?";
		jdbcTemplate.update(delQuery, new Object[] { uid });

	}

	public int insertUser(RmUser user) {
		String inserQuery = "insert into TESTSCHEMA.RMUSER (username, password, enabled , userid) values (?, ?, ?, ?) ";
		Object[] params = new Object[] { user.getUserName(),
				user.getPassword(), user.isEnabled(), user.getUserId() };
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				Types.INTEGER };
		int number = jdbcTemplate.update(inserQuery, params, types);
		return number;
	}

	// override the class level transactional behavior for select method
	@Transactional(readOnly = true,noRollbackFor=RuntimeException.class,propagation = Propagation.REQUIRES_NEW)
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
