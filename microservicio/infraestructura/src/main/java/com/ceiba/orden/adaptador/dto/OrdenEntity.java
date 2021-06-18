package com.ceiba.orden.adaptador.dto;

import com.ceiba.persona.comando.ComandoPersona;


import java.time.LocalDateTime;

public class OrdenEntity {
    private Long id;
    private Long idPersona;
    private LocalDateTime fecha;

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
