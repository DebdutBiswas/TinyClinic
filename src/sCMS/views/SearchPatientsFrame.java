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
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;

public class SearchPatientsFrame {

	public JFrame searchPatientsFrame;
	public JLabel lblCurrentDate;
	public JComboBox<String> comboBoxSearchBy;
	public JTextField txtSearchTerm;
	public JButton btnSearch;
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
	public JButton btnClear;
	public JButton btnDelete;
	public JButton btnUpdate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchPatientsFrame window = new SearchPatientsFrame();
					window.searchPatientsFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SearchPatientsFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		searchPatientsFrame = new JFrame();
		searchPatientsFrame.setMinimumSize(new Dimension(1024, 640));
		searchPatientsFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(SearchPatientsFrame.class.getResource("/sCMS/resources/medicalSearch_64.png")));
		searchPatientsFrame.setTitle("Search Patients");
		searchPatientsFrame.setBounds(
				(Toolkit.getDefaultToolkit().getScreenSize().width  - searchPatientsFrame.getMinimumSize().width) / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height - searchPatientsFrame.getMinimumSize().height) / 2,
				searchPatientsFrame.getMinimumSize().width, searchPatientsFrame.getMinimumSize().height);
		
		JMenuBar mainMenuBar = new JMenuBar();
		searchPatientsFrame.setJMenuBar(mainMenuBar);
		
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
		
		JLabel lblSearchResult = new JLabel("Search Result(s):");
		lblSearchResult.setToolTipText("");
		lblSearchResult.setFont(new Font("Dialog", Font.BOLD, 12));
		
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
		
		JLabel lblSearchBy = new JLabel("Search By:");
		lblSearchBy.setFont(new Font("Dialog", Font.BOLD, 16));
		
		comboBoxSearchBy = new JComboBox<String>();
		comboBoxSearchBy.setModel(new DefaultComboBoxModel<String>(new String[] {"Name", "Ph. No.", "Gender", "Assigned Doctor", "Appoinment Date", "Appoinment Day"}));
		comboBoxSearchBy.setToolTipText("Select a search parameter");
		comboBoxSearchBy.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblSearchTerm = new JLabel("Search Term:");
		lblSearchTerm.setFont(new Font("Dialog", Font.BOLD, 16));
		
		txtSearchTerm = new JTextField();
		txtSearchTerm.setToolTipText("Enter Partial or Full Search Word");
		txtSearchTerm.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtSearchTerm.setColumns(10);
		txtSearchTerm.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		btnSearch = new JButton("Search");
		btnSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch.setToolTipText("Search for Record");
		
		btnClear = new JButton("Clear");
		btnClear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClear.setToolTipText("Clear Search Results");
		
		JPanel panelUpdateForm = new JPanel();
		panelUpdateForm.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout mainGroupLayout = new GroupLayout(searchPatientsFrame.getContentPane());
		mainGroupLayout.setHorizontalGroup(
			mainGroupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(mainGroupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(mainGroupLayout.createSequentialGroup()
							.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
						.addGroup(mainGroupLayout.createSequentialGroup()
							.addGroup(mainGroupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblSearchBy)
								.addComponent(lblSearchTerm))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(mainGroupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(comboBoxSearchBy, 0, 863, Short.MAX_VALUE)
								.addComponent(txtSearchTerm, GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)))
						.addGroup(mainGroupLayout.createSequentialGroup()
							.addComponent(lblSearchResult)
							.addPreferredGap(ComponentPlacement.RELATED, 792, Short.MAX_VALUE)
							.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblCurrentDate)
						.addGroup(mainGroupLayout.createSequentialGroup()
							.addComponent(scrollPanePatientsList, GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelUpdateForm, GroupLayout.PREFERRED_SIZE, 473, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		mainGroupLayout.setVerticalGroup(
			mainGroupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(mainGroupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCurrentDate, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxSearchBy, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSearchBy, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(mainGroupLayout.createSequentialGroup()
							.addGap(13)
							.addComponent(lblSearchTerm, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(mainGroupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtSearchTerm, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnSearch)
						.addComponent(lblSearchResult, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPanePatientsList, GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
						.addComponent(panelUpdateForm, GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(mainGroupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnDelete)
							.addComponent(btnClear))
						.addComponent(btnUpdate))
					.addContainerGap())
		);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Dialog", Font.BOLD, 16));
		
		rdbtnGenderFemale = new JRadioButton("Female");
		rdbtnGenderFemale.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btgGender.add(rdbtnGenderFemale);
		rdbtnGenderFemale.setToolTipText("Female");
		rdbtnGenderFemale.setSelected(true);
		rdbtnGenderFemale.setFont(new Font("Dialog", Font.BOLD, 16));
		
		rdbtnGenderMale = new JRadioButton("Male");
		rdbtnGenderMale.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btgGender.add(rdbtnGenderMale);
		rdbtnGenderMale.setToolTipText("Male");
		rdbtnGenderMale.setFont(new Font("Dialog", Font.BOLD, 16));
		
		rdbtnGenderOther = new JRadioButton("Others");
		rdbtnGenderOther.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btgGender.add(rdbtnGenderOther);
		rdbtnGenderOther.setToolTipText("Other Genders");
		rdbtnGenderOther.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblAppoinmentDate = new JLabel("Appoinment Date:");
		lblAppoinmentDate.setFont(new Font("Dialog", Font.BOLD, 16));
		
		comboBoxAppoinmentDate = new JComboBox<String>();
		comboBoxAppoinmentDate.setToolTipText("Select Patient's Next Appoinment Day");
		comboBoxAppoinmentDate.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblAssignedDoctor = new JLabel("Assigned Doctor:");
		lblAssignedDoctor.setFont(new Font("Dialog", Font.BOLD, 16));
		
		comboBoxAssignedDoctor = new JComboBox<String>();
		comboBoxAssignedDoctor.setToolTipText("Select Patient's Assigned Doctor");
		comboBoxAssignedDoctor.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JLabel lblPhone = new JLabel("Phone No.:");
		lblPhone.setFont(new Font("Dialog", Font.BOLD, 16));
		
		txtPhone = new JTextField();
		txtPhone.setToolTipText("Enter Patient's Phone Number");
		txtPhone.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtPhone.setColumns(10);
		txtPhone.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Dialog", Font.BOLD, 16));
		
		txtAge = new JTextField();
		txtAge.setToolTipText("Enter Patient's Age");
		txtAge.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtAge.setColumns(10);
		txtAge.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Dialog", Font.BOLD, 16));
		
		txtName = new JTextField();
		txtName.setToolTipText("Enter Patient's Full Name");
		txtName.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtName.setColumns(10);
		txtName.setBorder(new LineBorder(new Color(0, 0, 0)));
		
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
					.addContainerGap()
					.addGroup(gl_panelUpdateForm.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelUpdateForm.createSequentialGroup()
							.addGap(36)
							.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(txtName, 353, 353, 353))
						.addGroup(gl_panelUpdateForm.createSequentialGroup()
							.addGap(50)
							.addComponent(lblAge, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(txtAge, 353, 353, 353))
						.addGroup(gl_panelUpdateForm.createSequentialGroup()
							.addGroup(gl_panelUpdateForm.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPaneAddress, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panelUpdateForm.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelUpdateForm.createSequentialGroup()
									.addComponent(lblSummary, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
									.addGap(160))
								.addComponent(scrollPaneSummary, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)))
						.addGroup(gl_panelUpdateForm.createSequentialGroup()
							.addGroup(gl_panelUpdateForm.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblGender, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPhone, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
							.addGap(9)
							.addGroup(gl_panelUpdateForm.createParallelGroup(Alignment.LEADING)
								.addComponent(txtPhone, 353, 353, 353)
								.addGroup(gl_panelUpdateForm.createSequentialGroup()
									.addGap(5)
									.addComponent(rdbtnGenderFemale, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(rdbtnGenderMale, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(rdbtnGenderOther, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))))
						.addGroup(Alignment.TRAILING, gl_panelUpdateForm.createSequentialGroup()
							.addGroup(gl_panelUpdateForm.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panelUpdateForm.createSequentialGroup()
									.addComponent(lblAppoinmentDate, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
									.addGap(14)
									.addComponent(comboBoxAppoinmentDate, 0, 172, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(chkNextSevenDays, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelUpdateForm.createSequentialGroup()
									.addComponent(lblAssignedDoctor, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
									.addComponent(comboBoxAssignedDoctor, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(11))
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
							.addGap(13)
							.addComponent(lblAge, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelUpdateForm.createSequentialGroup()
							.addGap(12)
							.addComponent(txtAge, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelUpdateForm.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnGenderMale, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnGenderOther, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelUpdateForm.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblGender, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addComponent(rdbtnGenderFemale, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelUpdateForm.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelUpdateForm.createSequentialGroup()
							.addGap(9)
							.addComponent(lblPhone, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelUpdateForm.createSequentialGroup()
							.addGap(8)
							.addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
					.addGap(14)
					.addGroup(gl_panelUpdateForm.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAssignedDoctor, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxAssignedDoctor, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_panelUpdateForm.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAppoinmentDate, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxAppoinmentDate, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(chkNextSevenDays, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelUpdateForm.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelUpdateForm.createSequentialGroup()
							.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(1)
							.addComponent(scrollPaneAddress, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
						.addGroup(gl_panelUpdateForm.createSequentialGroup()
							.addComponent(lblSummary, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(1)
							.addComponent(scrollPaneSummary, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)))
					.addContainerGap())
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
		searchPatientsFrame.getContentPane().setLayout(mainGroupLayout);
	}
}
