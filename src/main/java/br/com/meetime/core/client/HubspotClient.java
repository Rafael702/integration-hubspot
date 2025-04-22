package br.com.meetime.core.client;

import br.com.meetime.core.dto.request.HubspotContactRequest;
import br.com.meetime.core.dto.response.HubspotTokenResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.util.MultiValueMap;

public interface HubspotClient {
    HubspotTokenResponse retrieveToken(MultiValueMap<String, String> request);
    void createContact(HubspotContactRequest request) throws JsonProcessingException;
}
