package sCMS.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

//import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import sCMS.views.SearchDoctorsFrame;
import sCMS.models.Doctor;
import sCMS.common.Dbase;
import sCMS.common.Util;

public class SearchDoctors {
	private static SearchDoctorsFrame SearchDoctorsWindow = new SearchDoctorsFrame();
	
	private List<Doctor> doctorsList = new ArrayList<>();
	//private List<Doctor> searchedDoctorsList = new ArrayList<>();
	private static final String[] doctorsTableHeader = {"Serial No.", "Name", "Speciality", "Designation", "Ph. No.", "Weekly Visits", "Address"};
	//private static int doctorsTableSelectedRow = -1;
	private static int doctorsListSelectedRow = -1;
	
	@SuppressWarnings("serial")
	private DefaultTableModel doctorsTableModel = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
        	//return !((column == 0) || (column == 5));
        	return false;
        }
	};
	
	protected SearchDoctors() {
		doctorsTableModel.setColumnIdentifiers(doctorsTableHeader);
		SearchDoctorsWindow.tblDoctorsList.setModel(doctorsTableModel);
		
		SearchDoctorsWindow.btnSearch.addActionListener(l -> {
			fetchTableData();
		});
		
		//fetchTableData();
		SearchDoctorsWindow.btnDelete.addActionListener(l -> {
			if (!SearchDoctorsWindow.tblDoctorsList.getSelectionModel().isSelectionEmpty()) {
				int confirmDialogResult = JOptionPane.showOptionDialog(null,
						"This operation is irreversible!\n       Do you want to delete?",
						"Record(s) Delete Confirmation",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, 
						null, null, JOptionPane.NO_OPTION);
				
				if (confirmDialogResult == JOptionPane.YES_OPTION) deleteSelectedTableRows();
			}
		});
		
		SearchDoctorsWindow.btnUpdate.addActionListener(l -> {
			updateSelectedTableRow();
		});
		
		SearchDoctorsWindow.btnClear.addActionListener(l -> {
			clearFields();
		});
		
		SearchDoctorsWindow.tblDoctorsList.getSelectionModel().addListSelectionListener(l -> {
			int selectedRow = SearchDoctorsWindow.tblDoctorsList.getSelectedRow();
			int selectedRowSerial = -1;
			//doctorsTableSelectedRow = selectedRow;
			
			//Debug
			//System.out.println("Debug: selectedRow: " + selectedRow);
			
			if (selectedRow != -1) {
				selectedRowSerial = (int) SearchDoctorsWindow.tblDoctorsList.getModel().getValueAt(selectedRow, 0);
				
				//Debug
				//System.out.println("Debug: selectedRowSerial: " + selectedRowSerial);
				
				int currentDoctorsListIndex = 0;
				for (Doctor doctor : doctorsList) {
					if (doctor.getSerialNumber() == selectedRowSerial) {
						doctorsListSelectedRow = currentDoctorsListIndex;
						break;
					} else {
						doctorsListSelectedRow = -1;
					}
					
					currentDoctorsListIndex++;
				}
				
				//Debug
				//System.out.println("Debug: selectedRowIndex: " + doctorsListSelectedRow);
				
				SearchDoctorsWindow.txtName.setText((String) doctorsTableModel.getValueAt(selectedRow, 1));
				SearchDoctorsWindow.txtSpeciality.setText((String) doctorsTableModel.getValueAt(selectedRow, 2));
				SearchDoctorsWindow.txtDesignation.setText((String) doctorsTableModel.getValueAt(selectedRow, 3));
				SearchDoctorsWindow.txtPhone.setText((String) doctorsTableModel.getValueAt(selectedRow, 4));
				
				SearchDoctorsWindow.chkSunday.setSelected(false);
				SearchDoctorsWindow.chkMonday.setSelected(false);
				SearchDoctorsWindow.chkTuesday.setSelected(false);
				SearchDoctorsWindow.chkWednesday.setSelected(false);
				SearchDoctorsWindow.chkThursday.setSelected(false);
				SearchDoctorsWindow.chkFriday.setSelected(false);
				SearchDoctorsWindow.chkSaturday.setSelected(false);
				
				String[] weeklyVisits = doctorsList.get(doctorsListSelectedRow).getWeeklyVisits();
				for (String weekDay : weeklyVisits) {
					switch(weekDay) {
						case "Su":
							SearchDoctorsWindow.chkSunday.setSelected(true);
							break;
						case "Mo":
							SearchDoctorsWindow.chkMonday.setSelected(true);
							break;
						case "Tu":
							SearchDoctorsWindow.chkTuesday.setSelected(true);
							break;
						case "We":
							SearchDoctorsWindow.chkWednesday.setSelected(true);
							break;
						case "Th":
							SearchDoctorsWindow.chkThursday.setSelected(true);
							break;
						case "Fr":
							SearchDoctorsWindow.chkFriday.setSelected(true);
							break;
						case "Sa":
							SearchDoctorsWindow.chkSaturday.setSelected(true);
							break;
						default:
							break;
					}
				}
				
				SearchDoctorsWindow.txtAreaAddress.setText((String) doctorsTableModel.getValueAt(selectedRow, 6));
			}
		});
		
		//Update current date every 1 sec.
		new Timer(1000, l -> SearchDoctorsWindow.lblCurrentDate.setText("Current Date: " + Util.dateToStringDateFormat(new Date(), "dd MMM, yyyy"))).start();
	}
	
	private void fetchTableData() {
        doctorsList = Dbase.loadDoctorsData();
		doctorsList = (doctorsList == null) ? new ArrayList<>() : doctorsList;
		//searchedDoctorsList = new ArrayList<>();
		
		if (doctorsTableModel.getRowCount() > 0) {
			//doctorsTableModel.setRowCount(0);
			doctorsTableModel.getDataVector().removeAllElements();
			doctorsTableModel.fireTableDataChanged();
		}
		
		for (Doctor doctor : doctorsList) {
			if (((SearchDoctorsWindow.comboBoxSearchBy.getSelectedIndex() == 0) && (!SearchDoctorsWindow.txtSearchTerm.getText().trim().isBlank()) && (doctor.getName().matches(("(?i)" + SearchDoctorsWindow.txtSearchTerm.getText().trim() + "(.*)")))) ||
					((SearchDoctorsWindow.comboBoxSearchBy.getSelectedIndex() == 1) && (!SearchDoctorsWindow.txtSearchTerm.getText().trim().isBlank()) && (doctor.getPhoneNumber().matches(("(?i)" + SearchDoctorsWindow.txtSearchTerm.getText().trim() + "(.*)")))) ||
					((SearchDoctorsWindow.comboBoxSearchBy.getSelectedIndex() == 2) && (!SearchDoctorsWindow.txtSearchTerm.getText().trim().isBlank()) && (doctor.getSpeciality().matches(("(?i)(.*)" + SearchDoctorsWindow.txtSearchTerm.getText().trim() + "(.*)")))) ||
					((SearchDoctorsWindow.comboBoxSearchBy.getSelectedIndex() == 3) && (!SearchDoctorsWindow.txtSearchTerm.getText().trim().isBlank()) && (doctor.getDesignation().replaceAll("\\.", "").matches(("(?i)(.*)" + SearchDoctorsWindow.txtSearchTerm.getText().trim().replaceAll("\\.", "") + "(.*)")))))
			{
				//searchedDoctorsList.add(doctor);
				
				String weeklyVisits = "";
				for (String weekDay : doctor.getWeeklyVisits()) {
					weeklyVisits += weekDay;
					if (weekDay != doctor.getWeeklyVisits()[doctor.getWeeklyVisits().length - 1])
						weeklyVisits += ", ";
				}
				
				doctorsTableModel.addRow(new Object[] {
						doctor.getSerialNumber(),
						doctor.getName(),
						doctor.getSpeciality(),
						doctor.getDesignation(),
						doctor.getPhoneNumber(),
						weeklyVisits,
						doctor.getAddress()});
			}
		}
	}
	
	private void deleteSelectedTableRows() {
		int[] selectedRows = SearchDoctorsWindow.tblDoctorsList.getSelectedRows();
		int selectedRowSerial = -1;
		int selectedIndex = -1;
		
		for(int i = 0; i < selectedRows.length; i++) {
			selectedRowSerial = (int) SearchDoctorsWindow.tblDoctorsList.getModel().getValueAt(selectedRows[i] - i, 0);
			
			//Debug
			//System.out.println("Debug: selectedRowSerial: " + selectedRowSerial);

			int currentIndex = 0;
			for (Doctor doctor : doctorsList) {
				if (doctor.getSerialNumber() == selectedRowSerial) {
					selectedIndex = currentIndex;
					break;
				} else {
					selectedIndex = -1;
				}
				
				currentIndex++;
			}
			
			//Debug
			//System.out.println("Debug: selectedRowIndex: " + selectedIndex);
			
			doctorsTableModel.removeRow(selectedRows[i] - i);
			if (doctorsList != null && !doctorsList.isEmpty()) doctorsList.remove(selectedIndex);
		}
		
		Dbase.saveDoctorsData(doctorsList);
	}
	
	private void updateSelectedTableRow() {
		if (doctorsListSelectedRow != -1) {
			int serialNumber = doctorsListSelectedRow + 1;
			String name = SearchDoctorsWindow.txtName.getText().trim();
			String speciality = SearchDoctorsWindow.txtSpeciality.getText().trim();
			String designation = SearchDoctorsWindow.txtDesignation.getText().trim();
			String phoneNumber = SearchDoctorsWindow.txtPhone.getText().trim();
			String[] weeklyVisits = Arrays.stream(new String[] {
					SearchDoctorsWindow.chkSunday.isSelected() ? Doctor.weekDaysEnum.Su.name() : "",
					SearchDoctorsWindow.chkMonday.isSelected() ? Doctor.weekDaysEnum.Mo.name() : "",
					SearchDoctorsWindow.chkTuesday.isSelected() ? Doctor.weekDaysEnum.Tu.name() : "",
					SearchDoctorsWindow.chkWednesday.isSelected() ? Doctor.weekDaysEnum.We.name() : "",
					SearchDoctorsWindow.chkThursday.isSelected() ? Doctor.weekDaysEnum.Th.name() : "",
					SearchDoctorsWindow.chkFriday.isSelected() ? Doctor.weekDaysEnum.Fr.name() : "",
					SearchDoctorsWindow.chkSaturday.isSelected() ? Doctor.weekDaysEnum.Sa.name() : ""
					}).filter(str -> !str.isEmpty()).toArray(String[]::new);
			String address = SearchDoctorsWindow.txtAreaAddress.getText().trim();
			
			Doctor doctor = new Doctor(serialNumber, name, speciality, designation, phoneNumber, weeklyVisits, address);
			//doctorsList.remove(doctorsListSelectedRow);
			//doctorsList.add(doctorsListSelectedRow, doctor);
			doctorsList.set(doctorsListSelectedRow, doctor);
			
	        if (doctorsList != null && !doctorsList.isEmpty()) {
	        	Dbase.saveDoctorsData(doctorsList);
	        	fetchTableData();
	        }
        }
	}
	
	private void clearFields() {
		SearchDoctorsWindow.txtSearchTerm.setText("");
		SearchDoctorsWindow.comboBoxSearchBy.setSelectedIndex(0);
		
		if (doctorsTableModel.getRowCount() > 0) {
			//doctorsTableModel.setRowCount(0);
			doctorsTableModel.getDataVector().removeAllElements();
			doctorsTableModel.fireTableDataChanged();
		}
		
		SearchDoctorsWindow.txtName.setText("");
		SearchDoctorsWindow.txtSpeciality.setText("");
		SearchDoctorsWindow.txtDesignation.setText("");
		SearchDoctorsWindow.txtPhone.setText("");
		
		SearchDoctorsWindow.chkSunday.setSelected(false);
		SearchDoctorsWindow.chkMonday.setSelected(false);
		SearchDoctorsWindow.chkTuesday.setSelected(false);
		SearchDoctorsWindow.chkWednesday.setSelected(false);
		SearchDoctorsWindow.chkThursday.setSelected(false);
		SearchDoctorsWindow.chkFriday.setSelected(false);
		SearchDoctorsWindow.chkSaturday.setSelected(false);
		
		SearchDoctorsWindow.txtAreaAddress.setText("");
	}
	
	protected void setVisible() {
		SearchDoctorsWindow.searchDoctorsFrame.setVisible(true);
	}
}