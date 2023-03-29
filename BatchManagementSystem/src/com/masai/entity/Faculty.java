package com.masai.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Faculty extends AdminFunction implements Serializable {

	private int id ;
	private String name ;
	private String userName ;
	private String password ;
	
	public Faculty()
	{
		
	}

	public Faculty(int batchId, String courseName, int numberOfSeats, int duration, LocalDate sDate) {
		super(batchId, courseName, numberOfSeats, duration, sDate);
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.password = password;
	}

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

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", name=" + name + ", userName=" + userName + ", password=" + password + "]";
	}

	
}
