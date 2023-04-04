package com.example.JobManagementSite.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="Company")
public class Company {

	@Id
	@GeneratedValue
	private int companyId;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private User user;
	
	@Column(nullable=false)
	private String companyName;
	
	@Column(nullable=false)
	private String companyDesc;
	
	@Column(nullable=false)
	private String companyLoc;
	
	@Column(nullable=false)
	private String companyEstablishmentDate;

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyDesc() {
		return companyDesc;
	}

	public void setCompanyDesc(String companyDesc) {
		this.companyDesc = companyDesc;
	}

	public String getCompanyLoc() {
		return companyLoc;
	}

	public void setCompanyLoc(String companyLoc) {
		this.companyLoc = companyLoc;
	}

	public String getCompanyEstablishmentDate() {
		return companyEstablishmentDate;
	}

	public void setCompanyEstablishmentDate(String companyEstablishmentDate) {
		this.companyEstablishmentDate = companyEstablishmentDate;
	}

	
	
}
