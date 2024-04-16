package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import constants.Speciality;
import dto.Doctor;

public class DoctorUtility {
	
	public static int appoinmentDuration;

	public static Optional<Doctor> fetchDoctor(String doctorName, List<Doctor> doctors) {
		
		return doctors.stream().filter(doctor -> doctorName.equals(doctor.getDoctorName())).findFirst();
	}
	
	public static List<Doctor> fetchDoctorBySpeciality(Speciality speciality,List<Doctor> doctors) {
		return doctors.stream().filter(doctor -> speciality.equals(doctor.getSpeciality())).toList();
	}
}
