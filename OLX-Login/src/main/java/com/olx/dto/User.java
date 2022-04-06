package com.olx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="Login DTO")
public class User {
	
	@ApiModelProperty(value="Login fname")
	private String firstName;
	@ApiModelProperty(value="Login lname")
	private String lastName;
	@ApiModelProperty(value="Login uname")
	private String userName;
	@ApiModelProperty(value="Login password")
	private String password;
	@ApiModelProperty(value="Login email")
	private String email;
	@ApiModelProperty(value="Login phoneNo")
	private String phoneNo;
	public User(String firstName, String lastName, String userName, String password, String email, String phoneNo) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phoneNo = phoneNo;
	}
	public User() {
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
	
	

}
