package com.example.demo.models;

import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "medications")
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicationId;

    @NonNull
    @Column(name = "medication_name")
    private String medicationName;

    @NonNull
    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "dosage")
    private String dosage;

    @Column(name = "medication_type")
    private String medicationType;

    @Column(name = "medication_description")
    private String medicationDescription;

    @Column(name = "times")
    private Integer times;

    @Column(name = "duration")
    private Time duration;

    @Column(name = "consumation")
    private Integer consumation;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prescription_id", nullable = false)
    private Prescription prescription;
}
