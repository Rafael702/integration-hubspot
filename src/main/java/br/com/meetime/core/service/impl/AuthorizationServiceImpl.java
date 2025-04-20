package br.com.meetime.core.service.impl;

import br.com.meetime.core.dto.AuthorizationUrlResponse;
import br.com.meetime.core.dto.HubspotDto;
import br.com.meetime.core.service.AuthorizationService;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    private final HubspotDto hubspotDto;

    public AuthorizationServiceImpl(HubspotDto hubspotDto){
        this.hubspotDto = hubspotDto;
    }

    public AuthorizationUrlResponse generateAuthorizationUrl() throws MalformedURLException {
        URL url = new URL(hubspotDto.getUrl() +
                "?client_id=" + hubspotDto.getClientId() +
                "&scope=" + hubspotDto.getScope() +
                "&redirect_uri=" + hubspotDto.getRedirectUri());
        return new AuthorizationUrlResponse(url);
    }
}
