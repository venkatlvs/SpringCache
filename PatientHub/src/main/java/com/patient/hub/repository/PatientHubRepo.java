package com.patient.hub.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patient.hub.model.Patient;

public interface PatientHubRepo extends JpaRepository<Patient, Long> {

	Optional<Patient> findByPatientId(Long id);
}
