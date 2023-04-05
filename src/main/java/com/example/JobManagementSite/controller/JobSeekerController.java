package com.example.JobManagementSite.controller;

import com.example.JobManagementSite.dao.JobSeekerRepo;
import com.example.JobManagementSite.model.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobSeekerController {

    @Autowired
    private JobSeekerRepo jobSeekerRepo;

    @PostMapping("/jobseeker")
    public JobSeeker addJobSeeker(@RequestBody JobSeeker jobSeeker) {
        return jobSeekerRepo.save(jobSeeker);
    }

    @GetMapping("/jobseekers")
    public List<JobSeeker> findAllJobSeekers() {
        return jobSeekerRepo.findAll();
    }

    @GetMapping("/jobseekers/{id}")
    public ResponseEntity<JobSeeker> findJobSeekerById(@PathVariable(value = "id") int id) {
        JobSeeker jobSeeker = jobSeekerRepo.findById(id).orElse(null);
        if (jobSeeker == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(jobSeeker);
    }

    @PutMapping("/jobseekers/{id}")
    public ResponseEntity<JobSeeker> updateJobSeekerById(@PathVariable(value = "id") int id,
                                                          @RequestBody JobSeeker jobSeeker) {
        JobSeeker existingJobSeeker = jobSeekerRepo.findById(id).orElse(null);
        if (existingJobSeeker == null) {
            return ResponseEntity.notFound().build();
        }
        existingJobSeeker.setFullName(jobSeeker.getFullName());
        existingJobSeeker.setPhoneNumber(jobSeeker.getPhoneNumber());
        existingJobSeeker.setAddress(jobSeeker.getAddress());
        existingJobSeeker.setEducation(jobSeeker.getEducation());
        existingJobSeeker.setMajorSkill(jobSeeker.getMajorSkill());
        existingJobSeeker.setCreatedAt(jobSeeker.getCreatedAt());
        existingJobSeeker.setUpdatedAt(jobSeeker.getUpdatedAt());
        JobSeeker updatedJobSeeker = jobSeekerRepo.save(existingJobSeeker);
        return ResponseEntity.ok(updatedJobSeeker);
    }

    @DeleteMapping("/jobseekers/{id}")
    public ResponseEntity<JobSeeker> deleteJobSeekerById(@PathVariable(value = "id") int id) {
        JobSeeker jobSeeker = jobSeekerRepo.findById(id).orElse(null);
        if (jobSeeker == null) {
            return ResponseEntity.notFound().build();
        }
        jobSeekerRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
