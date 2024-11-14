package com.service;
import java.util.List;

import com.management.ManagerManagement;
import com.model.Booking;
import com.util.ApplicationUtil;

import java.util.Date;
public class ManagerService {
	

	
	     ManagerManagement manager =new ManagerManagement();
	     ApplicationUtil au=new ApplicationUtil();

	    public ManagerService() {
	        this.manager = new ManagerManagement();
	    }

	    public List<Booking> viewBookingDetails() {
	        return manager.getBookingDetails();
	    }

	    public List<String> viewAvailableRooms() {
	        return manager.getAvailableRooms();
	    }

	    public List<String> viewOccupiedRooms() {
	        return manager.getOccupiedRooms();
	    }

	    public List<String> viewAvailableRoomsForParticularFloorNumber(String floorNumber) {
	        return manager.getAvailableRoomsForFloor(floorNumber);
	    }

	    public List<String> viewOccupiedRoomsForParticularFloorNumber(String floorNumber) {
	        return manager.getOccupiedRoomsForFloor(floorNumber);
	    }

	    public List<String> viewOccupiedRoomsForParticularCheckInDate(String checkInDate) {
	    	Date checkInDate1=au.convertStringToUtilDate(checkInDate);
	        return manager.getOccupiedRoomsForCheckInDate(checkInDate1);
	    }

	    public List<String> viewOccupiedRoomsForParticularCheckOutDate(String checkOutDate) {
	    	Date checkOutDate1=au.convertStringToUtilDate(checkOutDate);
	        return manager.getOccupiedRoomsForCheckOutDate(checkOutDate1);
	    }
	}



