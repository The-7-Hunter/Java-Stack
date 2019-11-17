package com.example.demo.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.demo.models.user;

@Component
public class user_validator implements Validator {

	@Override
	public boolean supports(Class<?> cla$$) {
		return user.class.equals(cla$$);
	}

	@Override
	public void validate(Object target, Errors errors) {
		user u = (user) target;
		if (!u.getPasswordConfirmation().equals(u.getPassword())) {
			errors.rejectValue("passwordConfirmation", "Match");
		}
	}
}