package com.teamd.teamdspringapi.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamd.teamdspringapi.entity.Enrollment;
import com.teamd.teamdspringapi.repository.EnrollmentRepository;

@Service
public class EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public List<Enrollment> getAEnrollments() {
        return enrollmentRepository.findAll();
    }

    public Enrollment getEnrollmentId(Long enrollmentID) {
        return enrollmentRepository.findById(enrollmentID).orElse(null);
    }

    public List<Enrollment> getEnrollmentsByUserId(Long user_ID) {
        return enrollmentRepository.findByUserId(user_ID);
    }

    public Enrollment savEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    public void deleteEnrollment(Long enrollmentID) {
        enrollmentRepository.deleteById(enrollmentID);
    }
}
