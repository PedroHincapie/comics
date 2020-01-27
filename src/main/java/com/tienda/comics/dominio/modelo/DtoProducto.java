package com.tienda.comics.dominio.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoProducto {

    private String codigo;
    private String nombre;
    private double precio;
    private Long cantidad;
}
