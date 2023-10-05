package com.patient.hub.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.patient.hub.model.Patient;

@Component
public class PatientUtility {

	 public boolean isValid(Patient patient) {
	        return !patient.getName().isEmpty() && patient.getDoctorId()!=0 && !patient.getDoctorName().isEmpty()
	        		&& !patient.getSex().isEmpty() && !patient.getIllness().isEmpty();
	    }
	 
//	 @Bean
//	 public PatientUtility patientUtility() {
//		 return new PatientUtility();
//	}

}
