/**
 * 
 */
package com.test.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.test.rest.pojo.College;

/**
 * @author kunal.lawand
 *
 */
@RestController
public class CollegeController {

	@Autowired
	RestTemplate restTemplate;

	@Bean
	RestTemplate getrestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}

	/**
	 * @return List<College>
	 */
	@RequestMapping(value = "/colleges", method = RequestMethod.GET, headers = "accept=application/json")
	public ResponseEntity<List<?>> listColleges() {
		return new ResponseEntity<>(this.list(), HttpStatus.OK);
	}

	@RequestMapping(value = "/colleges/students/{name}", method = RequestMethod.GET, headers = "accept=application/json")
	public ResponseEntity<String> listColleges(@PathVariable String name) {

		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8082/api/student/" + name,
				String.class);
		return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
	}

	private List<College> list() {
		List<College> colleges = new ArrayList<>();
		List<String> departments = new ArrayList<>();
		departments.add("IT");
		departments.add("COMPUTER");
		departments.add("E&TC");
		departments.add("MECHANICAL");

		College coep = new College("COEP", departments, "Engineering");

		departments.remove("MECHANICAL");
		College pict = new College("PICT", departments, "Engineering");

		colleges.add(coep);
		colleges.add(pict);

		return colleges;

	}

}
