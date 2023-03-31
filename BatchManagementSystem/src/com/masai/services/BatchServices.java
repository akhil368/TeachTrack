package com.masai.services;

import com.masai.entity.*;
import com.masai.exceptions.BatchException;

import java.util.*;


public interface BatchServices {

	public String createBatch(Batch b,Map<Integer,Batch> batches );
	
	public String updateBatch(int id,Batch b,Map<Integer,Batch> batches) throws BatchException;
	
	
	public String assignBatch(int id) throws BatchException;
	
	public Batch viewBatch(int id, Batch b, Map<Integer, Batch> batches) throws BatchException;
	
	public String viewBatchByFaciltyId(int id) throws BatchException;
	
	public void viewAllBatch(Map<Integer,Batch> batches) throws BatchException;
	
	public void delete(int id,Batch b, Map<Integer,Batch> batches) throws BatchException;
	
}
