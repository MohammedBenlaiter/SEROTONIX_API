package com.example.demo.dtos.prescriptiondto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionCreateDto {
    private Long prescriptionId;
    private LocalDate date;
    private String description;
    private Long consultationId;
    private List<Long> medicationIds;
}



/* 
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionCreateDto {
    private Long prescriptionId;
    private LocalDate date;
    private String description;
    private Long consultationId;
    private List<Long> medicationIds;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionResponseDto {
    private LocalDate date;
    private String description;
    private Long consultationId;
    private List<Long> medicationIds;
}


this is  model 


@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "prescriptions")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prescription_id")
    private Long prescriptionId;

    @NonNull
    @Column(name = "date", nullable = false)
    private LocalDate date = LocalDate.now();

    @Column(name = "description")
    private String description;

    @NonNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consultation_id", nullable = false)
    private Consultation consultation;

    @OneToMany(mappedBy = "prescription", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Medication> medications = new ArrayList<Medication>();
}


 */