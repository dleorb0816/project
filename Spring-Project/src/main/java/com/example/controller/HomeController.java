package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.java.Log;

@Controller
@Log
public class HomeController {

	@GetMapping("/")
	public String index() {
		log.info("index() 호출됨");
		return "index";
	}

}
