/**
 * 
 */
package com.in10s.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in10s.pojo.Employee;
import com.in10s.pojo.Exception;
import com.in10s.pojo.Response;
import com.in10s.utils.Util;

/**
 * @author Abhishek Amar
 *
 */
@RestController
@RequestMapping("/cicd")
public class CICDController {
	static Logger LOG = LogManager.getLogger(CICDController.class);
	@GetMapping("/details")
	ResponseEntity<Map<String, String>> showDetails() {
		Map<String, String> map = new HashMap<>();
		map.put("name", "abhishek");
		map.put("companyName", "Intense technology pvt. ltd");
		map.put("subject", "creating the cicd pipeline");
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	/* for dummy save */
	@PostMapping
	ResponseEntity<Map<String, String>> saveDetails(@RequestBody Map<String, String> map) {
		map.put("message", "Saved successfully");
		map.put("status", "OK");
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@PostMapping("/find-by-id/{id}")
	ResponseEntity<Response> findDetailsById(@PathVariable("id") Integer id) {
		List<Employee> employeeList = Util.getEmployeeList();
		List<Employee> empLists = employeeList.stream().filter(emp -> emp.getEmployeeId().equals(id))
				.collect(Collectors.toList());
		LOG.info(":: find by id ::" + empLists);
		if (ObjectUtils.isEmpty(empLists)) {
			LOG.error(":: inside find by id  ::" +id+" :: there is no record found");
			return new ResponseEntity<>(new Response("Sorry! record not found ", "OK", new Date(), null), HttpStatus.OK);
		}
		return new ResponseEntity<>(new Response("Success", "OK", new Date(), empLists), HttpStatus.OK);
	}

	@PostMapping("/find-all")
	ResponseEntity<List<Employee>> findAll() {
		return new ResponseEntity<>(Util.getEmployeeList(), HttpStatus.OK);
	}

}
