package com.example.Blog.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.Id;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceException extends RuntimeException {
    private String fieldName;
    private String resourceName;
    private Object fieldValue;

    public ResourceException(String fieldName, String resourceName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.fieldName = fieldName;
        this.resourceName = resourceName;
        this.fieldValue = fieldValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getResourceName() {
        return resourceName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
