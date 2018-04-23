package br.com.sgf.api.entities;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "company_parameters")
public class CompanyParameters extends GenericEntity {

	private static final long serialVersionUID = 1L;

	private String name;
	private File logo;

	@Column(name = "name", nullable = false)
	@Length(max = 60)
	@NotEmpty(message = "Name field can not be empty!")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "logo")
	public File getLogo() {
		return logo;
	}

	public void setLogo(File logo) {
		this.logo = logo;
	}
}