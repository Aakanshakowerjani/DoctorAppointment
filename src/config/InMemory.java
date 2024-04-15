package config;

import repo.AppointmentRepo;
import repo.DoctorRepo;
import repo.PatientRepo;

public class InMemory {

	AppointmentRepo appointmentRepo;
	DoctorRepo doctorRepo;
	PatientRepo patientRepo;
	
	public InMemory() {
		// TODO Auto-generated constructor stub
		this.appointmentRepo=new AppointmentRepo();
		this.doctorRepo=new DoctorRepo();
		this.patientRepo=new PatientRepo();
	}
}
