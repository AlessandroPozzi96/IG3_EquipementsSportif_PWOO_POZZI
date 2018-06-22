package com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.controller;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.Constants;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.buisness.Promotion;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.configuration.PaypalPaymentIntent;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.configuration.PaypalPaymentMethod;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao.ElementsPanierDAO;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao.PanierModelDAO;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.dao.UserDAO;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.entity.UserEntity;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.dataAccess.repository.ElementsPanierRepository;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.Article;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.ElementsPanier;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.Panier;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.model.PanierModel;
import com.spring.henallux.IG3_EquipementsSportif_PWOO_POZZI.service.PaypalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;

@Controller
@RequestMapping(value = "/commande")
@SessionAttributes({Constants.PANIER})
public class CommandeController {
    private UserDAO userDAO;
    private PanierModelDAO panierModelDAO;
    private Promotion promotion;
    private Logger log = LoggerFactory.getLogger(getClass());
    private PaypalService paypalService;
    private ElementsPanierDAO elementsPanierDAO;

    public static final String PAYPAL_SUCCESS_URL = "/pay/success";
    public static final String PAYPAL_CANCEL_URL = "/pay/cancel";

    @Autowired
    public CommandeController(UserDAO userDAO, PanierModelDAO panierModelDAO, PaypalService paypalService, ElementsPanierDAO elementsPanierDAO) {
        this.elementsPanierDAO = elementsPanierDAO;
        this.paypalService = paypalService;
        this.userDAO = userDAO;
        this.panierModelDAO = panierModelDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, @ModelAttribute(Constants.PANIER) Panier panier, Principal principal) {

        //On passe la méthode de calcul de promotion dans le model
        promotion = new Promotion();
        model.addAttribute("promotion", promotion);

        return "integrated:commande";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/pay")
    public String validationAchat(@ModelAttribute(Constants.PANIER) Panier panier) {
        String cancelUrl = "http://localhost:8082/equipementsSportif/commande" + PAYPAL_CANCEL_URL;
        String successUrl = "http://localhost:8082/equipementsSportif/commande" + PAYPAL_SUCCESS_URL;
        try {
            Payment payment = paypalService.createPayment(
                    promotion.calculPromotion(panier),
                    "EUR",
                    PaypalPaymentMethod.paypal,
                    PaypalPaymentIntent.sale,
                    "Paiement via SandBox PayPal.",
                    cancelUrl,
                    successUrl);
            for(Links links : payment.getLinks()){
                if(links.getRel().equals("approval_url")){
                    return "redirect:" + links.getHref();
                }
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        return "redirect:/commande";
    }

    @RequestMapping(method = RequestMethod.GET, value = PAYPAL_CANCEL_URL)
    public String cancelPay(){
        return "integrated:error";
    }

    @RequestMapping(method = RequestMethod.GET, value = PAYPAL_SUCCESS_URL)
    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId, @ModelAttribute(Constants.PANIER) Panier panier, Principal principal){
        try {
            Payment payment = paypalService.executePayment(paymentId, payerId);
            if(payment.getState().equals("approved")){
                //On insert les informations de paiement dans la db avant de supprimer le panier
                //Ajout dans la table Panier
                UserEntity userEntity = userDAO.findByUsername(principal.getName());
                PanierModel panierModel = new PanierModel();
                Calendar calendar = new GregorianCalendar();
                panierModel.setDate(calendar.getTime());
                panierModel.setNumTicket(null);
                panierModel.setUsername_fk(principal.getName());
                panierModelDAO.savePanier(panierModel, userEntity);

                //Ajout de tous les articles dans la table ElementsPanier
                ElementsPanier elementsPanier = new ElementsPanier();
                for (Map.Entry<Article, Integer> panierEntry : panier.getPanierHashMap().entrySet()) {
                    elementsPanier.setQuantite(panierEntry.getValue());
                    elementsPanier.setPrixReel(panierEntry.getKey().getPrixUnitaire());
                    //Il faut obtenir le numéro de ticket le plus récent
                    elementsPanier.setNumTicket_fk(2);
                    elementsPanier.setCodeBarre_fk(panierEntry.getKey().getCodeBarre());
                    elementsPanierDAO.saveElementsPanier(elementsPanier);
                }
                //On vide le panier
                panier.viderPanier();
                System.out.println("Payement réussi !!!");
                return "integrated:home";
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        System.out.println("Payement échoué !");
        return "redirect:/commande";
    }
}
