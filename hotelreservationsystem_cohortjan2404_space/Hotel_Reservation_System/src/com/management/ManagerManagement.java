package com.management;


	
	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;

import com.model.Booking;

import java.util.Date;

	public class ManagerManagement {
	    

	    public List<Booking> getBookingDetails() {
	        String query = "SELECT * FROM booking";
	        List<Booking> bookingDetailsList = new ArrayList<>();
	        try (Connection connection = DBConnectionManager.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	                Booking bookingDetails = new Booking();
	                bookingDetails.setBookingId(resultSet.getString("booking_id"));
	                bookingDetails.setResidentId(resultSet.getString("resident_id"));
	                bookingDetails.setResidentName(resultSet.getString("Resident_name"));
	                bookingDetails.setDurationOfStay(resultSet.getInt("DURATION_OF_STAY"));
	                bookingDetails.setNumberOfAdults(resultSet.getInt("NUMBER_OF_ADULTS"));
	                bookingDetails.setNumberOfChildrenAbove12(resultSet.getInt("NUMBER_OF_CHILDREN_ABOVE12"));
	                bookingDetails.setNumberOfChildrenAbove5(resultSet.getInt("NUMBER_OF_CHILDREN_ABOVE5"));
	                bookingDetails.setCheckInDate(resultSet.getDate("CHECK_IN_DATE"));
	                bookingDetails.setCheckOutDate(resultSet.getDate("CHECK_OUT_DATE"));
	                bookingDetails.setFloorNumber(resultSet.getString("FLOOR_NUMBER"));
	                bookingDetails.setRoomNumber(resultSet.getString("ROOM_NUMBER"));
	                bookingDetails.setPreferredPackage(resultSet.getString("PREFERRED_PACKAGE"));
	                bookingDetails.setAcAccess(resultSet.getString("AC_ACCESS"));
	                bookingDetails.setPoolAccess(resultSet.getString("POOL_ACCESS"));
	                bookingDetails.setGymAccess(resultSet.getString("GYM_ACCESS"));
//	                bookingDetails.setBookingStatus(resultSet.getString("booking_status"));
	                bookingDetailsList.add(bookingDetails);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return bookingDetailsList;
	    }

	    public List<String> getAvailableRooms() {
	        String query = "SELECT room_number FROM room WHERE IS_OCCUPIED = 'no'";
	        List<String> availableRooms = new ArrayList<>();
	        try (Connection connection = DBConnectionManager.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	                availableRooms.add(resultSet.getString("room_number"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return availableRooms;
	    }

	    public List<String> getOccupiedRooms() {
	        String query = "SELECT room_number FROM room WHERE IS_OCCUPIED = 'yes'";
	        List<String> occupiedRooms = new ArrayList<>();
	        try (Connection connection = DBConnectionManager.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	                occupiedRooms.add(resultSet.getString("room_number"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return occupiedRooms;
	    }

	    public List<String> getAvailableRoomsForFloor(String floorNumber) {
	        String query = "SELECT room_number FROM room WHERE IS_OCCUPIED = 'no' AND floor_number = ?";
	        List<String> availableRooms = new ArrayList<>();
	        try (Connection connection = DBConnectionManager.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setString(1, floorNumber);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	                availableRooms.add(resultSet.getString("room_number"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return availableRooms;
	    }

	    public List<String> getOccupiedRoomsForFloor(String floorNumber) {
	        String query = "SELECT room_number FROM room WHERE IS_OCCUPIED = 'yes' AND floor_number = ?";
	        List<String> occupiedRooms = new ArrayList<>();
	        try (Connection connection = DBConnectionManager.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setString(1, floorNumber);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	                occupiedRooms.add(resultSet.getString("room_number"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return occupiedRooms;
	    }

	    public List<String> getOccupiedRoomsForCheckInDate(Date checkInDate) {
	        String query = "SELECT room_number FROM booking WHERE check_in_date = ?";
	        List<String> occupiedRooms = new ArrayList<>();
	        try (Connection connection = DBConnectionManager.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setDate(1, new java.sql.Date(checkInDate.getTime()));
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	                occupiedRooms.add(resultSet.getString("room_number"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return occupiedRooms;
	    }

	    public List<String> getOccupiedRoomsForCheckOutDate(Date checkOutDate) {
	        String query = "SELECT room_number FROM booking WHERE check_out_date = ?";
	        List<String> occupiedRooms = new ArrayList<>();
	        try (Connection connection = DBConnectionManager.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setDate(1, new java.sql.Date(checkOutDate.getTime()));
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	                occupiedRooms.add(resultSet.getString("room_number"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return occupiedRooms;
	    }
	}



