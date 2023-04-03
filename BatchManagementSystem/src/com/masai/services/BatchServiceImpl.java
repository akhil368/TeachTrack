package com.masai.services;
import java.util.Map;

import com.masai.entity.*;
import com.masai.exceptions.*;


public class BatchServiceImpl implements BatchServices {

	@Override
	public String createBatch(Batch b, Map<Integer, Batch> batches) {
		// TODO Auto-generated method stub
		batches.put(b.getBatchId(),b);
		return "Product added Successfully";
	}

	@Override
	public String updateBatch(int id, Batch b, Map<Integer, Batch> batches) throws BatchException{
		// TODO Auto-generated method stub
		if(batches!=null && batches.size()>0)
		{
			if(batches.containsKey(id))
			{
				batches.put(id, b);
				return "Batch has been succesfully updated";
			}
			else {
				throw new BatchException("Batch not found");
			}
		}
		else {
			throw new BatchException("Batch list is Empty");
		}
		
	}

	@Override
	public String assignBatch(int id,int batchId,Map<Integer, Faculty> faculty,Map<Integer, Batch> batches) throws FacultyException,BatchException {
		// TODO Auto-generated method stub
		if(faculty!=null && faculty.size()>0 )
		{
			if( batches!=null && batches.size()>0 )
			try {
				Faculty f=faculty.get(id);
				Batch b=batches.get(batchId);
				b.addFaculties(f);
				return ("Batch is Successfully Assigned ");
			} catch (NullArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			else {
				throw new BatchException("Batch is not available");
			}
		}
		else {
			throw new FacultyException("Faculty or Batch with entered id is not Available");
		}
		return "Faculty or Batch with entered id is not Available";
		
	}

	@Override
	public Batch viewBatchByBacthId(int id, Batch b, Map<Integer, Batch> batches) throws BatchException{
		if(batches!=null && batches.size()>0)
		{
			if(batches.containsKey(id))
			{
				
				return batches.get(id);
			}
			else {
				throw new BatchException("Batch not found");
			}
		}
		else {
			throw new BatchException("Batch list is Empty");
		}
	}

	@Override
	public Faculty viewBatchByFaciltyId(int id,Batch b,Map<Integer,Faculty> faculty) throws FacultyException{
		// TODO Auto-generated method stub
		if(faculty!=null && faculty.size()>0)
		{
			if(faculty.containsKey(id))
			{
				return faculty.get(id);
			}
			else {
				throw new FacultyException("Batch not found");
			}
		}
		else {
			throw new FacultyException("Batch list is Empty");
		}
	}

	@Override
	public void viewAllBatch(Map<Integer, Batch> batches) throws BatchException{
		// TODO Auto-generated method stub
		if(batches !=null && batches.size()>0)
		{
			for(Map.Entry<Integer,Batch> me :batches.entrySet())
			{
				System.out.println(me.getValue());
			}
		}
		else {
			throw new BatchException("Batch List is Empty");
		}

	}

	@Override
	public void delete(int id, Map<Integer, Batch> batches) throws BatchException{
		// TODO Auto-generated method stub
		if(batches!=null && batches.size()>0)
		{
			if(batches.containsKey(id))
			{
				batches.remove(id);
				System.out.println( "Batch has been succesfully Deleted");
			}
			else {
				throw new BatchException("Batch not found");
			}
		}
		else {
			throw new BatchException("Batch list is Empty");
		}
	}

}
