package com.olx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="MasterData DTO")
public class Categories {
	
	@ApiModelProperty(value="MasterData identifier")
	private int id;
	@ApiModelProperty(value="MasterData categories")
	private String categories;
	
	public Categories(int id, String categories) {
	super();
	this.id = id;
	this.categories = categories;
	}
	public Categories() {
	super();
	}
	public int getId() {
	return id;
	}
	public void setId(int id) {
	this.id = id;
	}
	public String getCategories() {
	return categories;
	}
	public void setCategories(String categories) {
	this.categories = categories;
	}
	@Override
	public String toString() {
	return "Categories [id=" + id + ", categories=" + categories + "]";
	}
}
