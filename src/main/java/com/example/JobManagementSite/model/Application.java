package com.example.JobManagementSite.model;

import java.security.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="Application")
public class Application 
{
	@Id @GeneratedValue
	private int applicationId;
	
	@Column(nullable=false)
	private int applicationJobId;
	
	@Column(nullable=false)
	private String applicationStat;
	
	@Column(nullable=false)
	private int applicantId;
	
	@Column(nullable=false)
	private Timestamp applicationCreated;
	
	@Column(nullable=false)
	private Timestamp applicationUpdated;

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public int getApplicationJobId() {
		return applicationJobId;
	}

	public void setApplicationJobId(int applicationJobId) {
		this.applicationJobId = applicationJobId;
	}

	public String getApplicationStat() {
		return applicationStat;
	}

	public void setApplicationStat(String applicationStat) {
		this.applicationStat = applicationStat;
	}

	public int getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}

	public Timestamp getApplicationCreated() {
		return applicationCreated;
	}

	public void setApplicationCreated(Timestamp applicationCreated) {
		this.applicationCreated = applicationCreated;
	}

	public Timestamp getApplicationUpdated() {
		return applicationUpdated;
	}

	public void setApplicationUpdated(Timestamp applicationUpdated) {
		this.applicationUpdated = applicationUpdated;
	}
	
}