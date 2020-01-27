package com.tienda.comics.aplicacion.comando;


public class ComandoProducto {
    private String codigo;
    private String nombre;
    private double precio;
    private Long cantidad;

    public ComandoProducto(String codigo, String nombre, double precio, Long cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public Long getCantidad() {
        return cantidad;
    }
}

