package com.patient.hub.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.TableGenerator;
import lombok.Data;
@Data
@Entity
public class Patient {
	 @Id
	 @GeneratedValue(strategy = GenerationType.TABLE, generator = "id_gen")
	 @TableGenerator(name = "id_gen", pkColumnName = "patient_id", initialValue = 10000, allocationSize = 100)
	Long patientId;
	String name;
	String sex;
	String illness;
	Long doctorId;
	String doctorName;
	
	
}
