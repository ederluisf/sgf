package br.com.sgf.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Entity
@Table(name = "manufacturer")
public class Manufacturer extends GenericEntity {

	private static final long serialVersionUID = 1L;

	private String name;
	private byte[] logo;
	private CommonsMultipartFile file;
	
	@Column(name = "name", nullable = false, unique = true)
	@Length(max = 60)
	@NotBlank(message = "Name field can not be empty!")
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

	@Transient
	public CommonsMultipartFile getFile() {
		return file;
	}

	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	}
}