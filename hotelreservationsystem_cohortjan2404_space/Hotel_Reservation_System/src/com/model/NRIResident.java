package com.model;

public class NRIResident extends Resident{

	 private String PassportNo;
	 private String PassportType;
	 private String Nationality;
	private String PurposeForVisit;
	 
	
	
	
	
	public String getPassportNo() {
		return PassportNo;
	}
	public void setPassportNo(String passportNo) {
		PassportNo = passportNo;
	}
	public String getPassportType() {
		return PassportType;
	}
	public void setPassportType(String passportType) {
		PassportType = passportType;
	}
	public String getNationality() {
		return Nationality;
	}
	public void setNationality(String nationality) {
		Nationality = nationality;
	}
	public String getPurposeForVisit() {
		return PurposeForVisit;
	}
	public void setPurposeForVisit(String purposeForVisit) {
		PurposeForVisit = purposeForVisit;
	}
	public NRIResident(String residentId, String residentName, int age, String gender, long contactNumber, String email,
			String address, int numberOfAdults, int numberOfChildrenAbove12, int numberOfChildrenAbove5,
			int durationOfStay, String residentType, String passportNo, String passportType, String nationality,String purposeForVisit) {
		super(residentId, residentName, age, gender, contactNumber, email, address, numberOfAdults,
				numberOfChildrenAbove12, numberOfChildrenAbove5, durationOfStay, residentType);
		PassportNo = passportNo;
		PassportType = passportType;
		Nationality = nationality;
		PurposeForVisit = purposeForVisit;
	}
	public NRIResident() {
		// TODO Auto-generated constructor stub
	}
		// TODO Auto-generated constructor stub
	@Override
	public String toString() {
		return "NRIResident [PassportNo=" + PassportNo + ", PassportType=" + PassportType + ", Nationality="
				+ Nationality + ", PurposeForVisit=" + PurposeForVisit + ", ResidentId=" + ResidentId
				+ ", ResidentName=" + ResidentName + ", Age=" + Age + ", Gender=" + Gender + ", ContactNumber="
				+ ContactNumber + ", Email=" + Email + ", Address=" + Address + ", NumberOfAdults=" + NumberOfAdults
				+ ", NumberOfChildrenAbove12=" + NumberOfChildrenAbove12 + ", NumberOfChildrenAbove5="
				+ NumberOfChildrenAbove5 + ", DurationOfStay=" + DurationOfStay + ", ResidentType=" + ResidentType
				+ "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	

	   


	}




