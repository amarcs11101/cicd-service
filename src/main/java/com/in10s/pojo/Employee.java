/**
 * 
 */
package com.in10s.pojo;

import java.io.Serializable;

/**
 * @author Abhishek Amar
 *
 */
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer employeeId;
	private String empName;
	private String mobileNumber;

	public Employee(Integer employeeId, String empName, String mobileNumber) {
		super();
		this.employeeId = employeeId;
		this.empName = empName;
		this.mobileNumber = mobileNumber;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", empName=" + empName + ", mobileNumber=" + mobileNumber + "]";
	}

}
