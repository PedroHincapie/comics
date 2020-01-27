package com.tienda.comics.dominio.excepcion;

public class ExcepcionNoHayCantidadProductos extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionNoHayCantidadProductos(String mensaje) {
        super(mensaje);
    }
}
