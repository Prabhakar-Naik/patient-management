package com.pm.patientservice.mapper;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.model.Patient;
import jakarta.annotation.Nonnull;

import java.time.LocalDate;

/**
 * @author prabhakar, @Date 18-03-2025
 */

public class PatientMapper {

    @Nonnull
    public static PatientResponseDTO toDTO(@Nonnull Patient patient) {
        PatientResponseDTO patientDTO = new PatientResponseDTO();
        patientDTO.setId(patient.getId().toString());
        patientDTO.setFirstName(patient.getFirstName());
        patientDTO.setLastName(patient.getLastName());
        patientDTO.setEmail(patient.getEmail());
        patientDTO.setPhone(patient.getPhone());
        patientDTO.setAddress(patient.getAddress());
        patientDTO.setGender(patient.getGender());
        patientDTO.setDateOfBirth(patient.getDateOfBirth().toString());

        return patientDTO;
    }

    @Nonnull
    public static Patient toModel(@Nonnull PatientRequestDTO patientRequestDTO) {
        Patient patient = new Patient();
        patient.setFirstName(patientRequestDTO.getFirstName());
        patient.setLastName(patientRequestDTO.getLastName());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setPhone(patientRequestDTO.getPhoneNumber());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setGender(patientRequestDTO.getGender());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
        patient.setRegistrationDate(patientRequestDTO.getRegistrationDate());
        return patient;
    }

}
