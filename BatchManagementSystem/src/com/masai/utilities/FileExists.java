package com.masai.utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import com.masai.entity.*;
public class FileExists {

	
	public static Map<Integer,Batch> batchFile()

	{
		Map<Integer,Batch> bFile=null;
		File f=new File("Batch.ser");
		boolean flag=false;
		try
		{
			if(!f.exists())
			{
				f.createNewFile();
				flag=true;
			}
			if(flag)
			{
				bFile=new LinkedHashMap<>();
				ObjectOutputStream oos=new  ObjectOutputStream(new FileOutputStream(f));
				oos.writeObject(bFile);
				return bFile;
			}
			else {
				ObjectInputStream ois=new ObjectInputStream(new FileInputStream(f));
				bFile=(Map<Integer,Batch>) ois.readObject();
				return bFile;
			}
		}
		 catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		return bFile;
	}
	
	
	public static Map<Integer,Faculty> facultyFile()
	{
		Map<Integer,Faculty> fFile=null;
		File f=new File("Faculty.ser");
		boolean flag=false;
		try
		{
			if(!f.exists())
			{
				f.createNewFile();
				flag=true;
			}
			if(flag)
			{
				fFile=new LinkedHashMap<>();
				ObjectOutputStream oos=new  ObjectOutputStream(new FileOutputStream(f));
				oos.writeObject(fFile);
				return fFile;
			}
			else {
				ObjectInputStream ois=new ObjectInputStream(new FileInputStream(f));
				fFile=(Map<Integer,Faculty>) ois.readObject();
				return fFile;
			}
		}
		 catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		return fFile;
	}
	
}
