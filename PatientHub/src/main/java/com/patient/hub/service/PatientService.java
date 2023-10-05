package com.patient.hub.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.patient.hub.model.Patient;
import com.patient.hub.repository.PatientHubRepo;
import com.patient.hub.utility.PatientUtility;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PatientService {
	
	@Autowired
	private PatientHubRepo repo;
	
	@Autowired
    public PatientService(PatientHubRepo repo) {
        this.repo = repo;
    }
	@Autowired
	PatientUtility utility;
	
	
	public List<Patient> getPatients() throws Exception{
		List<Patient> patients=repo.findAll();
		if(!patients.isEmpty()) {
			return repo.findAll();
		}else {
			throw new Exception("Patients Empty");
		}
	}
	
	@Cacheable(value = "patients",key = "#id")
	public Patient getPatientById(Long id)  throws Exception{
		log.info("FEtching from db");
		Optional<Patient> pat=repo.findByPatientId(id);
		if(!pat.isEmpty()) {
			return pat.get();
		}else {
			throw new Exception("Provide a valid patient Id");
		}
	}
	
	public String savePatient(Patient p) throws Exception{
			if(utility.isValid(p)) {
				repo.save(p);
				return "Patient saved";
			}else {
				throw new Exception("Patient details empty");
			}
	}

}
