package com.healthcare.healthcare.service;

import com.healthcare.healthcare.models.Patients;
import com.healthcare.healthcare.repository.IPatientsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientsServiceImpl implements IPatientsService {

    @Autowired
    private IPatientsRepository patientsRepository;

    @Override
    public List<Patients> getPatients() {
        return this.patientsRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Patients::getName))
                .toList();
    }

    @Override
    public Patients findPatients(Long id) {
        return this.patientsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient don't found with id: " + id));
    }

    @Override
    public Patients createPatients(Patients patients) {
        return this.patientsRepository.save(patients);
    }

    @Override
    public void deletePatients(Long id) {
        this.patientsRepository.deleteById(id);
    }

    @Override
    public Patients updatePatients(Long id, Patients patientsUpdate) {
        return this.patientsRepository.findById(id).map(patients -> {

            patients.setName(patientsUpdate.getName());
            patients.setLastName(patientsUpdate.getLastName());
            patients.setPhoneNumber(patientsUpdate.getPhoneNumber());
            patients.setGmail(patientsUpdate.getGmail());
            patients.setAge(patientsUpdate.getAge());
            patients.setMedicalRecords(patientsUpdate.getMedicalRecords());

            return this.patientsRepository.save(patients);

        }).orElseThrow(() -> new RuntimeException("Patient don't found with the id: " + id));

    }
}
