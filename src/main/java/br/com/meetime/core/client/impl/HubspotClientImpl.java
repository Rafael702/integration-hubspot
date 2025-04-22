package br.com.meetime.core.client.impl;

import br.com.meetime.core.client.HubspotClient;
import br.com.meetime.core.dto.response.HubspotTokenResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class HubspotClientImpl implements HubspotClient {

    @Value("${hub-api.base-url}")
    private String baseurl;

    @Override
    public HubspotTokenResponse retrieveToken(MultiValueMap<String, String> request) {
        String path = baseurl + "/oauth/v1/token";

        return WebClient.create().post()
                .uri(path)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(HubspotTokenResponse.class)
                .block();
    }
}
