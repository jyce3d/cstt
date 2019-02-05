package be.sdlg.webapps.model;

public class User {
	public Long id;
	public String userName;
	public Long roleId;
	public String password;
	public Long enabled;
	// Transient
	public String roleName;
}
