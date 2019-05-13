package businessLogic.beans;

public class User {

	private String first_name;
	private String last_name;
	private String email;
	private String username;
	private String password;
	private String address;
	private String number;	

	public User() {

	}

	public User(String first,String last,String email,String username,String pass,String address,String number) {
		this.username=username;
		this.password=pass;
		this.email=email;
		this.first_name=first;
		this.last_name=last;
		this.address=address;
		this.number=number;
	}

	public String getUserName() {
		return username;
	}
	public void setUserName(String name) {
		this.username = name;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
