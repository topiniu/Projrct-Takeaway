package com.topiniu.takeaway.entity;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="tb_identity")
public class IdentityInformation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String identityNumber;
	private String identityType;
	private String birthDate;
	private String name;
	private String sex;
	private String address;
	private String tel;
	private String photo;
	private int isTrue;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdentityNumber() {
		return identityNumber;
	}
	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}
	public String getIdentityType() {
		return identityType;
	}
	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getphoto() {
		return photo;
	}
	public void setphoto(String photo) {
		this.photo = photo;
	}
	public int getIsTrue() {
		return isTrue;
	}
	public void setIsTrue(int isTrue) {
		this.isTrue = isTrue;
	}
	
	
}
