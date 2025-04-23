package br.com.meetime.application.controller;

import br.com.meetime.application.controller.request.ContactCreateRequest;
import br.com.meetime.core.service.ContactService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/v1/contacts")
public class ContactController {

    private final ContactService service;

    public ContactController(ContactService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> createContact(
            @RequestBody @Valid ContactCreateRequest request,
            @RequestHeader("Authorization") @Valid String authentication
    ) throws JsonProcessingException {
        service.createContact(authentication, request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
