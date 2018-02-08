package br.com.sgf.api.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import javassist.bytecode.ByteArray;

@Entity
@Table(name = "manufacturer")
public class Manufacturer extends GenericEntity {

	private static final long serialVersionUID = 1L;

	private String name;
	private ByteArray[] logo;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ByteArray[] getLogo() {
		return logo;
	}
	
	public void setLogo(ByteArray[] logo) {
		this.logo = logo;
	}
}