/**
 * 
 */
package com.test.rest.pojo;

/**
 * @author kunal.lawand
 *
 */
public class Student {

	private String name;
	private String department;
	private String collegeName;
	private String year;

	public Student(String name, String department, String collegeName, String year) {
		super();
		this.name = name;
		this.department = department;
		this.collegeName = collegeName;
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
