package service.serviceImpl;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import dto.Appointment;
import dto.Doctor;
import dto.Patient;
import repo.AppointmentRepo;
import repo.DoctorRepo;
import service.AppointmentService;
import static util.DoctorUtility.appoinmentDuration;
import static util.AppointmentUtility.isDoctorAvailable;
import static util.AppointmentUtility.isPatientAvailable;
import static util.AppointmentUtility.fetchAllAppointmentByDoctorName;
import static util.AppointmentUtility.fetchAllAppointmentByPatientName;
import static util.AppointmentUtility.fetchAppointmentIndex;
import static util.DoctorUtility.fetchDoctor;

public class AppointmentServiceImpl implements AppointmentService{
	
	List<Appointment> appointments;
	List<Doctor> doctors;
	List<Patient> patients;
	
	public AppointmentServiceImpl() {
		// TODO Auto-generated constructor stub
		appointments=AppointmentRepo.getAppointments();
		doctors=DoctorRepo.getDoctors();
	}

	@Override
	public void bookAppointment(String patientName, String doctorName, LocalTime time) throws Exception {
		// TODO Auto-generated method stub
		
		Optional<Appointment> optionalAppointment=isPatientAvailable(patientName,time,appointments);
		if(optionalAppointment.isPresent()) throw new Exception("Can't book, Patient already have appointment with "+" Dr."+optionalAppointment.get().getDoctorName()  +" Appointment Id" + optionalAppointment.get().getAppointmentId());
		Optional<Doctor> optionalDoctor=isDoctorAvailable(doctorName,time,doctors);
		if(optionalDoctor.isEmpty()) throw new Exception("Can't book, Doctor is not available");
		Doctor doctor=optionalDoctor.get();
		
		String appointmentId=UUID.randomUUID().toString();
		Appointment appointment=new Appointment(appointmentId,patientName, doctorName, time,appoinmentDuration);
		appointments.add(appointment);
		doctor.getSlots().remove(time);
		System.out.println("Booked!! Booking Id : " + appointmentId);
	}

	@Override
	public void showAllPatientAppointments(String patientName) throws Exception {
		// TODO Auto-generated method stub
		List<Appointment> appointmentList=fetchAllAppointmentByPatientName(patientName,appointments);
		if(appointmentList.isEmpty()) throw new Exception("No Appointment for today!!");
		
		for(Appointment appointment:appointmentList) {
			System.out.println("Booking id : "+ appointment.getAppointmentId() + " , " + appointment.getDoctorName() +" "+ appointment.getStartTime());
		}
	}

	@Override
	public void showAllDoctorAppointments(String doctorName) throws Exception {
		// TODO Auto-generated method stub
		List<Appointment> appointmentList=fetchAllAppointmentByDoctorName(doctorName,appointments);
		if(appointmentList.isEmpty()) throw new Exception("No Appointment for today!!");
		
		for(Appointment appointment:appointmentList) {
			System.out.println("Booking id : "+ appointment.getAppointmentId() + " , " + appointment.getPatientName() +" "+ appointment.getStartTime());
		}
	}

	@Override
	public void cancelAppointment(String appointmentId) throws Exception {
		// TODO Auto-generated method stub
		int position=fetchAppointmentIndex(appointmentId,appointments);
		if(position==-1) System.out.println("No Appointment found!!");
		else {
			Optional<Doctor> optionalDoctor= fetchDoctor(appointments.get(position).getDoctorName(), doctors);
			Doctor doctor=optionalDoctor.get();
			doctor.getSlots().add(appointments.get(position).getStartTime());
			appointments.remove(position);
			System.out.println("Booking Cancelled!!");
		}
	}

}
