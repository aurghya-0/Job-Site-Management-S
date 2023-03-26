package com.example.JobManagementSite.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JobManagementSite.model.Job;

public interface JobRepo extends JpaRepository<Job,Integer> {

}
