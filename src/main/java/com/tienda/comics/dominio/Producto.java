package com.tienda.comics.dominio;

import static com.tienda.comics.dominio.ValidadorArgumento.validarObligatorio;
import static com.tienda.comics.dominio.ValidadorArgumento.validarPositivo;

public class Producto {

    private static final String SE_DEBE_INGRESAR_EL_CODIGO_PRODUCTO = "Se debe ingresar Codigo del producto";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_PRODUCTO = "Se debe ingresar el nombre del producto";
    private static final String SE_DEBE_INGRESAR_EL_PRECIO_DEL_PRODUCTO = "Se debe ingresar el precio del producto";
    private static final String SE_DEBE_INGRESAR_LA_CANTIDAD_DE_PRODUCTOS = "Se debe ingresar la cantidad de productos";
    private static final String SE_DEBE_INGRESAR_UNA_CANTIDAD_MAYOR_A_CERO = "Se debe ingresar un cantidad superior a 0";
    private static final String SE_DEBE_INGRESAR_EL_PRECIO_SUPERIOR_A_CERO = "Se debe ingresar un precio superior a 0";


    private String codigo;
    private String nombre;
    private double precio;
    private Long cantidad;

    public Producto(String codigo, String nombre, double precio, Long cantidad) {
        validarObligatorio(codigo, SE_DEBE_INGRESAR_EL_CODIGO_PRODUCTO);
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_PRODUCTO);
        validarObligatorio(precio, SE_DEBE_INGRESAR_EL_PRECIO_DEL_PRODUCTO);
        validarObligatorio(cantidad, SE_DEBE_INGRESAR_LA_CANTIDAD_DE_PRODUCTOS);
        validarPositivo(cantidad, SE_DEBE_INGRESAR_UNA_CANTIDAD_MAYOR_A_CERO);
        validarPositivo(precio, SE_DEBE_INGRESAR_EL_PRECIO_SUPERIOR_A_CERO);

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
