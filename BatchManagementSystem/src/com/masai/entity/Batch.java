package com.masai.entity;
import java.time.temporal.ChronoUnit;

import com.masai.exceptions.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Batch implements Serializable{

	private int batchId ;
	private String bName;
	private String course;

	private ArrayList<Faculty> b;
	
	private int numberOfSeats ;
	private long duration ; 
	private LocalDate sDate ;
	private LocalDate eDate;
	
	
	public Batch()
	{
		super();
	}
	public Batch(String bName,int batchId,  String course,int numberOfSeats, LocalDate sDate,LocalDate eDate,long duration) {
		super();
		this.bName=bName;
		this.batchId = batchId;
		this.course=course;
		this.numberOfSeats = numberOfSeats;
		this.duration = duration;
		this.sDate = sDate;
		this.eDate=eDate;
	}
	
	public ArrayList<Faculty> getAssignedFaculties() {
	        return b;
	    }
	public void addFaculties(Faculty b) throws NullArgumentException {
       this.b.add(b);
    }
	
	
	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public LocalDate getsDate() {
		return sDate;
	}
	public void setsDate(LocalDate sDate) {
		this.sDate = sDate;
	}
	public LocalDate geteDate() {
		return eDate;
	}
	public void seteDate(LocalDate eDate) {
		this.eDate = eDate;
	}
	@Override
	public String toString() {
		return "Batch [batchId=" + batchId + ", bName=" + bName + ", course=" + course + ", b=" + b + ", numberOfSeats="
				+ numberOfSeats + ", duration=" + duration + ", sDate=" + sDate + ", eDate=" + eDate + "]";
	}
	
	
	
	
	
	
}
