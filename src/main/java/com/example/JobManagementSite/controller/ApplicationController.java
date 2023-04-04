package com.example.JobManagementSite.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.JobManagementSite.dao.AppliRepo;
import com.example.JobManagementSite.model.Application;

@RestController
public class ApplicationController 
{
	
	@Autowired
	AppliRepo arepo;
	
	@PostMapping("application")
	public Application createApplication(@RequestBody Application app)
	{
		arepo.save(app);
		return app;
	}
	
	@GetMapping("application/{id}")
	public Application getApplicationById(@PathVariable int id)
	{
		return arepo.findById(id).orElse(new Application());
	}
	
	@DeleteMapping("/delapplication/{id}")
	public String deleteApplicationById(@PathVariable int id)
	{
		arepo.deleteById(id);
		return "Deleted";
	}
	
	
}