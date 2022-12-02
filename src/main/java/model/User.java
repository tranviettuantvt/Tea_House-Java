package model;

public class User {
	private int userId;
	private String username;
	private String password;
	private int role;
	private String fullName;
	
	public User() {
		
	}

	
	public User(int userId, String username, String password, int role, String fullName) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.role = role;
		this.fullName = fullName;
	}
	
	
	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getRole() {
		return role;
	}


	public void setRole(int role) {
		this.role = role;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", fullName=" + fullName + "]";
	}

}
