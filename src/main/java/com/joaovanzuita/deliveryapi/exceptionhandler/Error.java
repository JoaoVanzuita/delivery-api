package com.joaovanzuita.deliveryapi.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Error {

    private Integer status;
    private OffsetDateTime dateTime;
    private String title;
    private List<Errors> errors;

    public List<Errors> getErrors() {
        return errors;
    }

    public void setErrors(List<Errors> errors) {
        this.errors = errors;
    }

    public OffsetDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(OffsetDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static class Errors{
        private String tittle;
        private String message;

        public Errors(String tittle, String message) {
            this.tittle = tittle;
            this.message = message;
        }

        public String getName() {
            return tittle;
        }

        public String getMessage() {
            return message;
        }
    }
}
