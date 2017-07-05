package tutorial11.springjdbc.transactions.programmatic.usingplatformmanager;

import java.sql.Types;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import tutorial11.springjdbc.IRmUserDao;
import tutorial11.springjdbc.RmUser;

/**This class demonstrates how to use transaction template to programatically 
 * handle transactions.
 */
public class PlatformTxManagerUserDao implements IRmUserDao {

	private JdbcTemplate jdbcTemplate;
	private PlatformTransactionManager platformTransactionManager;
	public void setPlatformTransactionManager(
			PlatformTransactionManager platformTransactionManager) {
		this.platformTransactionManager = platformTransactionManager;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public void deleteUser(final int uid) {
		DefaultTransactionDefinition paramTransactionDefinition = new DefaultTransactionDefinition();
		//you can set propagation behaviour like this
		//paramTransactionDefinition.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRES_NEW);
		TransactionStatus status=platformTransactionManager.getTransaction(paramTransactionDefinition );
		try{
			String delQuery = "delete from TESTSCHEMA.RMUSER where userid = ?";
			jdbcTemplate.update(delQuery, new Object[]{uid});
			platformTransactionManager.commit(status);
			}catch (Exception e) {
				platformTransactionManager.rollback(status);
			}
		
	}

	public int insertUser(final RmUser user) {
		TransactionDefinition paramTransactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus status=platformTransactionManager.getTransaction(paramTransactionDefinition );
		String inserQuery = "insert into TESTSCHEMA.RMUSER (username, password, enabled , userid) values (?, ?, ?, ?) ";
		Object[] params = new Object[]{user.getUserName(), user.getPassword(),user.isEnabled(),user.getUserId()};
		int[] types = new int[]{Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.INTEGER};
		int rowsAffected =  jdbcTemplate.update(inserQuery,params,types);
		platformTransactionManager.commit(status);
		return rowsAffected;
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
