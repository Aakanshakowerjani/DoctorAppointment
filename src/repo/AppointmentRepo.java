package repo;

import java.util.ArrayList;
import java.util.List;

import dto.Appointment;

public class AppointmentRepo {

	static List<Appointment> appointments; 
	
	public AppointmentRepo() {
		// TODO Auto-generated constructor stub
		AppointmentRepo.appointments=new ArrayList<Appointment>();
	}

	public static List<Appointment> getAppointments() {
		return appointments;
	}
}
