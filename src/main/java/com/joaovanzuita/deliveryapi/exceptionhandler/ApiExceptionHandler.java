package com.joaovanzuita.deliveryapi.exceptionhandler;

import com.joaovanzuita.deliveryapi.domain.DomainException;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private MessageSource messageSource;

    public ApiExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<Error.Errors> values = new ArrayList<>();

        for (ObjectError error: ex.getBindingResult().getAllErrors()
             ) {
            String tittle = ((FieldError) error).getField();
            String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());

            values.add(new Error.Errors(tittle, message));
        }

        Error error = new Error();
        error.setStatus(status.value());
        error.setDateTime(OffsetDateTime.now());
        error.setTitle("Invalid inputs");
        error.setErrors(values);

        return handleExceptionInternal(ex, error, headers, status, request);
    }

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<Object> handleDomainException(DomainException ex, WebRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;

        Error error = new Error();
        error.setStatus(status.value());
        error.setDateTime(OffsetDateTime.now());
        error.setTitle(ex.getMessage());

        return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
    }
}
