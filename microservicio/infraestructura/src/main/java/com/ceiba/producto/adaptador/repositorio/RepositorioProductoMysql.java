package com.ceiba.producto.adaptador.repositorio;

import com.ceiba.usuario.modelo.entidad.Producto;
import com.ceiba.usuario.puerto.repositorio.RepositorioProducto;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioProductoMysql implements RepositorioProducto {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="producto", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="producto", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="producto", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="producto", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="producto", value="existeExcluyendoId")
    private static String sqlExisteExcluyendoId;

    public RepositorioProductoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate){
        this.customNamedParameterJdbcTemplate  =customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Producto producto) {
        return this.customNamedParameterJdbcTemplate.crear(producto, sqlCrear);
    }

    @Override
    public void actualizar(Producto producto) {
        this.customNamedParameterJdbcTemplate.actualizar(producto, sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);

    }

    @Override
    public boolean existe(String codigo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("codigo", codigo);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);

    }
}
