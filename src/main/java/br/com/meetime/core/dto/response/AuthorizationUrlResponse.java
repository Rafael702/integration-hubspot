package br.com.meetime.core.dto.response;

import java.net.URL;

public class AuthorizationUrlResponse {
    private final URL url;

    public AuthorizationUrlResponse(URL url) {
        this.url = url;
    }

    public URL getUrl(){
        return this.url;
    }
}
