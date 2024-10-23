package com.healthcare.healthcare.service;

import com.healthcare.healthcare.models.MedicalRecords;
import com.healthcare.healthcare.models.Patients;
import com.healthcare.healthcare.repository.IMedicalRecordsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalRecordsServiceImpl implements IMedicalRecordsService {

    @Autowired
    private IMedicalRecordsRepository medicalRecordsRepository;

    @Override
    public List<MedicalRecords> getMedicalRecords() {
        return this.medicalRecordsRepository.findAll();
    }

    @Override
    public MedicalRecords findMedicalRecords(Long id) {
        return this.medicalRecordsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("The record with the id: " + id + " doesn't exist"));
    }

    @Override
    public MedicalRecords createMedicalRecords(MedicalRecords medicalRecords) {
        return this.medicalRecordsRepository.save(medicalRecords);
    }

    @Override
    public void deleteMedicalRecords(Long id) {
        this.medicalRecordsRepository.deleteById(id);
    }

    @Override
    public MedicalRecords updateMedicalRecords(Long id, MedicalRecords medicalRecords) {
        return this.medicalRecordsRepository.findById(id).map(medicalRecords1 -> {

            medicalRecords1.setDiagnostic(medicalRecords.getDiagnostic());
            medicalRecords1.setTreatments(medicalRecords.getTreatments());
            medicalRecords1.setPrescriptionDrugs(medicalRecords.getPrescriptionDrugs());


            return this.medicalRecordsRepository.save(medicalRecords1);

        }).orElseThrow(() -> new RuntimeException("Patient don't found with the id: " + id));
    }
}
