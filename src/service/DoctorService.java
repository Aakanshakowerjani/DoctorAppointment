package service;

import java.util.List;

import constants.Speciality;

public interface DoctorService {
	
	void registerDoctor(String doctorName, Speciality speciality);
	
	void addDoctorAvailablity(String doctorName, List<String> availableTimes) throws Exception;
	
	void showAvailableBySpeciality(Speciality speciality) throws Exception;
	
	void viewAppointments() throws Exception;

}
