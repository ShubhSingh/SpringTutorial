package springjdbc.transactions.programmatic.usingplatformmanager;

import java.sql.Types;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import tutorial11.springjdbc.IUserDao;
import tutorial11.springjdbc.User;

/**This class demonstrates how to use transaction template to programatically 
 * handle transactions.
 * 
 * @author achauhan
 */
public class PlatformTxManagerUserDao implements IUserDao {

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
			String delQuery = "delete from newtable where user_id = ?";
			jdbcTemplate.update(delQuery, new Object[]{uid});
			platformTransactionManager.commit(status);
			}catch (Exception e) {
				platformTransactionManager.rollback(status);
			}
		
	}

	public int insertUser(final User user) {
		TransactionDefinition paramTransactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus status=platformTransactionManager.getTransaction(paramTransactionDefinition );
		String inserQuery = "insert into newtable (username, password, enabled , user_id) values (?, ?, ?, ?) ";
		Object[] params = new Object[]{user.getUserName(), user.getPassword(),user.isEnabled(),user.getUserId()};
		int[] types = new int[]{Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.INTEGER};
		int rowsAffected =  jdbcTemplate.update(inserQuery,params,types);
		platformTransactionManager.commit(status);
		return rowsAffected;
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
