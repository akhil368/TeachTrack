package com.masai.services;

import com.masai.entity.*;
import com.masai.exceptions.*;

import java.util.*;

public interface FacultyServices {



	
	
	
	
	public boolean login(int id,String email,String password, Map<Integer, Faculty> faculty) throws InvalidDetailException;

	public void signUp(Faculty cus, Map<Integer, Faculty> faculty) throws DuplicateDataException;
	
	
	public Faculty viewBatch(int id,Faculty f, Map<Integer,Faculty> faculty) throws FacultyException;
	

	public String assignBatch(int id,int batchId,Map<Integer, Faculty> faculty,Map<Integer, Batch> batches) throws FacultyException,BatchException, NullArgumentException ;
	
	
	public void delete(int id,Faculty f, Map<Integer,Faculty> faculty) throws FacultyException;
}
