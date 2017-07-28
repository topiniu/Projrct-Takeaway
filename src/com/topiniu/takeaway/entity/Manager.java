package com.topiniu.takeaway.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="tb_manager")
public class Manager {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nicName;
	private String password;
	private String email;
	
	@OneToOne(targetEntity=IdentityInformation.class)
	@JoinColumn(name="identity_id",referencedColumnName="id",nullable=false)
	private IdentityInformation identityInfo;
	
	@OneToMany(targetEntity=Application.class,mappedBy="manager",fetch=FetchType.EAGER)
	private List<Application> applicationList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public IdentityInformation getIdentityInfo() {
		return identityInfo;
	}
	public void setIdentityInfo(IdentityInformation identityInfo) {
		this.identityInfo = identityInfo;
	}
	public String getNicName() {
		return nicName;
	}
	public void setNicName(String nicName) {
		this.nicName = nicName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Application> getApplicationList() {
		return applicationList;
	}
	public void setApplicationList(List<Application> applicationList) {
		this.applicationList = applicationList;
	}
	
	
}
