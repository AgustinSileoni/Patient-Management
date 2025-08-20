package com.agustinsileoni.patientservice.service;

import com.agustinsileoni.patientservice.DTO.PatientRequestDTO;
import com.agustinsileoni.patientservice.DTO.PatientResponseDTO;
import com.agustinsileoni.patientservice.exception.EmailAlreadyExistsException;
import com.agustinsileoni.patientservice.mapper.PatientMapper;
import com.agustinsileoni.patientservice.model.Patient;
import com.agustinsileoni.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    public void addPatien(Patient patient){
        patientRepository.save(patient);
    }

    public List<PatientResponseDTO> getPatients(){
        List<Patient> patients = patientRepository.findAll();
        List<PatientResponseDTO> patientResponseDTOS = patients.stream().map(PatientMapper::toDTO).toList();
        return patientResponseDTOS;
    }

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO){
        if(patientRepository.existsByEmail(patientRequestDTO.getEmail())){
            throw new EmailAlreadyExistsException("A patient exists whit this email "
                + "already exists " + patientRequestDTO.getEmail() );
        }

        Patient newPatient = patientRepository.save(
                PatientMapper.toModel(patientRequestDTO));
        return PatientMapper.toDTO(newPatient);
    }
}
