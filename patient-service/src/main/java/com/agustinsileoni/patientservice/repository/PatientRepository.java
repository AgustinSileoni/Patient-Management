package com.agustinsileoni.patientservice.repository;

import com.agustinsileoni.patientservice.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient , String> {
    boolean existsByEmail(String email);


}
