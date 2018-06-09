package org.finra.SQSProcess;

public class IntegerList {

	private String firstName;
	private String lastName;
	private String intList;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getIntList() {
		return intList;
	}
	public void setIntList(String intList) {
		this.intList = intList;
	}
	public String toString() {
		return firstName + " " + lastName + " " + intList;
	}
}
