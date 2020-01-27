package com.tienda.comics.dominio.servicio;

import com.tienda.comics.dominio.modelo.DtoProducto;
import com.tienda.comics.dominio.repositorio.RepositorioProducto;
import org.springframework.stereotype.Component;

@Component
public class ServicioObtenerProducto {

    private RepositorioProducto repositorioProducto;

    public ServicioObtenerProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public DtoProducto ejecutar(String codigo) {
        return this.repositorioProducto.obtenerPorCodigo(codigo);
    }
}
