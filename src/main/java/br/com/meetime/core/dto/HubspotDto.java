package br.com.meetime.core.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("hubspot")
public class HubspotDto {
    private String clientId;
    private String clientSecret;
    private String scopes;
    private String redirectUri;
    private String url;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getScopes() {
        return scopes;
    }

    public void setScopes(String scopes) {
        this.scopes = scopes;
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
                .append("scopes: ")
                .append(getScopes())
                .append("redirectUrl: ")
                .append(getRedirectUri())
                .append("url: ")
                .append(getUrl())
                .append(" }")
                .toString();
    }
}
