package br.com.meetime.core.service.impl;

import br.com.meetime.core.client.HubspotClient;
import br.com.meetime.core.dto.response.AuthorizationTokenResponse;
import br.com.meetime.core.dto.response.AuthorizationUrlResponse;
import br.com.meetime.core.dto.HubspotDto;
import br.com.meetime.core.service.AuthorizationService;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.MalformedURLException;
import java.net.URL;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    private final HubspotDto hubspotDto;
    private final HubspotClient client;

    public AuthorizationServiceImpl(HubspotDto hubspotDto, HubspotClient client) {
        this.hubspotDto = hubspotDto;
        this.client = client;
    }

    @Override
    public AuthorizationUrlResponse generateAuthorizationUrl() throws MalformedURLException {
        URL url = new URL(hubspotDto.getUrl() +
                "?client_id=" + hubspotDto.getClientId() +
                "&scope=" + hubspotDto.getScopes() +
                "&redirect_uri=" + hubspotDto.getRedirectUri());
        return new AuthorizationUrlResponse(url);
    }

    @Override
    public AuthorizationTokenResponse getToken(String code) {
        MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
        request.add("grant_type", "authorization_code");
        request.add("client_id", hubspotDto.getClientId());
        request.add("client_secret", hubspotDto.getClientSecret());
        request.add("redirect_uri", hubspotDto.getRedirectUri());
        request.add("code", code);

        return new AuthorizationTokenResponse(client.retrieveToken(request).getAccessToken());
    }
}
