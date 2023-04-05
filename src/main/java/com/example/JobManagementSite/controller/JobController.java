package com.example.JobManagementSite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JobManagementSite.model.Job;
import com.example.JobManagementSite.service.JobService;

@RestController
@RequestMapping("/jobs")
public class JobController {

	@Autowired
	private JobService jobService;

	@PostMapping("")
	public ResponseEntity<Job> addJob(@RequestBody Job job) {
		Job createdJob = jobService.addJob(job);
		return new ResponseEntity<>(createdJob, HttpStatus.CREATED);
	}

	@GetMapping("")
	public ResponseEntity<List<Job>> findAllJobs() {
		List<Job> jobs = jobService.findAllJobs();
		return new ResponseEntity<>(jobs, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Job> findJobById(@PathVariable int id) {
		Job job = jobService.findJobById(id);
		if (job.getJobId() == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(job, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Job> updateJob(@PathVariable int id, @RequestBody Job job) {
		Job updatedJob = jobService.updateJob(id, job);
		return new ResponseEntity<>(updatedJob, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteJobById(@PathVariable int id) {
		jobService.deleteJobById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
