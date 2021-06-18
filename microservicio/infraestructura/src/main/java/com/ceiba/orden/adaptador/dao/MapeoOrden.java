package com.ceiba.orden.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoOrden;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoOrden implements RowMapper<DtoOrden>, MapperResult {
    @Override
    public DtoOrden mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        Long idPersona = resultSet.getLong("id_persona");
        String cliente = resultSet.getString("cliente");
        String identificacion = resultSet.getString("identificacion");
        LocalDateTime fecha = extraerLocalDateTime(resultSet, "fecha");
        Double valorTotal = resultSet.getDouble("valor_total");
        return  new DtoOrden(id,idPersona,cliente,identificacion,fecha,valorTotal);
    }
}
