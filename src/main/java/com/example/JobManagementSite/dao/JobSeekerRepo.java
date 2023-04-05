package com.example.JobManagementSite.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JobManagementSite.model.JobSeeker;

public interface JobSeekerRepo extends JpaRepository<JobSeeker, Integer>{

}
