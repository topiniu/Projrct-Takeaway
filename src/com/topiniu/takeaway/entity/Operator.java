package com.topiniu.takeaway.entity;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="tb_operator")
public class Operator {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(targetEntity=IdentityInformation.class)
	@JoinColumn(name="identity_id",referencedColumnName="id",nullable=false)
	private IdentityInformation identityInfo;

	@OneToOne(targetEntity=Store.class)
	@JoinColumn(name="store_id",referencedColumnName="id",nullable=true)	
	private Store store;
	
	private Date createDate;
	private Date updateDate;

	@OneToOne(targetEntity=Application.class)
	@JoinColumn(name="application_id",referencedColumnName="id",nullable=false)
	private Application application;
	
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
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Application getApplication() {
		return application;
	}
	public void setApplication(Application application) {
		this.application = application;
	}
	
	
}
