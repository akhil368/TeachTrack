package com.masai.services;

import com.masai.entity.*;
import com.masai.exceptions.*;

import java.util.*;

public interface FacultyServices {

	

	
	
	
	
	public boolean login(String email,String password, Map<String, Faculty> faculty) throws InvalidDetailException;

	public void signUp(Faculty cus, Map<String, Faculty> faculty) throws DuplicateDataException;
	
	
	public Batch viewBatch(int id,Faculty f, Map<Integer,Faculty> faculty) throws FacultyException;
	

	
	
	
	public void delete(int id,Faculty f, Map<Integer,Faculty> faculty) throws FacultyException;
}
