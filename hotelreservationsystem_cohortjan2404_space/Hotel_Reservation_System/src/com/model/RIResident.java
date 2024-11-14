package com.model;

public class RIResident extends Resident{
    
   private long Idproof_AadharNo;

public long getIdproof_AadharNo() {
	return Idproof_AadharNo;
}

public void setIdproof_AadharNo(long idproof_AadharNo) {
	Idproof_AadharNo = idproof_AadharNo;
}

public RIResident(String residentId, String residentName, int age, String gender, long contactNumber, String email,
		String address, int numberOfAdults, int numberOfChildrenAbove12, int numberOfChildrenAbove5, int durationOfStay,
		String residentType, long idproof_AadharNo) {
	super(residentId, residentName, age, gender, contactNumber, email, address, numberOfAdults, numberOfChildrenAbove12,
			numberOfChildrenAbove5, durationOfStay, residentType);
	Idproof_AadharNo = idproof_AadharNo;
}

public RIResident() {
	// TODO Auto-generated constructor stub
	super();
}

@Override
public String toString() {
	return "RIResident [Idproof_AadharNo=" + Idproof_AadharNo + ", ResidentId=" + ResidentId + ", ResidentName="
			+ ResidentName + ", Age=" + Age + ", Gender=" + Gender + ", ContactNumber=" + ContactNumber + ", Email="
			+ Email + ", Address=" + Address + ", NumberOfAdults=" + NumberOfAdults + ", NumberOfChildrenAbove12="
			+ NumberOfChildrenAbove12 + ", NumberOfChildrenAbove5=" + NumberOfChildrenAbove5 + ", DurationOfStay="
			+ DurationOfStay + ", ResidentType=" + ResidentType + "]";
}






}
   



