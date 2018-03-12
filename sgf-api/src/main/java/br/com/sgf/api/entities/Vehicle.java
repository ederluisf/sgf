package br.com.sgf.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import br.com.sgf.api.enums.FuelType;

@Entity
@Table(name = "vehicle")
public class Vehicle extends GenericEntity {

	private static final long serialVersionUID = 1L;

	private Model model;
	private int year;
	private String color;
	private String plate;
	private FuelType fuel;
	private String chassis;
	private Integer initialMileage;
	private Integer currentMileage;
	// private List<byte[]> pictures;
	
	@Column(name = "year", nullable = false)
	@NotNull(message = "Year field can not be null!")
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "model_id")
	public Model getModel() {
		return model;
	}
	
	public void setModel(Model model) {
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

	@Column(name = "chassis")
	public String getChassis() {
		return chassis;
	}

	public void setChassis(String chassis) {
		this.chassis = chassis;
	}

	@Column(name = "initial_mileage")
	public Integer getInitialMileage() {
		return initialMileage;
	}

	public void setInitialMileage(Integer initialMileage) {
		this.initialMileage = initialMileage;
	}

	@Column(name = "current_mileage")
	public Integer getCurrentMileage() {
		return currentMileage;
	}

	public void setCurrentMileage(Integer currentMileage) {
		this.currentMileage = currentMileage;
	}
}