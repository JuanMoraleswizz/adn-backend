package com.ceiba.persona.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.producto.adaptador.dao.MapeoProducto;
import com.ceiba.usuario.modelo.dto.DtoPersona;
import com.ceiba.usuario.puerto.dao.DaoPersona;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DaoPersonaMysql implements DaoPersona {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    @SqlStatement(namespace="persona", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="persona", value="listarPorIdentificacion")
    private static String sqlListarPorIdentificacion;

    public DaoPersonaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate){
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }
    @Override
    public List<DtoPersona> listar() {
       return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoPersona());
    }

    @Override
    public List<DtoPersona> listarPorIdentificacion(String identificacion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("identificacion", identificacion+"%");
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorIdentificacion,paramSource,new MapeoPersona());
    }
}
