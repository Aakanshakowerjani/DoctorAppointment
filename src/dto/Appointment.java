package dto;

import java.time.LocalTime;

import constants.Status;

public class Appointment {

	String appointmentId;
	String patientName;
	String doctorName;
	LocalTime startTime;
	int duration;
	Status status;
	
	public Appointment(String appointmentId,String patientName,String doctorName,LocalTime startTime,int duration) {
		// TODO Auto-generated constructor stub
		this.appointmentId=appointmentId;
		this.patientName=patientName;
		this.doctorName=doctorName;
		this.startTime=startTime;
		this.duration=duration;
		this.status=Status.BOOKED;
	}
	
	public String getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", patientName=" + patientName + ", doctorName="
				+ doctorName + ", startTime=" + startTime + ", duration=" + duration + ", status=" + status + "]";
	}
	
	
}
