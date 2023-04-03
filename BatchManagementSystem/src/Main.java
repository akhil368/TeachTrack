import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

import com.masai.entity.Batch;
import com.masai.entity.Course;
import com.masai.entity.Faculty;
import com.masai.exceptions.BatchException;
import com.masai.exceptions.DuplicateDataException;
import com.masai.exceptions.FacultyException;
import com.masai.exceptions.InvalidDetailException;
import com.masai.exceptions.NullArgumentException;
import com.masai.services.BatchServiceImpl;
import com.masai.services.BatchServices;
import com.masai.services.FacultyServices;
import com.masai.services.FacultyServicesImpl;
import com.masai.utilities.Admin;
import com.masai.utilities.FileExists;
import com.masai.utilities.IDGeneration;
public class Main {

	public static void main(String[] args) throws InvalidDetailException {
		// TODO Auto-generated method stub
		
		Map<Integer,Batch> batches=FileExists.batchFile();
		Map<Integer,Faculty> faculty=FileExists.facultyFile();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome , in Batch Monitoring System");
		try
		{
			int prefernce=0;
			do {
				System.out.println("Please enter your prefernce ,"+ " '1' ---> Admin Login , '2' ---> Faculty Login ,'3'---> Faculty SignUp '0' for exit");
				prefernce=sc.nextInt();
				switch(prefernce)
				{
				case 1:
					adminFunctionality(sc,batches,faculty);
					break;
					
				case 2:
					facultyFunctionality(sc,batches,faculty);
					break;
					
				case 3:
					facultySignUp(sc, faculty);
					break;
				case 0:
					System.out.println("Successfully Exited");
					break;
					
				default:
					throw new IllegalArgumentException("Invalid Selection");
				
				}
				
				
			}while(prefernce!=0);
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
		finally
		{
			try {
				ObjectOutputStream poos = new ObjectOutputStream(new FileOutputStream("Batch.ser"));
				poos.writeObject(batches);
				ObjectOutputStream coos = new ObjectOutputStream(new FileOutputStream("Faculty.ser"));
				coos.writeObject(batches);
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
		
		

	}
	private static void facultyFunctionality(Scanner sc,Map<Integer,Batch> batches,Map<Integer, Faculty> faculty )  throws BatchException,FacultyException, InvalidDetailException
	{
			BatchServices batchService=new BatchServiceImpl();
		
		FacultyServices facultyService=new FacultyServicesImpl();
		
		System.out.println("please enter the following details to login");
		System.out.println("please enter the email");
		String email = sc.next();
		System.out.println("Enter the password");
		String pass = sc.next();
		System.out.println("Enter your Id");
		int id=sc.nextInt();
		
		facultyLogin(id,email, pass, faculty, facultyService);
		try {
			int choice=0;
			do {
				System.out.println("Select the option of your choice");
				System.out.println("Press 1 to assign batch");
				System.out.println("Press 2 to delete a faculty");
				System.out.println("Press 3 to logout");
				choice=sc.nextInt();
				
				switch(choice)
				{
				case 1:
					facultyAssignBatch(sc, faculty,batches,facultyService);
					break;
					
				case 2:
					adminDelete(sc, batches, batchService);
					
				case 3:
					System.out.println("you have successsfully logout");
					break;
				default:
					System.out.println("invalid choice");
					break;
				}
				
			}while(choice<=2);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	private static void adminFunctionality(Scanner sc,Map<Integer,Batch> batches,Map<Integer,Faculty> faculty) throws BatchException,FacultyException, InvalidDetailException
	{
		adminLogin(sc);
		BatchServices batchService=new BatchServiceImpl();
		
		FacultyServices facultyService=new FacultyServicesImpl();
		
		int choice=0;
		
		try {
			do {
				System.out.println("Press 1 to Create Batch");
				System.out.println("Press 2 to View All Batch");
				System.out.println("Press 3 to Delete Batch");
				System.out.println("Press 4 to Update Batch");
				System.out.println("Press 5 to View Batch by Batch-ID");
				System.out.println("Press 6 to add Faculty to a Batch");
				System.out.println("Press 7 to View Batch by Faculty-ID");
				System.out.println("Press 8 to log out");
				choice=sc.nextInt();
				switch(choice)
				{
				case 1:
					String added=adminAddBatch(sc,batches,batchService);
					System.out.println(added);
					break;
				case 2:
					adminViewAllBatches(batches,batchService);
					break;
					
				case 3:
					adminDelete(sc,batches,batchService);
					break;
					
				case 4:
					adminUpdateBatch(sc,batches,batchService);
					break;
					
				case 5:
					Batch b=adminViewBatchByBatchId(sc,batches);
					System.out.println(b);
					break;
					
				case 6:
					adminAssignBatch(sc, faculty, batches, batchService);
					break;
				case 7:
					Faculty f=adminViewBatchByFaciltyId(sc,faculty);
					System.out.println(f);
					break;
				case 8:
					System.out.println("admin has successfully logout");
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + choice);
				
				}
				
			}
			while(choice<=7);
			
			
		}catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
	}
	public static void adminLogin(Scanner sc) throws InvalidDetailException {

		System.out.println("Enter the user name");
		String userName = sc.next();
		System.out.println("Enter the password");
		String password = sc.next();
		if (userName.equals(Admin.username) && password.equals(Admin.password)) {

			System.out.println("successfully login");
		} else {
			throw new InvalidDetailException("Invalid Admin Credentials");
		}
	}

	public static String adminAddBatch(Scanner sc, Map<Integer,Batch> batches, BatchServices bs) throws BatchException
	{
		String str=null;
		System.out.println("Please enter the Batch details");
		
		System.out.println("Enter the batch details");
		String name=sc.next();
		
		System.out.println("Enter the course Details ");
		String courseDetails =sc.next();
		
		System.out.println("Enter the number of seats :");
		int seats=sc.nextInt();
		
		System.out.println("Enter the start date in " + "dd/mm/yyyy "+ "format");
		String sDate=sc.next();
		
		LocalDate s1=LocalDate.parse(sDate);
		System.out.println("Enter the end date in " + "dd/mm/yyyy "+ "format");
		
		String eDate=sc.next();
		LocalDate s2=LocalDate.parse(eDate);
		
		long noOfDaysBetween = ChronoUnit.DAYS.between(s1, s2);
		
		Batch b=new Batch(name,IDGeneration.generateId(),courseDetails,seats, s1,s2,noOfDaysBetween);
		
		str=bs.createBatch(b, batches);
		
		return str;
		
	
		
	}
	
	public void adminAssignBatch(Scanner sc,int id,int batchId,Map<Integer, Faculty> faculty,Map<Integer, Batch> batches,BatchServices fService) throws FacultyException,BatchException 
	{
			System.out.println("Enter The Faculty Id");
			int fId=sc.nextInt();
			
			System.out.println("Enter the Batch Id");
			
			int bId=sc.nextInt();
			fService.assignBatch(fId, bId, faculty, batches);
	}

	public static void adminViewAllBatches(Map<Integer,Batch> batches,BatchServices bs) throws BatchException
	{
		bs.viewAllBatch(batches);
	}
	public static void adminDelete(Scanner sc,Map<Integer,Batch> batches,BatchServices bs) throws BatchException
	{
		System.out.println("Enter the id of the product which you want to delete");
		int id=sc.nextInt();
		bs.delete(id,  batches);
	}
	public static String adminUpdateBatch(Scanner sc, Map<Integer,Batch> batches, BatchServices bs) throws BatchException
	{
		String str=null;
		System.out.println("Please enter the id of batch which you want to update");
		
		int id=sc.nextInt();
		System.out.println("Enter the batch details");
		String name=sc.next();
		
		System.out.println("Enter the course Details ");
		String courseDetails =sc.next();
		
		System.out.println("Enter the number of seats :");
		int seats=sc.nextInt();
		
		System.out.println("Enter the start date in " + "dd/mm/yyyy"+ "format");
		String sDate=sc.next();
		
		LocalDate s1=LocalDate.parse(sDate);
		System.out.println("Enter the end date in " + "dd/mm/yyyy"+ "format");
		
		String eDate=sc.next();
		LocalDate s2=LocalDate.parse(eDate);
		
		long noOfDaysBetween = ChronoUnit.DAYS.between(s1, s2);
		
		Batch b=new Batch(name,id,courseDetails,seats, s1,s2,noOfDaysBetween);
		
		str=bs.updateBatch(id, b, batches);
		
		return str;
		
		
		
	}

	public static Batch adminViewBatchByBatchId(Scanner sc,Map<Integer,Batch> batches) throws BatchException
	{
		System.out.println("Please Enter Batch Id");
		int id=sc.nextInt();
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

	public static Faculty adminViewBatchByFaciltyId(Scanner sc,Map<Integer,Faculty> faculty) throws FacultyException{
		// TODO Auto-generated method stub
		int id=sc.nextInt();
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
	public static void adminAssignBatch(Scanner sc,Map<Integer, Faculty> faculty,Map<Integer, Batch> batches,BatchServices fService) throws FacultyException,BatchException, NullArgumentException 
	{
			System.out.println("Enter The Faculty Id");
			int fId=sc.nextInt();
			
			System.out.println("Enter the Batch Id");
			int bId=sc.nextInt();
			
			
			fService.assignBatch(fId, bId, faculty, batches);
	}

	//Faculty Functions
	public static void facultySignUp(Scanner sc,Map<Integer,Faculty> faculty) throws DuplicateDataException
	{
		System.out.println("Please Enter the following details to Signup");
		System.out.println("please enter the user name");
		String name = sc.next();
		System.out.println("Enter the password");
		String pass = sc.next();
	
		System.out.println("Enter the email id");
		String email = sc.next();
		
		System.out.println("Enter the user id in NUmbers");
		int id=sc.nextInt();
		Faculty f=new Faculty(id,name,email, pass);
		FacultyServices fservice=new FacultyServicesImpl();
		fservice.signUp(f, faculty);
		System.out.println("Faculty has Successfully Signed Up");
	}

	public static void facultyLogin(int id,String email,String pas,Map<Integer,Faculty> faculty, FacultyServices fService) throws InvalidDetailException
	{
		fService.login(id,email, pas, faculty);
		System.out.println("Faculty has Successfully Login");
		
	}
	public static void facultyUserDelete(int id,Map<Integer, Faculty> faculty,FacultyServices fService,Faculty f) throws FacultyException
	{
		fService.delete(id, f, faculty);
		
	}
	public static void facultyAssignBatch(Scanner sc,Map<Integer, Faculty> faculty,Map<Integer, Batch> batches,FacultyServices fService) throws FacultyException,BatchException, NullArgumentException 
	{
			System.out.println("Enter The Faculty Id");
			int fId=sc.nextInt();
			
			System.out.println("Enter the Batch Id");
			int bId=sc.nextInt();
			
			
			fService.assignBatch(fId, bId, faculty, batches);
	}


}
