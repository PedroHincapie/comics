package com.tienda.comics.aplicacion.manejadores.producto;

import com.tienda.comics.dominio.modelo.DtoProducto;
import com.tienda.comics.dominio.servicio.ServicioListarProducto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ManejadorListarProducto {

    private final ServicioListarProducto servicioListarProducto;

    public ManejadorListarProducto(ServicioListarProducto servicioListarProducto) {
        this.servicioListarProducto = servicioListarProducto;
    }

    @Transactional
    public List<DtoProducto> ejecutar() {
        return this.servicioListarProducto.ejecutar();
    }
}
