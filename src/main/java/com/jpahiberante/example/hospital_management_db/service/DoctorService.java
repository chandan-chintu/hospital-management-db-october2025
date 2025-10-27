package com.jpahiberante.example.hospital_management_db.service;

import com.jpahiberante.example.hospital_management_db.model.Doctor;
import com.jpahiberante.example.hospital_management_db.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Service // it contains business logic
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    public String saveDoctor(Doctor doctor){
        doctorRepository.save(doctor);
        return "Doctor saved successfully!";
    }

    public List<Doctor> getAllDoctors(){
        List<Doctor> doctorList = doctorRepository.findAll();
        return doctorList;
    }

    public Doctor getDoctorById(int id){
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
        if(optionalDoctor.isPresent()){
            return optionalDoctor.get();
        } else{
            return null;
        }
    }

    public String countDoctors(){
        long totalCount = doctorRepository.count();
        return "Total doctors present are : "+totalCount;
    }

    public String deleteDoctorById(int id){
        doctorRepository.deleteById(id);
        return "Doctor with id : "+id +" is deleted successfully";
    }

    // update using put
    public String updateDoctorUsingPut(int id, Doctor newDoctorRequest){
        // find doctor with id
        // if doctor is present, update it
        // else we cannot update
        Doctor existingDoctor = getDoctorById(id);
        if(existingDoctor!=null){
            // proceed to update
            doctorRepository.save(newDoctorRequest);
            return "Doctor updated successfully";
        } else {
            // cannot perform update
            return "Cannot update as doctor is  not found";
        }
    }

    // update using patch
    public String updateDoctorUsingPatch(int id, String newEmail){
        // find doctor with id
        // if doctor is present, update it
        // else we cannot update
        Doctor existingDoctor = getDoctorById(id);
        if(existingDoctor!=null){
            // proceed to update
            existingDoctor.setEmail(newEmail);
           // existingDoctor.setMobile(newMobile);
            doctorRepository.save(existingDoctor);
            return "Doctor updated successfully";
        } else {
            // cannot perform update
            return "Cannot update as doctor is  not found";
        }
    }
}
