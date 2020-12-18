package sCMS.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;

import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Cursor;

public class MainFrame {

	public JFrame mainFrame;
	public JLabel lblCurrentTime;
	
	public JMenuItem patientMnuItmAdd;
	public JMenuItem patientMnuItmList;
	public JMenuItem patientMnuItmSearch;
	public JMenuItem doctorMnuItmAdd;
	public JMenuItem doctorMnuItmList;
	public JMenuItem doctorMnuItmSearch;
	public JMenuItem fileMnuItmExit;
	
	public JButton btnPatientReg;
	public JButton btnPatientList;
	public JButton btnPatientSearch;
	public JButton btnDoctorReg;
	public JButton btnDoctorList;
	public JButton btnDoctorSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setMinimumSize(new Dimension(640, 480));
		mainFrame.setTitle("Tiny Clinic");
		mainFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/sCMS/resources/medicalPills_64.png")));
		mainFrame.setBounds(
				(Toolkit.getDefaultToolkit().getScreenSize().width  - mainFrame.getMinimumSize().width) / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height - mainFrame.getMinimumSize().height) / 2,
				mainFrame.getMinimumSize().width, mainFrame.getMinimumSize().height);
		mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		JMenuBar mainMenuBar = new JMenuBar();
		mainFrame.setJMenuBar(mainMenuBar);
		
		JMenu mnuFile = new JMenu("File");
		mainMenuBar.add(mnuFile);
		
		fileMnuItmExit = new JMenuItem("Exit");
		mnuFile.add(fileMnuItmExit);
		
		JMenu mnuPatient = new JMenu("Patients");
		mainMenuBar.add(mnuPatient);
		
		patientMnuItmAdd = new JMenuItem("Add Patients");
		mnuPatient.add(patientMnuItmAdd);
		
		patientMnuItmList = new JMenuItem("Patients List");
		mnuPatient.add(patientMnuItmList);
		
		patientMnuItmSearch = new JMenuItem("Search Patients");
		mnuPatient.add(patientMnuItmSearch);
		
		JMenu mnuDoctor = new JMenu("Doctors");
		mainMenuBar.add(mnuDoctor);
		
		doctorMnuItmAdd = new JMenuItem("Add Doctors");
		mnuDoctor.add(doctorMnuItmAdd);
		
		doctorMnuItmList = new JMenuItem("Doctors List");
		mnuDoctor.add(doctorMnuItmList);
		
		doctorMnuItmSearch = new JMenuItem("Search Doctors");
		mnuDoctor.add(doctorMnuItmSearch);
		
		JLabel lblAppTitle = new JLabel("Tiny Clinic");
		lblAppTitle.setToolTipText("Tiny Clinic");
		lblAppTitle.setIcon(new ImageIcon(MainFrame.class.getResource("/sCMS/resources/medicalPills_64.png")));
		lblAppTitle.setForeground(new Color(25, 25, 112));
		lblAppTitle.setFont(new Font("Segoe UI", Font.PLAIN, 38));
		
		JPanel panelMain = new JPanel();
		panelMain.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		lblCurrentTime = new JLabel("Current Time: 00:00:00 AM, 1 Jan, 1970");
		lblCurrentTime.setToolTipText("Current Time");
		lblCurrentTime.setFont(new Font("Dialog", Font.BOLD, 14));
		GroupLayout groupLayout = new GroupLayout(mainFrame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelMain, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblAppTitle)
							.addPreferredGap(ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
							.addComponent(lblCurrentTime)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAppTitle)
						.addComponent(lblCurrentTime, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(panelMain, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(61, Short.MAX_VALUE))
		);
		
		btnPatientReg = new JButton("Add Patients");
		btnPatientReg.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPatientReg.setForeground(new Color(255, 255, 255));
		btnPatientReg.setBackground(new Color(25, 25, 112));
		btnPatientReg.setIcon(new ImageIcon(MainFrame.class.getResource("/sCMS/resources/medicalAddPatient_64.png")));
		btnPatientReg.setToolTipText("New Patient Registration");
		
		btnPatientList = new JButton("Patients List");
		btnPatientList.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPatientList.setForeground(new Color(255, 255, 255));
		btnPatientList.setBackground(new Color(25, 25, 112));
		btnPatientList.setIcon(new ImageIcon(MainFrame.class.getResource("/sCMS/resources/medicalReportPatient_64.png")));
		btnPatientList.setToolTipText("Registered Patients List");
		
		btnPatientSearch = new JButton("Search Patients");
		btnPatientSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPatientSearch.setIcon(new ImageIcon(MainFrame.class.getResource("/sCMS/resources/medicalSearchPatient_64.png")));
		btnPatientSearch.setForeground(new Color(255, 255, 255));
		btnPatientSearch.setBackground(new Color(25, 25, 112));
		btnPatientSearch.setToolTipText("Registered Patient Search");
		
		btnDoctorReg = new JButton("Add Doctors");
		btnDoctorReg.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDoctorReg.setBackground(new Color(25, 25, 112));
		btnDoctorReg.setForeground(new Color(255, 255, 255));
		btnDoctorReg.setIcon(new ImageIcon(MainFrame.class.getResource("/sCMS/resources/medicalAddDoctor_64.png")));
		btnDoctorReg.setToolTipText("New Doctor Registration");
		
		btnDoctorList = new JButton("Doctors List");
		btnDoctorList.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDoctorList.setBackground(new Color(25, 25, 112));
		btnDoctorList.setForeground(new Color(255, 255, 255));
		btnDoctorList.setIcon(new ImageIcon(MainFrame.class.getResource("/sCMS/resources/medicalReportDoctor_64.png")));
		btnDoctorList.setToolTipText("Registered Doctors List");
		
		btnDoctorSearch = new JButton("Search Doctors");
		btnDoctorSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDoctorSearch.setIcon(new ImageIcon(MainFrame.class.getResource("/sCMS/resources/medicalSearchDoctor_64.png")));
		btnDoctorSearch.setForeground(new Color(255, 255, 255));
		btnDoctorSearch.setBackground(new Color(25, 25, 112));
		btnDoctorSearch.setToolTipText("Registered Doctor Search");
		GroupLayout gl_panelMain = new GroupLayout(panelMain);
		gl_panelMain.setHorizontalGroup(
			gl_panelMain.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMain.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelMain.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelMain.createSequentialGroup()
							.addComponent(btnPatientReg, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnPatientList, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnPatientSearch, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panelMain.createSequentialGroup()
							.addComponent(btnDoctorReg, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(12)
							.addComponent(btnDoctorList, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
							.addGap(12)
							.addComponent(btnDoctorSearch, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panelMain.setVerticalGroup(
			gl_panelMain.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelMain.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelMain.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(btnPatientReg, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPatientSearch, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPatientList, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelMain.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnDoctorReg, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDoctorList, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDoctorSearch, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
					.addGap(13))
		);
		panelMain.setLayout(gl_panelMain);
		mainFrame.getContentPane().setLayout(groupLayout);
	}
}
