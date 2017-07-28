package com.topiniu.takeaway.entity;

import java.sql.Date;

import javax.persistence.*;


@Entity
@Table(name="tb_application")
public class Application {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String createDate;
	private int status;//处理情况0否1正
	private String schedule;
	private String applicationText;
	
	@ManyToOne(targetEntity=Manager.class,cascade=CascadeType.ALL)
	@JoinColumn(name="manager_id",referencedColumnName="id",nullable=false)
	private Manager manager;
	
	@OneToOne(targetEntity=IdentityInformation.class,cascade=CascadeType.ALL)
	@JoinColumn(name="identity_Id",referencedColumnName="id",nullable=true)
	private IdentityInformation identityInfo;

	@OneToOne(targetEntity=User.class,cascade=CascadeType.ALL)
	@JoinColumn(name="user_Id",referencedColumnName="id",nullable=true)
	private User user;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public IdentityInformation getIdentityInfo() {
		return identityInfo;
	}
	public void setIdentityInfo(IdentityInformation identityInfo) {
		this.identityInfo = identityInfo;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public String getApplicationText() {
		return applicationText;
	}
	public void setApplicationText(String applicationText) {
		this.applicationText = applicationText;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
