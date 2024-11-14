package com.management;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.model.Payment;
import com.model.RIResident;

public class PaymentManagement {
	

	
	   

	    public List<Payment> insertPayments(List<Payment> payments) {
	    	List<Payment> list1=new ArrayList<>();
	        String query = "INSERT INTO payment (PAYMENT_ID, BOOKING_ID, RESIDENT_NAME, FLOOR_NUMBER, ROOM_NUMBER, CHECK_IN_DATE, CHECK_OUT_DATE, PAYMENT_DATE, PAYMENT_METHOD, BILL_AMOUNT) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        try (Connection connection = DBConnectionManager.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            for (Payment payment : payments) {
	                preparedStatement.setString(1, payment.getPaymentId());
	                preparedStatement.setString(2, payment.getBookingId());
	                preparedStatement.setString(3, payment.getResidentName());
	                preparedStatement.setString(4, payment.getFloorNumber());
	                preparedStatement.setString(5, payment.getRoomNumber());
	                preparedStatement.setDate(6, new java.sql.Date(payment.getCheckInDate().getTime()));
	                preparedStatement.setDate(7, new java.sql.Date(payment.getCheckOutDate().getTime()));
	                preparedStatement.setDate(8, new java.sql.Date(payment.getPaymentDate().getTime()));
	                preparedStatement.setString(9, payment.getPaymentMethod());
	                preparedStatement.setDouble(10, payment.getBillAmount());
	                preparedStatement.execute();
		            list1.add(payment);
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return list1;
	    }

	    public int checkPaymentIdExists() {
	        String query = "SELECT COUNT(*) as count FROM payment ";
	        try (Connection connection = DBConnectionManager.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//	            preparedStatement.setString(1, paymentId);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            if (resultSet.next()) {
	            	int count=resultSet.getInt("count");
					return count;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return 0;
	    }

	    public Payment getPaymentDetails(String paymentId) {
	        String query = "SELECT * FROM payment WHERE PAYMENT_ID = ?";
	        Payment payment = null;
	        try (Connection connection = DBConnectionManager.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setString(1, paymentId);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            if (resultSet.next()) {
	                
	                payment.setPaymentId(resultSet.getString("PAYMENT_ID"));
	                payment.setBookingId(resultSet.getString("BOOKING_ID"));
	                payment.setResidentName(resultSet.getString("RESIDENT_NAME"));
	                payment.setFloorNumber(resultSet.getString("FLOOR_NUMBER"));
	                payment.setRoomNumber(resultSet.getString("ROOM_NUMBER"));
	                payment.setCheckInDate(resultSet.getDate("CHECK_IN_DATE"));
	                payment.setCheckOutDate(resultSet.getDate("CHECK_OUT_DATE"));
	                payment.setPaymentDate(resultSet.getDate("PAYMENT_DATE"));
	                payment.setPaymentMethod(resultSet.getString("PAYMENT_METHOD"));
	                payment.setBillAmount(resultSet.getDouble("BILL_AMOUNT"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return payment;
	    }
	}



