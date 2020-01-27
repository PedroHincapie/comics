package com.tienda.comics.aplicacion.manejadores.producto;

import com.tienda.comics.aplicacion.comando.ComandoProducto;
import com.tienda.comics.aplicacion.manejadores.fabrica.FabricaProducto;
import com.tienda.comics.dominio.Producto;
import com.tienda.comics.dominio.servicio.ServicioAgregarCantidadProducto;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorAgregarCantidadProducto {

    private final ServicioAgregarCantidadProducto servicioAgregarCantidadProducto;
    private final FabricaProducto fabricaProducto;

    public ManejadorAgregarCantidadProducto(ServicioAgregarCantidadProducto servicioAgregarCantidadProducto, FabricaProducto fabricaProducto) {
        this.servicioAgregarCantidadProducto = servicioAgregarCantidadProducto;
        this.fabricaProducto = fabricaProducto;
    }

    @Transactional
    public void ejecutar(ComandoProducto comandoProducto) {
        Producto producto = this.fabricaProducto.crearProducto(comandoProducto);
        this.servicioAgregarCantidadProducto.ejecutar(producto);
    }
}
