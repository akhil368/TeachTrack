package com.masai.entity;

public class Course {
	private String name;
	private String description;
	private String code;
	
	public Course()
	{
		super();
	}
	public Course(String name, String description, String code) {
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "Course [name=" + name + ", description=" + description + ", code=" + code + "]";
	}
	
	
	
	
}
