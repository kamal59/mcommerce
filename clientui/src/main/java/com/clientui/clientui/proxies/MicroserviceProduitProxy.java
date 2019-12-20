package com.clientui.clientui.proxies;

import com.clientui.clientui.beans.ProductBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

//@FeignClient(name= "microservice-produits") >> Sans zuul
@FeignClient(name= "zuul-server")
@RibbonClient(name = "microservice-produits")
public interface MicroserviceProduitProxy {
    //@GetMapping(value = "/Produits") >> sans zuul
    @GetMapping(value = "/microservice-produits/Produits")
    List<ProductBean> listeDesProduits();

    @GetMapping( value = "/microservice-produits/Produits/{id}")
    ProductBean recupererUnProduit(@PathVariable("id") int id);
}
