package br.com.meetime.core.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

public class HubspotContactRequest {
    private String authorization;
    private ContactRequest body;

    public HubspotContactRequest(String authorization, ContactRequest body) {
        this.authorization = authorization;
        this.body = body;
    }

    public String getAuthorization() {
        return authorization;
    }

    public ContactRequest getBody() {
        return body;
    }

    public void setBody(ContactRequest body) {
        this.body = body;
    }

    public static class ContactRequest {
        private Property properties;

        public ContactRequest(Property properties) {
            this.properties = properties;
        }

        public Property getProperties() {
            return properties;
        }

        public void setProperties(Property properties) {
            this.properties = properties;
        }
    }

    @JsonNaming(PropertyNamingStrategies.LowerCaseStrategy.class)
    public static class Property {
        private String firstName;
        private String phone;
        private String email;

        public Property(String firstName, String phone, String email) {
            this.firstName = firstName;
            this.phone = phone;
            this.email = email;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
