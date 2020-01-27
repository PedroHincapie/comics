package com.tienda.comics.dominio.servicio;


import com.tienda.comics.dominio.Producto;
import com.tienda.comics.dominio.excepcion.ExcepcionNoHayCantidadProductos;
import com.tienda.comics.dominio.repositorio.RepositorioProducto;
import org.springframework.stereotype.Component;

@Component
public class ServicioRestarCantidadProducto {
    private static final String NO_HAY_CANTIDAD_A_LA_VENTA = "Lo sentimos no contamos con esa cantidad en el momento";

    private RepositorioProducto repositorioProducto;

    public ServicioRestarCantidadProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public void ejecutar(Producto producto, Long cantidadBaseProducto) {
        if (validarUnidadesAntesVenta(producto, cantidadBaseProducto)) {
            throw new ExcepcionNoHayCantidadProductos(NO_HAY_CANTIDAD_A_LA_VENTA);
        }
        Long saldo = obtenerSaldo(producto, cantidadBaseProducto);

        this.repositorioProducto.restarCantidad(producto, saldo);
    }

    private boolean validarUnidadesAntesVenta(Producto producto, Long cantidadBaseProducto) {
        return producto.getCantidad() > cantidadBaseProducto;
    }

    private Long obtenerSaldo(Producto producto, Long cantidadBaseProducto) {
        return cantidadBaseProducto - producto.getCantidad();
    }
}
