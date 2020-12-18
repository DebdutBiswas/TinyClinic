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

import sCMS.views.SearchPatientsFrame;
import sCMS.models.Patient;
import sCMS.models.Doctor;
import sCMS.common.Dbase;
import sCMS.common.Util;

public class SearchPatients {
	private static SearchPatientsFrame SearchPatientsWindow = new SearchPatientsFrame();

	private List<Doctor> doctorsList = new ArrayList<>();
	private List<Patient> patientsList = new ArrayList<>();
	private List<Integer> doctorsListIndex = new ArrayList<>();
	private Map<String, Date> appoinmentDatesOfWeekMap = new HashMap<String, Date>();
	private static final String[] patientsTableHeader = {"Serial No.", "Name", "Age", "Gender", "Ph. No.", "Assigned Doctor", "Appoinment Date", "Last Appoinment", "Address", "Summary"};
	//private static int patientsTableSelectedRow = -1;
	private static int patientsListSelectedRow = -1;
	
	@SuppressWarnings("serial")
	private DefaultTableModel patientsTableModel = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
        	//return !((column == 0) || (column == 5));
        	return false;
        }
	};
	
	protected SearchPatients() {
		patientsTableModel.setColumnIdentifiers(patientsTableHeader);
		SearchPatientsWindow.tblPatientsList.setModel(patientsTableModel);

		SearchPatientsWindow.btnSearch.addActionListener(l -> {
			fetchTableData();
		});
		
		//fetchTableData();
		SearchPatientsWindow.btnDelete.addActionListener(l -> {
			if (!SearchPatientsWindow.tblPatientsList.getSelectionModel().isSelectionEmpty()) {
				int confirmDialogResult = JOptionPane.showOptionDialog(null,
						"This operation is irreversible!\n       Do you want to delete?",
						"Record(s) Delete Confirmation",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, 
						null, null, JOptionPane.NO_OPTION);
				
				if (confirmDialogResult == JOptionPane.YES_OPTION) deleteSelectedTableRows();
			}
		});

		SearchPatientsWindow.btnUpdate.addActionListener(l -> {
			updateSelectedTableRow();
		});

		SearchPatientsWindow.btnClear.addActionListener(l -> {
			clearFields();
		});

		SearchPatientsWindow.tblPatientsList.getSelectionModel().addListSelectionListener(l -> {
			int selectedRow = SearchPatientsWindow.tblPatientsList.getSelectedRow();
			int selectedRowSerial = -1;
			//patientsTableSelectedRow = selectedRow;
			
			if (selectedRow != -1) {
				selectedRowSerial = (int) SearchPatientsWindow.tblPatientsList.getModel().getValueAt(selectedRow, 0);
				
				//Debug
				System.out.println("selectedRowSerial: " + selectedRowSerial);
				
				int currentPatientsListIndex = 0;
				for (Patient patient : patientsList) {
					if (patient.getSerialNumber() == selectedRowSerial) {
						patientsListSelectedRow = currentPatientsListIndex;
						break;
					} else {
						patientsListSelectedRow = -1;
					}
					
					currentPatientsListIndex++;
				}
				
				SearchPatientsWindow.txtName.setText((String) patientsTableModel.getValueAt(selectedRow, 1));
				SearchPatientsWindow.txtAge.setText(String.valueOf((Integer) patientsTableModel.getValueAt(selectedRow, 2)));
				
				switch((String) patientsTableModel.getValueAt(selectedRow, 3)) {
					case "F":
						SearchPatientsWindow.rdbtnGenderFemale.setSelected(true);
						break;
					case "M":
						SearchPatientsWindow.rdbtnGenderMale.setSelected(true);
						break;
					case "O":
						SearchPatientsWindow.rdbtnGenderOther.setSelected(true);
						break;
					default:
						break;
				}
				
				SearchPatientsWindow.txtPhone.setText((String) patientsTableModel.getValueAt(selectedRow, 4));
				
				int currentDoctorsListIndex = 0;
				for (Integer doctorIndex : doctorsListIndex) {
					//if ((Integer) patientsTableModel.getValueAt(selectedRow, 5) == doctorIndex) {
					//patientsList.get(doctorsListIndex.indexOf(patient.getAssignedDoctorSerialNumber())).getAssignedDoctorSerialNumber()
					if (patientsList.get((Integer) patientsTableModel.getValueAt(selectedRow, 0) - 1).getAssignedDoctorSerialNumber() == doctorIndex) {
						SearchPatientsWindow.comboBoxAssignedDoctor.setSelectedIndex(currentDoctorsListIndex);
						break;
					}
					currentDoctorsListIndex++;
				}
				
				//SearchPatientsWindow.comboBoxAppoinmentDate.setSelectedIndex(0);
				
				SearchPatientsWindow.txtAreaAddress.setText((String) patientsTableModel.getValueAt(selectedRow, 8));
				SearchPatientsWindow.txtAreaSummary.setText((String) patientsTableModel.getValueAt(selectedRow, 9));
			}
		});

		SearchPatientsWindow.comboBoxAssignedDoctor.addActionListener(l -> {
			populateComboBoxAppoinmentDate();
		});

		SearchPatientsWindow.chkNextSevenDays.addActionListener(l -> {
			populateComboBoxAppoinmentDate();
		});

		//Update current date every 1 sec.
		new Timer(1000, l -> SearchPatientsWindow.lblCurrentDate.setText("Current Date: " + Util.dateToStringDateFormat(new Date(), "dd MMM, yyyy"))).start();
	}
	
	private void fetchTableData() {
		patientsList = Dbase.loadPatientsData();
		patientsList = (patientsList == null) ? new ArrayList<>() : patientsList;
		
		if (patientsTableModel.getRowCount() > 0) {
			//patientsTableModel.setRowCount(0);
			patientsTableModel.getDataVector().removeAllElements();
			patientsTableModel.fireTableDataChanged();
		}
		
		populateComboBoxAssignedDoctor(); //Important to populate doctorsListIndex before fetching rows from patientsList to patientsTableModel
		
		for (Patient patient : patientsList) {
			if (((SearchPatientsWindow.comboBoxSearchBy.getSelectedIndex() == 0) && (!SearchPatientsWindow.txtSearchTerm.getText().trim().isBlank()) && (patient.getName().matches(("(?i)" + SearchPatientsWindow.txtSearchTerm.getText().trim() + "(.*)")))) ||
					((SearchPatientsWindow.comboBoxSearchBy.getSelectedIndex() == 1) && (!SearchPatientsWindow.txtSearchTerm.getText().trim().isBlank()) && (patient.getPhoneNumber().matches(("(?i)" + SearchPatientsWindow.txtSearchTerm.getText().trim() + "(.*)")))) ||
					((SearchPatientsWindow.comboBoxSearchBy.getSelectedIndex() == 2) && (!SearchPatientsWindow.txtSearchTerm.getText().trim().isBlank()) && (patient.getGender().matches(("(?i)" + SearchPatientsWindow.txtSearchTerm.getText().trim().charAt(0) + "(.*)")))) ||
					((SearchPatientsWindow.comboBoxSearchBy.getSelectedIndex() == 3) && (!SearchPatientsWindow.txtSearchTerm.getText().trim().isBlank()) && (!doctorsListIndex.isEmpty()) && (doctorsList.get(doctorsListIndex.indexOf(patient.getAssignedDoctorSerialNumber())).getName().matches(("(?i)" + SearchPatientsWindow.txtSearchTerm.getText().trim() + "(.*)"))))
					)
			{
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
				} else {
					//Debug
					System.out.println("doctorsListIndex is empty!");
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
	}

	private void deleteSelectedTableRows() {
		int[] selectedRows = SearchPatientsWindow.tblPatientsList.getSelectedRows();
		int selectedRowSerial = -1;
		int selectedIndex = -1;
		
		for(int i = 0; i < selectedRows.length; i++) {
			selectedRowSerial = (int) SearchPatientsWindow.tblPatientsList.getModel().getValueAt(selectedRows[i] - i, 0);
			
			int currentIndex = 0;
			for (Patient patient : patientsList) {
				if (patient.getSerialNumber() == selectedRowSerial) {
					selectedIndex = currentIndex;
					break;
				} else {
					selectedIndex = -1;
				}
				
				currentIndex++;
			}
			
			patientsTableModel.removeRow(selectedRows[i] - i);
			if (patientsList != null && !patientsList.isEmpty()) patientsList.remove(selectedIndex);
		}
		
		Dbase.savePatientsData(patientsList);
	}

	private void updateSelectedTableRow() {
		//int selectedRow = SearchPatientsWindow.tblPatientsList.getSelectedRow();
		//patientsTableSelectedRow = selectedRow;
		
		if (patientsListSelectedRow != -1) {
			doctorsList = Dbase.loadDoctorsData();
			doctorsList = (doctorsList == null) ? new ArrayList<>() : doctorsList;
			
			int serialNumber = patientsListSelectedRow + 1;
			String name = SearchPatientsWindow.txtName.getText().trim();
			
			String sanitizedAge = SearchPatientsWindow.txtAge.getText().trim().replaceAll("[^0-9.]", "");
			int age = (!sanitizedAge.isBlank()) ? Float.valueOf(sanitizedAge).intValue() : -1;
			
			String gender = "F";
			if (SearchPatientsWindow.rdbtnGenderFemale.isSelected())
				gender = Patient.genderEnum.F.name();
			else if (SearchPatientsWindow.rdbtnGenderMale.isSelected())
				gender = Patient.genderEnum.M.name();
			else if (SearchPatientsWindow.rdbtnGenderOther.isSelected())
				gender = Patient.genderEnum.O.name();
			
			String phoneNumber = SearchPatientsWindow.txtPhone.getText().trim();
			
			int assignedDoctorSerialNumber = doctorsListIndex.get(SearchPatientsWindow.comboBoxAssignedDoctor.getSelectedIndex());
			
			Date appoinmentDate = (SearchPatientsWindow.comboBoxAppoinmentDate.getSelectedIndex() != -1) ? appoinmentDatesOfWeekMap.get(appoinmentDatesOfWeekMap.keySet().toArray()[SearchPatientsWindow.comboBoxAppoinmentDate.getSelectedIndex()]) : Util.epochDate;
			//Date lastAppoinmentDate = (patientsListSelectedRow != -1) ? ((!(patientsList.get(patientsListSelectedRow).getAppoinmentDate().getDate() == appoinmentDate.getDate())) ? patientsList.get(patientsListSelectedRow).getAppoinmentDate() : patientsList.get(patientsListSelectedRow).getLastAppoinmentDate()) : Util.epochDate;
			Date lastAppoinmentDate = (patientsListSelectedRow != -1) ? ((!(Util.dateToStringDateFormat(patientsList.get(patientsListSelectedRow).getAppoinmentDate(), "dd-MM-yyyy").equals(Util.dateToStringDateFormat(appoinmentDate, "dd-MM-yyyy"))) ? patientsList.get(patientsListSelectedRow).getAppoinmentDate() : patientsList.get(patientsListSelectedRow).getLastAppoinmentDate())) : Util.epochDate;
			
			String address = SearchPatientsWindow.txtAreaAddress.getText().trim();
			String summary = SearchPatientsWindow.txtAreaSummary.getText().trim();
			
			Patient patient = new Patient(serialNumber, name, age, gender, phoneNumber, assignedDoctorSerialNumber,
					appoinmentDate, lastAppoinmentDate, address, summary);
			patientsList.set(patientsListSelectedRow, patient);
			
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
			SearchPatientsWindow.comboBoxAssignedDoctor.removeAllItems();
			if (!doctorsListIndex.isEmpty()) doctorsListIndex.clear(); //TC: O(n)
			//if (!doctorsListIndex.isEmpty()) doctorsListIndex.removeAll(doctorsListIndex); //TC: O(n^2)
			if (!doctorsList.isEmpty()) {
				for (Doctor doctor : doctorsList) {
					SearchPatientsWindow.comboBoxAssignedDoctor.addItem(doctor.getName() + " (" + doctor.getSpeciality() + ") [" + doctor.getDesignation() + "]");
					doctorsListIndex.add(doctor.getSerialNumber());
				}
				
				SearchPatientsWindow.comboBoxAssignedDoctor.setSelectedIndex(0);
			} else {
				SearchPatientsWindow.comboBoxAssignedDoctor.addItem("Empty Doctor List!");
			}
		}
	}

	private void populateComboBoxAppoinmentDate() {
		if ((SearchPatientsWindow.comboBoxAssignedDoctor.getSelectedIndex() != -1) && (!doctorsList.isEmpty() || doctorsList != null)) {
			SearchPatientsWindow.comboBoxAppoinmentDate.removeAllItems();
			
			if (!appoinmentDatesOfWeekMap.isEmpty()) appoinmentDatesOfWeekMap.clear();
			if (SearchPatientsWindow.chkNextSevenDays.isSelected()) {
				Calendar currentDateInCalendar = Calendar.getInstance();
				currentDateInCalendar.setTime(new Date());
				currentDateInCalendar.add(Calendar.DATE, 7);
				appoinmentDatesOfWeekMap = Util.daysOfWeekToDates(doctorsList.get(SearchPatientsWindow.comboBoxAssignedDoctor.getSelectedIndex()).getWeeklyVisits(), currentDateInCalendar.getTime());
			} else {
				appoinmentDatesOfWeekMap = Util.daysOfWeekToDates(doctorsList.get(SearchPatientsWindow.comboBoxAssignedDoctor.getSelectedIndex()).getWeeklyVisits());
			}
			for (String appoinmentDayOfWeek : appoinmentDatesOfWeekMap.keySet()) {
				//SearchPatientsWindow.comboBoxAppoinmentDate.addItem(Util.dateToStringDateFormat(appoinmentDatesOfWeekMap.get(appoinmentDayOfWeek), "dd MMM, yyyy (") + appoinmentDayOfWeek + ")");
				SearchPatientsWindow.comboBoxAppoinmentDate.addItem(Util.dateToStringDateFormat(appoinmentDatesOfWeekMap.get(appoinmentDayOfWeek), "dd MMM, yyyy (EEE)"));
			}
		}
	}
	
	private void clearFields() {
		SearchPatientsWindow.txtSearchTerm.setText("");
		SearchPatientsWindow.comboBoxSearchBy.setSelectedIndex(0);
		
		if (patientsTableModel.getRowCount() > 0) {
			//patientsTableModel.setRowCount(0);
			patientsTableModel.getDataVector().removeAllElements();
			patientsTableModel.fireTableDataChanged();
		}
		
		SearchPatientsWindow.txtName.setText("");
		SearchPatientsWindow.txtAge.setText("");
		SearchPatientsWindow.rdbtnGenderFemale.setSelected(true);
		SearchPatientsWindow.txtPhone.setText("");
		SearchPatientsWindow.comboBoxAssignedDoctor.setSelectedIndex(0);
		SearchPatientsWindow.comboBoxAppoinmentDate.setSelectedIndex(0);
		SearchPatientsWindow.chkNextSevenDays.setSelected(false);
		SearchPatientsWindow.txtAreaAddress.setText("");
		SearchPatientsWindow.txtAreaSummary.setText("");
		
		SearchPatientsWindow.txtName.requestFocusInWindow();
	}

	protected void setVisible() {
		SearchPatientsWindow.searchPatientsFrame.setVisible(true);
	}
}