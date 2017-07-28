package com.topiniu.takeaway.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="tb_store")
public class Store {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int shopId;
	private String shopName;
	
	@OneToOne(targetEntity=User.class)
	@JoinColumn(name="user_id",referencedColumnName="id",nullable=false)
	private User user;
	private Date createDate;
	private Date updateDate;
	private int collectNumber;
	
	@OneToMany(targetEntity=Waiter.class,mappedBy="store")
	private List<Waiter> waiterList;
	@OneToMany(targetEntity=Goods.class,mappedBy="store")
	private List<Goods> goodList;
	
	private int saledNum;
	private int creditLevel;
	
	
	public Store(String shopName,Date createDate,User user) {
		// TODO Auto-generated constructor stub
		this.shopName = shopName;
		this.createDate = createDate;
		this.user = user;
	}
	public Store() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
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
	public int getCollectNumber() {
		return collectNumber;
	}
	public void setCollectNumber(int collectNumber) {
		this.collectNumber = collectNumber;
	}
	public List<Waiter> getWaiterList() {
		return waiterList;
	}
	public void setWaiterList(List<Waiter> waiterList) {
		this.waiterList = waiterList;
	}
	public List<Goods> getGoodList() {
		return goodList;
	}
	public void setGoodList(List<Goods> goodList) {
		this.goodList = goodList;
	}
	public int getSaledNum() {
		return saledNum;
	}
	public void setSaledNum(int saledNum) {
		this.saledNum = saledNum;
	}
	public int getCreditLevel() {
		return creditLevel;
	}
	public void setCreditLevel(int creditLevel) {
		this.creditLevel = creditLevel;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
