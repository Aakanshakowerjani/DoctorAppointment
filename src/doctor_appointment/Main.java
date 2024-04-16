package doctor_appointment;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import config.InMemory;
import constants.Speciality;
import service.AppointmentService;
import service.DoctorService;
import service.PatientService;
import service.serviceImpl.AppointmentServiceImpl;
import service.serviceImpl.DoctorServiceImpl;
import service.serviceImpl.PatientServiceImpl;
import util.DoctorUtility;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InMemory inMemory=new InMemory();
		AppointmentService appointmentService=new AppointmentServiceImpl();
		DoctorService doctorService= new DoctorServiceImpl();
		PatientService patientService=new PatientServiceImpl();
		
		Scanner sc=new Scanner(System.in);
		
		// Setting appointment duration to 1 hour
		DoctorUtility.appoinmentDuration=1;
		
		while(true) {
			try {
			String[] input=sc.nextLine().trim().split(" ");
			switch(input[0]) {
				
					case "REGISTER_DOCTOR":{
						doctorService.registerDoctor(input[1], Speciality.valueOf(input[2]));
						break;
					}
					case "MARK_DOCTOR_AVAILABLITY":{
						List<String> inputTime=new ArrayList<String>();
						for(int ind=2;ind<input.length;ind++) inputTime.add(input[ind]);
						doctorService.addDoctorAvailablity(input[1], inputTime);
						break;
					}
					case "REGISTER_PATIENT":
					{
						patientService.registerPatient(input[1]);
						break;
					}
					case "SHOW_AVAILABILITY_BY_SPECIALITY":{
						doctorService.showAvailableBySpeciality(Speciality.valueOf(input[1]));
						break;
					}
					case "BOOK_APPOINTMENT":{
						LocalTime time=LocalTime.of(Integer.valueOf(input[3].split(":")[0]),Integer.valueOf(input[3].split(":")[1]));
						appointmentService.bookAppointment(input[1], input[2], time);
						break;
					}
					case "SHOW_ALL_APPOINTMENT_OF_PATIENT":{
						appointmentService.showAllPatientAppointments(input[1]);
						break;
					}
					case "SHOW_ALL_APPOINTMENT_OF_DOCTOR":{
						appointmentService.showAllDoctorAppointments(input[1]);
						break;
					}
					case "CANCEL_APPOINTMENT":{
						appointmentService.cancelAppointment(input[1]);
						break;
					}
					default:{
						System.out.println("Invalid Command");
					}
				}
			}catch(Exception exception) {
				System.out.println(exception.getMessage());
			}
		}
	}

}
