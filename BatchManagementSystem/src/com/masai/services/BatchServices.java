package com.masai.services;

import com.masai.entity.*;
import com.masai.exceptions.BatchException;
import com.masai.exceptions.FacultyException;

import java.util.*;


public interface BatchServices {

	public String createBatch(Batch b,Map<Integer,Batch> batches );
	
	public String updateBatch(int id,Batch b,Map<Integer,Batch> batches) throws BatchException;
	
	
	public String assignBatch(int id,int batchId,Map<Integer, Faculty> faculty,Map<Integer, Batch> batches) throws BatchException,FacultyException;
	
	public Batch viewBatchByBacthId(int id, Batch b, Map<Integer, Batch> batches) throws BatchException;
	
	public Faculty viewBatchByFaciltyId(int id,Batch b,Map<Integer,Faculty> faculty) throws FacultyException;
	
	public void viewAllBatch(Map<Integer,Batch> batches) throws BatchException;
	
	public void delete(int id, Map<Integer,Batch> batches) throws BatchException;
	
}
