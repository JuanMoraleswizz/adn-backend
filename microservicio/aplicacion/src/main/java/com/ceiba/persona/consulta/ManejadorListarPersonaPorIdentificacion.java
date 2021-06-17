package com.ceiba.persona.consulta;

import com.ceiba.usuario.modelo.dto.DtoPersona;
import com.ceiba.usuario.puerto.dao.DaoPersona;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarPersonaPorIdentificacion {

    private final DaoPersona daoPersona;

    public ManejadorListarPersonaPorIdentificacion(DaoPersona daoPersona){
        this.daoPersona = daoPersona;
    }

    public List<DtoPersona> ejecutar(String identificacion){ return this.daoPersona.listarPorIdentificacion(identificacion); }
}
