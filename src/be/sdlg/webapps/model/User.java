package be.sdlg.webapps.model;

public class User {
	public Long id;
	public String userName;
	public Long roleId;
	public String password;
	public Boolean enabled;
	// Transient
	public String roleName;
}
