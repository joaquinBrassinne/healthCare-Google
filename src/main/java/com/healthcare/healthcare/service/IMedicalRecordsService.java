package com.healthcare.healthcare.service;

import com.healthcare.healthcare.models.MedicalRecords;
import com.healthcare.healthcare.models.Patients;

import java.util.List;

public interface IMedicalRecordsService {

    List<MedicalRecords> getMedicalRecords();
    MedicalRecords findMedicalRecords(Long id);
    MedicalRecords createMedicalRecords(MedicalRecords medicalRecords);
    void deleteMedicalRecords(Long id);
    MedicalRecords updateMedicalRecords(Long id, MedicalRecords medicalRecords);
}
