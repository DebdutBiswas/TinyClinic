package sCMS.common;

import java.util.List;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.FileNotFoundException;
import java.io.IOException;

import sCMS.models.Doctor;
import sCMS.models.Patient;

public class Dbase {
	/* StaticMethodsDoctors */
	@SuppressWarnings("unchecked")
	public static List<Doctor> loadDoctorsData() {
		List<Doctor> doctorsDataList = null;
		FileInputStream doctorsDataFileInputStream = null;
		ObjectInputStream doctorsDataObjectInputStream = null;
		
		try {
			doctorsDataFileInputStream = new FileInputStream("doctorsDataList.db");
			doctorsDataObjectInputStream = new ObjectInputStream(doctorsDataFileInputStream);
			doctorsDataList = (List<Doctor>) doctorsDataObjectInputStream.readObject();

		} catch (FileNotFoundException ex) {
			System.out.println("File not found!");
			ex.printStackTrace();
		} catch (IOException ex) {
			System.out.println("File open/read error!");
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			System.out.println("Class not found in the file!");
			ex.printStackTrace();
		} finally {
			try {
				if (doctorsDataObjectInputStream != null)
					doctorsDataObjectInputStream.close();
				if (doctorsDataFileInputStream != null)
					doctorsDataFileInputStream.close();
			} catch (IOException ex) {
				System.out.println("File closing error!");
				ex.printStackTrace();
			}
		}
		
		return doctorsDataList;
	}

	public static void saveDoctorsData(List<Doctor> doctorsDataList) {
		FileOutputStream doctorsDataFileOutputStream = null;
		ObjectOutputStream doctorsDataObjectOutputStream = null;
		
		try {
			doctorsDataFileOutputStream = new FileOutputStream("doctorsDataList.db");
			doctorsDataObjectOutputStream = new ObjectOutputStream(doctorsDataFileOutputStream);
			
			if (doctorsDataList != null && doctorsDataList.size() != 0)
				doctorsDataObjectOutputStream.writeObject(doctorsDataList);
		
		} catch (FileNotFoundException ex) {
			System.out.println("File not found!");
			ex.printStackTrace();
		} catch (IOException ex) {
			System.out.println("File open/write error!");
			ex.printStackTrace();
		} finally {
			try {
				doctorsDataObjectOutputStream.close();
				doctorsDataFileOutputStream.close();
			} catch (IOException ex) {
				System.out.println("File closing error!");
				ex.printStackTrace();
			}
		}
	}
	/* StaticMethodsDoctors End */
	
	//===============================================================================================
	
	/* StaticMethodsPatients */
	@SuppressWarnings("unchecked")
	public static List<Patient> loadPatientsData() {
		List<Patient> patientsDataList = null;
		FileInputStream patientsDataFileInputStream = null;
		ObjectInputStream patientsDataObjectInputStream = null;
		
		try {
			patientsDataFileInputStream = new FileInputStream("patientsDataList.db");
			patientsDataObjectInputStream = new ObjectInputStream(patientsDataFileInputStream);
			patientsDataList = (List<Patient>) patientsDataObjectInputStream.readObject();

		} catch (FileNotFoundException ex) {
			System.out.println("File not found!");
			ex.printStackTrace();
		} catch (IOException ex) {
			System.out.println("File open/read error!");
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			System.out.println("Class not found in the file!");
			ex.printStackTrace();
		} finally {
			try {
				if (patientsDataObjectInputStream != null)
					patientsDataObjectInputStream.close();
				if (patientsDataFileInputStream != null)
					patientsDataFileInputStream.close();
			} catch (IOException ex) {
				System.out.println("File closing error!");
				ex.printStackTrace();
			}
		}
		
		return patientsDataList;
	}

	public static void savePatientsData(List<Patient> patientsDataList) {
		FileOutputStream patientsDataFileOutputStream = null;
		ObjectOutputStream patientsDataObjectOutputStream = null;
		
		try {
			patientsDataFileOutputStream = new FileOutputStream("patientsDataList.db");
			patientsDataObjectOutputStream = new ObjectOutputStream(patientsDataFileOutputStream);
			
			if (patientsDataList != null && patientsDataList.size() != 0)
				patientsDataObjectOutputStream.writeObject(patientsDataList);
			
		} catch (FileNotFoundException ex) {
			System.out.println("File not found!");
			ex.printStackTrace();
		} catch (IOException ex) {
			System.out.println("File open/write error!");
			ex.printStackTrace();
		} finally {
			try {
				patientsDataObjectOutputStream.close();
				patientsDataFileOutputStream.close();
			} catch (IOException ex) {
				System.out.println("File closing error!");
				ex.printStackTrace();
			}
		}
	}
	/* StaticMethodsPatients End */
}