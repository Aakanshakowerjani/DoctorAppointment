package dto;

import java.util.ArrayList;
import java.util.List;

public class Patient {

	String patientName;
	List<Appointment> appointments;
	
	public Patient(String patientName) {
		// TODO Auto-generated constructor stub
		this.patientName=patientName;
		this.appointments=new ArrayList<Appointment>();
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public List<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	@Override
	public String toString() {
		return "Patient [patientName=" + patientName + ", appointments=" + appointments + "]";
	}
	
	
}
