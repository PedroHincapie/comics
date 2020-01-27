package com.tienda.comics.infraestructura.persistencia.repositorio;


import com.tienda.comics.dominio.modelo.DtoProducto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoMapeo implements RowMapper<DtoProducto> {

    @Override
    public DtoProducto mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        String codigo = resultSet.getString("codigo");
        String nombre = resultSet.getString("nombre");
        double precio = resultSet.getDouble("precio");
        Long cantidad = resultSet.getLong("cantidad");

        return new DtoProducto(codigo, nombre, precio, cantidad);
    }
}
