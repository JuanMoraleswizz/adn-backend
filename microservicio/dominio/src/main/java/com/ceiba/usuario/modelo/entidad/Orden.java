package com.ceiba.usuario.modelo.entidad;


import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Orden {

    private Long id;
    private Long idPersona;
    private LocalDateTime fecha;

    public Orden(Long id, Long idPersona, LocalDateTime fecha){
        this.id = id;
        this.idPersona = idPersona;
        this.fecha =fecha;
    }
}
