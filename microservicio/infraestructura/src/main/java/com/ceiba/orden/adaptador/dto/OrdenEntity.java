package com.ceiba.orden.adaptador.dto;




import java.time.LocalDateTime;

public class OrdenEntity {
    private Long id;
    private Long idPersona;
    private LocalDateTime fecha;

    public Long getId() {
        return id;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

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
