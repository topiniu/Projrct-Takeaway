package com.topiniu.takeaway.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="tb_user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String password;
	
	@OneToOne(targetEntity=IdentityInformation.class)
	@JoinColumn(name="identity_id",referencedColumnName="id",nullable=true)
	private IdentityInformation identity;
	
	private int isCCStore;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public IdentityInformation getIdentity() {
		return identity;
	}
	public void setIdentity(IdentityInformation identity) {
		this.identity = identity;
	}
	public int getIsCCStore() {
		return isCCStore;
	}
	public void setIsCCStore(int isCCStore) {
		this.isCCStore = isCCStore;
	}
}
