package com.ceiba.orden.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoArticulosOrden;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoArticulosOrden implements RowMapper<DtoArticulosOrden>, MapperResult {
    @Override
    public DtoArticulosOrden mapRow(ResultSet resultSet, int rowNum) throws SQLException {
         Long id = resultSet.getLong("id");
         Long idOrden = resultSet.getLong("id_orden");
         Long idProducto = resultSet.getLong("id_producto") ;
         Double valorUnitario = resultSet.getDouble("valor_unitario");
         Double cantidad = resultSet.getDouble("cantidad");
         Double iva = resultSet.getDouble("iva");
         Double descuento = resultSet.getDouble("descuento");

        return new DtoArticulosOrden(id,null,null,valorUnitario,cantidad,iva,descuento);

    }
}
