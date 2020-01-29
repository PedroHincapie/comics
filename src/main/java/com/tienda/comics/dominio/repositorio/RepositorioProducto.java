package com.tienda.comics.dominio.repositorio;


import com.tienda.comics.dominio.Producto;
import com.tienda.comics.dominio.modelo.DtoProducto;

import java.util.List;

public interface RepositorioProducto {

    /**
     * Permite obtener un producto dado un codigo
     *
     * @param codigo
     * @return DtoProducto
     */
    DtoProducto obtenerPorCodigo(String codigo);

    /**
     * Permite obtener la lista de los productos
     *
     * @return List<DtoProducto>
     */
    List<DtoProducto> listar();

    /**
     * Permite agregar un producto al repositorio
     *
     * @param producto
     */
    void agregar(Producto producto);

    /**
     * Permite agregar cantidades al un producto del repositorio
     *
     * @param producto
     */
    void agregarCantidad(Producto producto);

    /**
     * Permite restar cantidades al un producto del repositorio
     *
     * @param producto
     * @param saldoCantidades
     */
    void restarCantidad(Producto producto, Long saldoCantidades);

}