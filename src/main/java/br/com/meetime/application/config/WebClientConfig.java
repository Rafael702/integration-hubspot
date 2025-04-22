package br.com.meetime.application.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Value("${hub-api.base-url}")
    private String baseurlHubspot;

    @Bean("hubspot-api")
    public WebClient webClient(){
        return WebClient.create(baseurlHubspot);
    }
}
