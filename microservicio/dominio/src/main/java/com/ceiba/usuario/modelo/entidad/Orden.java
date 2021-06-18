package com.ceiba.usuario.modelo.entidad;


import com.ceiba.dominio.ValidadorArgumento;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Orden {

    private static final  String LA_LISTA_NO_PUEDE_SER_VACIA="La lista de articulos no puedeser vacia";
    private static final  String LA_PERSONA_DEBE_EXITIR_EN_EL_SISTEMA ="La persona debe estar registrada en el sistema";
    private Long id;
    private Persona persona;
    private LocalDateTime fecha;
    private List<ArticulosOrden> listaArticulos;

    public Orden(Long id, Persona persona, LocalDateTime fecha,List<ArticulosOrden> listaArticulos){
        ValidadorArgumento.validarNoVacio(listaArticulos,LA_LISTA_NO_PUEDE_SER_VACIA);
        ValidadorArgumento.validarObligatorio(persona,LA_PERSONA_DEBE_EXITIR_EN_EL_SISTEMA);
        this.id = id;
        this.persona = persona;
        this.fecha =fecha;

        this.listaArticulos = listaArticulos;
    }
}
