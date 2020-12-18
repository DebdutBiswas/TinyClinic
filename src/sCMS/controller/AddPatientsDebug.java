package sCMS.controller;

import java.util.List;
import java.util.ArrayList;

import sCMS.models.Patient;
import sCMS.common.Dbase;

public class AddPatientsDebug {
	public static void main(String[] args) {
		List<Patient> patientsList = new ArrayList<>();
        patientsList = Dbase.loadPatientsData();
		patientsList = (patientsList == null) ? new ArrayList<>() : patientsList;
		
		System.out.println("serialNumber\tname\tage\tgender\tphoneNumber\tassignedDoctorSerialNumber\tappoinmentDate\tlastAppoinmentDate\taddress\tsummary");
		for (Patient p : patientsList) {
			System.out.println("\t" + p.getSerialNumber() + "\t"
								+ p.getName() + "\t"
								+ p.getAge() + "\t"
								+ p.getGender() + "\t"
								+ p.getPhoneNumber() + "\t"
								+ p.getAssignedDoctorSerialNumber() + "\t"
								+ p.getAppoinmentDate("dd/MM/yyyy") + "\t"
								+ p.getLastAppoinmentDate("dd/MM/yyyy") + "\t"
								+ p.getAddress() + "\t"
								+ p.getSummary());
		}
	}
}
