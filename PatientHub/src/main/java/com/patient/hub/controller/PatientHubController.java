package com.patient.hub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.patient.hub.model.Patient;
import com.patient.hub.service.PatientService;

@RestController
public class PatientHubController {

	@Autowired
	private PatientService service;
	
	@GetMapping("/getPatients")
	public List<Patient> getPatients() throws Exception {
		return service.getPatients();
	}
	
	@GetMapping("/getPatientById/{patient_id}")
	public Patient getPatientbyId(@PathVariable Long patient_id) throws Exception {
		return service.getPatientById(patient_id);
	}
	
	@PostMapping("/addPatient")
	public String savePatient(@RequestBody Patient patient) throws Exception{
		return service.savePatient(patient);
	}
}
