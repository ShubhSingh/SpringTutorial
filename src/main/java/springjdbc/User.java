package springjdbc;

public class User {

	private Integer userId;
	private String userName;
	private String password;
	private String enabled;
	
	public User(String userName, String password, String enabled, int userId) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.enabled = enabled;
	}
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String isEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

}
