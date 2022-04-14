package com.hospitalmanagementsystem.controller.doctor;


import com.hospitalmanagementsystem.model.doctor.Doctor;
import com.hospitalmanagementsystem.service.doctor.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;


    @GetMapping("/doctor")
    public List<Doctor> getDoctorList(){
        return doctorService.getDoctors();
    }
}
