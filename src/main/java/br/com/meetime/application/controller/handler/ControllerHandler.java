package br.com.meetime.application.controller.handler;

import br.com.meetime.shared.exception.model.MessageException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@RestControllerAdvice
public class ControllerHandler {

    @ExceptionHandler(WebClientResponseException.class)
    public ResponseEntity<MessageException> handlerWebClientResponseException(WebClientResponseException ex) {
        return ResponseEntity.status(ex.getStatusCode()).body(
                new MessageException(
                        ex.getMessage()
                )
        );
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<MessageException> handlerMissingRequestHeaderException(MissingRequestHeaderException ex) {
        return ResponseEntity.status(ex.getStatusCode()).body(
                new MessageException(
                        ex.getMessage()
                )
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageException> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return ResponseEntity.status(ex.getStatusCode()).body(
                new MessageException(
                        ex.getFieldError().getDefaultMessage(),
                        ex.getFieldError().getField()
                )
        );
    }
}
