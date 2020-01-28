package com.tienda.comics.unitarias.producto;

import com.tienda.comics.dominio.Producto;
import com.tienda.comics.dominio.excepcion.ExcepcionNoHayCantidadProductos;
import com.tienda.comics.dominio.servicio.ServicioRestarCantidadProducto;
import com.tienda.comics.testdatabuilder.ProductoTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class ProductoBuildTest {

    @InjectMocks
    private ServicioRestarCantidadProducto servicioRestarCantidadProducto;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test(expected = ExcepcionNoHayCantidadProductos.class)
    public void validarUnidadesAntesVenta() {
        // arrange
        Producto producto = new ProductoTestDataBuilder().build();
        Long cantidadBaseProducto = Long.valueOf(50);

        // act - assert
        servicioRestarCantidadProducto.ejecutar(producto, cantidadBaseProducto);
    }
}
