package pl.ComputerService.user;

public class User {

	private int UserId;
	private String UserName;
	private String Password;
	private String email;
	
	public User(int userId, String userName, String password, String email) {
		super();
		UserId = userId;
		UserName = userName;
		Password = password;
		this.email = email;
	}
	
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User() {
		super();
	}
	
	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", UserName=" + UserName + ", Password=" + Password + ", email=" + email
				+ "]";
	}
	
}
