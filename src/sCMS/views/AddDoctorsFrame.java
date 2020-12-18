package sCMS.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

public class AddDoctorsFrame {

	public JFrame addDoctorsFrame;
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
	public JLabel lblStatus;
	public JLabel lblCurrentDate;
	public JButton btnNew;
	public JButton btnClear;
	public JButton btnSave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDoctorsFrame window = new AddDoctorsFrame();
					window.addDoctorsFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddDoctorsFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		addDoctorsFrame = new JFrame();
		addDoctorsFrame.setMinimumSize(new Dimension(640, 480));
		addDoctorsFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(AddDoctorsFrame.class.getResource("/sCMS/resources/medicalSuitecase_64.png")));
		addDoctorsFrame.setTitle("Add Doctors");
		addDoctorsFrame.setBounds(
				(Toolkit.getDefaultToolkit().getScreenSize().width  - addDoctorsFrame.getMinimumSize().width) / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height - addDoctorsFrame.getMinimumSize().height) / 2,
				addDoctorsFrame.getMinimumSize().width, addDoctorsFrame.getMinimumSize().height);
		
		JMenuBar mainMenuBar = new JMenuBar();
		addDoctorsFrame.setJMenuBar(mainMenuBar);
		
		JMenu mnuFile = new JMenu("File");
		mainMenuBar.add(mnuFile);
		
		JMenuItem fileMnuItmNew = new JMenuItem("New");
		mnuFile.add(fileMnuItmNew);
		
		JMenuItem fileMnuItmSave = new JMenuItem("Save");
		mnuFile.add(fileMnuItmSave);
		
		JMenuItem fileMnuItmSep1 = new JMenuItem("------------");
		fileMnuItmSep1.setEnabled(false);
		mnuFile.add(fileMnuItmSep1);
		
		JMenuItem fileMnuItmClose = new JMenuItem("Close");
		mnuFile.add(fileMnuItmClose);
		
		JMenuItem fileMnuItmExit = new JMenuItem("Exit");
		mnuFile.add(fileMnuItmExit);
		
		JMenu mnuEdit = new JMenu("Edit");
		mainMenuBar.add(mnuEdit);
		
		JMenuItem editMnuItmClear = new JMenuItem("Clear");
		mnuEdit.add(editMnuItmClear);
		
		lblCurrentDate = new JLabel("Current Date: 1 Jan, 1970");
		lblCurrentDate.setToolTipText("Current Date");
		lblCurrentDate.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Dialog", Font.BOLD, 16));
		
		txtName = new JTextField();
		txtName.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtName.setToolTipText("Enter Doctor's Full Name");
		lblName.setLabelFor(txtName);
		txtName.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtName.setColumns(10);
		
		JLabel lblSpeciality = new JLabel("Speciality:");
		lblSpeciality.setFont(new Font("Dialog", Font.BOLD, 16));
		
		txtSpeciality = new JTextField();
		txtSpeciality.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtSpeciality.setToolTipText("Enter Doctor's Speciality");
		lblSpeciality.setLabelFor(txtSpeciality);
		txtSpeciality.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtSpeciality.setColumns(10);
		
		JLabel lblDesignation = new JLabel("Designation:");
		lblDesignation.setFont(new Font("Dialog", Font.BOLD, 16));
		
		txtDesignation = new JTextField();
		txtDesignation.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtDesignation.setToolTipText("Enter Doctor's Designation");
		lblDesignation.setLabelFor(txtDesignation);
		txtDesignation.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtDesignation.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone No.:");
		lblPhone.setFont(new Font("Dialog", Font.BOLD, 16));
		
		txtPhone = new JTextField();
		txtPhone.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtPhone.setToolTipText("Enter Doctor's Phone Number");
		lblPhone.setLabelFor(txtPhone);
		txtPhone.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtPhone.setColumns(10);
		
		JLabel lblWeeklyVisitDays = new JLabel("Weekly Visits:");
		lblWeeklyVisitDays.setFont(new Font("Dialog", Font.BOLD, 16));
		
		chkMonday = new JCheckBox("Mo");
		chkMonday.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		chkMonday.setToolTipText("Monday");
		chkMonday.setFont(new Font("Dialog", Font.BOLD, 16));
		
		chkTuesday = new JCheckBox("Tu");
		chkTuesday.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		chkTuesday.setToolTipText("Tuesday");
		chkTuesday.setFont(new Font("Dialog", Font.BOLD, 16));
		
		chkWednesday = new JCheckBox("We");
		chkWednesday.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		chkWednesday.setToolTipText("Wednesday");
		chkWednesday.setFont(new Font("Dialog", Font.BOLD, 16));
		
		chkThursday = new JCheckBox("Th");
		chkThursday.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		chkThursday.setToolTipText("Thursday");
		chkThursday.setFont(new Font("Dialog", Font.BOLD, 16));
		
		chkFriday = new JCheckBox("Fr");
		chkFriday.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		chkFriday.setToolTipText("Friday");
		chkFriday.setFont(new Font("Dialog", Font.BOLD, 16));
		
		chkSaturday = new JCheckBox("Sa");
		chkSaturday.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		chkSaturday.setToolTipText("Saturday");
		chkSaturday.setFont(new Font("Dialog", Font.BOLD, 16));
		
		chkSunday = new JCheckBox("Su");
		chkSunday.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		chkSunday.setToolTipText("Sunday");
		chkSunday.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JScrollPane scrollPaneAddress = new JScrollPane();
		scrollPaneAddress.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		btnNew = new JButton("New");
		btnNew.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNew.setToolTipText("New Record");
		
		btnClear = new JButton("Clear");
		btnClear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClear.setToolTipText("Clear Fields");
		
		btnSave = new JButton("Save");
		btnSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSave.setToolTipText("Save Record");
		
		lblStatus = new JLabel("Status: New");
		lblStatus.setToolTipText("Current Operation Status");
		lblStatus.setFont(new Font("Dialog", Font.BOLD, 14));
		GroupLayout mainGroupLayout = new GroupLayout(addDoctorsFrame.getContentPane());
		mainGroupLayout.setHorizontalGroup(
			mainGroupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(mainGroupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(mainGroupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 446, Short.MAX_VALUE)
							.addComponent(lblCurrentDate))
						.addGroup(mainGroupLayout.createSequentialGroup()
							.addComponent(lblAddress)
							.addGap(37)
							.addComponent(scrollPaneAddress, GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE))
						.addGroup(mainGroupLayout.createSequentialGroup()
							.addGroup(mainGroupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblWeeklyVisitDays)
								.addGroup(mainGroupLayout.createSequentialGroup()
									.addGroup(mainGroupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblSpeciality)
										.addComponent(lblDesignation)
										.addComponent(lblName)
										.addComponent(lblPhone))
									.addGap(9)))
							.addGroup(mainGroupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(mainGroupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(chkMonday)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(chkTuesday)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(chkWednesday)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(chkThursday, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(chkFriday, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(chkSaturday, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(chkSunday, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtPhone, GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
								.addComponent(txtSpeciality, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
								.addComponent(txtDesignation, GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
								.addComponent(txtName, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)))
						.addGroup(mainGroupLayout.createSequentialGroup()
							.addComponent(lblStatus)
							.addPreferredGap(ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
							.addComponent(btnNew, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		mainGroupLayout.setVerticalGroup(
			mainGroupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(mainGroupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCurrentDate)
					.addGap(18)
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtSpeciality, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSpeciality, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDesignation)
						.addComponent(txtDesignation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPhone, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWeeklyVisitDays)
						.addComponent(chkMonday)
						.addComponent(chkTuesday)
						.addComponent(chkWednesday, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(chkFriday, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(chkThursday, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(chkSaturday, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(chkSunday, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAddress)
						.addComponent(scrollPaneAddress, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
					.addGap(12)
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnClear)
						.addComponent(btnNew)
						.addComponent(lblStatus))
					.addContainerGap())
		);
		
		txtAreaAddress = new JTextArea();
		txtAreaAddress.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblAddress.setLabelFor(txtAreaAddress);
		txtAreaAddress.setToolTipText("Enter Doctor's Address");
		scrollPaneAddress.setViewportView(txtAreaAddress);
		addDoctorsFrame.getContentPane().setLayout(mainGroupLayout);
	}
}