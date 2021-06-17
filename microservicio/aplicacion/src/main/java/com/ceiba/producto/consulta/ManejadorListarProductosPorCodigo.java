package com.ceiba.producto.consulta;

import com.ceiba.usuario.modelo.dto.DtoProducto;
import com.ceiba.usuario.puerto.dao.DaoProducto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarProductosPorCodigo {
    private final DaoProducto daoProducto;

    public ManejadorListarProductosPorCodigo(DaoProducto daoProducto){
        this.daoProducto = daoProducto;
    }

    public List<DtoProducto> ejecutar(String codigo){ return this.daoProducto.listarPorCodigo(codigo); }
}
