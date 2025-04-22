package br.com.meetime.core.dto.response;

public class AuthorizationTokenResponse {
    private String token;

    public AuthorizationTokenResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
