package com.hospitalmanagementsystem.service.doctor;


import com.hospitalmanagementsystem.dao.doctor.DoctorRepository;
import com.hospitalmanagementsystem.mailservice.EmailService;
import com.hospitalmanagementsystem.model.doctor.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;


    @Autowired
    private EmailService emailService;


    @PostConstruct
    public void initDoctor() {
        doctorRepository.saveAll(Stream.of
                ( new Doctor(103L, "Gray", "Gynycologist", "06, Gabagada "),
                        new Doctor(104L, "Jane", "Dermatologist", "02, Nelson street"))
                .collect(Collectors.toList()));
    }


    public List<Doctor> getDoctors() {
        emailService.sendMail();
        return doctorRepository.findAll();
    }
}
