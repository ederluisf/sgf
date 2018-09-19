package br.com.sgf.api.enums;

public enum FuelType {
	ALCOHOL("Alcohol"), 
	ALCOHOL_GASOLINE("Alcohol_Gasoline"),
	DIESEL("DIESEL"),
	GAS("Gas"),
	GASOLINE("Gasoline");
   
	private String type;
	
	private FuelType(String type){
		this.setType(type);
	}
	
	private void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}