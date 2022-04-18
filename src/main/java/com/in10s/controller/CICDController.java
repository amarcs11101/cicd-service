/**
 * 
 */
package com.in10s.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Abhishek Amar
 *
 */
@RestController
@RequestMapping("/cicd")
public class CICDController {
	@GetMapping("/details")
	ResponseEntity<Map<String, String>> showDetails() {
		Map<String, String> map = new HashMap<>();
		map.put("name", "abhishek");
		map.put("companyName", "Intense technology pvt. ltd");
		map.put("subject", "creating thr cicd pipeline");
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
}
