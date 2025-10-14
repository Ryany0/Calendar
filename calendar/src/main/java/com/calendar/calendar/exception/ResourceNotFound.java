package com.calendar.calendar.exception;

import jakarta.persistence.EntityNotFoundException;

public class ResourceNotFound extends EntityNotFoundException {
    public ResourceNotFound(String message) {
        super(message);
    }
}
