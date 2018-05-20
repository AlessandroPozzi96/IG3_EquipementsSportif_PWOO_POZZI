package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller(value = "/error")
public class ErrorController {
    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        return "integrated:error";
    }
}
