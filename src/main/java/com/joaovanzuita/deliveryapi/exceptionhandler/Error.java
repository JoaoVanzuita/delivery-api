package com.joaovanzuita.deliveryapi.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

public class Error {

    private Integer status;
    private LocalDateTime localDateTime;
    private String title;
    private List<Errors> errors;

    public List<Errors> getErrors() {
        return errors;
    }

    public void setErrors(List<Errors> errors) {
        this.errors = errors;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
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
