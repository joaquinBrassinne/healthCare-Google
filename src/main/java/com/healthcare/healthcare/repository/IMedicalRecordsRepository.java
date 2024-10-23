package com.healthcare.healthcare.repository;

import com.healthcare.healthcare.models.MedicalRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedicalRecordsRepository extends JpaRepository<MedicalRecords, Long> {
}
