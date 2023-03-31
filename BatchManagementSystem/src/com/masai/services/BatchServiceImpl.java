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
	public String assignBatch(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Batch viewBatch(int id, Batch b, Map<Integer, Batch> batches) throws BatchException{
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
	public String viewBatchByFaciltyId(int id) {
		// TODO Auto-generated method stub
		return null;
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
	public void delete(int id, Batch b, Map<Integer, Batch> batches) throws BatchException{
		// TODO Auto-generated method stub
		if(batches!=null && batches.size()>0)
		{
			if(batches.containsKey(id))
			{
				batches.remove(id, b);
				System.out.println( "Batch has been succesfully updated");
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
