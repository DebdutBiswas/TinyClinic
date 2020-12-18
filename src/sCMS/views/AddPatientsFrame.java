package sCMS.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.JCheckBox;

public class AddPatientsFrame {

	public JFrame addPatientsFrame;
	public JLabel lblCurrentDate;
	public JTextField txtName;
	public JTextField txtAge;
	public JTextField txtPhone;
	public JTextArea txtAreaAddress;
	public JTextArea txtAreaSummary;
	private final ButtonGroup btgGender = new ButtonGroup();
	public JRadioButton rdbtnGenderFemale;
	public JRadioButton rdbtnGenderMale;
	public JRadioButton rdbtnGenderOther;
	public JComboBox<String> comboBoxAssignedDoctor;
	public JComboBox<String> comboBoxAppoinmentDate;
	public JCheckBox chkNextSevenDays;
	public JButton btnNew;
	public JButton btnClear;
	public JButton btnSave;
	public JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPatientsFrame window = new AddPatientsFrame();
					window.addPatientsFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddPatientsFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		addPatientsFrame = new JFrame();
		addPatientsFrame.setMinimumSize(new Dimension(640, 480));
		addPatientsFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(AddPatientsFrame.class.getResource("/sCMS/resources/medicalPotiPlls_64.png")));
		addPatientsFrame.setTitle("Add Patients");
		addPatientsFrame.setBounds(
				(Toolkit.getDefaultToolkit().getScreenSize().width  - addPatientsFrame.getMinimumSize().width) / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height - addPatientsFrame.getMinimumSize().height) / 2,
				addPatientsFrame.getMinimumSize().width, addPatientsFrame.getMinimumSize().height);
		
		JMenuBar mainMenuBar = new JMenuBar();
		addPatientsFrame.setJMenuBar(mainMenuBar);
		
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
		lblName.setLabelFor(txtName);
		txtName.setToolTipText("Enter Patient's Full Name");
		txtName.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtName.setColumns(10);
		txtName.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Dialog", Font.BOLD, 16));
		
		txtAge = new JTextField();
		lblAge.setLabelFor(txtAge);
		txtAge.setToolTipText("Enter Patient's Age");
		txtAge.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtAge.setColumns(10);
		txtAge.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblPhone = new JLabel("Phone No.:");
		lblPhone.setFont(new Font("Dialog", Font.BOLD, 16));
		
		txtPhone = new JTextField();
		lblPhone.setLabelFor(txtPhone);
		txtPhone.setToolTipText("Enter Patient's Phone Number");
		txtPhone.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtPhone.setColumns(10);
		txtPhone.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		rdbtnGenderFemale = new JRadioButton("Female");
		rdbtnGenderFemale.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnGenderFemale.setToolTipText("Female");
		rdbtnGenderFemale.setSelected(true);
		btgGender.add(rdbtnGenderFemale);
		rdbtnGenderFemale.setFont(new Font("Dialog", Font.BOLD, 16));
		
		rdbtnGenderMale = new JRadioButton("Male");
		rdbtnGenderMale.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnGenderMale.setToolTipText("Male");
		btgGender.add(rdbtnGenderMale);
		rdbtnGenderMale.setFont(new Font("Dialog", Font.BOLD, 16));
		
		rdbtnGenderOther = new JRadioButton("Others");
		rdbtnGenderOther.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnGenderOther.setToolTipText("Other Genders");
		btgGender.add(rdbtnGenderOther);
		rdbtnGenderOther.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblAssignedDoctor = new JLabel("Assigned Doctor:");
		lblAssignedDoctor.setFont(new Font("Dialog", Font.BOLD, 16));
		
		comboBoxAssignedDoctor = new JComboBox<>();
		comboBoxAssignedDoctor.setToolTipText("Select Patient's Assigned Doctor");
		lblAssignedDoctor.setLabelFor(comboBoxAssignedDoctor);
		comboBoxAssignedDoctor.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblAppoinmentDate = new JLabel("Appoinment Date:");
		lblAppoinmentDate.setFont(new Font("Dialog", Font.BOLD, 16));
		
		comboBoxAppoinmentDate = new JComboBox<>();
		comboBoxAppoinmentDate.setToolTipText("Select Patient's Next Appoinment Day");
		lblAppoinmentDate.setLabelFor(comboBoxAppoinmentDate);
		comboBoxAppoinmentDate.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblSummary = new JLabel("Summary:");
		lblSummary.setFont(new Font("Dialog", Font.BOLD, 12));
		
		JScrollPane scrollPaneSummary = new JScrollPane();
		scrollPaneSummary.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		btnNew = new JButton("New");
		btnNew.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNew.setToolTipText("New Record");
		
		btnClear = new JButton("Clear");
		btnClear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClear.setToolTipText("Clear Fields");
		
		btnSave = new JButton("Save");
		btnSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSave.setToolTipText("Save Record");
		
		lblStatus = new JLabel("Status: Not Saved");
		lblStatus.setToolTipText("Current Operation Status");
		lblStatus.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Dialog", Font.BOLD, 12));
		
		JScrollPane scrollPaneAddress = new JScrollPane();
		scrollPaneAddress.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		chkNextSevenDays = new JCheckBox("Next 7 Days");
		chkNextSevenDays.setToolTipText("Select Dates From Next 7 Days");
		chkNextSevenDays.setFont(new Font("Dialog", Font.BOLD, 16));
		
		GroupLayout mainGroupLayout = new GroupLayout(addPatientsFrame.getContentPane());
		mainGroupLayout.setHorizontalGroup(
			mainGroupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(mainGroupLayout.createSequentialGroup()
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(mainGroupLayout.createSequentialGroup()
							.addGap(0)
							.addGroup(mainGroupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(mainGroupLayout.createSequentialGroup()
									.addGap(12)
									.addComponent(lblAssignedDoctor)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(comboBoxAssignedDoctor, 0, 448, Short.MAX_VALUE))
								.addGroup(mainGroupLayout.createSequentialGroup()
									.addGap(36)
									.addGroup(mainGroupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblAge)
										.addComponent(lblGender)
										.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
									.addGap(9)
									.addGroup(mainGroupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(mainGroupLayout.createSequentialGroup()
											.addGap(12)
											.addComponent(rdbtnGenderFemale)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(rdbtnGenderMale, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(rdbtnGenderOther, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
										.addComponent(txtAge, GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
										.addComponent(txtName, GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)))
								.addGroup(mainGroupLayout.createSequentialGroup()
									.addGap(12)
									.addComponent(lblPhone)
									.addGap(9)
									.addComponent(txtPhone, GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE))))
						.addGroup(Alignment.LEADING, mainGroupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAppoinmentDate)
							.addGap(14)
							.addComponent(comboBoxAppoinmentDate, 0, 334, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(chkNextSevenDays))
						.addGroup(mainGroupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblStatus, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
							.addComponent(btnNew, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
						.addGroup(mainGroupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(mainGroupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPaneAddress, GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(mainGroupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(mainGroupLayout.createSequentialGroup()
									.addComponent(lblSummary, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(235))
								.addComponent(scrollPaneSummary, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)))
						.addGroup(mainGroupLayout.createSequentialGroup()
							.addContainerGap(437, Short.MAX_VALUE)
							.addComponent(lblCurrentDate)))
					.addContainerGap())
		);
		mainGroupLayout.setVerticalGroup(
			mainGroupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(mainGroupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCurrentDate, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtAge, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAge, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGender, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnGenderFemale)
						.addComponent(rdbtnGenderMale, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnGenderOther, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPhone, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAssignedDoctor, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxAssignedDoctor, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAppoinmentDate, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxAppoinmentDate, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(chkNextSevenDays, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSummary, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(1)
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPaneAddress, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
						.addComponent(scrollPaneSummary, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(mainGroupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNew)
							.addComponent(lblStatus, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnClear)
						.addComponent(btnSave))
					.addContainerGap())
		);
		
		txtAreaAddress = new JTextArea();
		txtAreaAddress.setToolTipText("Enter Patient's Summary");
		txtAreaAddress.setFont(new Font("Dialog", Font.PLAIN, 16));
		scrollPaneAddress.setViewportView(txtAreaAddress);
		
		txtAreaSummary = new JTextArea();
		txtAreaSummary.setToolTipText("Enter Patient's Summary");
		lblSummary.setLabelFor(txtAreaSummary);
		txtAreaSummary.setFont(new Font("Dialog", Font.PLAIN, 16));
		scrollPaneSummary.setViewportView(txtAreaSummary);
		addPatientsFrame.getContentPane().setLayout(mainGroupLayout);
	}
}
