package com.tienda.comics.dominio.excepcion;

public class ExcepcionValorNoNecesario extends RuntimeException {

	private static final long serialVersionUID = 1L;

    public ExcepcionValorNoNecesario(String message) {
        super(message);
    }
}
