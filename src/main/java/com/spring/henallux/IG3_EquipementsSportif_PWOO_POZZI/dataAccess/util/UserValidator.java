package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.util;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao.UserDAO;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

@Component
public class UserValidator implements org.springframework.validation.Validator {
    private UserDAO userDAO;

    @Autowired
    public UserValidator(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        if (userDAO.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.formUser.username");
        }

        if (userDAO.findByMail(user.getMail()) != null) {
            errors.rejectValue("mail", "Duplicate.formUser.mail");
        }

        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "Diff.formUser.confirmPassword");
        }
    }
}
