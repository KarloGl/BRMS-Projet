package com.processuscomplexeAssuranceAuto;

public class Car {

	private CarType carType;
	private boolean antiTheftDevice;
	private boolean occase;
	private int km;

	public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}
	
	 public Car( CarType carType, boolean antiTheftDevice, boolean occasion, int kilometrage) {
	        this.carType = carType;
	        this.occase = occasion;
	        this.km = kilometrage;
	        this.setAntiTheftDevice(antiTheftDevice);
	        
	    }

	public boolean isAntiTheftDevice() {
		return antiTheftDevice;
	}

	public void setAntiTheftDevice(boolean antiTheftDevice) {
		this.antiTheftDevice = antiTheftDevice;
	}

	public boolean isOccase() {
		return occase;
	}

	public void setOccase(boolean occase) {
		this.occase = occase;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}
	 
}
