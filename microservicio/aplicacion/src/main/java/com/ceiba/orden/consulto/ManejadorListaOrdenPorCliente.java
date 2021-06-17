package com.ceiba.orden.consulto;

import com.ceiba.usuario.modelo.dto.DtoOrden;
import com.ceiba.usuario.puerto.dao.DaoOrden;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListaOrdenPorCliente {
    private final DaoOrden daoOrden;

    public ManejadorListaOrdenPorCliente(DaoOrden daoOrden){
        this.daoOrden = daoOrden;
    }

    public List<DtoOrden> ejecutar(Long idPersona){ return this.daoOrden.ordenesPorCliente(idPersona); }


}
