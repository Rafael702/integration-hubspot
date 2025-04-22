package br.com.meetime.application.controller;

import br.com.meetime.core.dto.response.AuthorizationTokenResponse;
import br.com.meetime.core.dto.response.AuthorizationUrlResponse;
import br.com.meetime.core.service.AuthorizationService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;

@RestController
@RequestMapping("/v1")
public class AuthorizationController {

    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorization")
    public ResponseEntity<AuthorizationUrlResponse> retrieveAuthorizationUrl() throws MalformedURLException {
        return ResponseEntity.ok(service.generateAuthorizationUrl());
    }

    @GetMapping("/oauth-callback")
    public ResponseEntity<AuthorizationTokenResponse> retrieveTokenAccess(@RequestParam String code) {
        return ResponseEntity.ok().body(service.getToken(code));
    }
}
