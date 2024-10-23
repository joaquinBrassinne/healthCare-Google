package com.healthcare.healthcare.repository;

import com.healthcare.healthcare.models.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPatientsRepository extends JpaRepository<Patients, Long> {
}
