package com.healthcare.healthcare.service;

import com.healthcare.healthcare.models.Patients;

import java.util.List;

public interface IPatientsService {

    List<Patients> getPatients();
    Patients findPatients(Long id);
    Patients createPatients(Patients patients);
    void deletePatients(Long id);
    Patients updatePatients(Long id, Patients patientsUpdate);
}
