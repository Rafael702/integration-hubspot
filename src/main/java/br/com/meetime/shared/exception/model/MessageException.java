package br.com.meetime.shared.exception.model;

import java.time.LocalDateTime;

public class MessageException {
    private String message;
    private LocalDateTime timestamp = LocalDateTime.now();

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
