package com.ceiba.orden.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoOrden {
    private Long id;
    private Long idPersona;
    private LocalDateTime fecha;
    List<ComandoOrdenDetalle> listaDetalle;
}
