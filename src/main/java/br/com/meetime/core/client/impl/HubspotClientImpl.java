package br.com.meetime.core.client.impl;

import br.com.meetime.core.client.HubspotClient;
import br.com.meetime.core.dto.request.HubspotContactRequest;
import br.com.meetime.core.dto.response.HubspotTokenResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Objects;

@Component
public class HubspotClientImpl implements HubspotClient {

    @Qualifier("hubspot-api")
    private final WebClient webClient;

    private final ObjectMapper jsonMapper;

    public HubspotClientImpl(WebClient webClient, ObjectMapper jsonMapper) {
        this.webClient = webClient;
        this.jsonMapper = jsonMapper;
    }

    @Override
    public HubspotTokenResponse retrieveToken(MultiValueMap<String, String> request) {
        String path = "/oauth/v1/token";

        return webClient.post()
                .uri(path)
                .bodyValue(request)
                .retrieve()
                .onStatus(HttpStatusCode::isError, ClientResponse::createException)
                .bodyToMono(HubspotTokenResponse.class)
                .block();
    }

    @Override
    public void createContact(HubspotContactRequest request) throws JsonProcessingException {
        String path = "/crm/v3/objects/contacts";

        webClient.post()
                .uri(path)
                .header("Authorization", request.getAuthorization())
                .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .bodyValue(jsonMapper.writeValueAsString(request.getBody()))
                .retrieve()
                .onStatus(HttpStatusCode::isError, ClientResponse::createException)
                .bodyToMono(String.class)
                .block();
    }
}
