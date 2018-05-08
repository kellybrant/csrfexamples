package org.example.csrf.controller;

import org.example.csrf.model.Datum;
import org.example.csrf.model.DatumValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/springformtest")
public class SpringFormTestController {

	@Autowired
	DatumValidator datumValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(datumValidator);
	}

	@GetMapping
	public String getForm(Model model) {
		model.addAttribute("data", new Datum());
		return "springformtest";
	}

	@PostMapping
	public String bindInspect(@ModelAttribute("data") @Validated Datum datum, BindingResult result, Model model) {
		if (result.hasErrors()) {
			log.info("binding has errors");
			return "error";
		}
		log.info(datum.toString());
		return "springformtest";
	}

}
