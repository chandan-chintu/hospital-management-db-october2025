package com.jpahiberante.example.hospital_management_db.repository;

import com.jpahiberante.example.hospital_management_db.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //it performs the database operations and it is the data layer
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
