package com.tienda.comics.dominio.servicio;


import com.tienda.comics.dominio.Producto;
import com.tienda.comics.dominio.repositorio.RepositorioProducto;
import org.springframework.stereotype.Component;

@Component
public class ServicioAgregarCantidadProducto {

    private RepositorioProducto repositorioProducto;

    public ServicioAgregarCantidadProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public void ejecutar(Producto producto) {
        this.repositorioProducto.agregarCantidad(producto);
    }
}
