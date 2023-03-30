package com.masai.services;

import com.masai.entity.*;
import java.util.*;


public interface BatchServices {

	public String createBatch(Batch b,Map<Integer,Batch> batches );
	
	public String updateBatch(int id,Batch b,Map<Integer,Batch> batches);
	
	
	public String assignBacth(int id);
	
	public String viewBatch(int id);
	
	public String viewBatchByFaciltyId(int id);
	
	public String viewAllBatch(Map<Integer,Batch> batches);
	
	public String delete(int id,Batch b, Map<Integer,Batch> batches);
	
}
