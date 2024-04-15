package util;

import java.util.ArrayList;
import java.util.List;

import constants.Speciality;
import dto.Doctor;

public class DoctorUtility {
	
	public static int appoinmentDuration;

	public static Doctor fetchDoctor(String doctorName, List<Doctor> doctors) {
		for(Doctor doctor:doctors) {
			if(doctorName.equals(doctor.getDoctorName())) return doctor;
		}
		return null;
	}
	
	public static List<Doctor> fetchDoctorBySpeciality(Speciality speciality,List<Doctor> doctors) {
		List<Doctor> doctorList=new ArrayList<Doctor>();
		for(Doctor doctor: doctors) {
			if(speciality.equals(doctor.getSpeciality())) doctorList.add(doctor);
		}
		return doctorList;
	}
}
