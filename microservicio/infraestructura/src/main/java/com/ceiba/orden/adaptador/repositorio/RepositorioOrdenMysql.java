package com.ceiba.orden.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.entidad.Orden;
import com.ceiba.usuario.puerto.repositorio.RepositorioOrden;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioOrdenMysql implements RepositorioOrden {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioOrdenMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate){
        this.customNamedParameterJdbcTemplate=customNamedParameterJdbcTemplate;
    }
    @SqlStatement(namespace="orden", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="orden", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="orden", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="orden", value="eliminarPorOrden")
    private static String sqlEliminarPorOrden;

    @SqlStatement(namespace="orden", value="existe")
    private static String sqlExiste;

    @Override
    public Long crear(Orden orden) {

        return customNamedParameterJdbcTemplate.crear(orden,sqlCrear);
    }

    @Override
    public void actualizar(Orden orden) {
        customNamedParameterJdbcTemplate.actualizar(orden,sqlActualizar);
    }

    @Override
    public void eliminarPorOrden(Long idOrden) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idOrden", idOrden);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarPorOrden, paramSource);

    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);

    }

    @Override
    public boolean existe(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }
}
