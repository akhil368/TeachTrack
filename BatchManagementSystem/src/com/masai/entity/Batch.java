package com.masai.entity;


import com.masai.exceptions.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;

public class Batch implements Serializable{

	private int batchId ;
	private Course course;
	private HashMap<Integer ,Faculty> assignedFaculty=new HashMap<>();
	private String courseName ;
	private int numberOfSeats ;
	private long duration ; 
	private LocalDate sDate ;
	private LocalDate edate;
	public Batch(int batchId, String courseName, int numberOfSeats, int duration, LocalDate sDate) {
		super();
		this.batchId = batchId;
		this.courseName = courseName;
		this.numberOfSeats = numberOfSeats;
		this.duration = duration;
		this.sDate = sDate;
	}
	 public HashMap<Integer, Faculty> getAssignedFaculties() {
	        return assignedFaculty;
	    }
	public void addFaculties(Faculty... faculties) throws NullArgumentException {
        for(Faculty faculty : faculties) {
            if(faculty == null)
                throw new NullArgumentException("Cannot add null ");
        }

        for(Faculty faculty : faculties) {
        	assignedFaculty.put(faculty.getId(), faculty);
        }
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
	public long getDuration() {
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
