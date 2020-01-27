package com.tienda.comics.infraestructura.controllador;


import com.tienda.comics.aplicacion.comando.ComandoProducto;
import com.tienda.comics.aplicacion.manejadores.producto.ManejadorAgregarCantidadProducto;
import com.tienda.comics.aplicacion.manejadores.producto.ManejadorCrearProducto;
import com.tienda.comics.aplicacion.manejadores.producto.ManejadorObtenerProducto;
import com.tienda.comics.aplicacion.manejadores.producto.ManejadorRestarCantidadProducto;
import com.tienda.comics.dominio.modelo.DtoProducto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ControladorProducto {
    private final ManejadorCrearProducto manejadorCrearProducto;
    private final ManejadorAgregarCantidadProducto manejadorAgregarCantidadProducto;
    private final ManejadorObtenerProducto manejadorObtenerProducto;
    private final ManejadorRestarCantidadProducto manejadorRestarCantidadProducto;

    public ControladorProducto(ManejadorCrearProducto manejadorCrearProducto, ManejadorAgregarCantidadProducto manejadorAgregarCantidadProducto, ManejadorObtenerProducto manejadorObtenerProducto, ManejadorRestarCantidadProducto manejadorRestarCantidadProducto) {
        this.manejadorCrearProducto = manejadorCrearProducto;
        this.manejadorAgregarCantidadProducto = manejadorAgregarCantidadProducto;
        this.manejadorObtenerProducto = manejadorObtenerProducto;
        this.manejadorRestarCantidadProducto = manejadorRestarCantidadProducto;
    }

    @PostMapping
    public void agregar(@RequestBody ComandoProducto comandoProducto) {
        this.manejadorCrearProducto.ejecutar(comandoProducto);
    }

    @GetMapping("/{id}")
    public DtoProducto buscar(@PathVariable(name = "id") String codigo) {
        return this.manejadorObtenerProducto.ejecutar(codigo);
    }

    @PatchMapping
    public void agregarCantidad(@RequestBody ComandoProducto comandoProducto) {
        this.manejadorAgregarCantidadProducto.ejecutar(comandoProducto);
    }

    @PatchMapping("/venta")
    public void venta(@RequestBody ComandoProducto comandoProducto) {
        this.manejadorRestarCantidadProducto.ejecutar(comandoProducto);
    }
}
