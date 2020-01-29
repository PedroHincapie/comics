package com.tienda.comics.dominio.servicio;

import com.tienda.comics.dominio.modelo.DtoProducto;
import com.tienda.comics.dominio.repositorio.RepositorioProducto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioListarProducto {

    private RepositorioProducto repositorioProducto;

    public ServicioListarProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public List<DtoProducto> ejecutar() {
        return this.repositorioProducto.listar();
    }
}
