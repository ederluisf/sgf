package br.com.sgf.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "model")
public class Model extends GenericEntity {

	private static final long serialVersionUID = 1L;

	private Manufacturer manufacturer;
	private String name;
	private String engine;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "manufacturer_id")
	public Manufacturer getManufacturer() {
		return manufacturer;
	}
	
	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Column(name = "engine")
	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}
	
	@Column(name = "name")
	@NotBlank(message = "Name field can not be empty!")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}