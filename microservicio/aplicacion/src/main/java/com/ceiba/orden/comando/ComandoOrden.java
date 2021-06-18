package com.ceiba.orden.comando;

import com.ceiba.persona.comando.ComandoPersona;
import com.ceiba.usuario.modelo.entidad.Persona;
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
    private ComandoPersona persona;
    private LocalDateTime fecha;
    List<ComandoOrdenDetalle> listaDetalle;
}
