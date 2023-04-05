package com.example.JobManagementSite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.JobManagementSite.model.Application;
import com.example.JobManagementSite.service.ApplicationService;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

	@Autowired
	private ApplicationService applicationService;

	@PostMapping("")
	public Application createApplication(@RequestBody Application app) {
		return applicationService.createApplication(app);
	}

	@GetMapping("/{id}")
	public Application getApplicationById(@PathVariable int id) {
		return applicationService.getApplicationById(id);
	}

	@DeleteMapping("/{id}")
	public String deleteApplicationById(@PathVariable int id) {
		applicationService.deleteApplicationById(id);
		return "Deleted";
	}

}
