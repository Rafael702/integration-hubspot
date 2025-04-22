package br.com.meetime.core.service;

import br.com.meetime.core.dto.response.AuthorizationTokenResponse;
import br.com.meetime.core.dto.response.AuthorizationUrlResponse;

import java.net.MalformedURLException;

public interface AuthorizationService {
    AuthorizationUrlResponse generateAuthorizationUrl() throws MalformedURLException;
    AuthorizationTokenResponse getToken(String code);
}
