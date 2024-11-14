package com.model;

public class Resident {

	
	
	
	 @Override
	public String toString() {
		return "Resident [ResidentId=" + ResidentId + ", ResidentName=" + ResidentName + ", Age=" + Age + ", Gender="
				+ Gender + ", ContactNumber=" + ContactNumber + ", Email=" + Email + ", Address=" + Address
				+ ", NumberOfAdults=" + NumberOfAdults + ", NumberOfChildrenAbove12=" + NumberOfChildrenAbove12
				+ ", NumberOfChildrenAbove5=" + NumberOfChildrenAbove5 + ", DurationOfStay=" + DurationOfStay
				+ ", ResidentType=" + ResidentType + "]";
	}
	 protected String ResidentId;
	protected String ResidentName;
	 protected int Age;
	 protected String Gender;
	 protected long ContactNumber;
	 protected String Email;
	 protected String Address;
	 protected int NumberOfAdults;
	 protected int NumberOfChildrenAbove12;
	 protected int NumberOfChildrenAbove5;
	 protected int DurationOfStay;
	 protected String ResidentType;
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
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public long getContactNumber() {
		return ContactNumber;
	}
	public void setContactNumber(long contactNumber) {
		ContactNumber = contactNumber;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
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
	public int getDurationOfStay() {
		return DurationOfStay;
	}
	public void setDurationOfStay(int durationOfStay) {
		DurationOfStay = durationOfStay;
	}
	public String getResidentType() {
		return ResidentType;
	}
	public void setResidentType(String residentType) {
		ResidentType = residentType;
	}
	public Resident(String residentId, String residentName, int age, String gender, long contactNumber, String email,
			String address, int numberOfAdults, int numberOfChildrenAbove12, int numberOfChildrenAbove5,
			int durationOfStay, String residentType) {
		super();
		ResidentId = residentId;
		ResidentName = residentName;
		Age = age;
		Gender = gender;
		ContactNumber = contactNumber;
		Email = email;
		Address = address;
		NumberOfAdults = numberOfAdults;
		NumberOfChildrenAbove12 = numberOfChildrenAbove12;
		NumberOfChildrenAbove5 = numberOfChildrenAbove5;
		DurationOfStay = durationOfStay;
		ResidentType = residentType;
	}
	public Resident() {
		// TODO Auto-generated constructor stub
	}
	 
	 

}
