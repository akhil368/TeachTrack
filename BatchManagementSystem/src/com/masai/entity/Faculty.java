package com.masai.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Faculty  implements Serializable {

	private int id ;
	private String name ;
	private String userName ;
	private String password;
	private ArrayList<Batch> b;
	

	
	public Faculty()
	{
		super();
	}

	
	public Faculty(int id, String name, String userName,ArrayList<Batch> b,String password) {
		super();
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.b=b;
		this.password=password;
	}
	public Faculty(int id, String name, String userName,String password) {
		super();
		this.id = id;
		this.name = name;
		this.userName = userName;
		
		
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
	
	


	public int getId() {
		return id;
	}

	public ArrayList<Batch> getB() {
		return b;
	}


	public void setB(Batch b) {
		this.b.add(b);
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
		return "Faculty [id=" + id + ", name=" + name + ", userName=" + userName + ", password=" + password + ", b=" + b
				+ "]";
	}

	
}
