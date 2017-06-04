package springjdbc;
/**
 * 
 * @author Apurav
 *
 */
public interface IUserDao {

	int insertUser(User user);

	int updateUser(User user) throws Exception;

	void deleteUser(int uid);

	User selectUser(int uid);
}
