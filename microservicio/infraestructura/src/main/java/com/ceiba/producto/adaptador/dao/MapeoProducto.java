package com.ceiba.producto.adaptador.dao;

import com.ceiba.usuario.modelo.dto.DtoProducto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import com.ceiba.infraestructura.jdbc.MapperResult;

public class MapeoProducto implements RowMapper<DtoProducto>, MapperResult  {
    @Override
    public DtoProducto mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String codigo = resultSet.getString("codigo");
        String presentacion = resultSet.getString("presentacion");
        String urlImagen = resultSet.getString("url_imagen");
        Double valorUnitario = resultSet.getDouble("valor_unitario");
        return new DtoProducto(id,codigo,nombre,presentacion,urlImagen,valorUnitario);

    }
}
