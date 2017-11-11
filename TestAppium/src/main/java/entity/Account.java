package entity;

public class Account {
	private String Name;
	private String email;
	private String Password;
	private String ConfirmPass;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getConfirmPass() {
		return ConfirmPass;
	}
	public void setConfirmPass(String confirmPass) {
		ConfirmPass = confirmPass;
	}
}
