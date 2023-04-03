package com.masai.services;

import java.util.Map;

import com.masai.entity.Batch;
import com.masai.entity.Faculty;
import com.masai.exceptions.BatchException;
import com.masai.exceptions.DuplicateDataException;
import com.masai.exceptions.FacultyException;
import com.masai.exceptions.InvalidDetailException;
import com.masai.exceptions.NullArgumentException;

public class FacultyServicesImpl implements FacultyServices{

	@Override
	public boolean login(int id,String email, String password, Map<Integer, Faculty> faculty) throws InvalidDetailException {
		// TODO Auto-generated method stub
if (faculty.containsKey(id) ) {
			
			if(faculty.get(id).getPassword().equals(password)) {
				return true;
			}
			else {
				throw new InvalidDetailException("Invalid Credentials");
			}
			
		} else {
			throw new InvalidDetailException("you have not sign up yet, please signup");
		}
		
	}

	@Override
	public void signUp(Faculty fal, Map<Integer, Faculty> faculty) throws DuplicateDataException {
		// TODO Auto-generated method stub
		if(faculty.containsKey(fal.getId()))
		{
			throw new DuplicateDataException("User Already Exists");
		}
		else {
			faculty.put(fal.getId(), fal);
		}
		
	}

	@Override
	public Faculty viewBatch(int id, Faculty f, Map<Integer, Faculty> faculty) throws FacultyException {
		// TODO Auto-generated method stub
		if(faculty!=null && faculty.size()>0)
		{
			if(faculty.containsKey(id))
			{
				return faculty.get(id);
			}
			else {
				throw new FacultyException("Faculty not found");
			}
		}
		else {
			throw new FacultyException("Faculty list is Empty");
		}
		
		
		
	
	}
	public String assignBatch(int id,int batchId,Map<Integer, Faculty> faculty,Map<Integer, Batch> batches) throws FacultyException,BatchException, NullArgumentException{
	if(faculty!=null && faculty.size()>0 )
	{
		if( batches!=null && batches.size()>0 ) {
			Faculty f=faculty.get(id);
			Batch b=batches.get(batchId);
			
	
			f.setB(b);
			
			return ("Batch is Successfully Assigned ");
		} else {
			throw new BatchException("Batch is not available");
		}
	}
	else {
		throw new FacultyException("Faculty or Batch with entered id is not Available");
	}
	
	
}
	@Override
	public void delete(int id, Faculty f, Map<Integer, Faculty> faculty) throws FacultyException {
		// TODO Auto-generated method stub
		if(faculty!=null && faculty.size()>0)
		{
			if(faculty.containsKey(id))
			{
				faculty.remove(id, f);
				System.out.println( "Faculty has been succesfully Deleted");
			}
			else {
				throw new FacultyException("Faculty not found");
			}
		}
		else {
			throw new FacultyException("Faculty list is Empty");
		}
	}
}
		
	

	
	

