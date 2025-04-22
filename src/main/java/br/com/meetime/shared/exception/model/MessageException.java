package br.com.meetime.shared.exception.model;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class MessageException {
    private String message;
    private LocalDateTime timestamp = LocalDateTime.now(ZoneOffset.UTC);

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
}
