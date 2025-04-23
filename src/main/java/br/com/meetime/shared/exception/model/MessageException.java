package br.com.meetime.shared.exception.model;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class MessageException {
    private String message;
    private String field;
    private final LocalDateTime timestamp = LocalDateTime.now(ZoneOffset.UTC);

    public MessageException(String message, String field) {
        this.message = message;
        this.field = field;
    }

    public MessageException(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getField() {
        return field;
    }
}
