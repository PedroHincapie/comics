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

    public ProductoTestDataBuilder conCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public ProductoTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ProductoTestDataBuilder conCantidad(Long cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    public ProductoTestDataBuilder conPrecio(double precio) {
        this.precio = precio;
        return this;
    }

    public Producto build() {
        return new Producto(this.codigo, this.nombre, this.precio, this.cantidad);
    }
}