package com.anuja.restws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.anuja.restws.model.Patient;
@Consumes("application/xml,application/json")
@Produces("application/xml, application/json")
@Path("/patientservice")	//relative URL to be used by client to access the service
public interface PatientService {
	
	@Path("/patients")
	@GET	//associate the method with http get
	List<Patient> getPatients();
	
	@Path("/patients/{id}")	//id is bound. need to mark parameter by path param
	@GET
	Patient getPatient(@PathParam(value = "id") Long id);
	
	@Path("/patients")
	@POST
	Response createPatient(Patient patient);
	
	@Path("/patients")
	@PUT
	Response updatePatient(Patient patient);
	
	@Path("/patients/{id}")
	@DELETE
	Response deletePatient(@PathParam(value = "id") Long id);
}
