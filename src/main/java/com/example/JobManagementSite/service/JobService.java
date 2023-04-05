package com.example.JobManagementSite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JobManagementSite.dao.JobRepo;
import com.example.JobManagementSite.model.Job;

@Service
public class JobService {

    @Autowired
    private JobRepo jobRepo;

    public Job addJob(Job job) {
        return jobRepo.save(job);
    }

    public List<Job> findAllJobs() {
        return jobRepo.findAll();
    }

    public Job findJobById(int id) {
        return jobRepo.findById(id).orElse(new Job());
    }

    public Job updateJob(int id, Job job) {
        Job jb = jobRepo.findById(id).orElse(new Job());
        jb.setCompany(job.getCompany());
        jb.setJobTitle(job.getJobTitle());
        jb.setJobDesc(job.getJobDesc());
        jb.setJobQuali(job.getJobQuali());
        jb.setJobLoc(job.getJobLoc());
        jb.setJobSalary(job.getJobSalary());
        jb.setJobCreated(job.getJobCreated());
        jb.setJobUpdated(job.getJobUpdated());

        return jobRepo.save(jb);
    }

    public void deleteJobById(int id) {
        jobRepo.deleteById(id);
    }
}
