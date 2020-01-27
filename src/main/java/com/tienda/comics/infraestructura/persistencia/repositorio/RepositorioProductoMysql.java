package com.tienda.comics.infraestructura.persistencia.repositorio;

import com.tienda.comics.dominio.Producto;
import com.tienda.comics.dominio.modelo.DtoProducto;
import com.tienda.comics.dominio.repositorio.RepositorioProducto;
import com.tienda.comics.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.tienda.comics.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioProductoMysql implements RepositorioProducto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private static final String CANTIDAD = "cantidad";
    private static final String CAMPO_CODIGO = "codigo";

    @SqlStatement(namespace = "producto", value = "consultarPorCodigo")
    private static String sqlConsultaPorCodigo;

    @SqlStatement(namespace = "producto", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "producto", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "producto", value = "vender")
    private static String sqlVender;

    public RepositorioProductoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public DtoProducto obtenerPorCodigo(String codigo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(CAMPO_CODIGO, codigo);
        return this.customNamedParameterJdbcTemplate.consultarUnicoResultado(sqlConsultaPorCodigo, paramSource, new ProductoMapeo()).orElse(null);
    }

    @Override
    public void agregar(Producto producto) {
        this.customNamedParameterJdbcTemplate.guardar(producto, sqlCrear);
    }

    @Override
    public void agregarCantidad(Producto producto) {
        this.customNamedParameterJdbcTemplate.guardar(producto, sqlActualizar);
    }

    @Override
    public void restarCantidad(Producto producto, Long saldoCantidades) {
        MapSqlParameterSource parametros = new MapSqlParameterSource();
        parametros.addValue(CAMPO_CODIGO, producto.getCodigo());
        parametros.addValue(CANTIDAD, saldoCantidades);

        this.customNamedParameterJdbcTemplate.guardar(parametros, sqlVender);
    }
}
