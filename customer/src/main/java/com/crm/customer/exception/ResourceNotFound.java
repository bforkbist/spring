package com.crm.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException {
    private String Name;
    private String fieldName;
    private long fieldValue;

    public ResourceNotFound(String name, String fieldName, long fieldValue) {
        super(String.format("%s not found in table %s of id %l",fieldName,name,fieldValue));
        Name = name;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getName() {
        return Name;
    }

    public String getFieldName() {
        return fieldName;
    }

    public long getFieldValue() {
        return fieldValue;
    }
}
