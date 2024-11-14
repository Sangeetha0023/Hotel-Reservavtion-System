package com.service;


	

	

	   
		

		import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.management.BookingManagement;
import com.management.PaymentManagement;
import com.model.Booking;
import com.model.Payment;
import com.util.ApplicationUtil;

		public class PaymentService {

		     PaymentManagement paymentManagement=new PaymentManagement();
		     BookingManagement bs= new BookingManagement();
		     
		     ApplicationUtil au=new ApplicationUtil();
		     public List<Payment> getPaymentDetails(String[] details) 
			    {
			    	
			    	List<String> paymentString=	au.convertList(details);
			    	
			    	List<Payment> ls=generateObj(paymentString);
			    	return paymentManagement.insertPayments(ls);
					 
			       
			    }

				public  List<Payment> generateObj(List<String> obj) 
				{
					// TODO Auto-generated method stub
					List<Payment> payment=new ArrayList<>();
					for(String s:obj)
					{
						String [] paymentArray=s.split(":");
						String paymentId=generateId();
						String bookingId=paymentArray[0];
						Booking bookingObj=bs.retrieveBookingDetails(bookingId);
						String resName=bookingObj.getResidentName();
						String floorNum=bookingObj.getFloorNumber();
						String roomNum=bookingObj.getRoomNumber();
						Date chInDate=bookingObj.getCheckInDate();
						Date chOutDate=bookingObj.getCheckOutDate();
						Date paymentDate=au.convertStringToUtilDate(paymentArray[1]);
						String paymentMethod=paymentArray[2];
						double billAmount=calculateBill(bookingObj);
						Payment pay=new Payment(paymentId,bookingId,resName,floorNum,roomNum,chInDate,chOutDate,paymentDate,paymentMethod,billAmount);
						payment.add(pay);
						
						
					}
					return payment;
				}

		    public PaymentService() {
		        this.paymentManagement = new PaymentManagement();
		    }

		    public void insertPayments(List<Payment> payments) {
		        paymentManagement.insertPayments(payments);
		    }

		    public int checkPaymentIdExists() {
		        return paymentManagement.checkPaymentIdExists();
		    }

		    public Payment getPaymentDetails(String paymentId) {
		        return paymentManagement.getPaymentDetails(paymentId);
		    }
		    private static int counter = 1; 
		    private static final String PREFIX = "PAY"; 
		    PaymentManagement payManage=new PaymentManagement();
		    public String generateId() {
		    	
		       if(counter==1) {
		    	   counter=payManage.checkPaymentIdExists();
		       }
		       counter++;
		        String id = PREFIX + counter;
		        
		        
		        return id;
		    }
		    
		    
		    
		    private static final int ROOM_CHARGE_FLOOR_1 = 1500;
		    private static final int ROOM_CHARGE_FLOOR_2 = 2000;
		    private static final int ROOM_CHARGE_FLOOR_3 = 2500;
		    private static final int ROOM_CHARGE_FLOOR_4 = 4000;

		    private static final int AC_CHARGE_PER_NIGHT = 750;
		    private static final double CHILD_CHARGE = 500;
		    
		   
		    public static double calculateBill(Booking booking) {
		        int baseRoomCharge = getBaseRoomCharge(booking.getFloorNumber());
		        int durationOfStay = booking.getDurationOfStay();
		        int numberOfAdults = booking.getNumberOfAdults();
		        int numberOfChildrenAbove12 = booking.getNumberOfChildrenAbove12();
		        int numberOfChildrenAbove5 = booking.getNumberOfChildrenAbove5();

		        // Calculate room charges
		        double roomCharges = baseRoomCharge * durationOfStay;

		        // Calculate additional services charges
		    
		        double additionalServicesCharges = calculateAdditionalServicesCharge(booking);

		        // Calculate children charges
		        double childrenCharge = calculateChildrenCharge(numberOfChildrenAbove12, numberOfChildrenAbove5);

		        // Calculate total bill amount
		        double totalBillAmount = roomCharges + additionalServicesCharges + childrenCharge;

		        // Apply discounts based on package
		        totalBillAmount -= applyPackageDiscount(booking, totalBillAmount);

		        return totalBillAmount;
		    }

		    private static int getBaseRoomCharge(String floorNumber) {
		        switch (floorNumber) {
		            case "1":
		                return ROOM_CHARGE_FLOOR_1;
		            case "2":
		                return ROOM_CHARGE_FLOOR_2;
		            case "3":
		                return ROOM_CHARGE_FLOOR_3;
		            case "4":
		                return ROOM_CHARGE_FLOOR_4;
		            default:
		                return 0;
		        }
		    }

		    private static double calculateAdditionalServicesCharge(Booking booking) {
		        double additionalServicesCharge = 0;
		        if (booking.getAcAccess().equalsIgnoreCase("Yes")) {
		            additionalServicesCharge += AC_CHARGE_PER_NIGHT * booking.getDurationOfStay();
		        }
		        // Add charges for other additional services if needed
		        return additionalServicesCharge;
		    }

		    private static double calculateChildrenCharge(int numberOfChildrenAbove12, int numberOfChildrenAbove5) {
		        double childrenCharge = 0;
		        childrenCharge += CHILD_CHARGE * numberOfChildrenAbove12;
		        // Children under 5 years are free
		        return childrenCharge;
		    }

		    private static double applyPackageDiscount(Booking booking, double totalBillAmount) {
		        String preferredPackage = booking.getPreferredPackage();
		        if (preferredPackage != null && !preferredPackage.isEmpty()) {
		            switch (preferredPackage) {
		                case "Package 1":
		                    if (totalBillAmount > 3 * ROOM_CHARGE_FLOOR_1) {
		                        
		                        // and 10% discount on the entire bill
		                        return 0.1 * totalBillAmount;
		                    }
		                    break;
		                case "Package 2":
		                  
		                    return 0.1 * (ROOM_CHARGE_FLOOR_1 * booking.getDurationOfStay());
		                case "Package 3":
		                   
		                    if (booking.getFloorNumber().equals("4")) {
		                        // Assume breakfast and dinner charges are included in the room charges
		                        return 0;
		                    }
		                    break;
		                default:
		                    break;
		            }
		        }
		        return 0;
		    }
		}

		    
		    
		    
		

	



