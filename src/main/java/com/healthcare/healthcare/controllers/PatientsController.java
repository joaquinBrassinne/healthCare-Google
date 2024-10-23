package com.healthcare.healthcare.controllers;


import com.healthcare.healthcare.models.Patients;
import com.healthcare.healthcare.service.IPatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/patients")
@PreAuthorize("denyAll()")
public class PatientsController {

    @Autowired
    private IPatientsService iPatientsService;

    @PreAuthorize("isAuthenticated()")
    @PostMapping
    public ResponseEntity<Patients> createPatients(@RequestBody Patients patients) {
        return new ResponseEntity<>(this.iPatientsService.createPatients(patients), HttpStatus.CREATED);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/find")
    public ResponseEntity<List<Patients>> getPatients() {
        List<Patients> patients = this.iPatientsService.getPatients()
                .stream()
                .toList();
        return ResponseEntity.ok(patients);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/find/{id}")
    public ResponseEntity<Patients> findAPatients(@PathVariable Long id) {
        return new ResponseEntity<>(this.iPatientsService.findPatients(id), HttpStatus.OK);
    }

    @PreAuthorize("isAuthenticated()")
    @PutMapping("/update/{id}")
    public ResponseEntity<Patients> updatePatient(@PathVariable Long id, @RequestBody Patients patients) {
        return new ResponseEntity<>(this.iPatientsService.updatePatients(id, patients), HttpStatus.OK);
    }

    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) {
        this.iPatientsService.deletePatients(id);
        return ResponseEntity.ok("User deleted!");
    }
}
