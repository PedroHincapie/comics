package com.tienda.comics.unitarias.producto;

import com.tienda.comics.dominio.excepcion.ExcepcionValorInvalido;
import com.tienda.comics.dominio.excepcion.ExcepcionValorObligatorio;
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


    @Test(expected = ExcepcionValorObligatorio.class)
    public void validarObligatoriedadCamposNombre() {
        // act - assert
        new ProductoTestDataBuilder().conNombre(null).build();
    }

    @Test(expected = ExcepcionValorObligatorio.class)
    public void validarCantidadMayorACeroCampoCantidad() {
        // act - assert
        new ProductoTestDataBuilder().conCantidad(null).build();
    }

    @Test(expected = ExcepcionValorInvalido.class)
    public void validarCantidadMenorACeroCampoCantidad() {
        // act - assert
        new ProductoTestDataBuilder().conCantidad(Long.valueOf(0)).build();
    }

    @Test(expected = ExcepcionValorInvalido.class)
    public void validarCantidadNegativaEnCampoCantidad() {
        // act - assert
        new ProductoTestDataBuilder().conCantidad(Long.valueOf(0)).build();
    }
}
