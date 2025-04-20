package br.com.meetime.core.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("hubspot")
public class HubspotDto {
    private String clientId;
    private String scope;
    private String redirectUri;
    private String url;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("HubspotDto: {" + "clientId: ")
                .append(getClientId())
                .append("scope: ")
                .append(getScope())
                .append("redirectUrl: ")
                .append(getRedirectUri())
                .append("url: ")
                .append(getUrl())
                .append(" }")
                .toString();
    }
}
