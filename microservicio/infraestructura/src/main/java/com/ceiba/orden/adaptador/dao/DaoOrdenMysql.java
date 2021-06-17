package com.ceiba.orden.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.dto.DtoOrden;
import com.ceiba.usuario.puerto.dao.DaoOrden;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoOrdenMysql implements DaoOrden {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    @SqlStatement(namespace="orden", value="listar")
    private static String sqlListar;
    @SqlStatement(namespace="orden", value="listarPorCliente")
    private static String sqlListarPorCliente;

    public DaoOrdenMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate){
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoOrden> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoOrden());
    }

    @Override
    public List<DtoOrden> ordenesPorCliente(Long idPersona) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idPersona", idPersona);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorCliente,paramSource, new MapeoOrden());
    }
}
