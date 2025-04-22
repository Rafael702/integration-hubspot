package br.com.meetime.application.controller.handler;

import br.com.meetime.shared.exception.model.MessageException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@RestControllerAdvice
public class ControllerHandler {

    @ExceptionHandler(WebClientResponseException.class)
    public ResponseEntity<?> handlerWebClientResponseException(WebClientResponseException ex) {
        return ResponseEntity.status(ex.getStatusCode()).body(
                new MessageException(
                    ex.getMessage()
                )
        );
    }
}
