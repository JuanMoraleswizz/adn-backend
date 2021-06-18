package com.ceiba.usuario.puerto.dao;

import com.ceiba.usuario.modelo.dto.DtoArticulosOrden;
import java.util.List;

public interface DaoOrdenDetalle {
    List<DtoArticulosOrden> listar();
}
