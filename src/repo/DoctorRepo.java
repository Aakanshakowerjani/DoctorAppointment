package repo;

import java.util.ArrayList;
import java.util.List;

import dto.Doctor;

public class DoctorRepo {
	
	static List<Doctor> doctors;
	
	public DoctorRepo() {
		// TODO Auto-generated constructor stub
		DoctorRepo.doctors=new ArrayList<Doctor>();
	}

	public static List<Doctor> getDoctors() {
		return doctors;
	}

}
