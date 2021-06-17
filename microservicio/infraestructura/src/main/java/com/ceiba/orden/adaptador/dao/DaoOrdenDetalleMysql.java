package com.ceiba.orden.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.dto.DtoOrdenDetalle;
import com.ceiba.usuario.puerto.dao.DaoOrdenDetalle;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoOrdenDetalleMysql implements DaoOrdenDetalle {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    @SqlStatement(namespace="orden", value="listarDetalle")
    private static String sqlListar;

    public DaoOrdenDetalleMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate){
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoOrdenDetalle> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoOrdenDetalle());
    }
}
