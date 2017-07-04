package tutorial11.springjdbc;

public interface IRmUserDao {

	int insertUser(RmUser user);

	int updateUser(RmUser user) throws Exception;

	void deleteUser(int uid);

	RmUser selectUser(int uid);
}
