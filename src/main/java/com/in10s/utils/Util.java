/**
 * 
 */
package com.in10s.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.in10s.pojo.Employee;

/**
 * @author Abhishek Amar
 *
 */
public class Util {
	static Logger LOG = LogManager.getLogger(Util.class);

	public static List<Employee> getEmployeeList() {
		List<Employee> employeeList = new ArrayList<Employee>();
		Employee employee1 = new Employee(1, "ABHISHEK AMAR", "987654321O");
		Employee employee2 = new Employee(2, "AMAR", "0987654321");
		Employee employee3 = new Employee(3, "KUMAR AMAR ", "986765432");
		Employee employee4 = new Employee(4, "SK ", "9754321711");
		Employee employee5 = new Employee(5, "KKK KUMAR", "0452625267");
		Employee employee6 = new Employee(6, "INTENSE TECHNOLOGY", "7652345111");
		employeeList.add(employee1);
		employeeList.add(employee2);
		employeeList.add(employee3);
		employeeList.add(employee4);
		employeeList.add(employee5);
		employeeList.add(employee6);
		LOG.info(":: employee list contains ::" + employeeList);
		return employeeList;
	}
}
