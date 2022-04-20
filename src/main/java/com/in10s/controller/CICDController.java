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
import com.in10s.pojo.Response;
import com.in10s.utils.Util;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author Abhishek Amar
 *
 */
@RestController
@RequestMapping("/cicd")
public class CICDController {
	static Logger LOG = LogManager.getLogger(CICDController.class);
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "success", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "400", description = "Invalid payload supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "Not found", content = @Content),
			@ApiResponse(responseCode = "500", description = "Something went wrong") })
	@Tag(name = "CICD DUMMY DETAILS", description = "IT CONTAINS DUMMY DETAILS FOR CICD API")
	@GetMapping("/details")
	ResponseEntity<Map<String, String>> showDetails() {
		Map<String, String> map = new HashMap<>();
		map.put("name", "ABHISHEK AMAR");
		map.put("companyName", "INTENSE TECHNOLOGY PVT. LTD");
		map.put("subject", "CREATING THE CICD PIPELINE");
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	/* for dummy save */
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "success", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "400", description = "Invalid payload supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "Not found", content = @Content),
			@ApiResponse(responseCode = "500", description = "Something went wrong") })
	@Tag(name = "SAVES DUMMY DETAILS", description = "IT SAVES DUMMY DETAILS FOR CICD API")
	@PostMapping
	ResponseEntity<Map<String, String>> saveDetails(@RequestBody Map<String, String> map) {
		map.put("message", "Saved successfully");
		map.put("status", "OK");
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@PostMapping("/find-by-id/{id}")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "success", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "400", description = "Invalid payload supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "Not found", content = @Content),
			@ApiResponse(responseCode = "500", description = "Something went wrong") })
	@Tag(name = "FINDS DETAILS BY EMPLOYEE ID", description = "IT FINDS THE EMPLOYEE DETAILS BY ID")
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
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "success", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "400", description = "Invalid payload supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "Not found", content = @Content),
			@ApiResponse(responseCode = "500", description = "Something went wrong") })
	@Tag(name = "FINDS ALL EMPLOYEE DETAILS", description = "FINDS ALL EMPLOYEE DETAILS")
	ResponseEntity<List<Employee>> findAll() {
		return new ResponseEntity<>(Util.getEmployeeList(), HttpStatus.OK);
	}

}
