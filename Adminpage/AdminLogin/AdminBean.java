package AdminLogin;

import java.io.Serializable;

public class AdminBean implements Serializable {
	private Integer id;
    private String username;
    private String password;
    private String role;
     private String status;
    // Getters and Setters
    public String getUsername() {
        return username;
    }
	public Integer getId() {
		return id;
	}
	public void setId(int i) {
		this.id = i;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setUsername(String username) {
		this.username = username;
	}

  
}
