package com.clientui.clientui.controller;

import com.clientui.clientui.beans.ProductBean;
import com.clientui.clientui.proxies.MicroserviceProduitProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ClientController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MicroserviceProduitProxy microserviceProduitProxy;
    @RequestMapping("/")
    public String accueil(Model model){
        log.info("Envoie de la requête au microservice-produits");
        List<ProductBean> produits = microserviceProduitProxy.listeDesProduits();
        model.addAttribute("produits", produits);
        return "Accueil";
    }
}
