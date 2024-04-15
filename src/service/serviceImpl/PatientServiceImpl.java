package service.serviceImpl;

import java.util.List;

import constants.Speciality;
import dto.Patient;
import repo.PatientRepo;
import service.PatientService;

public class PatientServiceImpl implements PatientService{
	
	List<Patient> patients;
	
	public PatientServiceImpl() {
		// TODO Auto-generated constructor stub
		this.patients=PatientRepo.getPatients();
	}

	@Override
	public void registerPatient(String patientName) {
		// TODO Auto-generated method stub
		patients.add(new Patient(patientName));
		System.out.println(patientName + " Registered Successfully!!");
	}

	@Override
	public void searchSlot(Speciality speciality) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewBookedAppointments() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
