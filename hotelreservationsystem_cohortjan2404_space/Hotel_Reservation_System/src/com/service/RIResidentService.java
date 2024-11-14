 package com.service;
 import java.util.*;


import com.management.RIResidentManagement;
import com.model.*;
import com.util.ApplicationUtil;
 
 
public class RIResidentService 

{
	RIResidentManagement finalObj=new RIResidentManagement();
	public List<RIResident> add(String[] det)
	{
		ApplicationUtil appUtil=new ApplicationUtil();
		
		List<String> obj=appUtil.convertList(det);
		
		List<RIResident> obj1=buildRIResident(obj);
		
		
		
		List<RIResident> result=finalObj.insertRIResidentList(obj1);
		
		return result;
		
	}
	
	

	public List<RIResident> buildRIResident(List<String> obj)
	{
			List<RIResident> ri1=new ArrayList<>();
			for(String a:obj)
			{
				String arr[]=a.split(":");
				String id=generateId();
				String name=arr[0];
				int age=ApplicationUtil.convertInt1(arr[1]);
				String gender=arr[2];
				long cn=ApplicationUtil.convertLong(arr[3]);
				String email=arr[4];
				String address=arr[5];
				int noOfAdults=ApplicationUtil.convertInt1(arr[6]);
				int noOfChildren12=ApplicationUtil.convertInt1(arr[7]);
				int noOfChildren5=ApplicationUtil.convertInt1(arr[8]);
				int ds=ApplicationUtil.convertInt1(arr[9]);
				String rtype=arr[10];
				long Idproof_AadharNo=ApplicationUtil.convertLong(arr[11]);
				
				ri1.add(new RIResident(id,name,age,gender,cn,email,address,noOfAdults,noOfChildren12,noOfChildren5,ds,rtype,Idproof_AadharNo));
			}
			
			
			return ri1;
	}
		
	
	
	
	
	private RIResidentManagement riResidentManagement;

    public RIResidentService(RIResidentManagement riResidentManagement) {
        this.riResidentManagement = riResidentManagement;
    }

    public RIResidentService() {
		// TODO Auto-generated constructor stub
	}

	// Method to add a list of RI Residents to the system and confirm successful insertion
    
    
    private static int counter = 1; 
    private static final String PREFIX = "RI"; 
    public String generateId() {
    	
       if(counter==1) {
    	   counter=finalObj.checkIdExit();
       }
       counter++;
        String id = PREFIX + counter;
        
        
        return id;
    }
    // Method to generate a unique ID for RI residents

    
    
    public boolean updateRIResidentPhoneNumberUsingResidentId(String residentId, long newPhoneNumber) {
        return finalObj.updateRIResidentPhoneNumberUsingResidentId(residentId, newPhoneNumber);
    }
    
 
    public boolean updateOccupancyUsingResidentId(String residentId, int numberOfAdults, int numberOfChildrenAbove12, int numberOfChildrenAbove5) {
        
        if (residentId == null || residentId.isEmpty() || numberOfAdults < 0 || numberOfChildrenAbove12 < 0 || numberOfChildrenAbove5 < 0) {
            return false; 
        }

        
        return finalObj.updateOccupancyUsingResidentId(residentId, numberOfAdults, numberOfChildrenAbove12, numberOfChildrenAbove5);
    } 
    
    
    
    public boolean updateOccupancyUsingIdProof(long idProof, int numberOfAdults, int numberOfChildrenAbove12, int numberOfChildrenAbove5) {
        if (idProof <= 0 || numberOfAdults < 0 || numberOfChildrenAbove12 < 0 || numberOfChildrenAbove5 < 0) {
            return false;
        }
        return finalObj.updateOccupancyUsingIdProof(idProof, numberOfAdults, numberOfChildrenAbove12, numberOfChildrenAbove5);
    }

    // Method to update occupancy details of an RI resident using their contact number
    public boolean updateOccupancyUsingContactNumber(long contactNumber, int numberOfAdults, int numberOfChildrenAbove12, int numberOfChildrenAbove5) 
    {
        if (contactNumber <= 0 || numberOfAdults < 0 || numberOfChildrenAbove12 < 0 || numberOfChildrenAbove5 < 0) 
        {
            return false;
        }
        return finalObj.updateOccupancyUsingContactNumber(contactNumber, numberOfAdults, numberOfChildrenAbove12, numberOfChildrenAbove5);
    }

    // Method to retrieve RI resident details based on the resident ID
    public RIResident retrieveRIResidentDetails(String residentId) 
    {
//    	System.out.println(residentId);
       
        return finalObj.retrieveRIdetails(residentId);
    }

    // Method to delete RI resident details from the database using the resident ID
    public boolean deleteRIResidentDetailsFromDB(String residentId) 
    {
        if (residentId == null || residentId.isEmpty()) 
        {
            return false;
        }
        return finalObj.deleteRIResidentDetailsFromDB(residentId);
    }
    public boolean updateRIResidentPhoneNumberUsingIdProof(long IDproof, long newPhoneNumber) {
        return finalObj.updateRIResidentPhoneNumberUsingIdProof(IDproof, newPhoneNumber);
    }
    
    
    

    
}





	


