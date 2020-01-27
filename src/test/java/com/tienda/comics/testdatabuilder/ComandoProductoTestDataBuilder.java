package com.tienda.comics.testdatabuilder;

import com.tienda.comics.aplicacion.comando.ComandoProducto;

public class ComandoProductoTestDataBuilder {
    private static final String CODIGO_PRODUCTO = "PD002";
    private static final String NOMBRE_PRODUCTO = "VASITO DE COMISC";
    private static final double PRECIO_PRODUCTO = 1000.251;
    private static final Long CANTIDAD_PRODUCTO = Long.valueOf(1000);

    private String codigo;
    private String nombre;
    private double precio;
    private Long cantidad;

    public ComandoProductoTestDataBuilder() {
        this.codigo = CODIGO_PRODUCTO;
        this.nombre = NOMBRE_PRODUCTO;
        this.precio = PRECIO_PRODUCTO;
        this.cantidad = CANTIDAD_PRODUCTO;
    }

    public ComandoProductoTestDataBuilder conCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }


    public ComandoProductoTestDataBuilder conCantidad(Long cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    public ComandoProducto build() {
        return new ComandoProducto(this.codigo, this.nombre, this.precio, this.cantidad);
    }
}