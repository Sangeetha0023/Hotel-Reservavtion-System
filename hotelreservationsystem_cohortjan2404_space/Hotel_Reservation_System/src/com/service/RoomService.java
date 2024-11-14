package com.service;
import java.util.*;

import com.management.RoomManagement;
import com.model.Room;
import com.util.ApplicationUtil;
public class RoomService {

RoomManagement roomManagement=new RoomManagement();
	public List<Room> add(String[] det)
	{
		ApplicationUtil appUtil=new ApplicationUtil();

		
		List<String> obj=appUtil.convertList(det);
		
		List<Room> obj1=buildRoom(obj);
		
		Room roomObj=new Room();
		
		List<Room> result=roomManagement.insertRoomList(obj1);
		
		return result;
		
	}
	public List<Room> buildRoom(List<String> obj)
	{
			List<Room> room=new ArrayList<>();
			for(String a:obj)
			{
				String arr[]=a.split(":");
//				String roomId=numReturn();
		        String roomNumber=arr[0];
				String FloorNumber=arr[1];
				String IsOccupied=arr[2];
				int MaxOccupancy=ApplicationUtil.convertInt1(arr[3]);
				String HasAc=arr[4];
				String HasSwimmingPoolAccess=arr[5];
				String HasGymAccess=arr[6];
//				
				room.add(new Room(roomNumber,FloorNumber,IsOccupied,MaxOccupancy,HasAc,HasSwimmingPoolAccess,HasGymAccess));
			}
			return room;
			}
	
	public static int num2=0;
	public String numReturn() {
		num2++;
		String num1="SHNRI"+num2;
		return num1;
	}
	 
	    
	    
	    public RoomService() {
			// TODO Auto-generated constructor stub
		}

		public boolean updateOccupiedStatusUsingRoomNumber(String roomNumber,String isOccupied) {
	       
			return roomManagement.updateOccupiedStatusUsingRoomNumber(roomNumber,isOccupied);
	    }
		 public boolean deleteRoomDetailsFromDBUsingFloorNumber(String FloorNumber) 
		    {
		        if (FloorNumber == null || FloorNumber.isEmpty()) 
		        {
		            return false;
		        }
		        return roomManagement.deleteRoomDetailsFromDBUsingFloorNumber(FloorNumber);
		    }
		 public boolean deleteRoomDetailsFromDBUsingRoomNumber(String RoomNumber) 
		    {
		        if (RoomNumber == null || RoomNumber.isEmpty()) 
		        {
		            return false;
		        }
		        return roomManagement.deleteRoomDetailsFromDBUsingRoomNumber(RoomNumber);
		    }
		 
		 public Room viewRoomDetails(String roomNumber)
		 {
			 return roomManagement.viewRoomDetails(roomNumber);
		 }
		
		
	}
	

