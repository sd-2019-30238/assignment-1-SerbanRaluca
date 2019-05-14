package cqrs.readModel;

public class LoginCheckQueryResult {

	private String loginRole;
	
	
	public LoginCheckQueryResult(String loginRole) {
		this.setLoginRole(loginRole);
	}


	public String getLoginRole() {
		return loginRole;
	}


	public void setLoginRole(String loginRole) {
		this.loginRole = loginRole;
	}

}
