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

import com.example.JobManagementSite.dao.JobRepo;
import com.example.JobManagementSite.model.Job;

@RestController
public class JobController {

	
	@Autowired
	JobRepo jrepo;
	
	
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
		jb.setJobEmployerId(job.getJobEmployerId());
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
}
