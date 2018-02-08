package br.com.sgf.api.entities;

import java.io.File;
import java.util.List;

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
	
	public List<File> getPictures() {
		return pictures;
	}
	
	public void setPictures(List<File> pictures) {
		this.pictures = pictures;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public Manufacturer getManufacturer() {
		return manufacturer;
	}
	
	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public String getPlate() {
		return plate;
	}
	
	public void setPlate(String plate) {
		this.plate = plate;
	}
	
	public FuelType getFuel() {
		return fuel;
	}

	public void setFuel(FuelType fuel) {
		this.fuel = fuel;
	}
}