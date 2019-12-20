package com.mcommerce.zuulserver.configurations;

import brave.sampler.Sampler;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SleuthConfig {

    public Sampler defaultSampler(){
        return Sampler.ALWAYS_SAMPLE; // indique au sleuth d'envoyer toutes les requêtes à Zipkin, afin que celui-ci puisse les analyser
    }
}
