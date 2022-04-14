package com.hospitalmanagementsystem.dao.doctor;

import com.hospitalmanagementsystem.model.doctor.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{

}
