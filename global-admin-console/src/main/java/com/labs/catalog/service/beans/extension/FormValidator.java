package com.labs.catalog.service.beans.extension;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.labs.catalog.service.model.Form;

public class FormValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(Form.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Form form = (Form)target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "form.username.isEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "form.firstName.isEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "form.lastName.isEmpty");
        if(form.getUsername().length() > 8){
            errors.rejectValue("username", "form.username.maxLengthExceeded", new Object[]{8},null);
        }
    }

}
