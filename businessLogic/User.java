package businessLogic;

public class User {

	private String username;
	private String password;
	private int id;
	
	public User(String name,int id,String pass) {
		this.username=name;
		this.id=id;
		this.password=pass;
	}
	
	public String getName() {
		return username;
	}
	public void setName(String name) {
		this.username = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
		
}
