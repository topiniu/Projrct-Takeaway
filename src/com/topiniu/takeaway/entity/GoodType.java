package com.topiniu.takeaway.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="tb_goodtype")
public class GoodType {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private Date createDate;
	private Date updateDate;
	
	@OneToMany(targetEntity=Goods.class,mappedBy="type")
	private List<Goods> goodsList;
	
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
	public List<Goods> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}
	
	
}
