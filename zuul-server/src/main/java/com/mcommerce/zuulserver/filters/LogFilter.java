package com.mcommerce.zuulserver.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LogFilter extends ZuulFilter {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public String filterType() {
        return "pre";  //pre : la requête sera filter au moment d'arriver sur Zuul
    }                   // post sera executer dans le sens contraire

    @Override
    public int filterOrder() {
        return 1; //si on a plusieurs filtres, on définit dans quel ordre ce filtree sera executé
    }

    @Override
    public boolean shouldFilter() {
        return true;//pour indiquer si ce filtre doit s'executer ou pas??
    }

    @Override
    public Object run() throws ZuulException {
        // ici la logique du filtre
        HttpServletRequest req = RequestContext.getCurrentContext().getRequest();
        log.info("******** Requête interceptée " +req.getRequestURL());
        return null;
    }
}
