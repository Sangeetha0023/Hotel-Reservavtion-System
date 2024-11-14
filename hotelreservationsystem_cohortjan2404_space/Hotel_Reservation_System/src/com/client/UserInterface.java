package com.client;
import java.text.SimpleDateFormat;
import java.util.*;

import com.model.Booking;
import com.model.NRIResident;
import com.model.Payment;
import com.model.RIResident;
import com.model.Room;
import com.service.BookingService;
import com.service.ManagerService;
import com.service.NRIResidentService;
import com.service.PaymentService;
import com.service.RIResidentService;
import com.service.RoomService;
public class UserInterface {
 public static void main(String args[]) 
 {
	 Scanner sc=new Scanner(System.in);
	 RIResidentService RIService=new RIResidentService();
	 NRIResidentService NRIService=new NRIResidentService();
	 
	 
	 
	 
	
	 
	 
	int choice=0;
	
	while(choice<=6)
	{
		System.out.println("1.Resident Registration");
		 System.out.println("2.Room Manipulation");
		 System.out.println("3.Booking Manipulation");
		 System.out.println("4.Manager Manipulation");
		 System.out.println("5.Bill Generation");
		 System.out.println("6.Exit");
		 System.out.println("Enter your choice");
		choice=sc.nextInt();
		sc.nextLine();
		if(choice==1)
		{
				
			    int select=0;
			    while(select<=2) {
			    	System.out.println("Enter the Resident Type");
					System.out.println("1.RIResident");
				    System.out.println("2.NRIResident");
				    select=sc.nextInt();
				    sc.nextLine();
			    if(select==1)
			    {
			    	 
			    	 int choice1=0;
			    	 while(choice1<=5) {
			    		 System.out.println("1.Add RIResident details");
				    	 System.out.println("2.update RIResident details");
				    	 System.out.println("3.delete RIResident details");
				    	 System.out.println("4.View RIResident details");
			    	 
			    	 choice1=sc.nextInt();
			    	 sc.nextLine();
			    	 if(choice1==1)
			    	 {
			    		 System.out.println("Enter the no of RI details");
			    		 int num=sc.nextInt();
			    		 System.out.println("Please Enter the details as per this format"
				    		  		+ " ResidentName:Age:Gender:ContactNumber:Email:Address:NumberOfAdults:"
				    		  		+ "NumberOfChildrenAbove12:NumberOfChildrenAbove5:"
				    		  		+ "DurationOfStay:ResidentType:IDAadharProof");
			    		 String array[]= new String[num];
			    		 for(int i=0;i<num;i++)
			    		 {
			    			array[i]=sc.next(); 
			    		 }
			    		 
			    		 List<RIResident> RIobj=RIService.add(array);
			    		 if(RIobj.size()!=0)
			    		 {
			    			 for(RIResident obj:RIobj)
			    			 {
			    				 System.out.println(obj.getResidentName()+"Your id is :"+ obj.getResidentId());
			    			 }
			    		 }
			    		 else {
			    			 System.out.println("Unable to add details");
			    		 }
			    	 }
			    	 if(choice1==2)
			    	 {
			    		 int update=0;
			    		
			    		 System.out.println("1.Update phonenumber by ResidentId?");
			    		 System.out.println("2.Update phonenumber by IDProof");
			    		 System.out.println("3.Update occupancy using ResidentId");
			    		 System.out.println("4.update occupancy using IDproof");
			    		 System.out.println("5.update occupancy using phonenumber:");
			    		  update=sc.nextInt();
			    		  sc.nextLine();
			    		 if(update==1)
			    		 {
			    			 System.out.print("Enter Resident ID: ");
			    		        String residentId = sc.nextLine();
			    		        sc.nextLine();
			    		        System.out.print("Enter New Phone Number: ");
			    		        long newPhoneNumber = sc.nextLong();
			    		        sc.nextLine();
			    		        boolean updated = RIService.updateRIResidentPhoneNumberUsingResidentId(residentId, newPhoneNumber);
			    		        if (updated) {
			    		            System.out.println("Phone Number Updated Successfully");
			    		        } else {
			    		            System.out.println("Failed to Update Phone Number");
			    		        }
			    		 }
			    		 if(update==2)
			    		 {
			    			 System.out.println("Enter AadharProof: ");
			    			 long proof=sc.nextLong();
			    			 System.out.print("Enter New Phone Number: ");
			    		        long newPhoneNumber = sc.nextLong();
			    		        sc.nextLine();
			    		        boolean updated = RIService.updateRIResidentPhoneNumberUsingIdProof(proof, newPhoneNumber);
			    		        if (updated) {
			    		            System.out.println("Phone Number Updated Successfully");
			    		        } else {
			    		            System.out.println("Failed to Update Phone Number");
			    		        }
			    			 
			    		 }
			    		 if(update==3)
			    		 {
			    			 System.out.print("Enter Resident ID: ");
			    		        String residentId = sc.nextLine();
			    		       
			    		        System.out.print("Enter Number of Adults: ");
			    		        int numberOfAdults = sc.nextInt();
			    		        System.out.print("Enter Number of Children Above 12: ");
			    		        int numberOfChildrenAbove12 = sc.nextInt();
			    		        System.out.print("Enter Number of Children Above 5: ");
			    		        int numberOfChildrenAbove5 = sc.nextInt();
			    		        sc.nextLine(); 
			    		        boolean updated = RIService.updateOccupancyUsingResidentId(residentId, numberOfAdults, numberOfChildrenAbove12, numberOfChildrenAbove5);
			    		        if (updated) {
			    		            System.out.println("Occupancy Updated Successfully");
			    		        } else {
			    		            System.out.println("Failed to Update Occupancy");
			    		        }
			    		    }
			    		   if(update==4)
			    		   {
			    			   System.out.println("Enter AadharProof: ");
				    			 long proof=sc.nextLong();
				    			 System.out.print("Enter Number of Adults: ");
				    		        int numberOfAdults = sc.nextInt();
				    		        System.out.print("Enter Number of Children Above 12: ");
				    		        int numberOfChildrenAbove12 = sc.nextInt();
				    		        System.out.print("Enter Number of Children Above 5: ");
				    		        int numberOfChildrenAbove5 = sc.nextInt();
				    		        sc.nextLine(); 
				    		        boolean updated = RIService.updateOccupancyUsingIdProof(proof, numberOfAdults, numberOfChildrenAbove12, numberOfChildrenAbove5);
				    		        if (updated) {
				 
				 System.out.println("Occupancy Updated Successfully");
				    		        } else {
				    		            System.out.println("Failed to Update Occupancy");
				    		        }
			    		   }
			    		   if(update==5)
			    		   {
			    			   System.out.println("Enter contactNumber: ");
			    			   long contact=sc.nextLong();
			    			   System.out.print("Enter Number of Adults: ");
			    			   int numberOfAdults = sc.nextInt();
			    		        System.out.print("Enter Number of Children Above 12: ");
			    		        int numberOfChildrenAbove12 = sc.nextInt();
			    		        System.out.print("Enter Number of Children Above 5: ");
			    		        int numberOfChildrenAbove5 = sc.nextInt();
			    		        sc.nextLine(); 
			    		        boolean updated = RIService.updateOccupancyUsingContactNumber(contact, numberOfAdults, numberOfChildrenAbove12, numberOfChildrenAbove5);
			    		        if (updated) {
			    		            System.out.println("Occupancy Updated Successfully");
			    		        } else {
			    			   
			    		        System.out.println("Failed to Update Occupancy");
			    		        }
			    		   }
			    		 
			    	 }
			    		   
			    			 
			    		 
			    	 if(choice1==3)
			    	 {
			    		 System.out.print("Enter Resident ID: ");
			    	        String residentId = sc.nextLine();
			    	        
			    	        boolean deleted = RIService.deleteRIResidentDetailsFromDB(residentId);
			    	        if (deleted) {
			    	            System.out.println("Resident Details Deleted Successfully");
			    	        } else {
			    	            System.out.println("Failed to Delete Resident Details");
			    	        }
			    	 }
			    	 if(choice1==4)
			    	 {
			    		 System.out.print("Enter Resident ID: ");
			    	        String residentId = sc.nextLine();
			    	        RIResident resident = RIService.retrieveRIResidentDetails(residentId);
			    	        if (resident != null) {
			    	            System.out.println("Resident Details:");
			    	            System.out.println(resident);
			    	        } else {
			    	            System.out.println("Resident with ID " + residentId + " not found");
			    	        }
			    	 }
			    	 
			    	 if(choice1==5)
			    	 {
			    		 break;
			    	 }
			    	 
			    }
			    }
			    
			    
			    //NRI
			    if(select==2)
			    {
			    	int choice1=0;
			    	while(choice1<=5) 
					    	{
					    	System.out.println("1.Add NRIResident details");
					    	 System.out.println("2.update NRIResident details");
					    	 System.out.println("3.delete NRIResident details");
					    	 System.out.println("4.View NRIResident details");
					    	 choice1=sc.nextInt();
					    	 sc.nextLine();
					    	 if(choice1==1)
					    	 {
					    		 System.out.println("Enter the no of NRI details");
					    		 int num=sc.nextInt();
					    		 System.out.println("Please Enter the details as per this format"
						    		  		+ " ResidentName:Age:Gender:ContactNumber:Email:Address:NumberOfAdults:"
						    		  		+ "NumberOfChildrenAbove12:NumberOfChildrenAbove5:"
						    		  		+ "DurationOfStay:ResidentType:PassportNo:"
						    		  		+ "PassportType:Nationality:PurposeForVisit");
					    		 String array[]= new String[num];
					    		 for(int i=0;i<num;i++)
					    		 {
					    			array[i]=sc.next(); 
					    		 }
					    		 
					    		 NRIService.add(array);
					    		 List<NRIResident> NRIobj=NRIService.add(array);
					    		 if(NRIobj.size()!=0)
					    		 {
					    			 for(NRIResident obj:NRIobj)
					    			 {
					    				 System.out.println(obj.getResidentName()+"Your id is :"+ obj.getResidentId());
					    			 }
					    		 }
					    		 else {
					    			 System.out.println("Unable to add details");
					    		 }
					    	 }
					    	
					    	 if(choice1==2)
					    	 {
					    		 int update=0;
					    		 
					    		 System.out.println("1.Update phonenumber by NResidentId?");
					    		 System.out.println("2.Update phonenumber by PassportNumber");
					    		 System.out.println("3.Update occupancy using ResidentId");
					    		 System.out.println("4.update occupancy using PassportNumber");
					    		 System.out.println("5.update occupancy using phonenumber:");
					    		 System.out.println("Enter the updation choice");
					    		 update=sc.nextInt();
					    		 sc.nextLine();
					    		 if(update==1)
					    		 {
					    			 System.out.println("Enter Resident ID: ");
					    		        String residentId = sc.nextLine();
					    		        System.out.println("Enter New Phone Number: ");
					    		        long newPhoneNumber = sc.nextLong();
					    		        sc.nextLine();
					    		        boolean updated = NRIService.updateNRIResidentPhoneNumberUsingResidentId(residentId, newPhoneNumber);
					    		        if (updated) {
					    		            System.out.println("Phone Number Updated Successfully");
					    		        } else {
					    		            System.out.println("Failed to Update Phone Number");
					    		        }
					    		 }
					    		 if(update==2)
					    		 {
					    			 System.out.println("Enter PassportNumber: ");
					    			 String PassportNumber=sc.next();
					    			 System.out.print("Enter New Phone Number: ");
					    		        long newPhoneNumber = sc.nextLong();
					    		        sc.nextLine();
					    		        boolean updated = NRIService.updateNRIResidentPhoneNumberUsingPassportNumber(PassportNumber, newPhoneNumber);
					    		        if (updated) {
					    		            System.out.println("Phone Number Updated Successfully");
					    		        } else {
					    		            System.out.println("Failed to Update Phone Number");
					    		        }
					    			 
					    		 }
					    		 if(update==3)
					    		 {
					    			 System.out.print("Enter Resident ID: ");
					    		        String residentId = sc.nextLine();
					    		       
					    		        System.out.print("Enter Number of Adults: ");
					    		        int numberOfAdults = sc.nextInt();
					    		        System.out.print("Enter Number of Children Above 12: ");
					    		        int numberOfChildrenAbove12 = sc.nextInt();
					    		        System.out.print("Enter Number of Children Above 5: ");
					    		        int numberOfChildrenAbove5 = sc.nextInt();
					    		        sc.nextLine(); 
					    		        boolean updated = NRIService.updateOccupancyUsingResidentId(residentId, numberOfAdults, numberOfChildrenAbove12, numberOfChildrenAbove5);
					    		        if (updated) {
					    		            System.out.println("Occupancy Updated Successfully");
					    		        } else {
					    		            System.out.println("Failed to Update Occupancy");
					    		        }
					    		    }
					    		   if(update==4)
					    		   {
					    			   System.out.println("Enter PassportNumber: ");
						    			 String PassportNumber=sc.next();
						    			 System.out.print("Enter Number of Adults: ");
						    		        int numberOfAdults = sc.nextInt();
						    		        System.out.print("Enter Number of Children Above 12: ");
						    		        int numberOfChildrenAbove12 = sc.nextInt();
						    		        System.out.print("Enter Number of Children Above 5: ");
						    		        int numberOfChildrenAbove5 = sc.nextInt();
						    		        sc.nextLine(); 
						    		        boolean updated = NRIService.updateOccupancyUsingPassportNumber(PassportNumber, numberOfAdults, numberOfChildrenAbove12, numberOfChildrenAbove5);
						    		        if (updated) {
						    		            System.out.println("Occupancy Updated Successfully");
						    		        } else {
						    		            System.out.println("Failed to Update Occupancy");
						    		        }
					    		   }
					    		   if(update==5)
					    		   {
					    			   System.out.println("Enter contactNumber: ");
					    			   long contact=sc.nextLong();
					    			   System.out.print("Enter Number of Adults: ");
					    			   int numberOfAdults = sc.nextInt();
					    		        System.out.print("Enter Number of Children Above 12: ");
					    		        int numberOfChildrenAbove12 = sc.nextInt();
					    		        System.out.print("Enter Number of Children Above 5: ");
					    		        int numberOfChildrenAbove5 = sc.nextInt();
					    		        sc.nextLine(); 
					    		        boolean updated = NRIService.updateOccupancyUsingContactNumber(contact, numberOfAdults, numberOfChildrenAbove12, numberOfChildrenAbove5);
					    		        if (updated) {
					    		            System.out.println("Occupancy Updated Successfully");
					    		        } else {
					    			   
					    		        System.out.println("Failed to Update Occupancy");
					    		        }
					    		   }
					    		 
					    	 }
					    	 if(choice1==3)
					    	 {
					    		 System.out.print("Enter Resident ID: ");
					    	        String residentId = sc.nextLine();
					    	        
					    	        boolean deleted = NRIService.deleteRIResidentDetailsFromDB(residentId);
					    	        if (deleted) {
					    	            System.out.println("Resident Details Deleted Successfully");
					    	        } else {
					    	            System.out.println("Failed to Delete Resident Details");
					    	        }
					    	 }
					    	 if(choice1==4)
					    	 {
					    		 System.out.print("Enter Resident ID: ");
					    	        String residentId = sc.nextLine();
					    	        NRIResident resident = NRIService.retrieveNRIResidentDetails(residentId);
					    	        if (resident != null) {
					    	            System.out.println("Resident Details:");
					    	            System.out.println(resident);
					    	        } else {
					    	            System.out.println("Resident with ID " + residentId + " not found");
					    	        }
					    	 }
					    	 
					    	 if(choice1==5)
					    	 {
					    		 break;
					    	 }
					    }
			     }
			    
			    if(select==3)
			    {
			    	break;
			    }
			    }
			    
			    
			    
			    
			    
			    
			    
			    
			    
			    
			    }
		if(choice==2)
		{
			//room
			RoomService roomservice=new RoomService();
			int choice2=0;
			while(choice2<=6)
			{
				 System.out.println("1. Insert Room");
		            System.out.println("2. Update Occupied Status");
		            System.out.println("3. View Room Details");
		            System.out.println("4. Delete Room by Room Number");
		            System.out.println("5. Delete Rooms by Floor Number");
		            System.out.println("6. Exit");
		            choice2=sc.nextInt();
		            if(choice2==1)
		            {
		            	
		            	System.out.println("Enter number of Rooms to be inserted");
		            	int num=sc.nextInt();
		            	System.out.println("Enter the room details(Room Number:Floor Number:Is Occupied (Yes/No):Max Occupancy:Has AC (Yes/No):Has Swimming Pool Access (Yes/No):Has Gym Access (Yes/No): ");
		            	
		            	String array[]= new String[num];
			    		 for(int i=0;i<num;i++)
			    		 {
			    			array[i]=sc.next(); 
			    		 }
			    		 
			    		 roomservice.add(array);
			    		 
			    	        System.out.println("Room inserted successfully.");
		            }
		            if(choice2==2)
		            {
		            	System.out.print("Enter Room Number: ");
		                String roomNumber = sc.nextLine();
		                System.out.print("Enter Occupied Status (Yes/No): ");
		                String isOccupied = sc.nextLine();

		                roomservice.updateOccupiedStatusUsingRoomNumber(roomNumber, isOccupied);
		                System.out.println("Room occupied status updated successfully.");
		            }
		            if(choice2==3)
		            {
		            	 System.out.print("Enter Room Number: ");
		                 String roomNumber = sc.nextLine();

		                 Room room = roomservice.viewRoomDetails(roomNumber);
		                 if (room != null) {
		                     System.out.println("Room Details:");
		                     System.out.println("Room Number: " + room.getRoomNumber());
		                     System.out.println("Floor Number: " + room.getFloorNumber());
		                     System.out.println("Is Occupied: " + room.getIsOccupied());
		                     System.out.println("Max Occupancy: " + room.getMaxOccupancy());
		                     System.out.println("Has AC: " + room.getHasAc());
		                     System.out.println("Has Swimming Pool Access: " + room.getHasSwimmingPoolAccess());
		                     System.out.println("Has Gym Access: " + room.getHasGymAccess());
		                 } else {
		                     System.out.println("Room details not found.");
		                 }
		            }
		            if(choice2==4)
		            {
		            	System.out.print("Enter Room Number: ");
		                String roomNumber = sc.nextLine();

		                roomservice.deleteRoomDetailsFromDBUsingRoomNumber(roomNumber);
		                System.out.println("Room deleted successfully.");
		            }
		            if(choice2==5)
		            {
		            	System.out.print("Enter Floor Number: ");
		                String floorNumber = sc.nextLine();

		                roomservice.deleteRoomDetailsFromDBUsingFloorNumber(floorNumber);
		                System.out.println("Rooms on floor " + floorNumber + " deleted successfully.");
		            }
		            if(choice2==6)
		            {
		            	break;
		            }
		            }
			}
		
		if(choice==3)
		{
			
				//booking
				BookingService bookingService=new BookingService();
				int choice3=0;
				while(choice3<=5)
				{
				 System.out.println("Booking Management System");
		            System.out.println("1. Create New Booking");
		            System.out.println("2. Update Booking Details");
		            System.out.println("3. Cancel Booking");
		            System.out.println("4. View Booking Information");
		            System.out.println("5. Exit");
		            System.out.print("Enter your choice: ");
		            choice3=sc.nextInt();
		            if(choice3==1)
		            {
		            	System.out.println("Enter number of booking to be inserted");
		            	int num=sc.nextInt();
		            System.out.println("Enter booking Details in format of "
		            		+ "ResidentId:ResidentName:DurationOfStay:NumberOfAdults"
		            		+ ":NumberOfChildrenAbove12:NumberOfChildrenAbove5:"
		            		+ "CheckInDate:CheckOutDate:FloorNumber:RoomNumber:PreferredPackage:"
		            		+ "AcAccess:PoolAccess:GymAccess");
		            
		        	
		        	String array[]= new String[num];
		    		 for(int i=0;i<num;i++)
		    		 {
		    			array[i]=sc.next(); 
		    		 }
		    		 
		    		 bookingService.add(array);
		    		 
		    	        System.out.println("Room inserted successfully.");
		            }
		            if(choice3==2)
		            {
		            	System.out.println("Enter the booking id for update");
		            	String bookingId=sc.next();
		            	System.out.println("1.Update preferredPackage\n2.Update checkin/checkout date\n3.Update Extra Access");
		            	int up=sc.nextInt();
		            	if(up==1) {
		            		
			            	System.out.println("Enter the preferredPackage");
			            	String prePackage=sc.next();
			            	boolean res= bookingService.updatePackageUsingBookingId(bookingId,prePackage);
			            	if(res) {
			            		System.out.println("Package is updated successfully");
			            	}
			            	else {
			            		System.out.println("Package is not updated");
			            	}
		            	}
		            	else if(up==2) {
		            		System.out.println("Enter the CheckInDate and CheckOutDate");
		            		String checkInDate=sc.next();
		            		String checkOutDate=sc.next();
		            		
		            		
		            		boolean res=bookingService.updateCheckInAndCheckOutUsingBookingId( bookingId,checkInDate,checkOutDate);
		            		if(res) {
			            		System.out.println("CheckInDate and CheckOutDate is updated successfully");
			            	}
			            	else {
			            		System.out.println("CheckInDate and CheckOutDate is not updated");
			            	}
		            		
		            	}
		            	else if(up==3) {
		            		System.out.println("Enter the Extra Access only enter yes/no");
		            		String acAccess=sc.next();
		            		String poolAccess=sc.next();
		            		String gymAccess=sc.next(); 
		            		boolean res= bookingService.updateExtraAccessUsingBookingId(bookingId,acAccess,poolAccess,gymAccess);
		            		if(res) {
			            		System.out.println("Extra Access is updated successfully");
			            	}
			            	else {
			            		System.out.println("Extra Access is not updated");
			            	}
		            	}
		            	else {
		            		break;
		            	}
		            	
		            	
		            }
		            if(choice3==3) {
		            	System.out.println("Enter the booking id for cancel");
		            	String bookingId=sc.next();
		            	
		            	boolean res= bookingService.cancelBookingFromDB(bookingId);
		            	if(res) {
		            		System.out.println(" Your Booking is cancel successfully");
		            	}
		            	else {
		            		System.out.println("Your Booking was not cancel ");
		            	}
		            }
		            if(choice3==4) {
		            	System.out.println("Enter the booking id for view Booking Details");
		            	String bookingId=sc.next();
		            	Booking book=bookingService.viewBookingDetails(bookingId);
//		            	
		            		System.out.println(book);
//		          
		            	
		            }
		            if(choice3==5) {
		            	break;
		            }
				}
			}
		if(choice==4)
		{
			//manager
			int choice4=0;
			while(choice4<=5)
			{
				ManagerService managerService=new ManagerService();
				System.out.println("1.ViewBookingDetails\n2.ViewAvailableRoom\n3.ViewOccupiredRoom\n4.ViewAvailableRoomForParticularFloorNumber\n5.ViewOccupiedRoomForParticularFloorNumber\n6.ViewOccupiedRoomForParticularCheckInDate\n7.ViewOccupiedRoomFOrParticularCheckOutDate");
				System.out.println("Enter your choice");
				choice4=sc.nextInt();
				if(choice4==1)
				{
					List<Booking> book=managerService.viewBookingDetails();
					for(Booking x:book) {
						System.out.println(x);
					}
					
				}
				else if(choice4==2) {
					List<String> book=managerService.viewAvailableRooms();
					for(String x:book) {
						System.out.println(x);
					}
				}
				else if(choice4==3) {
					List<String> book=managerService.viewOccupiedRooms();
					for(String x:book) {
						System.out.println(x);
					}
				}
				else if(choice4==4) {
					System.out.println("Enter the floorNumber: ");
					String floornum=sc.next();
					List<String> book=managerService.viewAvailableRoomsForParticularFloorNumber(floornum);
					for(String x:book) {
						System.out.println(x);
					}
				}
				else if(choice4==5) {
					System.out.println("Enter the floorNumber: ");
					String floornum=sc.next();
					List<String> book=managerService.viewOccupiedRoomsForParticularFloorNumber(floornum);
					for(String x:book) {
						System.out.println(x);
					}
				}
				else if(choice4==6) {
					System.out.println("Enter the CheckInDate: ");
					String date=sc.next();
					List<String> book=managerService.viewOccupiedRoomsForParticularCheckInDate(date);
					for(String x:book) {
						System.out.println(x);
					}
				}
				else if(choice4==7) {
					System.out.println("Enter the CheckOutDate: ");
					String date=sc.next();
					List<String> book=managerService.viewOccupiedRoomsForParticularCheckOutDate(date);
					for(String x:book) {
						System.out.println(x);
					}
				}
			}
			
			
		}
		if(choice==5)
		{
			//bill
			System.out.println("How many payments details should be added");
			int details=sc.nextInt();
			System.out.println("Enter the Booking ID:Payment Date:Mode Of Pay");
			BookingService  bookingService=new BookingService();
			PaymentService paymentService=new PaymentService();
			String [] bid=new String[details];
			for(int i=0;i<details;i++) {
				bid[i]=sc.next();
			}
		    List<Payment>li=paymentService.getPaymentDetails(bid);
		    System.out.println("Payments details");
		    for(Payment X: li) {
		    	System.out.println(X);
		    }
			 

		        
		}
			 
	    		 
	    	 }

	
}
}	
	
	    
	    		
	    		 
	    		 
	    		 
	    		 
	    		  

	 
 
 

