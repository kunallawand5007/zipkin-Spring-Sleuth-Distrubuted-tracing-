/**
 * 
 */
package com.test.rest.pojo;

import java.util.List;

/**
 * @author kunal.lawand
 *
 */
public class College {

	private String name;
	private List<String> department;
	private String stream;

	public College(String name, List<String> department, String stream) {
		super();
		this.name = name;
		this.department = department;
		this.stream = stream;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getDepartment() {
		return department;
	}

	public void setDepartment(List<String> department) {
		this.department = department;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

}
