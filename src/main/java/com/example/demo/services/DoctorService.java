package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.dtos.doctordto.DoctorCreateDto;
import com.example.demo.dtos.doctordto.DoctorResponseDto;
import com.example.demo.models.Doctor;
import com.example.demo.repositories.DoctorRepositories;
import com.example.demo.util.GenericMapper;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepositories doctorRepository;

    public List<DoctorResponseDto> findAllDoctors() {
        var doctors = doctorRepository.findAll();
        var doctorResponseDto = GenericMapper.mapCollection(doctors, DoctorResponseDto.class);
        return doctorResponseDto;
    }

    public Optional<DoctorResponseDto> findDoctorById(Long id) {
        var doctor = doctorRepository.findById(id);
        var response = doctor.map(value -> GenericMapper.map(value, DoctorResponseDto.class));
        return response;
    }

    public DoctorResponseDto saveDoctor(DoctorCreateDto doctor) {
        var doctorEntity = GenericMapper.map(doctor, Doctor.class);
        var savedDoctor = doctorRepository.save(doctorEntity);
        return GenericMapper.map(savedDoctor, DoctorResponseDto.class);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    public DoctorResponseDto updateDoctor(Long id, DoctorCreateDto doctorDetails) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));
        Doctor respons = GenericMapper.map(doctorDetails, doctor.getClass());
        DoctorResponseDto response = GenericMapper.map(respons, DoctorResponseDto.class);
        return response;
    }
}
