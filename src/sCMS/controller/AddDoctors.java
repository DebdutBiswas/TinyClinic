package sCMS.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import javax.swing.Timer;

import sCMS.views.AddDoctorsFrame;
import sCMS.models.Doctor;
import sCMS.common.Dbase;
import sCMS.common.Util;

public class AddDoctors {
	private static AddDoctorsFrame AddDoctorsWindow = new AddDoctorsFrame();
	private List<Doctor> doctorsList = new ArrayList<>();
	
	protected AddDoctors() {
        //doctorsList = Dbase.loadDoctorsData();
		//doctorsList = (doctorsList == null) ? new ArrayList<>() : doctorsList;
		
		AddDoctorsWindow.btnNew.addActionListener(l -> {
			saveFields();
			clearFields();
		});
		
		AddDoctorsWindow.btnClear.addActionListener(l -> {
			clearFields();
			savedStatusUpdate("Cleared");
		});
		
		AddDoctorsWindow.btnSave.addActionListener(l -> {
			saveFields();
		});
		
		//Update current date every 1 sec.
		new Timer(1000, l -> AddDoctorsWindow.lblCurrentDate.setText("Current Date: " + Util.dateToStringDateFormat(new Date(), "dd MMM, yyyy"))).start();
	}
	
	private void saveFields() {
        doctorsList = Dbase.loadDoctorsData();
		doctorsList = (doctorsList == null) ? new ArrayList<>() : doctorsList;
		
		int serialNumber = doctorsList.isEmpty() ? 1 : doctorsList.get(doctorsList.size()-1).getSerialNumber() + 1;
		String name = AddDoctorsWindow.txtName.getText().trim();
		String speciality = AddDoctorsWindow.txtSpeciality.getText().trim();
		String designation = AddDoctorsWindow.txtDesignation.getText().trim();
		String phoneNumber = AddDoctorsWindow.txtPhone.getText().trim();
		String[] weeklyVisits = Arrays.stream(new String[] {
				AddDoctorsWindow.chkSunday.isSelected() ? Doctor.weekDaysEnum.Su.name() : "",
				AddDoctorsWindow.chkMonday.isSelected() ? Doctor.weekDaysEnum.Mo.name() : "",
				AddDoctorsWindow.chkTuesday.isSelected() ? Doctor.weekDaysEnum.Tu.name() : "",
				AddDoctorsWindow.chkWednesday.isSelected() ? Doctor.weekDaysEnum.We.name() : "",
				AddDoctorsWindow.chkThursday.isSelected() ? Doctor.weekDaysEnum.Th.name() : "",
				AddDoctorsWindow.chkFriday.isSelected() ? Doctor.weekDaysEnum.Fr.name() : "",
				AddDoctorsWindow.chkSaturday.isSelected() ? Doctor.weekDaysEnum.Sa.name() : ""
				}).filter(str -> !str.isEmpty()).toArray(String[]::new);
		String address = AddDoctorsWindow.txtAreaAddress.getText().trim();
		
		Doctor doctor = new Doctor(serialNumber, name, speciality, designation, phoneNumber, weeklyVisits, address);
		doctorsList.add(doctor);
		
        if (doctorsList != null && !doctorsList.isEmpty()) {
        	Dbase.saveDoctorsData(doctorsList);
        	savedStatusUpdate("Saved");
        }
	}
	
	private void clearFields() {
		AddDoctorsWindow.txtName.setText("");
		AddDoctorsWindow.txtSpeciality.setText("");
		AddDoctorsWindow.txtDesignation.setText("");
		AddDoctorsWindow.txtPhone.setText("");
		AddDoctorsWindow.txtAreaAddress.setText("");
		
		AddDoctorsWindow.chkSunday.setSelected(false);
		AddDoctorsWindow.chkMonday.setSelected(false);
		AddDoctorsWindow.chkTuesday.setSelected(false);
		AddDoctorsWindow.chkWednesday.setSelected(false);
		AddDoctorsWindow.chkThursday.setSelected(false);
		AddDoctorsWindow.chkFriday.setSelected(false);
		AddDoctorsWindow.chkSaturday.setSelected(false);
		
		AddDoctorsWindow.txtName.requestFocusInWindow();
	}
	
	private void savedStatusUpdate(String savedStatusSet) {
		AddDoctorsWindow.lblStatus.setText("Status: " + savedStatusSet);
		//new Timer(changeDelay, l -> AddDoctorsWindow.lblStatus.setText("Status: " + savedStatusReset)).start();
	}
	
	protected void setVisible() {
		AddDoctorsWindow.addDoctorsFrame.setVisible(true);
	}
}