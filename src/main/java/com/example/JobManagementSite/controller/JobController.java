package com.example.JobManagementSite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.JobManagementSite.dao.AppliRepo;
import com.example.JobManagementSite.dao.JobRepo;
import com.example.JobManagementSite.model.Application;
import com.example.JobManagementSite.model.Job;


//JOB MANAGEMENT
@RestController
public class JobController {

	
	@Autowired
	JobRepo jrepo;
	@Autowired 
	AppliRepo arepo;
	
	
	@PostMapping("/job")
	public Job addJobs(@RequestBody Job job)
	{
		jrepo.save(job);
		return job;
	}
	
	@GetMapping("/jobs")
	public List<Job> findAllJobs()
	{
		return jrepo.findAll();
	}
	
	@GetMapping("/jobs/{id}")
	public Job findById(@PathVariable int id)
	{
		return jrepo.findById(id).orElse(new Job());
	}
	
	@PutMapping("/jobs/{id}")
	public Job updateById(@PathVariable int id, @RequestBody Job job)
	{
		Job jb=jrepo.findById(id).orElse(new Job());
		jb.setCompany(job.getCompany());
		jb.setJobTitle(job.getJobTitle());
		jb.setJobDesc(job.getJobDesc());
		jb.setJobQuali(job.getJobQuali());
		jb.setJobLoc(job.getJobLoc());
		jb.setJobSalary(job.getJobSalary());
		jb.setJobCreated(job.getJobCreated());
		jb.setJobUpdated(job.getJobUpdated());
		
		jrepo.save(job);
		return job;
	}
	
	@DeleteMapping("/jobs/{id}")
	public String deleteById(@PathVariable int id )
	{
		jrepo.deleteById(id);
		return "DELETED";
	}
	
	//APPLICANT TRACKING
	
	
	@GetMapping("jobs/{id}/applications")
	public Application getByAppId(@PathVariable int id )
	{
		return arepo.findById(id).orElse(new Application());
	}
	
	@GetMapping("jobs/applications/{applicationId}")
	public Application getApplication( @PathVariable int  appId)
	{
		return arepo.findById(appId).orElse(new Application());
	}
	
	@PutMapping("jobs/applications/{id}/status")
	public Application updateStatus(@RequestBody Application app, @PathVariable int id)
	{
		Application ap=arepo.findById(id).orElse(new Application());
		ap.setApplicationStatus(app.getApplicationStatus());
		arepo.save(app);
		return app;
	}
}
