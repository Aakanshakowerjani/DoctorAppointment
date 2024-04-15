package service;

import java.time.LocalTime;

public interface AppointmentService {

	void bookAppointment(String patientName,String doctorName,LocalTime time) throws Exception;
	
	void showAllPatientAppointments(String patientName) throws Exception;
	
	void showAllDoctorAppointments(String doctorName) throws Exception;
	
	void cancelAppointment(String appointmentId) throws Exception;
	
}
