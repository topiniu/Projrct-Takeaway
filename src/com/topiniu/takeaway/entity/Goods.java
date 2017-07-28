package com.topiniu.takeaway.entity;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="tb_goods")
public class Goods {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private Date createDate;
	private Date updateDate;
	private String introduction;
	private String goodPhoto;
	
	private int saledNumber;
	
	@ManyToOne(targetEntity=Store.class)
	@JoinColumn(name="store_id",referencedColumnName="id",nullable=false)
	private Store store;
	
	@ManyToOne(targetEntity=GoodType.class)
	@JoinColumn(name="goodtype_id",referencedColumnName="id",nullable=false)
	private GoodType type;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getGoodPhoto() {
		return goodPhoto;
	}
	public void setGoodPhoto(String goodPhoto) {
		this.goodPhoto = goodPhoto;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public int getSaledNumber() {
		return saledNumber;
	}
	public void setSaledNumber(int saledNumber) {
		this.saledNumber = saledNumber;
	}
	public GoodType getType() {
		return type;
	}
	public void setType(GoodType type) {
		this.type = type;
	}
	
	
}
