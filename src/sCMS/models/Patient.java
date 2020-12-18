package sCMS.models;

import java.io.Serializable;
import java.util.Date;
//import java.text.DateFormat;
import java.text.ParseException;

import sCMS.common.Util;

@SuppressWarnings("serial")
public class Patient implements Serializable {
	public static enum genderEnum {F, M, O};
	
	private int serialNumber;
	private String name;
	private int age;
	private String gender;
	private String phoneNumber;
	private int assignedDoctorSerialNumber;
	private Date appoinmentDate;
	private Date lastAppoinmentDate;
	private String address;
	private String summary;
	
	public Patient() {
		//Default constructor for empty object creation
	}
	
	public Patient(int serialNumber, String name, int age, String gender, String phoneNumber, int assignedDoctorSerialNumber,
			Date appoinmentDate, Date lastAppoinmentDate, String address, String summary) {
		this.serialNumber = serialNumber;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.assignedDoctorSerialNumber = assignedDoctorSerialNumber;
		this.appoinmentDate = appoinmentDate;
		this.lastAppoinmentDate = lastAppoinmentDate;
		this.address = address;
		this.summary = summary;
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

	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getGender() {
		return gender;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setAssignedDoctorSerialNumber(int assignedDoctorSerialNumber) {
		this.assignedDoctorSerialNumber = assignedDoctorSerialNumber;
	}
	
	public int getAssignedDoctorSerialNumber() {
		return assignedDoctorSerialNumber;
	}

	/* AppoinmentDate */
	public void setAppoinmentDate(Date appoinmentDate) {
		this.appoinmentDate = appoinmentDate;
	}

	public void setAppoinmentDate(String appoinmentDate) throws ParseException {
		this.appoinmentDate = Util.stringDateFormatToDate(appoinmentDate);
	}
	
	public void setAppoinmentDate(String appoinmentDate, String appoinmentDateFormat) throws ParseException {
		this.appoinmentDate = Util.stringDateFormatToDate(appoinmentDate, appoinmentDateFormat);
	}
	
	public Date getAppoinmentDate() {
		return appoinmentDate;
	}
	
	public String getAppoinmentDate(String appoinmentDateFormat) {
		return Util.dateToStringDateFormat(appoinmentDate, appoinmentDateFormat);
	}
	/* AppoinmentDate End */
	
	/* LastAppoinmentDate */
	public void setLastAppoinment(Date lastAppoinmentDate) {
		this.lastAppoinmentDate = lastAppoinmentDate;
	}
	
	public void setLastAppoinmentDate(String lastAppoinmentDate) throws ParseException {
		this.lastAppoinmentDate = Util.stringDateFormatToDate(lastAppoinmentDate);
	}
	
	public void setLastAppoinmentDate(String lastAppoinmentDate, String lastAppoinmentDateFormat) throws ParseException {
		this.lastAppoinmentDate = Util.stringDateFormatToDate(lastAppoinmentDate, lastAppoinmentDateFormat);
	}
	
	public Date getLastAppoinmentDate() {
		return lastAppoinmentDate;
	}
	
	public String getLastAppoinmentDate(String lastAppoinmentDateFormat) {
		return Util.dateToStringDateFormat(lastAppoinmentDate, lastAppoinmentDateFormat);
	}
	/* LastAppoinmentDate End */

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public String getSummary() {
		return summary;
	}

	/*
	public static void main(String[] args) throws ParseException {
		Patient p1 = new Patient();
		//p1.gender = Patient.genderEnum.F.toString();
		
		p1.setAppoinmentDate(new Date());
		//p1.setAppoinmentDate("31-12-2009");
		//p1.setAppoinmentDate("2009-12-31", "yyyy-MM-dd");
		
		p1.setLastAppoinmentDate("2024-08-03", "yyyy-MM-dd");
		
		System.out.println(p1.getAppoinmentDate("dd/MM/yyyy, hh:mm a"));
		System.out.println(DateFormat.getDateInstance(DateFormat.MEDIUM).format(p1.getAppoinmentDate()));
		
		System.out.println(p1.getLastAppoinmentDate("dd/MM/yyyy, hh:mm a"));
		System.out.println(DateFormat.getDateInstance(DateFormat.MEDIUM).format(p1.getLastAppoinmentDate()));
	}
	*/
}