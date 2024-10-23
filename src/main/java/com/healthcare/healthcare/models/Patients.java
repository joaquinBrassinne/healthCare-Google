package com.healthcare.healthcare.models;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Patients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String phoneNumber;
    private String gmail;
    private byte age;

    @OneToOne(targetEntity = MedicalRecords.class)
    private MedicalRecords medicalRecords;
}
