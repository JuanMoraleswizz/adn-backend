package com.ceiba.persona.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoPersona;
import com.ceiba.usuario.modelo.entidad.Persona;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MapeoPersona implements RowMapper<DtoPersona>, MapperResult {

    @Override
    public DtoPersona mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String identificacion = resultSet.getString("identificacion");
        String nombres = resultSet.getString("nombres");
        String primerApellido = resultSet.getString("primer_apellido");
        String segundoApelido = resultSet.getString("segundo_apellido");
        String sexo = resultSet.getString("sexo");
        return new DtoPersona(id,identificacion,nombres,primerApellido,segundoApelido,sexo);
    }
}
