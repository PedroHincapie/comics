package com.tienda.comics.aplicacion.manejadores.producto;

import com.tienda.comics.dominio.modelo.DtoProducto;
import com.tienda.comics.dominio.servicio.ServicioObtenerProducto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManejadorObtenerProducto {

    private final ServicioObtenerProducto servicioObtenerProducto;

    public ManejadorObtenerProducto(ServicioObtenerProducto servicioObtenerProducto) {
        this.servicioObtenerProducto = servicioObtenerProducto;
    }

    @Transactional
    public DtoProducto ejecutar(String codigo) {
        return this.servicioObtenerProducto.ejecutar(codigo);
    }
}
