package com.masai.services;

import java.util.Map;

import com.masai.entity.Batch;
import com.masai.entity.Faculty;
import com.masai.exceptions.DuplicateDataException;
import com.masai.exceptions.FacultyException;
import com.masai.exceptions.InvalidDetailException;

public class FacultyServicesImpl implements FacultyServices{

	@Override
	public boolean login(String email, String password, Map<String, Faculty> faculty) throws InvalidDetailException {
		// TODO Auto-generated method stub
if (faculty.containsKey(email) ) {
			
			if(faculty.get(email).getPassword().equals(password)) {
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
	public void signUp(Faculty fal, Map<String, Faculty> faculty) throws DuplicateDataException {
		// TODO Auto-generated method stub
		if(faculty.containsKey(fal.getUserName()))
		{
			throw new DuplicateDataException("User Already Exists");
		}
		else {
			faculty.put(fal.getUserName(), fal);
		}
		
	}

	@Override
	public Batch viewBatch(int id, Faculty f, Map<Integer, Faculty> faculty) throws FacultyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id, Faculty f, Map<Integer, Faculty> faculty) throws FacultyException {
		// TODO Auto-generated method stub
		
	}

	
	
}
