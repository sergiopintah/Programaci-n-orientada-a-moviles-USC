package com.usc.crud.service;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String mensaje) {

        super(mensaje);

    }
}
