package com.tienda.comics.controllador;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tienda.comics.ApplicationMock;
import com.tienda.comics.aplicacion.comando.ComandoProducto;
import com.tienda.comics.infraestructura.controllador.ControladorProducto;
import com.tienda.comics.testdatabuilder.ComandoProductoTestDataBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ControladorProducto.class)
public class ComandoControladorProductoTest {

    private static final String CODIGO_PRODUCTO_NUMERO_PD001 = "PD001";
    private static final Long CANTIDAD_PRODUCTO_NUMERO_500 = Long.valueOf(500);
    private static final Long CANTIDAD_PRODUCTO_NUMERO_4 = Long.valueOf(4);
    private static final Long CANTIDAD_RESULTANTE_OPERACION = Long.valueOf(496);
    private static final String CODIGO_PRODUCTO_NUMERO_PD008 = "PD008";

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void buscarProductoPorCodigo() throws Exception {
        // act - assert
        mocMvc.perform(get("/productos/" + CODIGO_PRODUCTO_NUMERO_PD001)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.codigo", is(CODIGO_PRODUCTO_NUMERO_PD001)));
    }

    @Test
    public void agregar() throws Exception {
        //arrange
        ComandoProducto comandoProducto = new ComandoProductoTestDataBuilder().build();

        // act
        mocMvc.perform(post("/productos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoProducto)))
                .andExpect(status().isOk());

        // assert
        mocMvc.perform(get("/productos/" + comandoProducto.getCodigo())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.codigo", is(comandoProducto.getCodigo())));
    }

    @Test
    public void agregarCantidad() throws Exception {

        //arrange
        ComandoProducto comandoProducto = new ComandoProductoTestDataBuilder().conCodigo(CODIGO_PRODUCTO_NUMERO_PD001)
                .conCantidad(CANTIDAD_PRODUCTO_NUMERO_500)
                .build();

        // act
        mocMvc.perform(patch("/productos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoProducto)))
                .andExpect(status().isOk());

        // assert
        mocMvc.perform(get("/productos/" + comandoProducto.getCodigo())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cantidad", is(comandoProducto.getCantidad().intValue())));
    }


    @Test
    public void venta() throws Exception {

        //arrange
        ComandoProducto comandoProducto = new ComandoProductoTestDataBuilder().conCodigo(CODIGO_PRODUCTO_NUMERO_PD008)
                .conCantidad(CANTIDAD_PRODUCTO_NUMERO_500)
                .build();

        ComandoProducto comandoProductoVenta = new ComandoProductoTestDataBuilder().conCodigo(CODIGO_PRODUCTO_NUMERO_PD008)
                .conCantidad(CANTIDAD_PRODUCTO_NUMERO_4)
                .build();

        mocMvc.perform(post("/productos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoProducto)))
                .andExpect(status().isOk());

        // act
        mocMvc.perform(patch("/productos/venta")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoProductoVenta)))
                .andExpect(status().isOk());

        // assert
        mocMvc.perform(get("/productos/" + comandoProducto.getCodigo())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cantidad", is(CANTIDAD_RESULTANTE_OPERACION.intValue())));
    }
}
