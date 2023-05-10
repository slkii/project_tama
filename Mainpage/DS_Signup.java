package Mainpage;

public class DS_Signup {
	private String id;
	private String password;
	
	
	
	public DS_Signup(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	public DS_Signup() {
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		String str = String.format("아이디 : "+id+"비밀번호 : "+password);
		
		return str;
	}
	
}
