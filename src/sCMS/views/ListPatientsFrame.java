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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;

public class ListPatientsFrame {

	public JFrame listPatientsFrame;
	public JLabel lblCurrentDate;
	public JTable tblPatientsList;
	public JTextField txtName;
	public JTextField txtAge;
	private final ButtonGroup btgGender = new ButtonGroup();
	public JRadioButton rdbtnGenderFemale;
	public JRadioButton rdbtnGenderMale;
	public JRadioButton rdbtnGenderOther;
	public JTextField txtPhone;
	public JComboBox<String> comboBoxAssignedDoctor;
	public JComboBox<String> comboBoxAppoinmentDate;
	public JCheckBox chkNextSevenDays;
	public JTextArea txtAreaAddress;
	public JTextArea txtAreaSummary;
	public JButton btnRefresh;
	public JButton btnDelete;
	public JButton btnUpdate;
	public JButton btnNew;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListPatientsFrame window = new ListPatientsFrame();
					window.listPatientsFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListPatientsFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		listPatientsFrame = new JFrame();
		listPatientsFrame.setMinimumSize(new Dimension(1024, 640));
		listPatientsFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(ListPatientsFrame.class.getResource("/sCMS/resources/medicalReport_64.png")));
		listPatientsFrame.setTitle("Appointed Patients");
		listPatientsFrame.setBounds(
				(Toolkit.getDefaultToolkit().getScreenSize().width  - listPatientsFrame.getMinimumSize().width) / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height - listPatientsFrame.getMinimumSize().height) / 2,
				listPatientsFrame.getMinimumSize().width, listPatientsFrame.getMinimumSize().height);
		
		JMenuBar mainMenuBar = new JMenuBar();
		listPatientsFrame.setJMenuBar(mainMenuBar);
		
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
		
		JMenuItem fileMnuItmUpdate = new JMenuItem("Update");
		mnuEdit.add(fileMnuItmUpdate);
		
		JMenuItem editMnuItmDelete = new JMenuItem("Delete");
		mnuEdit.add(editMnuItmDelete);
		
		JLabel lblDescription = new JLabel("List of app. Patients:");
		lblDescription.setToolTipText("");
		lblDescription.setFont(new Font("Dialog", Font.BOLD, 14));
		
		lblCurrentDate = new JLabel("Current Date: 1 Jan, 1970");
		lblCurrentDate.setToolTipText("Current Date");
		lblCurrentDate.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JScrollPane scrollPanePatientsList = new JScrollPane();
		scrollPanePatientsList.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		btnDelete = new JButton("Delete");
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setToolTipText("Delete Record");
		
		btnUpdate = new JButton("Update");
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setToolTipText("Update Record");
		
		btnNew = new JButton("New");
		btnNew.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNew.setToolTipText("New Record");
		
		JPanel panelUpdateForm = new JPanel();
		panelUpdateForm.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRefresh.setToolTipText("Refresh Records Table");
		GroupLayout mainGroupLayout = new GroupLayout(listPatientsFrame.getContentPane());
		mainGroupLayout.setHorizontalGroup(
			mainGroupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(mainGroupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(mainGroupLayout.createSequentialGroup()
							.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNew, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
						.addGroup(mainGroupLayout.createSequentialGroup()
							.addComponent(scrollPanePatientsList, GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelUpdateForm, GroupLayout.PREFERRED_SIZE, 490, GroupLayout.PREFERRED_SIZE))
						.addGroup(mainGroupLayout.createSequentialGroup()
							.addComponent(lblDescription, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 655, Short.MAX_VALUE)
							.addComponent(lblCurrentDate)))
					.addContainerGap())
		);
		mainGroupLayout.setVerticalGroup(
			mainGroupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(mainGroupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDescription, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCurrentDate, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelUpdateForm, GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
						.addComponent(scrollPanePatientsList, GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(mainGroupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnDelete)
							.addComponent(btnRefresh))
						.addComponent(btnUpdate)
						.addComponent(btnNew))
					.addContainerGap())
		);
		
		JLabel lblAssignedDoctor = new JLabel("Assigned Doctor:");
		lblAssignedDoctor.setFont(new Font("Dialog", Font.BOLD, 16));
		
		comboBoxAssignedDoctor = new JComboBox<String>();
		comboBoxAssignedDoctor.setToolTipText("Select Patient's Assigned Doctor");
		comboBoxAssignedDoctor.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Dialog", Font.BOLD, 16));
		
		rdbtnGenderFemale = new JRadioButton("Female");
		btgGender.add(rdbtnGenderFemale);
		rdbtnGenderFemale.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnGenderFemale.setToolTipText("Female");
		rdbtnGenderFemale.setSelected(true);
		rdbtnGenderFemale.setFont(new Font("Dialog", Font.BOLD, 16));
		
		rdbtnGenderMale = new JRadioButton("Male");
		btgGender.add(rdbtnGenderMale);
		rdbtnGenderMale.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnGenderMale.setToolTipText("Male");
		rdbtnGenderMale.setFont(new Font("Dialog", Font.BOLD, 16));
		
		rdbtnGenderOther = new JRadioButton("Others");
		btgGender.add(rdbtnGenderOther);
		rdbtnGenderOther.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdbtnGenderOther.setToolTipText("Other Genders");
		rdbtnGenderOther.setFont(new Font("Dialog", Font.BOLD, 16));
		
		txtAge = new JTextField();
		txtAge.setToolTipText("Enter Patient's Age");
		txtAge.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtAge.setColumns(10);
		txtAge.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		txtName = new JTextField();
		txtName.setToolTipText("Enter Patient's Full Name");
		txtName.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtName.setColumns(10);
		txtName.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblPhone = new JLabel("Phone No.:");
		lblPhone.setFont(new Font("Dialog", Font.BOLD, 16));
		
		txtPhone = new JTextField();
		txtPhone.setToolTipText("Enter Patient's Phone Number");
		txtPhone.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtPhone.setColumns(10);
		txtPhone.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblAppoinmentDate = new JLabel("Appoinment Date:");
		lblAppoinmentDate.setFont(new Font("Dialog", Font.BOLD, 16));
		
		comboBoxAppoinmentDate = new JComboBox<String>();
		comboBoxAppoinmentDate.setToolTipText("Select Patient's Next Appoinment Day");
		comboBoxAppoinmentDate.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Dialog", Font.BOLD, 12));
		
		JScrollPane scrollPaneAddress = new JScrollPane();
		scrollPaneAddress.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblSummary = new JLabel("Summary:");
		lblSummary.setFont(new Font("Dialog", Font.BOLD, 12));
		
		JScrollPane scrollPaneSummary = new JScrollPane();
		scrollPaneSummary.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		chkNextSevenDays = new JCheckBox("Next 7 Days");
		chkNextSevenDays.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		chkNextSevenDays.setToolTipText("Select Dates From Next 7 Days");
		chkNextSevenDays.setFont(new Font("Dialog", Font.BOLD, 16));
		GroupLayout gl_panelUpdateForm = new GroupLayout(panelUpdateForm);
		gl_panelUpdateForm.setHorizontalGroup(
			gl_panelUpdateForm.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelUpdateForm.createSequentialGroup()
					.addGap(12)
					.addGroup(gl_panelUpdateForm.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSummary, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPaneAddress, GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
						.addGroup(gl_panelUpdateForm.createSequentialGroup()
							.addComponent(lblAppoinmentDate, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(comboBoxAppoinmentDate, 0, 189, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(chkNextSevenDays, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelUpdateForm.createSequentialGroup()
							.addComponent(lblAssignedDoctor, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(comboBoxAssignedDoctor, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPaneSummary, GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
						.addGroup(gl_panelUpdateForm.createSequentialGroup()
							.addGroup(gl_panelUpdateForm.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelUpdateForm.createSequentialGroup()
									.addGap(36)
									.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelUpdateForm.createSequentialGroup()
									.addGap(24)
									.addGroup(gl_panelUpdateForm.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblAge, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblGender, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)))
								.addComponent(lblPhone, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
							.addGap(9)
							.addGroup(gl_panelUpdateForm.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panelUpdateForm.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_panelUpdateForm.createSequentialGroup()
										.addGap(9)
										.addComponent(rdbtnGenderFemale, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(rdbtnGenderMale, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(rdbtnGenderOther, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
									.addComponent(txtName, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
									.addComponent(txtAge)))))
					.addContainerGap())
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
					.addGap(13)
					.addGroup(gl_panelUpdateForm.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAge, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtAge, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_panelUpdateForm.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGender, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnGenderFemale, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnGenderMale, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnGenderOther, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panelUpdateForm.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelUpdateForm.createSequentialGroup()
							.addGap(9)
							.addComponent(lblPhone, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelUpdateForm.createSequentialGroup()
							.addGap(8)
							.addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelUpdateForm.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelUpdateForm.createSequentialGroup()
							.addGap(14)
							.addComponent(lblAssignedDoctor, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelUpdateForm.createSequentialGroup()
							.addGap(12)
							.addComponent(comboBoxAssignedDoctor, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panelUpdateForm.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelUpdateForm.createSequentialGroup()
							.addGap(14)
							.addComponent(lblAppoinmentDate, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelUpdateForm.createSequentialGroup()
							.addGap(12)
							.addGroup(gl_panelUpdateForm.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBoxAppoinmentDate, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(chkNextSevenDays, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(scrollPaneAddress, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(lblSummary, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(scrollPaneSummary, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
					.addGap(32))
		);
		
		txtAreaSummary = new JTextArea();
		txtAreaSummary.setToolTipText("Enter Patient's Summary");
		txtAreaSummary.setFont(new Font("Dialog", Font.PLAIN, 16));
		scrollPaneSummary.setViewportView(txtAreaSummary);
		
		txtAreaAddress = new JTextArea();
		txtAreaAddress.setToolTipText("Enter Patient's Summary");
		txtAreaAddress.setFont(new Font("Dialog", Font.PLAIN, 16));
		scrollPaneAddress.setViewportView(txtAreaAddress);
		panelUpdateForm.setLayout(gl_panelUpdateForm);
		
		tblPatientsList = new JTable(new String[][] {}, new String[] {"Serial No.", "Name", "Age", "Gender", "Ph. No.", "Assigned Doctor", "Appoinment Date", "Last Appoinment", "Address", "Summary"});
		scrollPanePatientsList.setViewportView(tblPatientsList);
		listPatientsFrame.getContentPane().setLayout(mainGroupLayout);
	}
}
