package com.tienda.comics.aplicacion.manejadores.fabrica;

import com.tienda.comics.aplicacion.comando.ComandoProducto;
import com.tienda.comics.dominio.Producto;
import org.springframework.stereotype.Component;

@Component
public class FabricaProducto {
    public Producto crearProducto(ComandoProducto comandoProducto) {
        return new Producto(comandoProducto.getCodigo(), comandoProducto.getNombre(), comandoProducto.getPrecio(), comandoProducto.getCantidad());
    }
}
