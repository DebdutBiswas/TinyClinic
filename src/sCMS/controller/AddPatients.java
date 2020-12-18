package sCMS.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
//import java.util.Arrays;
import java.util.Date;
import java.util.Calendar;

import javax.swing.Timer;

import sCMS.views.AddPatientsFrame;
import sCMS.models.Patient;
import sCMS.models.Doctor;
import sCMS.common.Dbase;
import sCMS.common.Util;

public class AddPatients {
	private static AddPatientsFrame AddPatientsWindow = new AddPatientsFrame();
	private List<Doctor> doctorsList = new ArrayList<>();
	private List<Patient> patientsList = new ArrayList<>();
	private List<Integer> doctorsListIndex = new ArrayList<>();
	private Map<String, Date> appoinmentDatesOfWeekMap = new HashMap<String, Date>();
	
	protected AddPatients() {
        //doctorsList = Dbase.loadDoctorsData();
		//patientsList = Dbase.loadPatientsData();
		//doctorsList = (doctorsList == null) ? new ArrayList<>() : doctorsList;
		//patientsList = (patientsList == null) ? new ArrayList<>() : patientsList;
		
		AddPatientsWindow.btnNew.addActionListener(l -> {
			saveFields();
			clearFields();
		});
		
		AddPatientsWindow.btnClear.addActionListener(l -> {
			clearFields();
			savedStatusUpdate("Cleared");
		});
		
		AddPatientsWindow.btnSave.addActionListener(l -> {
			saveFields();
		});
		
		AddPatientsWindow.comboBoxAssignedDoctor.addActionListener(l -> {
			populateComboBoxAppoinmentDate();
		});
		
		AddPatientsWindow.chkNextSevenDays.addActionListener(l -> {
			populateComboBoxAppoinmentDate();
		});
		
		//Update current date every 1 sec.
		new Timer(1000, l -> AddPatientsWindow.lblCurrentDate.setText("Current Date: " + Util.dateToStringDateFormat(new Date(), "dd MMM, yyyy"))).start();
	}
	
	private void saveFields() {
		doctorsList = Dbase.loadDoctorsData();
		patientsList = Dbase.loadPatientsData();
		doctorsList = (doctorsList == null) ? new ArrayList<>() : doctorsList;
		patientsList = (patientsList == null) ? new ArrayList<>() : patientsList;
		
		int serialNumber = patientsList.isEmpty() ? 1 : patientsList.get(patientsList.size() - 1).getSerialNumber() + 1;
		String name = AddPatientsWindow.txtName.getText().trim();
		
		String sanitizedAge = AddPatientsWindow.txtAge.getText().trim().replaceAll("[^0-9.]", "");
		int age = (!sanitizedAge.isBlank()) ? Float.valueOf(sanitizedAge).intValue() : -1;
		
		String gender = "F";
		if (AddPatientsWindow.rdbtnGenderFemale.isSelected())
			gender = Patient.genderEnum.F.name();
		else if (AddPatientsWindow.rdbtnGenderMale.isSelected())
			gender = Patient.genderEnum.M.name();
		else if (AddPatientsWindow.rdbtnGenderOther.isSelected())
			gender = Patient.genderEnum.O.name();
		
		String phoneNumber = AddPatientsWindow.txtPhone.getText().trim();
		
		int assignedDoctorSerialNumber = doctorsListIndex.get(AddPatientsWindow.comboBoxAssignedDoctor.getSelectedIndex());
		
		Date appoinmentDate = (AddPatientsWindow.comboBoxAppoinmentDate.getSelectedIndex() != -1) ? appoinmentDatesOfWeekMap.get(appoinmentDatesOfWeekMap.keySet().toArray()[AddPatientsWindow.comboBoxAppoinmentDate.getSelectedIndex()]) : Util.epochDate;
		Date lastAppoinmentDate = Util.epochDate;
		
		String address = AddPatientsWindow.txtAreaAddress.getText().trim();
		String summary = AddPatientsWindow.txtAreaSummary.getText().trim();
		
		Patient patient = new Patient(serialNumber, name, age, gender, phoneNumber, assignedDoctorSerialNumber,
				appoinmentDate, lastAppoinmentDate, address, summary);
		patientsList.add(patient);
		
        if (patientsList != null && !patientsList.isEmpty()) {
        	Dbase.savePatientsData(patientsList);
        	savedStatusUpdate("Saved");
        }
	}
	
	private void populateComboBoxAssignedDoctor() {
		doctorsList = Dbase.loadDoctorsData();
		doctorsList = (doctorsList == null) ? new ArrayList<>() : doctorsList;
		
		if (!doctorsList.isEmpty()) {
			AddPatientsWindow.comboBoxAssignedDoctor.removeAllItems();
			if (!doctorsListIndex.isEmpty()) doctorsListIndex.clear(); //TC: O(n)
			//if (!doctorsListIndex.isEmpty()) doctorsListIndex.removeAll(doctorsListIndex); //TC: O(n^2)
			if (!doctorsList.isEmpty()) {
				for (Doctor doctor : doctorsList) {
					AddPatientsWindow.comboBoxAssignedDoctor.addItem(doctor.getName() + " (" + doctor.getSpeciality() + ") [" + doctor.getDesignation() + "]");
					doctorsListIndex.add(doctor.getSerialNumber());
				}
				
				AddPatientsWindow.comboBoxAssignedDoctor.setSelectedIndex(0);
			} else {
				AddPatientsWindow.comboBoxAssignedDoctor.addItem("Empty Doctor List!");
			}
		}
	}
	
	private void populateComboBoxAppoinmentDate() {
		if ((AddPatientsWindow.comboBoxAssignedDoctor.getSelectedIndex() != -1) && (!doctorsList.isEmpty() || doctorsList != null)) {
			AddPatientsWindow.comboBoxAppoinmentDate.removeAllItems();
			
			if (!appoinmentDatesOfWeekMap.isEmpty()) appoinmentDatesOfWeekMap.clear();
			if (AddPatientsWindow.chkNextSevenDays.isSelected()) {
				Calendar currentDateInCalendar = Calendar.getInstance();
				currentDateInCalendar.setTime(new Date());
				currentDateInCalendar.add(Calendar.DATE, 7);
				appoinmentDatesOfWeekMap = Util.daysOfWeekToDates(doctorsList.get(AddPatientsWindow.comboBoxAssignedDoctor.getSelectedIndex()).getWeeklyVisits(), currentDateInCalendar.getTime());
			} else {
				appoinmentDatesOfWeekMap = Util.daysOfWeekToDates(doctorsList.get(AddPatientsWindow.comboBoxAssignedDoctor.getSelectedIndex()).getWeeklyVisits());
			}
			for (String appoinmentDayOfWeek : appoinmentDatesOfWeekMap.keySet()) {
				//AddPatientsWindow.comboBoxAppoinmentDate.addItem(Util.dateToStringDateFormat(appoinmentDatesOfWeekMap.get(appoinmentDayOfWeek), "dd MMM, yyyy (") + appoinmentDayOfWeek + ")");
				AddPatientsWindow.comboBoxAppoinmentDate.addItem(Util.dateToStringDateFormat(appoinmentDatesOfWeekMap.get(appoinmentDayOfWeek), "dd MMM, yyyy (EEE)"));
			}
		}
	}
	
	private void clearFields() {
		AddPatientsWindow.txtName.setText("");
		AddPatientsWindow.txtAge.setText("");
		AddPatientsWindow.rdbtnGenderFemale.setSelected(true);
		AddPatientsWindow.txtPhone.setText("");
		AddPatientsWindow.comboBoxAssignedDoctor.setSelectedIndex(0);
		AddPatientsWindow.comboBoxAppoinmentDate.setSelectedIndex(0);
		AddPatientsWindow.chkNextSevenDays.setSelected(false);
		AddPatientsWindow.txtAreaAddress.setText("");
		AddPatientsWindow.txtAreaSummary.setText("");
		
		AddPatientsWindow.txtName.requestFocusInWindow();
		//populateComboBoxAppoinmentDate();
	}
	
	private void savedStatusUpdate(String savedStatusSet) {
		AddPatientsWindow.lblStatus.setText("Status: " + savedStatusSet);
		//new Timer(changeDelay, l -> AddPatientsWindow.lblStatus.setText("Status: " + savedStatusReset)).start();
	}
	
	protected void setVisible() {
		populateComboBoxAssignedDoctor();
		AddPatientsWindow.addPatientsFrame.setVisible(true);
	}
}