package br.com.sgf.api.enums;

public enum FuelType {
	GASOLINE("Gasoline"),
	ALCOHOL("Alcohol"), 
	GAS("Gas");
   
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