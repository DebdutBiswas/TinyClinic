package sCMS.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class ListDoctorsFrame {

	public JFrame listDoctorsFrame;
	public JLabel lblCurrentDate;
	public JTable tblDoctorsList;
	public JTextField txtName;
	public JTextField txtSpeciality;
	public JTextField txtDesignation;
	public JTextField txtPhone;
	public JCheckBox chkMonday;
	public JCheckBox chkTuesday;
	public JCheckBox chkWednesday;
	public JCheckBox chkThursday;
	public JCheckBox chkFriday;
	public JCheckBox chkSaturday;
	public JCheckBox chkSunday;
	public JTextArea txtAreaAddress;
	public JButton btnDelete;
	public JButton btnUpdate;
	public JButton btnNew;
	public JButton btnRefresh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListDoctorsFrame window = new ListDoctorsFrame();
					window.listDoctorsFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListDoctorsFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		listDoctorsFrame = new JFrame();
		listDoctorsFrame.setMinimumSize(new Dimension(1024, 640));
		listDoctorsFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(ListDoctorsFrame.class.getResource("/sCMS/resources/medicalReport_64.png")));
		listDoctorsFrame.setTitle("Registered Doctors");
		listDoctorsFrame.setBounds(
				(Toolkit.getDefaultToolkit().getScreenSize().width  - listDoctorsFrame.getMinimumSize().width) / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height - listDoctorsFrame.getMinimumSize().height) / 2,
				listDoctorsFrame.getMinimumSize().width, listDoctorsFrame.getMinimumSize().height);
		
		JMenuBar mainMenuBar = new JMenuBar();
		listDoctorsFrame.setJMenuBar(mainMenuBar);
		
		JMenu mnuFile = new JMenu("File");
		mainMenuBar.add(mnuFile);
		
		JMenuItem fileMnuItmNew = new JMenuItem("New");
		mnuFile.add(fileMnuItmNew);
		
		JMenuItem fileMnuItmSep1 = new JMenuItem("------------");
		fileMnuItmSep1.setEnabled(false);
		mnuFile.add(fileMnuItmSep1);
		
		JMenuItem fileMnuItmClose = new JMenuItem("Close");
		mnuFile.add(fileMnuItmClose);
		
		JMenuItem fileMnuItmExit = new JMenuItem("Exit");
		mnuFile.add(fileMnuItmExit);
		
		JMenu mnuEdit = new JMenu("Edit");
		mainMenuBar.add(mnuEdit);
		
		JMenuItem editMnuItmUpdate = new JMenuItem("Update");
		mnuEdit.add(editMnuItmUpdate);
		
		JMenuItem editMnuItmDelete = new JMenuItem("Delete");
		mnuEdit.add(editMnuItmDelete);
		
		lblCurrentDate = new JLabel("Current Date: 1 Jan, 1970");
		lblCurrentDate.setToolTipText("Current Date");
		lblCurrentDate.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JScrollPane scrollPaneDoctorsList = new JScrollPane();
		scrollPaneDoctorsList.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		btnDelete = new JButton("Delete");
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setToolTipText("Delete Record");
		
		btnUpdate = new JButton("Update");
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setToolTipText("Update Record");
		
		btnNew = new JButton("New");
		btnNew.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNew.setToolTipText("New Record");
		
		JLabel lblDescription = new JLabel("List of reg. Doctors:");
		lblDescription.setToolTipText("");
		lblDescription.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JPanel panelUpdateForm = new JPanel();
		panelUpdateForm.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRefresh.setToolTipText("Refresh Records Table");
		GroupLayout mainGroupLayout = new GroupLayout(listDoctorsFrame.getContentPane());
		mainGroupLayout.setHorizontalGroup(
			mainGroupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(mainGroupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(mainGroupLayout.createSequentialGroup()
							.addComponent(lblDescription, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 655, Short.MAX_VALUE)
							.addComponent(lblCurrentDate))
						.addGroup(mainGroupLayout.createSequentialGroup()
							.addComponent(scrollPaneDoctorsList, GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelUpdateForm, GroupLayout.PREFERRED_SIZE, 487, GroupLayout.PREFERRED_SIZE))
						.addGroup(mainGroupLayout.createSequentialGroup()
							.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNew, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		mainGroupLayout.setVerticalGroup(
			mainGroupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(mainGroupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCurrentDate, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDescription, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelUpdateForm, GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
						.addComponent(scrollPaneDoctorsList, GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE))
					.addGap(12)
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(mainGroupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnDelete)
							.addComponent(btnRefresh))
						.addComponent(btnUpdate)
						.addComponent(btnNew))
					.addContainerGap())
		);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JScrollPane scrollPaneAddress = new JScrollPane();
		scrollPaneAddress.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblWeeklyVisitDays = new JLabel("Weekly Visits:");
		lblWeeklyVisitDays.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblSpeciality = new JLabel("Speciality:");
		lblSpeciality.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblDesignation = new JLabel("Designation:");
		lblDesignation.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblPhone = new JLabel("Phone No.:");
		lblPhone.setFont(new Font("Dialog", Font.BOLD, 16));
		
		chkMonday = new JCheckBox("Mo");
		chkMonday.setToolTipText("Monday");
		chkMonday.setFont(new Font("Dialog", Font.BOLD, 16));
		
		chkTuesday = new JCheckBox("Tu");
		chkTuesday.setToolTipText("Tuesday");
		chkTuesday.setFont(new Font("Dialog", Font.BOLD, 16));
		
		chkWednesday = new JCheckBox("We");
		chkWednesday.setToolTipText("Wednesday");
		chkWednesday.setFont(new Font("Dialog", Font.BOLD, 16));
		
		chkThursday = new JCheckBox("Th");
		chkThursday.setToolTipText("Thursday");
		chkThursday.setFont(new Font("Dialog", Font.BOLD, 16));
		
		chkFriday = new JCheckBox("Fr");
		chkFriday.setToolTipText("Friday");
		chkFriday.setFont(new Font("Dialog", Font.BOLD, 16));
		
		chkSaturday = new JCheckBox("Sa");
		chkSaturday.setToolTipText("Saturday");
		chkSaturday.setFont(new Font("Dialog", Font.BOLD, 16));
		
		chkSunday = new JCheckBox("Su");
		chkSunday.setToolTipText("Sunday");
		chkSunday.setFont(new Font("Dialog", Font.BOLD, 16));
		
		txtPhone = new JTextField();
		txtPhone.setToolTipText("Enter Doctor's Phone Number");
		txtPhone.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtPhone.setColumns(10);
		txtPhone.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		txtSpeciality = new JTextField();
		txtSpeciality.setToolTipText("Enter Doctor's Speciality");
		txtSpeciality.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtSpeciality.setColumns(10);
		txtSpeciality.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		txtDesignation = new JTextField();
		txtDesignation.setToolTipText("Enter Doctor's Designation");
		txtDesignation.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtDesignation.setColumns(10);
		txtDesignation.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		txtName = new JTextField();
		txtName.setToolTipText("Enter Doctor's Full Name");
		txtName.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtName.setColumns(10);
		txtName.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout gl_panelUpdateForm = new GroupLayout(panelUpdateForm);
		gl_panelUpdateForm.setHorizontalGroup(
			gl_panelUpdateForm.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelUpdateForm.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelUpdateForm.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelUpdateForm.createSequentialGroup()
							.addGroup(gl_panelUpdateForm.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelUpdateForm.createSequentialGroup()
									.addComponent(lblWeeklyVisitDays, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
									.addGap(14)
									.addComponent(chkMonday, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(chkTuesday, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(chkWednesday, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(chkThursday, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(chkFriday, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
									.addComponent(chkSaturday, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
									.addComponent(chkSunday, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelUpdateForm.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_panelUpdateForm.createSequentialGroup()
										.addGap(12)
										.addComponent(lblPhone, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
										.addGap(9)
										.addComponent(txtPhone))
									.addGroup(gl_panelUpdateForm.createSequentialGroup()
										.addComponent(lblDesignation, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
										.addGap(9)
										.addComponent(txtDesignation))
									.addGroup(gl_panelUpdateForm.createSequentialGroup()
										.addGap(18)
										.addComponent(lblSpeciality, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
										.addGap(9)
										.addComponent(txtSpeciality))
									.addGroup(gl_panelUpdateForm.createSequentialGroup()
										.addGap(48)
										.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
										.addGap(9)
										.addComponent(txtName, GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE))))
							.addGap(6))
						.addGroup(gl_panelUpdateForm.createSequentialGroup()
							.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
							.addComponent(scrollPaneAddress, GroupLayout.PREFERRED_SIZE, 354, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_panelUpdateForm.setVerticalGroup(
			gl_panelUpdateForm.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelUpdateForm.createSequentialGroup()
					.addGroup(gl_panelUpdateForm.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelUpdateForm.createSequentialGroup()
							.addGap(13)
							.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelUpdateForm.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelUpdateForm.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelUpdateForm.createSequentialGroup()
							.addGap(14)
							.addComponent(lblSpeciality, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelUpdateForm.createSequentialGroup()
							.addGap(12)
							.addComponent(txtSpeciality, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panelUpdateForm.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelUpdateForm.createSequentialGroup()
							.addGap(13)
							.addComponent(lblDesignation, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelUpdateForm.createSequentialGroup()
							.addGap(12)
							.addComponent(txtDesignation, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panelUpdateForm.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelUpdateForm.createSequentialGroup()
							.addGap(14)
							.addComponent(lblPhone, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelUpdateForm.createSequentialGroup()
							.addGap(12)
							.addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addGap(8)
					.addGroup(gl_panelUpdateForm.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelUpdateForm.createSequentialGroup()
							.addGap(4)
							.addComponent(lblWeeklyVisitDays, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addComponent(chkMonday, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(chkTuesday, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(chkWednesday, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(chkThursday, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(chkFriday, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(chkSaturday, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(chkSunday, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_panelUpdateForm.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPaneAddress, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		txtAreaAddress = new JTextArea();
		txtAreaAddress.setFont(new Font("Dialog", Font.PLAIN, 16));
		scrollPaneAddress.setViewportView(txtAreaAddress);
		panelUpdateForm.setLayout(gl_panelUpdateForm);
		
		tblDoctorsList = new JTable(new String[][] {}, new String[] {"Serial No.", "Name", "Speciality", "Designation", "Ph. No.", "Weekly Visits", "Address"});
		scrollPaneDoctorsList.setViewportView(tblDoctorsList);
		listDoctorsFrame.getContentPane().setLayout(mainGroupLayout);
	}
}