package Entity;

import lombok.ToString;

@ToString
public class User {//用户类
	private String userphone;
	private String userpwd;
	private String username;

	public User(String userphone, String userpwd, String username) {
		this.userphone = userphone;
		this.userpwd = userpwd;
		this.username = username;
	}

	public User() {

	}

    public User(String userphone, String userpwd) {
		this.userphone = userphone;
		this.userpwd = userpwd;
    }

    public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
