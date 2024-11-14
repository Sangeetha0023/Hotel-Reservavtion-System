package com.service;
import java.util.*;
import java.util.List;

import com.management.NRIResidentManagement;

import com.model.NRIResident;

import com.util.ApplicationUtil;

public class NRIResidentService 
{
	NRIResidentManagement finalObj=new NRIResidentManagement();
	public List<NRIResident> add(String[] det)
	{
		ApplicationUtil appUtil=new ApplicationUtil();

		
		List<String> obj=appUtil.convertList(det);
		
		List<NRIResident> obj1=buildNriResident(obj);
		
		
		
		List<NRIResident> result=finalObj.insertNRIResidentList(obj1);
		
		return result;
		
	}
	
	public List<NRIResident> buildNriResident(List<String> obj)
	{
			List<NRIResident> nri1=new ArrayList<>();
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
				String pno=arr[11];
				String ptype=arr[12];
				String nationality=arr[13];	
				String purpose=arr[14];
				nri1.add(new NRIResident(id,name,age,gender,cn,email,address,noOfAdults,noOfChildren12,noOfChildren5,ds,rtype,pno,ptype,nationality,purpose));
			}
			
			
			return nri1;
	}
		
	
	
	private static int counter = 1; 
    private static final String PREFIX = "NRI"; 

   
    public String generateId() {
    	NRIResidentManagement nriResidentManagement=new NRIResidentManagement();
       if(counter==1) {
    	   counter=nriResidentManagement.checkIdExit();
       }
       counter++;
        String id = PREFIX + counter;
        
        
        return id;
    }
    
//   
    
    
    public NRIResidentService() {
		// TODO Auto-generated constructor stub
	}

	public boolean updateNRIResidentPhoneNumberUsingResidentId(String residentId, long newPhoneNumber) {
       
		return finalObj.updateNRIResidentPhoneNumberUsingResidentId(residentId, newPhoneNumber);
    }
	
    public boolean updateOccupancyUsingResidentId(String residentId, int numberOfAdults, int numberOfChildrenAbove12, int numberOfChildrenAbove5) {
        
        if (residentId == null || residentId.isEmpty() || numberOfAdults < 0 || numberOfChildrenAbove12 < 0 || numberOfChildrenAbove5 < 0) {
            return false; 
        }

        
        return finalObj.updateOccupancyUsingResidentId(residentId, numberOfAdults, numberOfChildrenAbove12, numberOfChildrenAbove5);
    }


    public boolean updateOccupancyUsingPassportNumber(String PassNo, int numberOfAdults, int numberOfChildrenAbove12, int numberOfChildrenAbove5) {
        if (PassNo == null || numberOfAdults < 0 || numberOfChildrenAbove12 < 0 || numberOfChildrenAbove5 < 0) {
            return false;
        }
        return finalObj.updateOccupancyUsingPassportNumber(PassNo, numberOfAdults, numberOfChildrenAbove12, numberOfChildrenAbove5);
    }
    
    
    public boolean updateOccupancyUsingContactNumber(long contactNumber, int numberOfAdults, int numberOfChildrenAbove12, int numberOfChildrenAbove5) 
    {
        if (contactNumber <= 0 || numberOfAdults < 0 || numberOfChildrenAbove12 < 0 || numberOfChildrenAbove5 < 0) 
        {
            return false;
        }
        return finalObj.updateOccupancyUsingContactNumber(contactNumber, numberOfAdults, numberOfChildrenAbove12, numberOfChildrenAbove5);
    }

    // Method to retrieve RI resident details based on the resident ID
    public NRIResident retrieveNRIResidentDetails(String residentId) 
    {
        if (residentId == null || residentId.isEmpty()) 
        {
            return null; 
        }
        return finalObj.retrieveNRIResidentDetails(residentId);
    }

    // Method to delete RI resident details from the database using the resident ID
    public boolean deleteRIResidentDetailsFromDB(String residentId) 
    {
        if (residentId == null || residentId.isEmpty()) 
        {
            return false;
        }
        return finalObj.deleteNRIResidentDetailsFromDB(residentId);
    }
    public boolean updateNRIResidentPhoneNumberUsingPassportNumber(String passNo, long newPhoneNumber) {
        return finalObj.updateNRIResidentPhoneNumberUsingPassportNumber(passNo, newPhoneNumber);
    }
    

	        

}
