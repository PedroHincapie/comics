package com.tienda.comics.aplicacion.manejadores.producto;

import com.tienda.comics.aplicacion.comando.ComandoProducto;
import com.tienda.comics.aplicacion.manejadores.fabrica.FabricaProducto;
import com.tienda.comics.dominio.Producto;
import com.tienda.comics.dominio.servicio.ServicioCrearProducto;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorCrearProducto {

    private final ServicioCrearProducto servicioCrearProducto;
    private final FabricaProducto fabricaProducto;

    public ManejadorCrearProducto(ServicioCrearProducto servicioCrearProducto, FabricaProducto fabricaProducto) {
        this.servicioCrearProducto = servicioCrearProducto;
        this.fabricaProducto = fabricaProducto;
    }

    @Transactional
    public void ejecutar(ComandoProducto comandoProducto) {
        Producto producto = this.fabricaProducto.crearProducto(comandoProducto);
        this.servicioCrearProducto.ejecutar(producto);
    }
}
