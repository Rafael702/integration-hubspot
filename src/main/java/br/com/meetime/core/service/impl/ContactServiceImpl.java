package br.com.meetime.core.service.impl;

import br.com.meetime.application.controller.request.ContactCreateRequest;
import br.com.meetime.core.client.HubspotClient;
import br.com.meetime.core.dto.request.HubspotContactRequest;
import br.com.meetime.core.service.ContactService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;

@Component
public class ContactServiceImpl implements ContactService {

    private final HubspotClient client;

    public ContactServiceImpl(HubspotClient client) {
        this.client = client;
    }

    @Override
    public void createContact(String authentication, ContactCreateRequest request) throws JsonProcessingException {
        HubspotContactRequest contactRequest = new HubspotContactRequest(
                authentication,
                new HubspotContactRequest.ContactRequest(
                        new HubspotContactRequest.Property(
                                request.getName(),
                                request.getPhone(),
                                request.getEmail()
                        )
                )
        );

        client.createContact(contactRequest);
    }
}
