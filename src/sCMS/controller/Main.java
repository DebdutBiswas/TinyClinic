package sCMS.controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import sCMS.common.Util;
import sCMS.views.MainFrame;

public class Main extends MainFrame {
	protected static AddDoctors AddDoctorsWindowController = new AddDoctors();
	protected static ListDoctors ListDoctorsWindowController = new ListDoctors();
	protected static SearchDoctors SearchDoctorsWindowController = new SearchDoctors();
	
	protected static AddPatients AddPatientsWindowController = new AddPatients();
	protected static ListPatients ListPatientsWindowController = new ListPatients();
	protected static SearchPatients SearchPatientsWindowController = new SearchPatients();
	
	public Main() {
		mainFrame.setVisible(true);
		
		btnDoctorReg.addActionListener(l -> AddDoctorsWindowController.setVisible());
		btnDoctorList.addActionListener(l -> ListDoctorsWindowController.setVisible());
		btnDoctorSearch.addActionListener(l -> SearchDoctorsWindowController.setVisible());
		btnPatientReg.addActionListener(l -> AddPatientsWindowController.setVisible());
		btnPatientList.addActionListener(l -> ListPatientsWindowController.setVisible());
		btnPatientSearch.addActionListener(l -> SearchPatientsWindowController.setVisible());
		
		doctorMnuItmAdd.addActionListener(l -> AddDoctorsWindowController.setVisible());
		doctorMnuItmList.addActionListener(l -> ListDoctorsWindowController.setVisible());
		doctorMnuItmSearch.addActionListener(l -> SearchDoctorsWindowController.setVisible());
		patientMnuItmAdd.addActionListener(l -> AddPatientsWindowController.setVisible());
		patientMnuItmList.addActionListener(l -> ListPatientsWindowController.setVisible());
		patientMnuItmSearch.addActionListener(l -> SearchPatientsWindowController.setVisible());
		
		fileMnuItmExit.addActionListener(l -> {
			int exitDialogResult = JOptionPane.showOptionDialog(null,
													"You may have unsaved data!\n       Do you want to exit?",
													"Application Exit Confirmation",
													JOptionPane.YES_NO_OPTION,
													JOptionPane.WARNING_MESSAGE, 
													null, null, JOptionPane.NO_OPTION);
			
			if (exitDialogResult == JOptionPane.YES_OPTION) System.exit(0);
		});
		
		mainFrame.addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent e) {
				int exitDialogResult = JOptionPane.showOptionDialog(null,
						"You may have unsaved data!\n       Do you want to exit?",
						"Application Exit Confirmation",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE, 
						null, null, JOptionPane.NO_OPTION);
				
				if (exitDialogResult == JOptionPane.YES_OPTION) {
					super.windowClosing(e);
					System.exit(0);
				};
	        }
	    });
		
		//Update current date every 1 sec.
		new Timer(1000, l -> lblCurrentTime.setText("Current Time: " + Util.dateToStringDateFormat(new Date(), "hh:mm:ss a, dd MMM, yyyy"))).start();
	}
}