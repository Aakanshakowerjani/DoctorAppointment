package service.serviceImpl;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;

import constants.Speciality;
import dto.Doctor;
import repo.DoctorRepo;
import service.DoctorService;
import static util.DoctorUtility.fetchDoctor;
import static util.DoctorUtility.appoinmentDuration;
import static util.DoctorUtility.fetchDoctorBySpeciality;

public class DoctorServiceImpl implements DoctorService {
	
	List<Doctor> doctors;
	
	public DoctorServiceImpl() {
		// TODO Auto-generated constructor stub
		this.doctors=DoctorRepo.getDoctors();
	}

	@Override
	public void registerDoctor(String doctorName, Speciality speciality) {
		// TODO Auto-generated method stub
		Doctor doctor=new Doctor(doctorName, speciality);
		doctors.add(doctor);
		System.out.println("Welcome Dr. " +doctorName + " !!");
		System.out.println(doctors);
	}

	@Override
	public void addDoctorAvailablity(String doctorName, List<String> availableTimes) throws Exception {
		// TODO Auto-generated method stub
		Doctor doctor=fetchDoctor(doctorName, doctors);
		if(doctor==null) throw new Exception("Doctor Not Found!!");
		for(String availableTime: availableTimes) {
			String[] time=availableTime.split("-");
			LocalTime startTime=LocalTime.of(Integer.parseInt(time[0].split(":")[0]), Integer.parseInt(time[0].split(":")[1]));
			LocalTime endTime=LocalTime.of(Integer.parseInt(time[1].split(":")[0]), Integer.parseInt(time[1].split(":")[1]));
			if(endTime.minusHours(appoinmentDuration).compareTo(startTime)!=0) throw new Exception("Sorry Dr. " + doctorName+ " slots are available for " + appoinmentDuration +" hour.");
			
			doctor.getSlots().add(startTime);
		}
		doctor.setDuration(appoinmentDuration);
		System.out.println("Done Doctor!!");
	}

	@Override
	public void viewAppointments() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showAvailableBySpeciality(Speciality speciality) throws Exception {
		// TODO Auto-generated method stub
		List<Doctor> doctorList=fetchDoctorBySpeciality(speciality,doctors);
		if(doctorList.isEmpty()) throw new Exception("No Doctor Available!!");
		System.out.println("Available Doctor's List : ");
		for(Doctor doctor:doctorList) {
			if(!doctor.getSlots().isEmpty()) {
				for(LocalTime time: doctor.getSlots())
					System.out.println("Dr. "+ doctor.getDoctorName()+" : "+ time + " " + time.plusHours(appoinmentDuration));
			}
		}
	}

}
