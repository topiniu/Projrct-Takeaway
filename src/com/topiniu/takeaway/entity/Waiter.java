package com.topiniu.takeaway.entity;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="tb_waiter")
public class Waiter {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int waiterId;
	private String petName;
	
	@ManyToOne(targetEntity=Store.class)
	@JoinColumn(name="store_id",referencedColumnName="id",nullable=false)
	private Store store;
	
	private String stage;
	private Date creatDate;
	private Date updateDate;
	
	@OneToOne(targetEntity=IdentityInformation.class)
	@JoinColumn(name="identity_id",referencedColumnName="id",nullable=false)
	private IdentityInformation identityInfo;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWaiterId() {
		return waiterId;
	}
	public void setWaiterId(int waiterId) {
		this.waiterId = waiterId;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public Date getCreatDate() {
		return creatDate;
	}
	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public IdentityInformation getIdentityInfo() {
		return identityInfo;
	}
	public void setIdentityInfo(IdentityInformation identityInfo) {
		this.identityInfo = identityInfo;
	}
	
	
}
