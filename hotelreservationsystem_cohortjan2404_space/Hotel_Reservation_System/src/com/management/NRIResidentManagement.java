package com.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import com.model.NRIResident;
//import java.sql.*;
import com.model.RIResident;

	

	public class NRIResidentManagement {
	 

	    public List<NRIResident> insertNRIResidentList(List<NRIResident> nriResidentList) {
	    	List<NRIResident> list1=new ArrayList<>();
	        String query = "INSERT INTO nriresident (nri_resident_id, resident_name, age, gender, contact_number, email, address, number_of_adults, number_of_children_above12, number_of_children_above5, duration_of_stay, resident_type, passport_no, passport_type, nationality, purposeforvisit) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        try  {
	        	Connection connection = DBConnectionManager.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query);
	            for (NRIResident nriResident : nriResidentList) {
	                preparedStatement.setString(1, nriResident.getResidentId());
	                preparedStatement.setString(2, nriResident.getResidentName());
	                preparedStatement.setInt(3, nriResident.getAge());
	                preparedStatement.setString(4, nriResident.getGender());
	                preparedStatement.setLong(5, nriResident.getContactNumber());
	                preparedStatement.setString(6, nriResident.getEmail());
	                preparedStatement.setString(7, nriResident.getAddress());
	                preparedStatement.setInt(8, nriResident.getNumberOfAdults());
	                preparedStatement.setInt(9, nriResident.getNumberOfChildrenAbove12());
	                preparedStatement.setInt(10, nriResident.getNumberOfChildrenAbove5());
	                preparedStatement.setInt(11, nriResident.getDurationOfStay());
	                preparedStatement.setString(12, nriResident.getResidentType());
	                preparedStatement.setString(13, nriResident.getPassportNo());
	                preparedStatement.setString(14, nriResident.getPassportType());
	                preparedStatement.setString(15, nriResident.getNationality());
	                preparedStatement.setString(16, nriResident.getPurposeForVisit());
	                
	                preparedStatement.execute();
		            list1.add(nriResident);
	            }
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	            
	        }
	        return list1;
	    }

	    public NRIResident retrieveNRIResidentDetails(String residentId) {
	    	
	    		
	    		NRIResident obj=null;
	    		try
	    		{
	    			Connection con=DBConnectionManager.getConnection();
	    			String query="Select*from nriresident where NRI_RESIDENT_ID=?";
	    			PreparedStatement statement = con.prepareStatement(query);
	    			
	    			 statement.setString(1,residentId);
	    			 ResultSet rs=statement.executeQuery();
	    			 boolean flag=rs.next();
	    			 if(flag) {
	    				 obj=new NRIResident(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getLong(5),rs.getString(6),rs.getString(7),rs.getInt(8),rs.getInt(9),rs.getInt(10),rs.getInt(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16));
	    			 }
	    			 
	    		}
	    		
	    		catch(Exception e)
	    		{
	    			e.printStackTrace();
	    		}
	    		return obj;
	    	}
	    

	    public boolean updateNRIResidentPhoneNumberUsingResidentId(String residentId, long newPhoneNumber) {
	        String query = "UPDATE nriresident SET contact_number = ? WHERE nri_resident_id = ?";
	        try (Connection connection = DBConnectionManager.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setLong(1, newPhoneNumber);
	            preparedStatement.setString(2, residentId);
	            preparedStatement.executeUpdate();
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    public boolean updateOccupancyUsingResidentId(String residentId, int numberOfAdults, int numberOfChildrenAbove12, int numberOfChildrenAbove5) {
	        String query = "UPDATE nriresident SET number_of_adults = ?, number_of_children_above12 = ?, number_of_children_above5 = ? WHERE nri_resident_id = ?";
	        try (Connection connection = DBConnectionManager.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setInt(1, numberOfAdults);
	            preparedStatement.setInt(2, numberOfChildrenAbove12);
	            preparedStatement.setInt(3, numberOfChildrenAbove5);
	            preparedStatement.setString(4, residentId);
	            preparedStatement.executeUpdate();
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	    
	    
	    
	    public int checkIdExit()
		{
			
			try {
			Connection con=DBConnectionManager.getConnection();
			String query="Select count(*) as count from  nriresident";
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

	    public boolean updateNRIResidentPhoneNumberUsingPassportNumber(String passportNumber, long newPhoneNumber) {
	        String query = "UPDATE nriresident SET contact_number = ? WHERE passport_no = ?";
	        try (Connection connection = DBConnectionManager.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setLong(1, newPhoneNumber);
	            preparedStatement.setString(2, passportNumber);
	            preparedStatement.executeUpdate();
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    public boolean updateOccupancyUsingPassportNumber(String passportNumber, int numberOfAdults, int numberOfChildrenAbove12, int numberOfChildrenAbove5) {
	        String query = "UPDATE nriresident SET number_of_adults = ?, number_of_children_above12 = ?, number_of_children_above5 = ? WHERE passport_no = ?";
	        try (Connection connection = DBConnectionManager.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setInt(1, numberOfAdults);
	            preparedStatement.setInt(2, numberOfChildrenAbove12);
	            preparedStatement.setInt(3, numberOfChildrenAbove5);
	            preparedStatement.setString(4, passportNumber);
	            preparedStatement.executeUpdate();
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    public boolean updateNRIResidentPhoneNumberUsingContactNumber(long oldPhoneNumber, long newPhoneNumber) {
	        String query = "UPDATE nriresident SET contact_number = ? WHERE contact_number = ?";
	        try (Connection connection = DBConnectionManager.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setLong(1, newPhoneNumber);
	            preparedStatement.setLong(2, oldPhoneNumber);
	            preparedStatement.executeUpdate();
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    public boolean updateOccupancyUsingContactNumber(long contactNumber, int numberOfAdults, int numberOfChildrenAbove12, int numberOfChildrenAbove5) {
	        String query = "UPDATE nriresident SET number_of_adults = ?, number_of_children_above12 = ?, number_of_children_above5 = ? WHERE contact_number = ?";
	        try (Connection connection = DBConnectionManager.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setInt(1, numberOfAdults);
	            preparedStatement.setInt(2, numberOfChildrenAbove12);
	            preparedStatement.setInt(3, numberOfChildrenAbove5);
	            preparedStatement.setLong(4, contactNumber);
	            preparedStatement.executeUpdate();
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    public boolean deleteNRIResidentDetailsFromDB(String residentId) {
	        String query = "DELETE FROM nriresident WHERE nri_resident_id = ?";
	        try (Connection connection = DBConnectionManager.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setString(1, residentId);
	            preparedStatement.executeUpdate();
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    public List<NRIResident> retrieveNRIResidentList() {
	        String query = "SELECT * FROM nriresident";
	        List<NRIResident> nriResidents = new ArrayList<>();
	        try (Connection connection = DBConnectionManager.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	                NRIResident nriResident = new NRIResident();
	                nriResident.setResidentId(resultSet.getString("resident_id"));
	                nriResident.setResidentName(resultSet.getString("resident_name"));
	                nriResident.setAge(resultSet.getInt("age"));
	                nriResident.setGender(resultSet.getString("gender"));
	                nriResident.setContactNumber(resultSet.getLong("contact_number"));
	                nriResident.setEmail(resultSet.getString("email"));
	                nriResident.setAddress(resultSet.getString("address"));
	                nriResident.setNumberOfAdults(resultSet.getInt("number_of_adults"));
	                nriResident.setNumberOfChildrenAbove12(resultSet.getInt("number_of_children_above12"));
	                nriResident.setNumberOfChildrenAbove5(resultSet.getInt("number_of_children_above5"));
	                nriResident.setDurationOfStay(resultSet.getInt("duration_of_stay"));
	                nriResident.setResidentType(resultSet.getString("resident_type"));
	                nriResident.setPassportNo(resultSet.getString("passport_no"));
	                nriResident.setPassportType(resultSet.getString("passport_type"));
	                nriResident.setNationality(resultSet.getString("nationality"));
	                nriResident.setPurposeForVisit(resultSet.getString("purposeforvisit"));
	                nriResidents.add(nriResident);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return nriResidents;
	    }
	}

					 
					 
					 
					 
					 
					 
					 
					 
					 
					 
					 
					 
					 
					 
					 
					 
					 
					 
					 
		
		
		
		

