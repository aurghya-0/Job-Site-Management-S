package com.example.JobManagementSite.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.JobManagementSite.model.Company;

public interface CompanyRepo extends CrudRepository<Company, Integer> {

}
