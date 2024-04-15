package dto;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import constants.Speciality;

public class Doctor {

	String doctorName;
	Speciality speciality;
	List<LocalTime> slots;
	//in hours
	int duration;
	List<Appointment> appointments;
	
	public Doctor(String doctorName,Speciality speciality) {
		// TODO Auto-generated constructor stub
		this.doctorName=doctorName;
		this.speciality=speciality;
		this.slots=new ArrayList<LocalTime>();
		this.appointments=new ArrayList<Appointment>();
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Speciality getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

	public List<LocalTime> getSlots() {
		return slots;
	}

	public void setSlots(List<LocalTime> slots) {
		this.slots = slots;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	@Override
	public String toString() {
		return "Doctor [doctorName=" + doctorName + ", speciality=" + speciality + ", slots=" + slots + ", duration="
				+ duration + ", appointments=" + appointments + "]";
	}
	

}
