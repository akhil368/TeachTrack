package com.masai.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Batch implements Serializable{

	private int batchId ;
	private String courseName ;
	private int numberOfSeats ;
	private int duration ; 
	private LocalDate sDate ;
	public Batch(int batchId, String courseName, int numberOfSeats, int duration, LocalDate sDate) {
		super();
		this.batchId = batchId;
		this.courseName = courseName;
		this.numberOfSeats = numberOfSeats;
		this.duration = duration;
		this.sDate = sDate;
	}
	public Batch()
	{
		super();
	}
	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public LocalDate getsDate() {
		return sDate;
	}
	public void setsDate(LocalDate sDate) {
		this.sDate = sDate;
	}
	@Override
	public String toString() {
		return "Batch [batchId=" + batchId + ", courseName=" + courseName + ", numberOfSeats=" + numberOfSeats
				+ ", duration=" + duration + ", sDate=" + sDate + "]";
	}
	
	
	
}
