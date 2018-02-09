package br.com.sgf.api.entities;

import java.io.File;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import br.com.sgf.api.enums.FuelType;

public class Vehicle extends GenericEntity {

	private static final long serialVersionUID = 1L;

	private List<File> pictures;
	private int year;
	private String model;
	private String color;
	private Manufacturer manufacturer;
	private String plate;
	private FuelType fuel;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<File> getPictures() {
		return pictures;
	}
	
	public void setPictures(List<File> pictures) {
		this.pictures = pictures;
	}
	
	@Column(name = "year", nullable = false)
	@NotNull(message = "Year field can not be null!")
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	@Column(name = "model", nullable = false)
	@Length(max = 60)
	@NotBlank(message = "Model field can not be empty!")
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	@Column(name = "color", nullable = false)
	@Length(max = 30)
	@NotBlank(message = "Color field can not be empty!")
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	@Column(name = "manufacturer")
	@ManyToOne(fetch = FetchType.EAGER)
	public Manufacturer getManufacturer() {
		return manufacturer;
	}
	
	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	@Column(name = "plate", nullable = false)
	@Length(max = 30)
	@NotBlank(message = "Color field can not be empty!")
	public String getPlate() {
		return plate;
	}
	
	public void setPlate(String plate) {
		this.plate = plate;
	}
	
	@Column(name = "fuel_type")
	@Enumerated(EnumType.STRING)
	public FuelType getFuel() {
		return fuel;
	}

	public void setFuel(FuelType fuel) {
		this.fuel = fuel;
	}
}