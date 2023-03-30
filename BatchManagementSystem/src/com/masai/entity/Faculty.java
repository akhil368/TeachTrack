package com.masai.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Faculty  implements Serializable {

	private int id ;
	private String name ;
	private String userName ;
	
	private String batches;
private String description; 
	
	public Faculty()
	{
		super();
	}

	
	public Faculty(int id, String name, String userName, String batches, String description) {
		super();
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.batches = batches;
		this.description = description;
	}


	public void setBatches(String batches)
	{
		this.batches=batches;
	}
	public String getBatches()
	{
		return this.batches;
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

	

	

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", name=" + name + ", userName=" + userName + ", batches=" + batches
				+ ", description=" + description + "]";
	}

	
}
