package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.controller;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao.UserDAO;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.util.ProviderConverter;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {
    private UserDAO userDAO;

    @Autowired
    public RegistrationController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("title", "Registration Page");
        model.addAttribute("user", new User());
        return "integrated:registration";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String validationForm(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors() || !user.getPassword().equals(user.getConfirmPassword())) {
            return "integrated:error";
        }
        System.out.println("---REGISTRATION CONTROLLER POST---");
        userDAO.save(user);
        return "redirect:/";
    }
}
