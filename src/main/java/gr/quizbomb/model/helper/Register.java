package gr.quizbomb.model.helper;

public class Register {
	
	private String fullName;
	
	private String username;
	
	private String email;
	
	private String password;

	private long sClassId;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getsClassId() {
		return sClassId;
	}

	public void setsClassId(long sClassId) {
		this.sClassId = sClassId;
	}
	
}
