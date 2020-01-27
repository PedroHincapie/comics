package com.tienda.comics.aplicacion.manejadores.producto;

import com.tienda.comics.aplicacion.comando.ComandoProducto;
import com.tienda.comics.aplicacion.manejadores.fabrica.FabricaProducto;
import com.tienda.comics.dominio.Producto;
import com.tienda.comics.dominio.servicio.ServicioObtenerProducto;
import com.tienda.comics.dominio.servicio.ServicioRestarCantidadProducto;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorRestarCantidadProducto {

    private final ServicioRestarCantidadProducto servicioRestarCantidadProducto;
    private final FabricaProducto fabricaProducto;
    private final ServicioObtenerProducto servicioObtenerProducto;

    public ManejadorRestarCantidadProducto(ServicioRestarCantidadProducto servicioAgregarCantidadProducto, FabricaProducto fabricaProducto, ServicioObtenerProducto servicioObtenerProducto) {
        this.servicioRestarCantidadProducto = servicioAgregarCantidadProducto;
        this.fabricaProducto = fabricaProducto;
        this.servicioObtenerProducto = servicioObtenerProducto;
    }

    @Transactional
    public void ejecutar(ComandoProducto comandoProducto) {
        Producto producto = this.fabricaProducto.crearProducto(comandoProducto);
        Long cantidadBaseProducto = this.servicioObtenerProducto.ejecutar(producto.getCodigo()).getCantidad();
        this.servicioRestarCantidadProducto.ejecutar(producto, cantidadBaseProducto);
    }
}
