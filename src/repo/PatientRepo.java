package repo;

import java.util.ArrayList;
import java.util.List;

import dto.Patient;

public class PatientRepo {

	static List<Patient> patients;
	
	public PatientRepo() {
		// TODO Auto-generated constructor stub
		PatientRepo.patients=new ArrayList<Patient>();
	}

	public static List<Patient> getPatients() {
		return patients;
	}


}
