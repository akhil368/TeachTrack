package com.masai.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Faculty  implements Serializable {

	private int id ;
	private String name ;
	private String userName ;
	private String password;
	private Batch b;
	private String batches;
private String description; 
	
	public Faculty()
	{
		super();
	}

	
	public Faculty(int id, String name, String userName, String batches, String description,Batch b,String password) {
		super();
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.batches = batches;
		this.description = description;
		this.b=b;
		this.password=password;
	}


	public void setPassword(String password)
	{
		this.password=password;
	}
	public String getPassword()
	{
		return this.password;
	}
	public void setBatches(String batches)
	{
		this.batches=batches;
	}
	public String getBatches()
	{
		return this.batches;
	}
	public Faculty(int id, String name, String userName, Batch b, String batches, String description) {
		super();
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.b = b;
		this.batches = batches;
		this.description = description;
	}


	public int getId() {
		return id;
	}

	public Batch getB() {
		return b;
	}


	public void setB(Batch b) {
		this.b = b;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
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

	
	@Override
	public String toString() {
		return "Faculty [id=" + id + ", name=" + name + ", userName=" + userName + ", b=" + b + ", batches=" + batches
				+ ", description=" + description + "]";
	}

	
}
