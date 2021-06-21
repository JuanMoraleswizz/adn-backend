package com.ceiba.dominio.excepcion;

public class ExcepcionDescuento extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExcepcionDescuento(String mensaje){
        super(mensaje);
    }
}
