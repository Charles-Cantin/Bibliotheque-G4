package bibliotheque.web.DTO;

import com.fasterxml.jackson.annotation.JsonView;

import bibliotheque.model.Views;

public class AuthDTO {
	@JsonView(Views.ViewBase.class)
	private String login;
	@JsonView(Views.ViewBase.class)
	private String password;
	
    public AuthDTO() {}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

