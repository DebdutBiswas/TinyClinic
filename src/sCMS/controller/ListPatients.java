package sCMS.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
//import java.util.Arrays;
import java.util.Date;
import java.util.Calendar;

//import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import sCMS.views.ListPatientsFrame;
import sCMS.models.Patient;
import sCMS.models.Doctor;
import sCMS.common.Dbase;
import sCMS.common.Util;

public class ListPatients {
	private static ListPatientsFrame ListPatientsWindow = new ListPatientsFrame();
	
	private List<Doctor> doctorsList = new ArrayList<>();
	private List<Patient> patientsList = new ArrayList<>();
	private List<Integer> doctorsListIndex = new ArrayList<>();
	private Map<String, Date> appoinmentDatesOfWeekMap = new HashMap<String, Date>();
	private static final String[] patientsTableHeader = {"Serial No.", "Name", "Age", "Gender", "Ph. No.", "Assigned Doctor", "Appoinment Date", "Last Appoinment", "Address", "Summary"};
	private static int patientsTableSelectedRow = -1;
	//private static int patientsListSelectedRow = -1;
	
	@SuppressWarnings("serial")
	private DefaultTableModel patientsTableModel = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
        	//return !((column == 0) || (column == 5));
        	return false;
        }
	};
	
	protected ListPatients() {
		patientsTableModel.setColumnIdentifiers(patientsTableHeader);
		ListPatientsWindow.tblPatientsList.setModel(patientsTableModel);
		
		//fetchTableData();
		ListPatientsWindow.btnDelete.addActionListener(l -> {
			if (!ListPatientsWindow.tblPatientsList.getSelectionModel().isSelectionEmpty()) {
				int confirmDialogResult = JOptionPane.showOptionDialog(null,
						"This operation is irreversible!\n       Do you want to delete?",
						"Record(s) Delete Confirmation",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, 
						null, null, JOptionPane.NO_OPTION);
				
				if (confirmDialogResult == JOptionPane.YES_OPTION) deleteSelectedTableRows();
			}
		});
		
		ListPatientsWindow.btnUpdate.addActionListener(l -> {
			updateSelectedTableRow();
		});
		
		ListPatientsWindow.btnNew.addActionListener(l -> {
			Main.AddPatientsWindowController.setVisible();
		});
		
		ListPatientsWindow.btnRefresh.addActionListener(l -> {
			fetchTableData();
		});
		
		ListPatientsWindow.tblPatientsList.getSelectionModel().addListSelectionListener(l -> {
			int selectedRow = ListPatientsWindow.tblPatientsList.getSelectedRow();
			patientsTableSelectedRow = selectedRow;
			
			if (selectedRow != -1) {
				ListPatientsWindow.txtName.setText((String) patientsTableModel.getValueAt(selectedRow, 1));
				ListPatientsWindow.txtAge.setText(String.valueOf((Integer) patientsTableModel.getValueAt(selectedRow, 2)));
				
				switch((String) patientsTableModel.getValueAt(selectedRow, 3)) {
					case "F":
						ListPatientsWindow.rdbtnGenderFemale.setSelected(true);
						break;
					case "M":
						ListPatientsWindow.rdbtnGenderMale.setSelected(true);
						break;
					case "O":
						ListPatientsWindow.rdbtnGenderOther.setSelected(true);
						break;
					default:
						break;
				}
				
				ListPatientsWindow.txtPhone.setText((String) patientsTableModel.getValueAt(selectedRow, 4));
				
				int currentIndex = 0;
				for (Integer doctorIndex : doctorsListIndex) {
					//if ((Integer) patientsTableModel.getValueAt(selectedRow, 5) == doctorIndex) {
					if (patientsList.get((Integer) patientsTableModel.getValueAt(selectedRow, 0) - 1).getAssignedDoctorSerialNumber() == doctorIndex) {
						ListPatientsWindow.comboBoxAssignedDoctor.setSelectedIndex(currentIndex);
						break;
					}
					currentIndex++;
				}
				
				//ListPatientsWindow.comboBoxAppoinmentDate.setSelectedIndex(0);
				
				ListPatientsWindow.txtAreaAddress.setText((String) patientsTableModel.getValueAt(selectedRow, 8));
				ListPatientsWindow.txtAreaSummary.setText((String) patientsTableModel.getValueAt(selectedRow, 9));
			}
		});
		
		ListPatientsWindow.comboBoxAssignedDoctor.addActionListener(l -> {
			populateComboBoxAppoinmentDate();
		});
		
		ListPatientsWindow.chkNextSevenDays.addActionListener(l -> {
			populateComboBoxAppoinmentDate();
		});
		
		//Update current date every 1 sec.
		new Timer(1000, l -> ListPatientsWindow.lblCurrentDate.setText("Current Date: " + Util.dateToStringDateFormat(new Date(), "dd MMM, yyyy"))).start();
	}
	
	private void fetchTableData() {
		patientsList = Dbase.loadPatientsData();
		patientsList = (patientsList == null) ? new ArrayList<>() : patientsList;
		
		if (patientsTableModel.getRowCount() > 0) {
			//doctorsTableModel.setRowCount(0);
			patientsTableModel.getDataVector().removeAllElements();
			patientsTableModel.fireTableDataChanged();
		}
		
		populateComboBoxAssignedDoctor(); //Important to populate doctorsListIndex before fetching rows from patientsList to patientsTableModel
		
		for (Patient patient : patientsList) {
			String assignedDoctorName = "Not Exist";
			if (!doctorsListIndex.isEmpty()) {
				int currentIndex = 0;
				for (Integer doctorIndex : doctorsListIndex) {
					if (patient.getAssignedDoctorSerialNumber() == doctorIndex) {
						assignedDoctorName = doctorsList.get(currentIndex).getName();
						break;
					}
					currentIndex++;
				}
			}
			
			patientsTableModel.addRow(new Object[] {
					patient.getSerialNumber(),
					patient.getName(),
					patient.getAge(),
					patient.getGender(),
					patient.getPhoneNumber(),
					assignedDoctorName, //to be changed
					patient.getAppoinmentDate("dd-MM-yyyy (EEE)"),
					((patient.getLastAppoinmentDate().equals(Util.epochDate)) ? "New Patient" : patient.getLastAppoinmentDate("dd-MM-yyyy (EEE)")),
					patient.getAddress(),
					patient.getSummary()});
		}
	}
	
	private void deleteSelectedTableRows() {
		int[] selectedRows = ListPatientsWindow.tblPatientsList.getSelectedRows();
		for(int i = 0; i < selectedRows.length; i++) {
			patientsTableModel.removeRow(selectedRows[i] - i);
			
			if (patientsList != null && !patientsList.isEmpty()) patientsList.remove(selectedRows[i] - i);
		}
		
		Dbase.savePatientsData(patientsList);
	}
	
	private void updateSelectedTableRow() {
		int selectedRow = ListPatientsWindow.tblPatientsList.getSelectedRow();
		patientsTableSelectedRow = selectedRow;
		
		if (patientsTableSelectedRow != -1) {
			doctorsList = Dbase.loadDoctorsData();
			doctorsList = (doctorsList == null) ? new ArrayList<>() : doctorsList;
			
			int serialNumber = patientsTableSelectedRow + 1;
			String name = ListPatientsWindow.txtName.getText().trim();
			
			String sanitizedAge = ListPatientsWindow.txtAge.getText().trim().replaceAll("[^0-9.]", "");
			int age = (!sanitizedAge.isBlank()) ? Float.valueOf(sanitizedAge).intValue() : -1;
			
			String gender = "F";
			if (ListPatientsWindow.rdbtnGenderFemale.isSelected())
				gender = Patient.genderEnum.F.name();
			else if (ListPatientsWindow.rdbtnGenderMale.isSelected())
				gender = Patient.genderEnum.M.name();
			else if (ListPatientsWindow.rdbtnGenderOther.isSelected())
				gender = Patient.genderEnum.O.name();
			
			String phoneNumber = ListPatientsWindow.txtPhone.getText().trim();
			
			int assignedDoctorSerialNumber = doctorsListIndex.get(ListPatientsWindow.comboBoxAssignedDoctor.getSelectedIndex());
			
			Date appoinmentDate = (ListPatientsWindow.comboBoxAppoinmentDate.getSelectedIndex() != -1) ? appoinmentDatesOfWeekMap.get(appoinmentDatesOfWeekMap.keySet().toArray()[ListPatientsWindow.comboBoxAppoinmentDate.getSelectedIndex()]) : Util.epochDate;
			//Date lastAppoinmentDate = (patientsTableSelectedRow != -1) ? ((!(patientsList.get(patientsTableSelectedRow).getAppoinmentDate().getDate() == appoinmentDate.getDate())) ? patientsList.get(patientsTableSelectedRow).getAppoinmentDate() : patientsList.get(patientsTableSelectedRow).getLastAppoinmentDate()) : Util.epochDate;
			Date lastAppoinmentDate = (patientsTableSelectedRow != -1) ? ((!(Util.dateToStringDateFormat(patientsList.get(patientsTableSelectedRow).getAppoinmentDate(), "dd-MM-yyyy").equals(Util.dateToStringDateFormat(appoinmentDate, "dd-MM-yyyy"))) ? patientsList.get(patientsTableSelectedRow).getAppoinmentDate() : patientsList.get(patientsTableSelectedRow).getLastAppoinmentDate())) : Util.epochDate;
			
			String address = ListPatientsWindow.txtAreaAddress.getText().trim();
			String summary = ListPatientsWindow.txtAreaSummary.getText().trim();
			
			Patient patient = new Patient(serialNumber, name, age, gender, phoneNumber, assignedDoctorSerialNumber,
					appoinmentDate, lastAppoinmentDate, address, summary);
			patientsList.set(patientsTableSelectedRow, patient);
			
	        if (patientsList != null && !patientsList.isEmpty()) {
	        	Dbase.savePatientsData(patientsList);
	        	fetchTableData();
	        }
		}
	}
	
	private void populateComboBoxAssignedDoctor() {
		doctorsList = Dbase.loadDoctorsData();
		doctorsList = (doctorsList == null) ? new ArrayList<>() : doctorsList;
		
		if (!doctorsList.isEmpty()) {
			ListPatientsWindow.comboBoxAssignedDoctor.removeAllItems();
			if (!doctorsListIndex.isEmpty()) doctorsListIndex.clear(); //TC: O(n)
			//if (!doctorsListIndex.isEmpty()) doctorsListIndex.removeAll(doctorsListIndex); //TC: O(n^2)
			if (!doctorsList.isEmpty()) {
				for (Doctor doctor : doctorsList) {
					ListPatientsWindow.comboBoxAssignedDoctor.addItem(doctor.getName() + " (" + doctor.getSpeciality() + ") [" + doctor.getDesignation() + "]");
					doctorsListIndex.add(doctor.getSerialNumber());
				}
				
				ListPatientsWindow.comboBoxAssignedDoctor.setSelectedIndex(0);
			} else {
				ListPatientsWindow.comboBoxAssignedDoctor.addItem("Empty Doctor List!");
			}
		}
	}
	
	private void populateComboBoxAppoinmentDate() {
		if ((ListPatientsWindow.comboBoxAssignedDoctor.getSelectedIndex() != -1) && (!doctorsList.isEmpty() || doctorsList != null)) {
			ListPatientsWindow.comboBoxAppoinmentDate.removeAllItems();
			
			if (!appoinmentDatesOfWeekMap.isEmpty()) appoinmentDatesOfWeekMap.clear();
			if (ListPatientsWindow.chkNextSevenDays.isSelected()) {
				Calendar currentDateInCalendar = Calendar.getInstance();
				currentDateInCalendar.setTime(new Date());
				currentDateInCalendar.add(Calendar.DATE, 7);
				appoinmentDatesOfWeekMap = Util.daysOfWeekToDates(doctorsList.get(ListPatientsWindow.comboBoxAssignedDoctor.getSelectedIndex()).getWeeklyVisits(), currentDateInCalendar.getTime());
			} else {
				appoinmentDatesOfWeekMap = Util.daysOfWeekToDates(doctorsList.get(ListPatientsWindow.comboBoxAssignedDoctor.getSelectedIndex()).getWeeklyVisits());
			}
			for (String appoinmentDayOfWeek : appoinmentDatesOfWeekMap.keySet()) {
				//ListPatientsWindow.comboBoxAppoinmentDate.addItem(Util.dateToStringDateFormat(appoinmentDatesOfWeekMap.get(appoinmentDayOfWeek), "dd MMM, yyyy (") + appoinmentDayOfWeek + ")");
				ListPatientsWindow.comboBoxAppoinmentDate.addItem(Util.dateToStringDateFormat(appoinmentDatesOfWeekMap.get(appoinmentDayOfWeek), "dd MMM, yyyy (EEE)"));
			}
		}
	}
	
	protected void setVisible() {
		fetchTableData();
		ListPatientsWindow.listPatientsFrame.setVisible(true);
	}
}