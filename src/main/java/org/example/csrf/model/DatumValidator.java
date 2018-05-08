package org.example.csrf.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class DatumValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Datum.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// Everyone gets a PASS today!
	}

}
