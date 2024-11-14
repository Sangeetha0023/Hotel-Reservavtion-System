package com.service;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.management.BookingManagement;
import com.model.Booking;
import com.model.RIResident;
import com.util.ApplicationUtil;

public class BookingService {
    private BookingManagement bookingManagement;

    public BookingService(BookingManagement bookingManagement) {
        this.bookingManagement = bookingManagement;
    }

    public BookingService() {
		// TODO Auto-generated constructor stub
    	bookingManagement=new BookingManagement();
	}
    ApplicationUtil appUtil=new ApplicationUtil();
    public List<Booking> add(String[] det)
	{
    	 BookingManagement bookingManagement=new  BookingManagement();
		
		
		List<String> obj=appUtil.convertList(det);
		
		List<Booking> obj1=buildBookingList(obj);
		
	
		
		List<Booking>result=bookingManagement.insertBookingList(obj1);
		
		return result;
		
	}
    
    
   PaymentService payment=new PaymentService();
//	 Method to create a list of bookings and add them to the system
    public List<Booking> buildBookingList(List<String> bookingList) {
    	List<Booking> bk1=new ArrayList<>();
    	for(String a:bookingList)
    	{
             String[] fields = a.split(":");
             Booking booking = new Booking();
             booking.setBookingId(generateId());
             booking.setResidentId(fields[0]);
             booking.setResidentName(fields[1]);
             booking.setDurationOfStay(Integer.parseInt(fields[2]));
             booking.setNumberOfAdults(Integer.parseInt(fields[3]));
             booking.setNumberOfChildrenAbove12(Integer.parseInt(fields[4]));
             booking.setNumberOfChildrenAbove5(Integer.parseInt(fields[5]));
             java.util.Date  date1=appUtil.convertStringToUtilDate(fields[6]);
             java.util.Date  date2=appUtil.convertStringToUtilDate(fields[7]);
             
             booking.setCheckInDate(date1);
             booking.setCheckOutDate(date2);
             
             booking.setFloorNumber(fields[8]);
             booking.setRoomNumber(fields[9]);
             
             booking.setPreferredPackage(fields[10]);
             booking.setAcAccess(fields[11]);
             booking.setPoolAccess(fields[12]);
             booking.setGymAccess(fields[13]);
             
             bk1.add(booking);
           
    	}
         return bk1;
    }

    // Method to add a list of bookings to the database
    public List<Booking> insertBookingList(List<Booking> bookingList) {
        for (Booking booking : bookingList) {
            booking.setBookingId(generateId());
        }
        return bookingManagement.insertBookingList(bookingList);
    }

    // Method to generate a unique booking ID
    public String generateId() {
        return "BKG" + UUID.randomUUID().toString().substring(0, 23);
    }

    // Method to update check-in and check-out dates using booking ID
    public boolean updateCheckInAndCheckOutUsingBookingId(String bookingId, String checkInDate,String checkOutDate) {
    	java.sql.Date checkInDate1=ApplicationUtil.convertUtilToSqlDate(ApplicationUtil.convertStringToUtilDate(checkInDate));
    	java.sql.Date checkOutDate1=ApplicationUtil.convertUtilToSqlDate( ApplicationUtil.convertStringToUtilDate(checkOutDate));
        return bookingManagement.updateCheckInAndCheckOut(bookingId, checkInDate1, checkOutDate1);
    }

    // Method to update the preferred package using booking ID
    public boolean updatePackageUsingBookingId(String bookingId, String preferredPackage) {
//    	System.out.println(preferredPackage);
        return bookingManagement.updatePackage(bookingId, preferredPackage);
    }

    // Method to update extra access (AC, pool, gym) using booking ID
    public boolean updateExtraAccessUsingBookingId(String bookingId, String acAccess, String poolAccess, String gymAccess) {
        return bookingManagement.updateExtraAccess(bookingId, acAccess, poolAccess, gymAccess);
    }

    // Method to cancel a booking from the database using booking ID
    public boolean cancelBookingFromDB(String bookingId) {
        return bookingManagement.cancelBooking(bookingId);
    }

    // Method to view booking details using booking ID
    public Booking viewBookingDetails(String bookingId) {
        return bookingManagement.retrieveBookingDetails(bookingId);
    }
    
}
