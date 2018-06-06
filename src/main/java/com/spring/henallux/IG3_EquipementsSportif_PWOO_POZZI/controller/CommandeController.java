package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.controller;

import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.Constants;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao.PanierModelDAO;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao.UserDAO;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.UserEntity;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.Panier;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.PanierModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Controller
@RequestMapping(value = "/commande")
@SessionAttributes({Constants.PANIER})
public class CommandeController {
    private UserDAO userDAO;
    private PanierModelDAO panierModelDAO;

    @Autowired
    public CommandeController(UserDAO userDAO, PanierModelDAO panierModelDAO) {
        this.userDAO = userDAO;
        this.panierModelDAO = panierModelDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, @ModelAttribute(Constants.PANIER) Panier panier, Principal principal) {
        UserEntity userEntity = userDAO.findByUsername(principal.getName());
        PanierModel panierModel = new PanierModel();
        Calendar calendar = new GregorianCalendar();
        panierModel.setDate(calendar.getTime());
        panierModel.setNumTicket(null);
        panierModel.setUsername_fk(principal.getName());
        panierModelDAO.savePanier(panierModel, userEntity);

        return "integrated:commande";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String validationAchat(Model model) {
        return "";
    }
}
