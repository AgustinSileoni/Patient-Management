package com.agustinsileoni.patientservice.mapper;

import com.agustinsileoni.patientservice.DTO.PatientResponseDTO;
import com.agustinsileoni.patientservice.model.Patient;

public class PatientMapper {

    public static PatientResponseDTO toDTO(Patient patient){
        PatientResponseDTO patienDTO = new PatientResponseDTO();
        patienDTO.setId(patient.getId());
        patienDTO.setName(patient.getName());
        patienDTO.setAddress(patient.getAddress());
        patienDTO.setEmail(patient.getEmail());
        patienDTO.setDateOfBirth(patient.getDateOfBirth().toString());
        return patienDTO;
    }
}
