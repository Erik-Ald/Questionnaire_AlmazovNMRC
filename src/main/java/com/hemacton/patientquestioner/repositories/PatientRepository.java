package com.hemacton.patientquestioner.repositories;

import com.hemacton.patientquestioner.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
