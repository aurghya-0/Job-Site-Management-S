package com.example.JobManagementSite.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JobManagementSite.model.Application;

public interface AppliRepo extends JpaRepository<Application, Integer>{

	

}
