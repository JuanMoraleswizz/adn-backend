package com.ceiba.orden.servicio.TestDataBuilder;

import java.time.LocalDateTime;

public class OrdenTestDataBuilder {
    private Long id;
    private Long idPersona;
    private LocalDateTime fecha;

    public OrdenTestDataBuilder(){
        idPersona = 1L;
        fecha = LocalDateTime.now();
    }


}
