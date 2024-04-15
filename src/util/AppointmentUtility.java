package util;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import dto.Appointment;
import dto.Doctor;

public class AppointmentUtility {

	public static boolean isPatientAvailable(String patientName, LocalTime time, List<Appointment> appointments) {
		for(Appointment appointment: appointments) {
			if(patientName.equals(appointment.getPatientName()) && time.compareTo(appointment.getStartTime())==0) return false;
		}
		return true;
	}
	
	public static Doctor isDoctorAvailable(String doctorName, LocalTime time, List<Doctor> doctors) {
		for(Doctor doctor: doctors) {
			if(doctorName.equals(doctor.getDoctorName())) {
				List<LocalTime> slots=doctor.getSlots();
				if(slots.contains(time)) return doctor;
				break;
			}
		}
		return null;
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
