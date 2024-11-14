package com.model;

import java.util.Date;

public class Booking extends Resident{
 private String BookingId;
 private String ResidentId;
 private String ResidentName;
 private int DurationOfStay;
 private int NumberOfAdults;
 private int NumberOfChildrenAbove12;
 private int NumberOfChildrenAbove5;
 private Date CheckInDate;
 private Date CheckOutDate;
 private String FloorNumber;
 private String RoomNumber;
 private String PreferredPackage;
 private String AcAccess;
 private String PoolAccess;
 private String GymAccess;
public String getBookingId() {
	return BookingId;
}
public void setBookingId(String bookingId) {
	BookingId = bookingId;
}
public String getResidentId() {
	return ResidentId;
}
public void setResidentId(String residentId) {
	ResidentId = residentId;
}
public String getResidentName() {
	return ResidentName;
}
public void setResidentName(String residentName) {
	ResidentName = residentName;
}
public int getDurationOfStay() {
	return DurationOfStay;
}
public void setDurationOfStay(int durationOfStay) {
	DurationOfStay = durationOfStay;
}
public int getNumberOfAdults() {
	return NumberOfAdults;
}
public void setNumberOfAdults(int numberOfAdults) {
	NumberOfAdults = numberOfAdults;
}
public int getNumberOfChildrenAbove12() {
	return NumberOfChildrenAbove12;
}
public void setNumberOfChildrenAbove12(int numberOfChildrenAbove12) {
	NumberOfChildrenAbove12 = numberOfChildrenAbove12;
}
public int getNumberOfChildrenAbove5() {
	return NumberOfChildrenAbove5;
}
public void setNumberOfChildrenAbove5(int numberOfChildrenAbove5) {
	NumberOfChildrenAbove5 = numberOfChildrenAbove5;
}
public Date getCheckInDate() {
	return CheckInDate;
}
public void setCheckInDate(java.util.Date checkInDate2) {
	CheckInDate =  (Date) checkInDate2;
}
public Date getCheckOutDate() {
	return CheckOutDate;
}
public void setCheckOutDate(java.util.Date checkOutDate2) {
	CheckOutDate = (Date) checkOutDate2;
}
public String getFloorNumber() {
	return FloorNumber;
}
public void setFloorNumber(String floorNumber) {
	FloorNumber = floorNumber;
}
public String getRoomNumber() {
	return RoomNumber;
}
public void setRoomNumber(String roomNumber) {
	RoomNumber = roomNumber;
}
public String getPreferredPackage() {
	return PreferredPackage;
}
public void setPreferredPackage(String preferedPackage) {
	PreferredPackage = preferedPackage;
}
public String getAcAccess() {
	return AcAccess;
}
public void setAcAccess(String acAccess) {
	AcAccess = acAccess;
}
public String getPoolAccess() {
	return PoolAccess;
}
public void setPoolAccess(String poolAccess) {
	PoolAccess = poolAccess;
}
@Override
public String toString() {
	return "Booking [BookingId=" + BookingId + ", ResidentId=" + ResidentId + ", ResidentName=" + ResidentName
			+ ", DurationOfStay=" + DurationOfStay + ", NumberOfAdults=" + NumberOfAdults + ", NumberOfChildrenAbove12="
			+ NumberOfChildrenAbove12 + ", NumberOfChildrenAbove5=" + NumberOfChildrenAbove5 + ", CheckInDate="
			+ CheckInDate + ", CheckOutDate=" + CheckOutDate + ", FloorNumber=" + FloorNumber + ", RoomNumber="
			+ RoomNumber + ", PreferedPackage=" + PreferredPackage + ", AcAccess=" + AcAccess + ", PoolAccess="
			+ PoolAccess + ", GymAccess=" + GymAccess + "]";
}
public String getGymAccess() {
	return GymAccess;
}
public void setGymAccess(String gymAccess) {
	GymAccess = gymAccess;
}
public Booking(String residentId, String residentName, int age, String gender, long contactNumber, String email,
		String address, int numberOfAdults, int numberOfChildrenAbove12, int numberOfChildrenAbove5, int durationOfStay,
		String residentType, String bookingId, String residentId2, String residentName2, int durationOfStay2,
		int numberOfAdults2, int numberOfChildrenAbove122, int numberOfChildrenAbove52, Date checkInDate,
		Date checkOutDate, String floorNumber, String roomNumber, String preferredPackage, String acAccess,
		String poolAccess, String gymAccess) {
	super(residentId, residentName, age, gender, contactNumber, email, address, numberOfAdults, numberOfChildrenAbove12,
			numberOfChildrenAbove5, durationOfStay, residentType);
	BookingId = bookingId;
	ResidentId = residentId2;
	ResidentName = residentName2;
	DurationOfStay = durationOfStay2;
	NumberOfAdults = numberOfAdults2;
	NumberOfChildrenAbove12 = numberOfChildrenAbove122;
	NumberOfChildrenAbove5 = numberOfChildrenAbove52;
	CheckInDate = checkInDate;
	CheckOutDate = checkOutDate;
	FloorNumber = floorNumber;
	RoomNumber = roomNumber;
	PreferredPackage = preferredPackage;
	AcAccess = acAccess;
	PoolAccess = poolAccess;
	GymAccess = gymAccess;
}
public Booking() {
	// TODO Auto-generated constructor stub
}

 
}
