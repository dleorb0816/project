package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

@Controller
@Log
@RequestMapping("/use/*")
public class LibraryUseController {

	@GetMapping("/time")
	public String time() {
		log.info("get time()" );

		return "use/time";
	}

	@GetMapping("/usebook")
	public String usebook() {
		log.info("get time()" );

		return "use/usebook";
	}

	@GetMapping("/uselibrary")
	public String uselibrary() {
		log.info("get uselibrary()" );

		return "use/uselibrary";
	}

	@GetMapping("/video")
	public String video() {
		log.info("get video()" );

		return "use/video";
	}


}
