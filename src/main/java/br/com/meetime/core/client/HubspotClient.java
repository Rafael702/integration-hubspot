package br.com.meetime.core.client;

import br.com.meetime.core.dto.response.HubspotTokenResponse;
import org.springframework.util.MultiValueMap;

public interface HubspotClient {
    HubspotTokenResponse retrieveToken(MultiValueMap<String, String> request);
}
