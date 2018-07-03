package com.anuja.restws;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.anuja.restws.model.Patient;

@Service	//spring will discover this bean at runtime
public class PatientServiceImpl implements PatientService {
	
	Map<Long, Patient> patients = new HashMap<Long, Patient>();
	long currentId = 123;
	
	public PatientServiceImpl() {
		init();
	}
	void init() {
		Patient patient = new Patient();
		patient.setId(currentId);
		patient.setName("John");
		patients.put(patient.getId(),patient);
	}
	@Override
	public List<Patient> getPatients() {
		Collection<Patient> results = patients.values();
		List<Patient> response = new ArrayList<>(results);
		return response;
	}
	@Override
	public Patient getPatient(Long id) {
		
		return patients.get(id);
		// TODO Auto-generated method stub
	}
	@Override
	public Response createPatient(Patient patient) {
		patient.setId(++currentId);
		patients.put(patient.getId(), patient);
		
		
		return Response.ok(patient).build();
	}
	@Override
	public Response updatePatient(Patient patient) {
		
		Patient currentPatient = patients.get(patient.getId());
		Response response;
		if(currentPatient != null) {
			patients.put(patient.getId(), patient);
			response = Response.ok().build();
		}
		else
			response = Response.notModified().build();
		return response;
	}
	@Override
	public Response deletePatient(Long id) {
		
		Patient patient = patients.get(id);
		if(patient != null) {
			patients.remove(id);
			return Response.ok().build();
		}
		else
			return Response.notModified().build();
		
	}
}
