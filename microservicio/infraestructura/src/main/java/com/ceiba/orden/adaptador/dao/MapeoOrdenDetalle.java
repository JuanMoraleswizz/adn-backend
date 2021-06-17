package com.ceiba.orden.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoOrdenDetalle;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoOrdenDetalle implements RowMapper<DtoOrdenDetalle>, MapperResult {
    @Override
    public DtoOrdenDetalle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
         Long id = resultSet.getLong("id");
         Long idOrden = resultSet.getLong("id_orden");
         Long idProducto = resultSet.getLong("id_producto") ;
         Double valorUnitario = resultSet.getDouble("valor_unitario");
         Double cantidad = resultSet.getDouble("cantidad");
         Double iva = resultSet.getDouble("iva");
         Double descuento = resultSet.getDouble("descuento");

        return new DtoOrdenDetalle(id,idOrden,idProducto,valorUnitario,cantidad,iva,descuento);
    }
}
