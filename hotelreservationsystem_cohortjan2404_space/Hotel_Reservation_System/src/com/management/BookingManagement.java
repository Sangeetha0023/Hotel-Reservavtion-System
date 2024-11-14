
package com.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Booking;
import com.model.RIResident;
import com.util.ApplicationUtil;

public class BookingManagement {
    // Method to insert a list of bookings into the database
    public List<Booking> insertBookingList(List<Booking> bookingList) {
    	List<Booking> list1=new ArrayList<>();
    	
        String sql = "INSERT INTO booking (BOOKING_ID, RESIDENT_ID, RESIDENT_NAME, DURATION_OF_STAY, NUMBER_OF_ADULTS, NUMBER_OF_CHILDREN_ABOVE12, NUMBER_OF_CHILDREN_ABOVE5, CHECK_IN_DATE, CHECK_OUT_DATE, FLOOR_NUMBER, ROOM_NUMBER, PREFERRED_PACKAGE, AC_ACCESS, POOL_ACCESS, GYM_ACCESS) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            for (Booking booking : bookingList) {
            	
                statement.setString(1, booking.getBookingId());
                
                
                statement.setString(2, booking.getResidentId());
                statement.setString(3, booking.getResidentName());
                
                statement.setInt(4, booking.getDurationOfStay());
                statement.setInt(5, booking.getNumberOfAdults());
                statement.setInt(6, booking.getNumberOfChildrenAbove12());
                statement.setInt(7, booking.getNumberOfChildrenAbove5());
              
                statement.setDate(8,ApplicationUtil.convertUtilToSqlDate(booking.getCheckInDate()) );
                statement.setDate(9, ApplicationUtil.convertUtilToSqlDate(booking.getCheckOutDate()));
                
                statement.setString(10, booking.getFloorNumber());
                statement.setString(11, booking.getRoomNumber());
                statement.setString(12, booking.getPreferredPackage());
                statement.setString(13, booking.getAcAccess());
                statement.setString(14, booking.getPoolAccess());
                statement.setString(15, booking.getGymAccess());
                
                statement.execute();
	            list1.add(booking);
        } 
        }catch (SQLException e) {
            e.printStackTrace();
            
        }
        return list1;
    }
    
    
    public int checkIdExit()
	{
		
		try {
		Connection con=DBConnectionManager.getConnection();
		String query="Select count(*) as count from booking";
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
	

    // Method to update check-in and check-out dates using booking ID
    public boolean updateCheckInAndCheckOut(String bookingId, java.sql.Date checkInDate, java.sql.Date checkOutDate) {
        String sql = "UPDATE booking SET CHECK_IN_DATE = ?, CHECK_OUT_DATE = ? WHERE BOOKING_ID = ?";
        try (Connection connection = DBConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDate(1, checkInDate);
            statement.setDate(2, checkOutDate);
            statement.setString(3, bookingId);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to update the preferred package using booking ID
    public boolean updatePackage(String bookingId, String preferredPackage) {
        String sql = "UPDATE booking SET PREFERRED_PACKAGE = ? WHERE BOOKING_ID = ?";
        try (Connection connection = DBConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, preferredPackage);
            statement.setString(2, bookingId);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to update extra access using booking ID
    public boolean updateExtraAccess(String bookingId, String acAccess, String poolAccess, String gymAccess) {
        String sql = "UPDATE booking SET AC_ACCESS = ?, POOL_ACCESS = ?, GYM_ACCESS = ? WHERE BOOKING_ID = ?";
        try (Connection connection = DBConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, acAccess);
            statement.setString(2, poolAccess);
            statement.setString(3, gymAccess);
            statement.setString(4, bookingId);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to cancel a booking using booking ID
    public boolean cancelBooking(String bookingId) {
        String sql = "DELETE FROM booking WHERE BOOKING_ID = ?";
        try (Connection connection = DBConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, bookingId);
            int count = statement.executeUpdate();
//            System.out.println(count);
            return  count> 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to retrieve booking details using booking ID
    public Booking retrieveBookingDetails(String bookingId) {
        String sql = "SELECT * FROM booking WHERE BOOKING_ID = ?";
        try (Connection connection = DBConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, bookingId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Booking booking = new Booking();
                    booking.setBookingId(resultSet.getString("BOOKING_ID"));
                    booking.setResidentId(resultSet.getString("RESIDENT_ID"));
                    booking.setResidentName(resultSet.getString("RESIDENT_NAME"));
                    booking.setDurationOfStay(resultSet.getInt("DURATION_OF_STAY"));
                    booking.setNumberOfAdults(resultSet.getInt("NUMBER_OF_ADULTS"));
                    booking.setNumberOfChildrenAbove12(resultSet.getInt("NUMBER_OF_CHILDREN_ABOVE12"));
                    booking.setNumberOfChildrenAbove5(resultSet.getInt("NUMBER_OF_CHILDREN_ABOVE5"));
                    booking.setCheckInDate(resultSet.getDate("CHECK_IN_DATE"));
                    booking.setCheckOutDate(resultSet.getDate("CHECK_OUT_DATE"));
                    booking.setFloorNumber(resultSet.getString("FLOOR_NUMBER"));
                    booking.setRoomNumber(resultSet.getString("ROOM_NUMBER"));
                    booking.setPreferredPackage(resultSet.getString("PREFERRED_PACKAGE"));
                    booking.setAcAccess(resultSet.getString("AC_ACCESS"));
                    booking.setPoolAccess(resultSet.getString("POOL_ACCESS"));
                    booking.setGymAccess(resultSet.getString("GYM_ACCESS"));
                    return booking;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
