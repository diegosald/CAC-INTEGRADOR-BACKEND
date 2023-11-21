package ar.cac.abm.clases;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {
   
	private int id;
	private String user;
	private String pass;
	private String email;
	private String role;
	public Usuario(int id, String user, String pass, String email, String role) {
		this.id = id;
		this.user = user;
		this.pass = pass;
		this.email = email;
		this.role = role;
	}
	public Usuario( String user, String pass, String email, String role) {
		
		this.user = user;
		this.pass = pass;
		this.email = email;
		this.role = role;
	}
	
}
