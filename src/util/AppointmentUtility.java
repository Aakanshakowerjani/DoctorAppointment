package util;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dto.Appointment;
import dto.Doctor;

public class AppointmentUtility {

	public static Optional<Appointment> isPatientAvailable(String patientName, LocalTime time, List<Appointment> appointments) {
		return appointments.stream().filter(appointment-> patientName.equals(appointment.getPatientName()) && time.compareTo(appointment.getStartTime())==0).findFirst();
	}
	
	public static Optional<Doctor> isDoctorAvailable(String doctorName, LocalTime time, List<Doctor> doctors) {
		return doctors.stream().filter(doctor -> doctorName.equals(doctor.getDoctorName()) && 
				!doctor.getSlots().isEmpty() && doctor.getSlots().contains(time)).findFirst();
		
	}
	
	public static List<Appointment> fetchAllAppointmentByPatientName(String patientName, List<Appointment> appointments){
		List<Appointment> appointmentList=new ArrayList<Appointment>();
		for(Appointment appointment:appointments) {
			if(patientName.equals(appointment.getPatientName())) appointmentList.add(appointment);
		}
		return appointmentList;
	}
	
	public static List<Appointment> fetchAllAppointmentByDoctorName(String doctorName, List<Appointment> appointments){
		List<Appointment> appointmentList=new ArrayList<Appointment>();
		for(Appointment appointment:appointments) {
			if(doctorName.equals(appointment.getDoctorName())) appointmentList.add(appointment);
		}
		return appointmentList;
	}
	
	public static int fetchAppointmentIndex(String appointmentId,List<Appointment> appointments) {
		for(int ind=0;ind<appointments.size();ind++) {
			if(appointmentId.equals(appointments.get(ind).getAppointmentId())) return ind;
		}
		return -1;
	}
}
