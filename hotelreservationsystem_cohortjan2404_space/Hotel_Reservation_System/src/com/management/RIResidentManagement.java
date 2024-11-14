package com.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.model.RIResident;

public class RIResidentManagement
{

	public  List<RIResident> insertRIResidentList(List<RIResident> resident) 
	{
		List<RIResident> list1=new ArrayList<>();
	try 
	{
		Connection con=DBConnectionManager.getConnection();
		 String query = "INSERT INTO riresident (RI_RESIDENT_ID, RESIDENT_NAME, AGE, GENDER, CONTACT_NUMBER, EMAIL, ADDRESS, NUMBER_OF_ADULTS, NUMBER_OF_CHILDREN_ABOVE12, NUMBER_OF_CHILDREN_ABOVE5, DURATION_OF_STAY, RESIDENT_TYPE,IDPROOF_AADHARNO) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	     for(RIResident resident1:resident)  
	     {
	    	 PreparedStatement statement = con.prepareStatement(query);
			            statement.setString(1, resident1.getResidentId());
			            statement.setString(2, resident1.getResidentName());
			            statement.setInt(3, resident1.getAge());
			            statement.setString(4, resident1.getGender());
			            statement.setLong(5, resident1.getContactNumber());
			            statement.setString(6, resident1.getEmail());
			            statement.setString(7, resident1.getAddress());
			            statement.setInt(8, resident1.getNumberOfAdults());
			            statement.setInt(9, resident1.getNumberOfChildrenAbove12());
			            statement.setInt(10, resident1.getNumberOfChildrenAbove5());
			            statement.setInt(11, resident1.getDurationOfStay());
			            statement.setString(12, resident1.getResidentType());
			            statement.setLong(13,resident1.getIdproof_AadharNo());
			            statement.execute();
			            list1.add(resident1);
			            
			            
			           
			          
			            
			            
	     }
	    
		
	}
	catch(Exception e)
	{
//		System.out.println(e.getMessage());
		e.printStackTrace();
		
	}
	return list1;
	 
            
	
      
    }
	
	
	
	public RIResident retrieveRIdetails(String residentId)
	{
		System.out.println(residentId);
		RIResident obj=null;
		try
		{
			Connection con=DBConnectionManager.getConnection();
			String query="Select*from riresident where RI_RESIDENT_ID=?";
			PreparedStatement statement = con.prepareStatement(query);
			
			 statement.setString(1,residentId);
			 ResultSet rs=statement.executeQuery();
			 boolean flag=rs.next();
			 if(flag) {
				 obj=new RIResident(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getLong(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getInt(9),rs.getInt(10),rs.getInt(11),rs.getString(12),rs.getLong(13));
			 }
			 
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return obj;
	}
	
	
	public int checkIdExit()
	{
		
		try {
		Connection con=DBConnectionManager.getConnection();
		String query="Select count(*) as count from  riresident";
		PreparedStatement statement = con.prepareStatement(query);
		ResultSet rs=statement.executeQuery();
		if(rs.next())
			{
				int count=rs.getInt("count");
				return count;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	public boolean updateRIResidentPhoneNumberUsingResidentId(String residentId,long newContact)
	{
		
		try {
		Connection con=DBConnectionManager.getConnection();
		String query="update riresident SET CONTACT_NUMBER=? where RI_RESIDENT_ID=?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setLong(1,newContact);
		statement.setString(2,residentId);
		int status=statement.executeUpdate();
		
		return status>0;
		
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
			return false;
		}
	}
	
	
	public boolean updateOccupancyUsingResidentId(String residentId,int numberOfAdults,int numberOfchildrenAbove12,int numberOfchildrenAbove5)
	{
		try 
		{
				
			Connection con=DBConnectionManager.getConnection();
			String query="update riresident SET NUMBER_OF_ADULTS =?,NUMBER_OF_CHILDREN_ABOVE12=?,NUMBER_OF_CHILDREN_ABOVE5 =?,where RI_RESIDENT_ID=?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1,numberOfAdults);
			statement.setInt(2,numberOfchildrenAbove12);
			statement.setInt(3,numberOfchildrenAbove5);
			statement.setString(4,residentId);
			int status=statement.executeUpdate();
			
			return status>0;
			
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
			return false;
		}
				
				
	}
	
	
	public boolean updateRIResidentPhoneNumberUsingIdProof(long idproof,long phonenumber)
	{
		try {
			Connection con=DBConnectionManager.getConnection();
			String query="update riresident SET CONTACT_NUMBER=? where IDPROOF_AADHARNO =?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setLong(1,phonenumber);
			statement.setLong(2,idproof);
			int status=statement.executeUpdate();
			
			return status>0;
			
			}
			catch(Exception e)
			{
				System.err.println(e.getMessage());
				return false;
			}
	}
	
	
	public boolean updateOccupancyUsingIdProof(long idproof,int numberOfAdults,int numberOfchildrenAbove12,int numberOfchildrenAbove5)
	{
		try 
		{
				
			Connection con=DBConnectionManager.getConnection();
			String query="update riresident SET NUMBER_OF_ADULTS =?,NUMBER_OF_CHILDREN_ABOVE12=?,NUMBER_OF_CHILDREN_ABOVE5 =? where IDPROOF_AADHARNO=?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1,numberOfAdults);
			statement.setInt(2,numberOfchildrenAbove12);
			statement.setInt(3,numberOfchildrenAbove5);
			statement.setLong(4,idproof);
			int status=statement.executeUpdate();
			
			return status>0;
			
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
			return false;
		}
	}
		
	
	
	public boolean updateOccupancyUsingContactNumber(long contactNumber,int numberOfAdults,int numberOfchildrenAbove12,int numberOfchildrenAbove5)
	{
		try 
		{
				
			Connection con=DBConnectionManager.getConnection();
			String query="update riresident SET NUMBER_OF_ADULTS =?,NUMBER_OF_CHILDREN_ABOVE12=?,NUMBER_OF_CHILDREN_ABOVE5 =? where CONTACT_NUMBER=?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1,numberOfAdults);
			statement.setInt(2,numberOfchildrenAbove12);
			statement.setInt(3,numberOfchildrenAbove5);
			statement.setLong(4,contactNumber);
			int status=statement.executeUpdate();
			
			return status>0;
			
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
			return false;
		}
				
				
	}
	
	
	public boolean deleteRIResidentDetailsFromDB(String residentId)
	{
		try {
		Connection con=DBConnectionManager.getConnection();
		String query="delete from riresident where RI_RESIDENT_ID=?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1,residentId);
		int status=statement.executeUpdate();
		
		return status>0; 
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
			return false;
			
		}
		
	}
	
	

}
