package com.ceiba.orden.consulto;

import com.ceiba.usuario.modelo.dto.DtoOrden;
import com.ceiba.usuario.modelo.dto.DtoPersona;
import com.ceiba.usuario.puerto.dao.DaoOrden;
import com.ceiba.usuario.puerto.dao.DaoPersona;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListaOrden {
    private final DaoOrden daoOrden;

    public ManejadorListaOrden(DaoOrden daoOrden){
        this.daoOrden = daoOrden;
    }

    public List<DtoOrden> ejecutar(){ return this.daoOrden.listar(); }


}
