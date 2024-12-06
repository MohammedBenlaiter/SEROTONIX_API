package com.example.demo.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "radiographies")
public class Radiography {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "radiography_id")
    private Long radiographyId;

    @Column(name = "radiography_type")
    private String radiographyType;

    @Column(name = "radiography_date")
    private LocalDate radiographyDate;

    @Column(name = "radiography_description")
    private String radiographyDescription;

}