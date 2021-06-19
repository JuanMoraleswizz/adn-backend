package com.ceiba.persona.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.entidad.Persona;
import com.ceiba.usuario.puerto.repositorio.RepositorioPersona;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPersonaMysql implements RepositorioPersona {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    public RepositorioPersonaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate){
        this.customNamedParameterJdbcTemplate=customNamedParameterJdbcTemplate;
    }

    @SqlStatement(namespace="persona", value="existe")
    private static String sqlExistePersona;
    
    @SqlStatement(namespace="persona", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="persona", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="persona", value="eliminar")
    private static String sqlEliminarEliminarPersona;



    @Override
    public Long crear(Persona persona) {
        return customNamedParameterJdbcTemplate.crear(persona,sqlCrear);
    }

    @Override
    public void actualizar(Persona persona) {
        customNamedParameterJdbcTemplate.actualizar(persona,sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);

    }

    @Override
    public boolean existe(String identificacion) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("identificacion", identificacion);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePersona,paramSource, Boolean.class);

    }
}
