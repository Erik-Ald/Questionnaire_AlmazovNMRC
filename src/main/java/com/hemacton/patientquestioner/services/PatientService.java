package com.hemacton.patientquestioner.services;

import com.hemacton.patientquestioner.models.Patient;
import com.hemacton.patientquestioner.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public Long addPatient(Patient patient){
        Patient newPatient = patient.builder()
                .lastName(patient.getLastName())
                .firstName(patient.getFirstName())
                .patronymic(patient.getPatronymic())
                .sex(patient.getSex())
                .email(patient.getEmail())
                .dateOfBirth(patient.getDateOfBirth())
                .build();
        patientRepository.save(newPatient);
        return newPatient.getId();
    }

}
