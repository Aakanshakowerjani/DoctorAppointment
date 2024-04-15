package util;

import java.util.List;

import dto.Patient;

public class PatientUtility {

	public static Patient fetchPatient(String patientName,List<Patient> patients) {
		for(Patient patient:patients) {
			if(patientName.equals(patient.getPatientName())) return patient;
		}
		return null;
	}
}
