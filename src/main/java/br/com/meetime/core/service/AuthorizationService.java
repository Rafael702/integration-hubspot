package br.com.meetime.core.service;

import br.com.meetime.core.dto.AuthorizationUrlResponse;

import java.net.MalformedURLException;

public interface AuthorizationService {
    AuthorizationUrlResponse generateAuthorizationUrl() throws MalformedURLException;
}
