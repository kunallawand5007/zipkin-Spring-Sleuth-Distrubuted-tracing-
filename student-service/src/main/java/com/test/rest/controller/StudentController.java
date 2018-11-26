/**
 * 
 */
package com.test.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.rest.pojo.Student;

/**
 * @author kunal.lawand
 *
 */
@RestController
public class StudentController {

	private List<Student> students = new ArrayList<>();

	@PostConstruct
	public void init() {
		Student student = new Student("Kunal Lawand", "Computer", "COEP", "FE");
		Student student1 = new Student("Rahul G", "IT", "COEP", "SE");
		Student student2 = new Student("Kunal Lawand", "Computer", "PICT", "FE");
		Student student3 = new Student("Akashy G", "IT", "COEP", "TE");
		Student student4 = new Student("John Sinha ", "ETC", "PICT", "BE");
		Student student5 = new Student("Khali ", "IT", "COEP", "FE");

		students.add(student5);
		students.add(student4);
		students.add(student3);
		students.add(student2);
		students.add(student1);
		students.add(student);

		System.out.println("Student list is loaded");

	}

	/**
	 * @param collegeName
	 * @return
	 */
	@RequestMapping(value = "/student/{collegename}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<String> studentByCollegeName(@PathVariable String collegename) {

		List<Student> collect = students.stream().filter(st -> st.getCollegeName().equalsIgnoreCase(collegename))
				.collect(Collectors.toList());
		String writeValueAsString = "";
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			writeValueAsString = objectMapper.writeValueAsString(collect);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<String>(writeValueAsString, HttpStatus.OK);
	}

}
