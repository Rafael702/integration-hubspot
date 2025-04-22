package br.com.meetime.core.service;

import br.com.meetime.application.controller.request.ContactCreateRequest;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface ContactService {
    void createContact(String authentication,ContactCreateRequest request) throws JsonProcessingException;
}
