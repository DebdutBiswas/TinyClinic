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
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;

public class SearchDoctorsFrame {

	public JFrame searchDoctorsFrame;
	public JLabel lblCurrentDate;
	public JComboBox<String> comboBoxSearchBy;
	public JTextField txtSearchTerm;
	public JButton btnSearch;
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
	public JButton btnClear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchDoctorsFrame window = new SearchDoctorsFrame();
					window.searchDoctorsFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SearchDoctorsFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		searchDoctorsFrame = new JFrame();
		searchDoctorsFrame.setMinimumSize(new Dimension(1024, 640));
		searchDoctorsFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(SearchDoctorsFrame.class.getResource("/sCMS/resources/medicalSearch_64.png")));
		searchDoctorsFrame.setTitle("Search Doctors");
		searchDoctorsFrame.setBounds(
				(Toolkit.getDefaultToolkit().getScreenSize().width  - searchDoctorsFrame.getMinimumSize().width) / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height - searchDoctorsFrame.getMinimumSize().height) / 2,
				searchDoctorsFrame.getMinimumSize().width, searchDoctorsFrame.getMinimumSize().height);
		
		JMenuBar mainMenuBar = new JMenuBar();
		searchDoctorsFrame.setJMenuBar(mainMenuBar);
		
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
		
		JLabel lblSearchResult = new JLabel("Search Result(s):");
		lblSearchResult.setToolTipText("");
		lblSearchResult.setFont(new Font("Dialog", Font.BOLD, 12));
		
		JLabel lblSearchBy = new JLabel("Search By:");
		lblSearchBy.setFont(new Font("Dialog", Font.BOLD, 16));
		
		comboBoxSearchBy = new JComboBox<String>();
		comboBoxSearchBy.setModel(new DefaultComboBoxModel<String>(new String[] {"Name", "Ph. No.", "Speciality", "Designation"}));
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
		
		JPanel panelUpdateForm = new JPanel();
		panelUpdateForm.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblWeeklyVisitDays = new JLabel("Weekly Visits:");
		lblWeeklyVisitDays.setFont(new Font("Dialog", Font.BOLD, 16));
		
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
		
		JLabel lblPhone = new JLabel("Phone No.:");
		lblPhone.setFont(new Font("Dialog", Font.BOLD, 16));
		
		txtPhone = new JTextField();
		txtPhone.setToolTipText("Enter Doctor's Phone Number");
		txtPhone.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtPhone.setColumns(10);
		txtPhone.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblDesignation = new JLabel("Designation:");
		lblDesignation.setFont(new Font("Dialog", Font.BOLD, 16));
		
		txtDesignation = new JTextField();
		txtDesignation.setToolTipText("Enter Doctor's Designation");
		txtDesignation.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtDesignation.setColumns(10);
		txtDesignation.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblSpeciality = new JLabel("Speciality:");
		lblSpeciality.setFont(new Font("Dialog", Font.BOLD, 16));
		
		txtSpeciality = new JTextField();
		txtSpeciality.setToolTipText("Enter Doctor's Speciality");
		txtSpeciality.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtSpeciality.setColumns(10);
		txtSpeciality.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Dialog", Font.BOLD, 16));
		
		txtName = new JTextField();
		txtName.setToolTipText("Enter Doctor's Full Name");
		txtName.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtName.setColumns(10);
		txtName.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Dialog", Font.BOLD, 16));
		
		JScrollPane scrollPaneAddress = new JScrollPane();
		scrollPaneAddress.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout gl_panelUpdateForm = new GroupLayout(panelUpdateForm);
		gl_panelUpdateForm.setHorizontalGroup(
			gl_panelUpdateForm.createParallelGroup(Alignment.LEADING)
				.addGap(0, 487, Short.MAX_VALUE)
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
				.addGap(0, 491, Short.MAX_VALUE)
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
		
		btnClear = new JButton("Clear");
		btnClear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClear.setToolTipText("Clear Search Results");
		GroupLayout mainGroupLayout = new GroupLayout(searchDoctorsFrame.getContentPane());
		mainGroupLayout.setHorizontalGroup(
			mainGroupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(mainGroupLayout.createSequentialGroup()
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(mainGroupLayout.createSequentialGroup()
							.addGap(14)
							.addGroup(mainGroupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSearchTerm, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSearchBy, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
						.addGroup(mainGroupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblSearchResult)))
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(mainGroupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(mainGroupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtSearchTerm, GroupLayout.DEFAULT_SIZE, 861, Short.MAX_VALUE)
								.addComponent(comboBoxSearchBy, 0, 861, Short.MAX_VALUE)))
						.addGroup(mainGroupLayout.createSequentialGroup()
							.addGap(401)
							.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(12))
				.addGroup(mainGroupLayout.createSequentialGroup()
					.addContainerGap(821, Short.MAX_VALUE)
					.addComponent(lblCurrentDate)
					.addContainerGap())
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
							.addComponent(scrollPaneDoctorsList, GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelUpdateForm, GroupLayout.PREFERRED_SIZE, 487, GroupLayout.PREFERRED_SIZE)))
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
					.addGap(12)
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtSearchTerm, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSearchTerm, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnSearch)
						.addComponent(lblSearchResult, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPaneDoctorsList, GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
						.addComponent(panelUpdateForm, GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(mainGroupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(mainGroupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnDelete)
							.addComponent(btnClear))
						.addComponent(btnUpdate))
					.addContainerGap())
		);
		
		tblDoctorsList = new JTable(new String[][] {}, new String[] {"Serial No.", "Name", "Speciality", "Designation", "Ph. No.", "Weekly Visits", "Address"});
		scrollPaneDoctorsList.setViewportView(tblDoctorsList);
		searchDoctorsFrame.getContentPane().setLayout(mainGroupLayout);
	}
}
