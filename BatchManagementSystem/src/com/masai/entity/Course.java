package com.masai.entity;

public class Course {
	private String name;
	private String description;
	private int code;
	
	public Course()
	{
		super();
	}
	public Course(String name, String description, int code) {
		super();
		this.name = name;
		this.description = description;
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "Course [name=" + name + ", description=" + description + ", code=" + code + "]";
	}
	
	
	
	
}
