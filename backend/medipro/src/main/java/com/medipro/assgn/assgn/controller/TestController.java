package com.medipro.assgn.assgn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.medipro.assgn.assgn.beans.Test;
import com.medipro.assgn.assgn.service.TestService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	TestService testservice;

	// http://localhost:8686/test/List
	@GetMapping("/List")
	public List<Test> listAllTest() {
		return testservice.listAllTest();
	}

	// http://localhost:8686/test/AddTest/
	@PostMapping("/AddTest")
	public Test addTest(@RequestBody Test t) {
		Test b1 = testservice.addTest(t);
		return b1;
	}

	// http://localhost:8686/test/UpdateTest/
	@PostMapping("/UpdateTest")
	public String updateTopic(@RequestBody Test t) {
		testservice.updateTopic(t);
		return "Updated Success";
	}

	// http://localhost:8686/test/deleteTest/
	@DeleteMapping("/deleteTest/{id}")
	public boolean deleteTest(@PathVariable("id") int did) {
		testservice.deleteTest(did);
		return true;
	}

//	//http://localhost:8686/test/Find/
	@GetMapping("/Find/{id}")
	public Test findTest(@PathVariable("id") int did) {
		Test resp = testservice.findTest(did);
		return resp;
	}

}
