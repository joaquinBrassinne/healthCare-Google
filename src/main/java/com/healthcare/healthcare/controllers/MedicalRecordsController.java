package com.healthcare.healthcare.controllers;

import com.healthcare.healthcare.models.MedicalRecords;
import com.healthcare.healthcare.service.IMedicalRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/medical/records")
@PreAuthorize("denyAll()")
public class MedicalRecordsController {

    @Autowired
    private IMedicalRecordsService medicalRecordsService;

    @PreAuthorize("isAuthenticated()")
    @PostMapping
    public ResponseEntity<MedicalRecords> createMedicalRecords(@RequestBody MedicalRecords medicalRecords) {
        return new ResponseEntity<>(this.medicalRecordsService.createMedicalRecords(medicalRecords), HttpStatus.CREATED);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public ResponseEntity<List<MedicalRecords>> getMedicalRecords() {
        List<MedicalRecords> medicalRecords = this.medicalRecordsService.getMedicalRecords()
                .stream()
                .toList();
        return ResponseEntity.ok(medicalRecords);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/find/{id}")
    public ResponseEntity<MedicalRecords> findAMedicalRecord(@PathVariable Long id) {
        return new ResponseEntity<>(this.medicalRecordsService.findMedicalRecords(id), HttpStatus.OK);
    }

    @PreAuthorize("isAuthenticated()")
    @PutMapping("/update/{id}")
    public ResponseEntity<MedicalRecords> updateMedicalRecords(@PathVariable Long id, @RequestBody MedicalRecords medicalRecords) {
        return new ResponseEntity<>(this.medicalRecordsService.updateMedicalRecords(id, medicalRecords), HttpStatus.OK);
    }

    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMedicalRecords(@PathVariable Long id) {
        this.medicalRecordsService.deleteMedicalRecords(id);
        return ResponseEntity.ok("Medical deleted!");
    }
}
