package com.task.manager.validator;

import com.task.manager.models.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import org.springframework.validation.Validator;

@Component
public class user_validator implements Validator {

    @Override
    public boolean supports(Class<?> cla$$) {
        return User.class.equals(cla$$);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User u = (User) target;
        if (!u.getPasswordConfirmation().equals(u.getPassword())) {
            errors.rejectValue("passwordConfirmation", "Match");
        }
    }
}