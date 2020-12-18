package sCMS.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

//import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import sCMS.views.ListDoctorsFrame;
import sCMS.models.Doctor;
import sCMS.common.Dbase;
import sCMS.common.Util;

public class ListDoctors {
	private static ListDoctorsFrame ListDoctorsWindow = new ListDoctorsFrame();
	
	private List<Doctor> doctorsList = new ArrayList<>();
	private static final String[] doctorsTableHeader = {"Serial No.", "Name", "Speciality", "Designation", "Ph. No.", "Weekly Visits", "Address"};
	private static int doctorsTableSelectedRow = -1;
	
	@SuppressWarnings("serial")
	private DefaultTableModel doctorsTableModel = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
        	//return !((column == 0) || (column == 5));
        	return false;
        }
	};
	
	protected ListDoctors() {
		doctorsTableModel.setColumnIdentifiers(doctorsTableHeader);
		ListDoctorsWindow.tblDoctorsList.setModel(doctorsTableModel);
		
		//fetchTableData();
		ListDoctorsWindow.btnDelete.addActionListener(l -> {
			if (!ListDoctorsWindow.tblDoctorsList.getSelectionModel().isSelectionEmpty()) {
				int confirmDialogResult = JOptionPane.showOptionDialog(null,
						"This operation is irreversible!\n       Do you want to delete?",
						"Record(s) Delete Confirmation",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, 
						null, null, JOptionPane.NO_OPTION);
				
				if (confirmDialogResult == JOptionPane.YES_OPTION) deleteSelectedTableRows();
			}
		});
		
		ListDoctorsWindow.btnUpdate.addActionListener(l -> {
			updateSelectedTableRow();
		});
		
		ListDoctorsWindow.btnNew.addActionListener(l -> {
			Main.AddDoctorsWindowController.setVisible();
		});
		
		ListDoctorsWindow.btnRefresh.addActionListener(l -> {
			fetchTableData();
		});
		
		ListDoctorsWindow.tblDoctorsList.getSelectionModel().addListSelectionListener(l -> {
			int selectedRow = ListDoctorsWindow.tblDoctorsList.getSelectedRow();
			doctorsTableSelectedRow = selectedRow;
			
			if (selectedRow != -1) {
				ListDoctorsWindow.txtName.setText((String) doctorsTableModel.getValueAt(selectedRow, 1));
				ListDoctorsWindow.txtSpeciality.setText((String) doctorsTableModel.getValueAt(selectedRow, 2));
				ListDoctorsWindow.txtDesignation.setText((String) doctorsTableModel.getValueAt(selectedRow, 3));
				ListDoctorsWindow.txtPhone.setText((String) doctorsTableModel.getValueAt(selectedRow, 4));
				
				ListDoctorsWindow.chkSunday.setSelected(false);
				ListDoctorsWindow.chkMonday.setSelected(false);
				ListDoctorsWindow.chkTuesday.setSelected(false);
				ListDoctorsWindow.chkWednesday.setSelected(false);
				ListDoctorsWindow.chkThursday.setSelected(false);
				ListDoctorsWindow.chkFriday.setSelected(false);
				ListDoctorsWindow.chkSaturday.setSelected(false);
				
				String[] weeklyVisits = doctorsList.get(selectedRow).getWeeklyVisits();
				for (String weekDay : weeklyVisits) {
					switch(weekDay) {
						case "Su":
							ListDoctorsWindow.chkSunday.setSelected(true);
							break;
						case "Mo":
							ListDoctorsWindow.chkMonday.setSelected(true);
							break;
						case "Tu":
							ListDoctorsWindow.chkTuesday.setSelected(true);
							break;
						case "We":
							ListDoctorsWindow.chkWednesday.setSelected(true);
							break;
						case "Th":
							ListDoctorsWindow.chkThursday.setSelected(true);
							break;
						case "Fr":
							ListDoctorsWindow.chkFriday.setSelected(true);
							break;
						case "Sa":
							ListDoctorsWindow.chkSaturday.setSelected(true);
							break;
						default:
							break;
					}
				}
				
				ListDoctorsWindow.txtAreaAddress.setText((String) doctorsTableModel.getValueAt(selectedRow, 6));
			}
		});
		
		//Update current date every 1 sec.
		new Timer(1000, l -> ListDoctorsWindow.lblCurrentDate.setText("Current Date: " + Util.dateToStringDateFormat(new Date(), "dd MMM, yyyy"))).start();
	}
	
	private void fetchTableData() {
        doctorsList = Dbase.loadDoctorsData();
		doctorsList = (doctorsList == null) ? new ArrayList<>() : doctorsList;
		
		if (doctorsTableModel.getRowCount() > 0) {
			//doctorsTableModel.setRowCount(0);
			doctorsTableModel.getDataVector().removeAllElements();
			doctorsTableModel.fireTableDataChanged();
		}
		
		for (Doctor doctor : doctorsList) {
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
	
	private void deleteSelectedTableRows() {
		int[] selectedRows = ListDoctorsWindow.tblDoctorsList.getSelectedRows();
		for(int i = 0; i < selectedRows.length; i++) {
			doctorsTableModel.removeRow(selectedRows[i] - i);
			
			if (doctorsList != null && !doctorsList.isEmpty()) doctorsList.remove(selectedRows[i] - i);
		}
		
		Dbase.saveDoctorsData(doctorsList);
	}
	
	private void updateSelectedTableRow() {
		if (doctorsTableSelectedRow != -1) {
			int serialNumber = doctorsTableSelectedRow + 1;
			String name = ListDoctorsWindow.txtName.getText().trim();
			String speciality = ListDoctorsWindow.txtSpeciality.getText().trim();
			String designation = ListDoctorsWindow.txtDesignation.getText().trim();
			String phoneNumber = ListDoctorsWindow.txtPhone.getText().trim();
			String[] weeklyVisits = Arrays.stream(new String[] {
					ListDoctorsWindow.chkSunday.isSelected() ? Doctor.weekDaysEnum.Su.name() : "",
					ListDoctorsWindow.chkMonday.isSelected() ? Doctor.weekDaysEnum.Mo.name() : "",
					ListDoctorsWindow.chkTuesday.isSelected() ? Doctor.weekDaysEnum.Tu.name() : "",
					ListDoctorsWindow.chkWednesday.isSelected() ? Doctor.weekDaysEnum.We.name() : "",
					ListDoctorsWindow.chkThursday.isSelected() ? Doctor.weekDaysEnum.Th.name() : "",
					ListDoctorsWindow.chkFriday.isSelected() ? Doctor.weekDaysEnum.Fr.name() : "",
					ListDoctorsWindow.chkSaturday.isSelected() ? Doctor.weekDaysEnum.Sa.name() : ""
					}).filter(str -> !str.isEmpty()).toArray(String[]::new);
			String address = ListDoctorsWindow.txtAreaAddress.getText().trim();
			
			Doctor doctor = new Doctor(serialNumber, name, speciality, designation, phoneNumber, weeklyVisits, address);
			//doctorsList.remove(doctorsTableSelectedRow);
			//doctorsList.add(doctorsTableSelectedRow, doctor);
			doctorsList.set(doctorsTableSelectedRow, doctor);
			
	        if (doctorsList != null && !doctorsList.isEmpty()) {
	        	Dbase.saveDoctorsData(doctorsList);
	        	fetchTableData();
	        }
        }
	}
	
	protected void setVisible() {
		fetchTableData();
		ListDoctorsWindow.listDoctorsFrame.setVisible(true);
	}
}