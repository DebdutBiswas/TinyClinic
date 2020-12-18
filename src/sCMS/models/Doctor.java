package sCMS.models;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Doctor implements Serializable {
	public static enum weekDaysEnum {Su, Mo, Tu, We, Th, Fr, Sa};
	
	private int serialNumber;
	private String name;
	private String speciality;
	private String designation;
	private String phoneNumber;
	private String[] weeklyVisits;
	private String address;
	
	public Doctor() {
		//Default constructor for empty object creation
	}

	public Doctor(int serialNumber, String name, String speciality, String designation, String phoneNumber,
			String[] weeklyVisits, String address) {
		this.serialNumber = serialNumber;
		this.name = name;
		this.speciality = speciality;
		this.designation = designation;
		this.phoneNumber = phoneNumber;
		this.weeklyVisits = weeklyVisits;
		this.address = address;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	public int getSerialNumber() {
		return serialNumber;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
	public String getSpeciality() {
		return speciality;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public String getDesignation() {
		return designation;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}

	public void setWeeklyVisits(String[] weeklyVisits) {
		this.weeklyVisits = weeklyVisits;
	}
	
	public String[] getWeeklyVisits() {
		return weeklyVisits;
	}
}