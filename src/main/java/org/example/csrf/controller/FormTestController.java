package org.example.csrf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/formtest")
public class FormTestController {

	@GetMapping
	public String getForm() {
		return "formtest";
	}

	@PostMapping
	public ModelAndView inspect(@RequestBody MultiValueMap<String,String> formData) {
        ModelAndView modelAndView = new ModelAndView("formtest");
		for (String key : formData.keySet()) {
			log.info(String.format("%s : %s", key, formData.get(key)));
		}
		return modelAndView;
	}

}
