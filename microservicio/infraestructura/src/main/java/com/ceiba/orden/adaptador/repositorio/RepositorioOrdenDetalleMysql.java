package com.ceiba.orden.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.entidad.ArticulosOrden;
import com.ceiba.usuario.puerto.repositorio.RepositorioOrdenDetalle;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioOrdenDetalleMysql implements RepositorioOrdenDetalle {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioOrdenDetalleMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate){
        this.customNamedParameterJdbcTemplate=customNamedParameterJdbcTemplate;
    }

    @SqlStatement(namespace="orden", value="crearDetalle")
    private static String sqlCrear;

    @SqlStatement(namespace="orden", value="actualizarDetalle")
    private static String sqlActualizar;

    @SqlStatement(namespace="orden", value="eliminarDetalle")
    private static String sqlEliminar;


    @Override
    public Long crear(ArticulosOrden articulosOrden) {
        return customNamedParameterJdbcTemplate.crear(articulosOrden,sqlCrear);
    }

    @Override
    public void actualizar(ArticulosOrden articulosOrden) {
        customNamedParameterJdbcTemplate.actualizar(articulosOrden,sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);

    }
}
