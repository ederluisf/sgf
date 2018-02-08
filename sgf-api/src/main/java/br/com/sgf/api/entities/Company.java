package br.com.sgf.api.entities;

import java.io.File;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company extends GenericEntity {

	private static final long serialVersionUID = 1L;

	private String name;
	private File logo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public File getLogo() {
		return logo;
	}

	public void setLogo(File logo) {
		this.logo = logo;
	}
}