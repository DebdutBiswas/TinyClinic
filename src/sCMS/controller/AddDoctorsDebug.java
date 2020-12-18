package sCMS.controller;

import java.util.List;
import java.util.ArrayList;

import sCMS.models.Doctor;
import sCMS.common.Dbase;

public class AddDoctorsDebug {
	public static void main(String[] args) {
		List<Doctor> doctorsList = new ArrayList<>();
        doctorsList = Dbase.loadDoctorsData();
		doctorsList = (doctorsList == null) ? new ArrayList<>() : doctorsList;
		
		System.out.println("serialNumber\tname\tspeciality\tdesignation\tphoneNumber\tweeklyVisits\taddress");
		for (Doctor d : doctorsList) {
			String weeklyVisits = "";
			for (String day : d.getWeeklyVisits()) {
				weeklyVisits += day;
				if (day != d.getWeeklyVisits()[d.getWeeklyVisits().length-1])
					weeklyVisits += ", ";
			}
			System.out.println("\t" + d.getSerialNumber() + "\t"
								+ d.getName() + "\t"
								+ d.getSpeciality() + "\t"
								+ d.getDesignation() + "\t"
								+ d.getPhoneNumber() + "\t"
								+ weeklyVisits + "\t"
								+ d.getAddress());
		}
	}
}