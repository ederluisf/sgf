package br.com.sgf.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "manufacturer")
public class Manufacturer extends GenericEntity {

	private static final long serialVersionUID = 1L;

	private String name;
	private byte[] logo;
	
	@Column(name = "name", nullable = false, unique = true)
	@Length(max = 60)
	@NotEmpty(message = "Name field can not be empty!")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "logo")
	public byte[] getLogo() {
		return logo;
	}
	
	public void setLogo(byte[] logo) {
		this.logo = logo;
	}
}