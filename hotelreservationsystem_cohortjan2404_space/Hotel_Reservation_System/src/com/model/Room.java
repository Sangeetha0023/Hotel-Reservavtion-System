package com.model;

public class Room {

	private String RoomNumber;
	private String FloorNumber;
	private String IsOccupied;
	private int MaxOccupancy;
	private String HasAc;
	private String HasSwimmingPoolAccess;
	private String HasGymAccess;
	
	public Room(String roomNumber, String floorNumber, String isOccupied, int maxOccupancy, String hasAc,
			String hasSwimmingPoolAccess, String hasGymAccess) {
		
		RoomNumber = roomNumber;
		FloorNumber = floorNumber;
		IsOccupied = isOccupied;
		MaxOccupancy = maxOccupancy;
		HasAc = hasAc;
		HasSwimmingPoolAccess = hasSwimmingPoolAccess;
		HasGymAccess = hasGymAccess;
	}

	public Room() {
		// TODO Auto-generated constructor stub
	}

	public String getRoomNumber() 
	{
		return RoomNumber;
	}

	public void setRoomNumber(String roomNumber) 
	{
		RoomNumber = roomNumber;
	}

	public String getFloorNumber()
	{
		return FloorNumber;
	}
	
	public void setFloorNumber(String floorNumber) 
	{
		FloorNumber = floorNumber;
	}


	public String getIsOccupied() 
	{
		return IsOccupied;
	}


	public void setIsOccupied(String isOccupied)
	{
		IsOccupied = isOccupied;
	}


	public int getMaxOccupancy() 
	{
		return MaxOccupancy;
	}


	public void setMaxOccupancy(int maxOccupancy)
	{
		MaxOccupancy = maxOccupancy;
	}


	public String getHasAc()
	{
		return HasAc;
	}


	public void setHasAc(String hasAc)
	{
		HasAc = hasAc;
	}


	public String getHasSwimmingPoolAccess() 
	{
		return HasSwimmingPoolAccess;
	}


	public void setHasSwimmingPoolAccess(String hasSwimmingPoolAccess)
	{
		HasSwimmingPoolAccess = hasSwimmingPoolAccess;
	}


	public String getHasGymAccess() 
	{
		return HasGymAccess;
	}


	public void setHasGymAccess(String hasGymAccess)
	{
		HasGymAccess = hasGymAccess;
	}


	
}
