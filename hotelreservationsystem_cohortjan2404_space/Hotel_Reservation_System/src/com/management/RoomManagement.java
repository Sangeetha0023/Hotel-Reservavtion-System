package com.management;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.model.Payment;
import com.model.RIResident;
import com.model.Room;

public class RoomManagement {
	
	       

	        public List<Room> insertRoomList(List<Room> rooms) {
	            String query = "INSERT INTO room (ROOM_NUMBER, FLOOR_NUMBER, IS_OCCUPIED, MAX_OCCUPANCY, HAS_AC, HAS_SWIMMING_POOL_ACCESS, HAS_GYM_ACCESS) VALUES (?, ?, ?, ?, ?, ?, ?)";
	            List<Room> list1=new ArrayList<>();
	            try (Connection connection = DBConnectionManager.getConnection();
	                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	                for (Room room : rooms) {
	                    preparedStatement.setString(1, room.getRoomNumber());
	                    preparedStatement.setString(2, room.getFloorNumber());
	                    preparedStatement.setString(3, room.getIsOccupied());
	                    preparedStatement.setInt(4, room.getMaxOccupancy());
	                    preparedStatement.setString(5, room.getHasAc());
	                    preparedStatement.setString(6, room.getHasSwimmingPoolAccess());
	                    preparedStatement.setString(7, room.getHasGymAccess());
	                    preparedStatement.execute();
			            list1.add(room);
			            
			            
			           
			          
			            
			            
	     }
	    
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
	}
	return list1;
	        }

	        public boolean updateOccupiedStatusUsingRoomNumber(String roomNumber, String isOccupied) {
	            String query = "UPDATE room SET IS_OCCUPIED = ? WHERE ROOM_NUMBER = ?";
	            try (Connection connection = DBConnectionManager.getConnection();
	                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	                preparedStatement.setString(1, isOccupied);
	                preparedStatement.setString(2, roomNumber);
//	                preparedStatement.executeUpdate();
	                int status=preparedStatement.executeUpdate();
	        		
	        		return status>0;
	            } catch (Exception e) {
	                e.printStackTrace();
	                return false;
	            }
	        }

	        public boolean deleteRoomDetailsFromDBUsingFloorNumber(String floorNumber) {
	            String query = "DELETE FROM room WHERE FLOOR_NUMBER = ?";
	            try (Connection connection = DBConnectionManager.getConnection();
	                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	                preparedStatement.setString(1, floorNumber);
//	                preparedStatement.executeUpdate();
                     int status=preparedStatement.executeUpdate();
	        		
	        		return status>0;
	            } catch (Exception e) {
	                e.printStackTrace();
	                return false;
	            }
	        }

	        public boolean deleteRoomDetailsFromDBUsingRoomNumber(String roomNumber) {
	            String query = "DELETE FROM room WHERE ROOM_NUMBER = ?";
	            try (Connection connection = DBConnectionManager.getConnection();
	                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	                preparedStatement.setString(1, roomNumber);
                    int status=preparedStatement.executeUpdate();
                    return status>0;
	            } catch (Exception e) {
	                e.printStackTrace();
	                return false;
	            }
	        }

	        public Room viewRoomDetails(String roomNumber) {
	            String query = "SELECT * FROM room WHERE ROOM_NUMBER = ?";
	            Room room = null;
	            try (Connection connection = DBConnectionManager.getConnection();
	                 PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	                preparedStatement.setString(1, roomNumber);
	                ResultSet resultSet = preparedStatement.executeQuery();
	                if (resultSet.next()) {
	                    room = new Room();
	                    room.setRoomNumber(resultSet.getString("ROOM_NUMBER"));
	                    room.setFloorNumber(resultSet.getString("FLOOR_NUMBER"));
	                    room.setIsOccupied(resultSet.getString("IS_OCCUPIED"));
	                    room.setMaxOccupancy(resultSet.getInt("MAX_OCCUPANCY"));
	                    room.setHasAc(resultSet.getString("HAS_AC"));
	                    room.setHasSwimmingPoolAccess(resultSet.getString("HAS_SWIMMING_POOL_ACCESS"));
	                    room.setHasGymAccess(resultSet.getString("HAS_GYM_ACCESS"));
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            return room;
	        }
	    }

	

