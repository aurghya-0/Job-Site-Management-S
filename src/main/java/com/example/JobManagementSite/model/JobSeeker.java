package com.example.JobManagementSite.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="JobSeeker")
public class JobSeeker {

	@Id
	@GeneratedValue
	private int jobSeekerId;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private User user;
	
	@Column(nullable=false)
	private String fullName;
	
	@Column(nullable=false)
	private String phoneNumber;
	
	@Column(nullable=false)
	private String address;
	
	@Column(nullable=false)
	private String education;
	
	@Column(nullable=false)
	private String majorSkill;
	
	@Column(nullable=false)
	private Timestamp createdAt;
	
	@Column(nullable=false)
	private Timestamp updatedAt;
	
	
	
	
	
}
