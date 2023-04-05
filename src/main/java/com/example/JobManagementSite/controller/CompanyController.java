package com.example.JobManagementSite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.JobManagementSite.dao.CompanyRepo;
import com.example.JobManagementSite.model.Company;

@RestController
public class CompanyController {

	@Autowired
	CompanyRepo crepo;
	
	@PostMapping("/company")
	public Company addCompany(@RequestBody Company company)
	{
		crepo.save(company);
		return company;
	}
	
	@GetMapping("/companies")
	public Iterable<Company> findAllCompanies()
	{
		return crepo.findAll();
	}
	
	@GetMapping("/companies/{id}")
	public Company findById(@PathVariable int id)
	{
		return crepo.findById(id).orElse(new Company());
	}
	
	@DeleteMapping("/companies/{id}")
	public String deleteById(@PathVariable int id )
	{
		crepo.deleteById(id);
		return "DELETED";
	}
}
