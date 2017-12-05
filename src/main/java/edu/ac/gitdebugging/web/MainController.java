package edu.ac.gitdebugging.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@RequestMapping("/sayHello")
	public String sayHello() {
		return "Hello";
	}
}
