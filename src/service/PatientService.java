package service;

import constants.Speciality;

public interface PatientService {

	void registerPatient(String patientName);
	
	void searchSlot(Speciality speciality) throws Exception;
	
	void viewBookedAppointments() throws Exception;
}
