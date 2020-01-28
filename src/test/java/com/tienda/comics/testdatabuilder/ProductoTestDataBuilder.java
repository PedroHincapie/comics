package com.tienda.comics.testdatabuilder;

import com.tienda.comics.dominio.Producto;

public class ProductoTestDataBuilder {

    private static final String CODIGO_PRODUCTO = "PD002";
    private static final String NOMBRE_PRODUCTO = "VASITO DE COMISC";
    private static final double PRECIO_PRODUCTO = 1000.251;
    private static final Long CANTIDAD_PRODUCTO = Long.valueOf(1000);

    private String codigo;
    private String nombre;
    private double precio;
    private Long cantidad;

    public ProductoTestDataBuilder() {
        this.codigo = CODIGO_PRODUCTO;
        this.nombre = NOMBRE_PRODUCTO;
        this.precio = PRECIO_PRODUCTO;
        this.cantidad = CANTIDAD_PRODUCTO;
    }

    public Producto build() {
        return new Producto(this.codigo, this.nombre, this.precio, this.cantidad);
    }


}
