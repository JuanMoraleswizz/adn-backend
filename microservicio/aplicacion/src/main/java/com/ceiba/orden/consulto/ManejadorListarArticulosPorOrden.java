package com.ceiba.orden.consulto;

import com.ceiba.usuario.modelo.dto.DtoArticulosOrden;
import com.ceiba.usuario.puerto.dao.DaoOrden;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarArticulosPorOrden {
    private final DaoOrden daoOrden;

    public ManejadorListarArticulosPorOrden(DaoOrden daoOrden){
        this.daoOrden = daoOrden;
    }

    public List<DtoArticulosOrden> ejecutar(Long idOrden){ return this.daoOrden.articulosPorOrden(idOrden); }
}
