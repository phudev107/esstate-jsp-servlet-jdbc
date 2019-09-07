package com.laptrinhjavaweb.entity;

import java.sql.Timestamp;

import com.laptrinhjavaweb.annotation.Column;

public class BaseEntity {
	
	@Column(name="id")
	private Long id;
	
	@Column(name="createdby")
	private String createdBy;	
	
	@Column(name="modifiedby")
	private String modifiedBy;	
	
	@Column(name="createddate")
	private Timestamp createdDate;	
	
	@Column(name="modifieddate")
	private Timestamp modifiedDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public Timestamp getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	
}
