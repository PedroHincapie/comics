package com.tienda.comics.dominio.excepcion;

public class ExcepcionValorVacio extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionValorVacio(String message) {
        super(message);
    }
}
