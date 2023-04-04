package com.example.JobManagementSite.model;

import java.security.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="Job")
public class Job 
{
	@Id
	@GeneratedValue
	private int jobId;
	
	@Column(nullable=false)
	private String jobTitle;
	
	@Column(nullable=false)
	private String jobDesc;
	
	@Column(nullable=false)
	private String jobQuali;
	
	@Column(nullable=false)
	private String jobLoc;
	
	@Column(nullable=false)
	private String jobSalary;
	
	@Column(nullable=false)
	private Timestamp jobCreated;
	
	@Column(nullable=false)
	private Timestamp jobUpdated;
	
	@ManyToOne
	@JoinColumn(name="company_Id")
	private Company company;

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobDesc() {
		return jobDesc;
	}

	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

	public String getJobQuali() {
		return jobQuali;
	}

	public void setJobQuali(String jobQuali) {
		this.jobQuali = jobQuali;
	}

	public String getJobLoc() {
		return jobLoc;
	}

	public void setJobLoc(String jobLoc) {
		this.jobLoc = jobLoc;
	}

	public String getJobSalary() {
		return jobSalary;
	}

	public void setJobSalary(String jobSalary) {
		this.jobSalary = jobSalary;
	}

	public Timestamp getJobCreated() {
		return jobCreated;
	}

	public void setJobCreated(Timestamp jobCreated) {
		this.jobCreated = jobCreated;
	}

	public Timestamp getJobUpdated() {
		return jobUpdated;
	}

	public void setJobUpdated(Timestamp jobUpdated) {
		this.jobUpdated = jobUpdated;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	
	
	
	
	
}
