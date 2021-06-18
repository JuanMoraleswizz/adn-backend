package com.ceiba.usuario.puerto.dao;

import com.ceiba.usuario.modelo.dto.DtoArticulosOrden;
import com.ceiba.usuario.modelo.dto.DtoOrden;

import java.util.List;

public interface DaoOrden {
    List<DtoOrden> listar();

    List<DtoOrden> ordenesPorCliente(Long idPersona);

    List<DtoArticulosOrden> articulosPorOrden(Long idOrden);
}
