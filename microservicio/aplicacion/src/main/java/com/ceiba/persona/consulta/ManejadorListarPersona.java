package com.ceiba.persona.consulta;

import com.ceiba.usuario.modelo.dto.DtoPersona;
import com.ceiba.usuario.modelo.dto.DtoProducto;
import com.ceiba.usuario.puerto.dao.DaoPersona;
import com.ceiba.usuario.puerto.dao.DaoProducto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarPersona {

    private final DaoPersona daoPersona;

    public ManejadorListarPersona(DaoPersona daoPersona){
        this.daoPersona = daoPersona;
    }

    public List<DtoPersona> ejecutar(){ return this.daoPersona.listar(); }
}
