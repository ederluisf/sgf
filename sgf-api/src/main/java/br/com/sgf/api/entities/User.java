package br.com.sgf.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;

import br.com.sgf.api.enums.TypeUser;

@Entity
@Table(name = "user")
public class User extends GenericEntity {

	private static final long serialVersionUID = 1L;

	private String name;
	private String email;
	private String password;
	private TypeUser type;
	
	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "email", nullable = false, unique = true)
	@Email
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "type", nullable = false)
	@Enumerated(EnumType.STRING)
	public TypeUser getType() {
		return type;
	}
	
	public void setType(TypeUser type) {
		this.type = type;
	}
}