package com.mcommerce.zuulserver.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ResponseFilter extends ZuulFilter {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public String filterType() {
        return "post";  //pre : la requête sera filter au moment d'arriver sur Zuul
    }                   // post sera executer dans le sens contraire

    @Override
    public int filterOrder() {
        return 2; //si on a plusieurs filtres, on définit dans quel ordre ce filtree sera executé
    }

    @Override
    public boolean shouldFilter() {
        return true;//pour indiquer si ce filtre doit s'executer ou pas??
    }

    @Override
    public Object run() throws ZuulException {
        // ici la logique du filtre
        HttpServletResponse response = RequestContext.getCurrentContext().getResponse();

        response.setStatus(200); //Ce filtre récupère toutes les réponses et change le code en 200.
                                //Si on change le code en 400 On a va avoir une erreur côté client
        log.info(" CODE HTTP {} ", response.getStatus());


        return null;
    }
}
