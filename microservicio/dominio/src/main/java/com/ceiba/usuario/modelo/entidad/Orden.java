package com.ceiba.usuario.modelo.entidad;


import com.ceiba.dominio.ValidadorArgumento;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Orden {

    private static final  String LA_LISTA_NO_PUEDE_SER_VACIA="La lista de articulos no puedeser vacia";
    private Long id;
    private Persona persona;
    private LocalDateTime fecha;
    private List<ArticulosOrden> listaArticulos;

    public Orden(Long id, Persona persona, LocalDateTime fecha,List<ArticulosOrden> listaArticulos){
        this.id = id;
        this.persona = persona;
        this.fecha =fecha;
        ValidadorArgumento.validarNoVacio(listaArticulos,LA_LISTA_NO_PUEDE_SER_VACIA);
        this.listaArticulos = listaArticulos;
    }
}
