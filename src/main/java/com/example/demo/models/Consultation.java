package com.example.demo.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "consultations")
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consultation_id")
    private Long consultationId;

    @NonNull
    @Column(name = "consultation_date")
    private LocalDate consultationDate = LocalDate.now();

    @NonNull
    @Column(name = "consultation_reason")
    private String consultationReason;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @OneToMany(mappedBy = "consultation" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Operation> operations = new ArrayList<Operation>();

    @OneToMany(mappedBy = "consultation" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Analyse> prescriptions = new ArrayList<Analyse>();

    @OneToMany(mappedBy = "consultation" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Radiography> radiographies = new ArrayList<Radiography>();

    @OneToOne(mappedBy = "consultation" , cascade = CascadeType.ALL , orphanRemoval = true)
    private Prescription prescription;
}