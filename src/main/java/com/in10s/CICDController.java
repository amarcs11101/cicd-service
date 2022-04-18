/**
 * 
 */
package com.in10s;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		map.put("subject", "creating the cicd pipeline");
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	/* for dummy save*/
	@PostMapping
	ResponseEntity<Map<String, String>> saveDetails(@RequestBody Map<String,String> map) { 
		map.put("message", "Saved successfully");
		map.put("status", "OK");
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
}
