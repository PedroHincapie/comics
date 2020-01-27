package com.tienda.comics.dominio.servicio;


import com.tienda.comics.dominio.Producto;
import com.tienda.comics.dominio.repositorio.RepositorioProducto;
import org.springframework.stereotype.Component;

@Component
public class ServicioCrearProducto {

    private RepositorioProducto repositorioProducto;

    public ServicioCrearProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public void ejecutar(Producto producto) {
        this.repositorioProducto.agregar(producto);
    }
}
