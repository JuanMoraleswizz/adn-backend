package com.ceiba.usuario.servicio.orden;

import com.ceiba.dominio.excepcion.ExcepcionDescuento;
import com.ceiba.usuario.modelo.entidad.ArticulosOrden;
import com.ceiba.usuario.modelo.entidad.Orden;
import com.ceiba.usuario.puerto.repositorio.RepositorioOrden;

import java.time.DayOfWeek;
import java.util.List;


public class ServicioCrearOrden {
    private final RepositorioOrden repositorioOrden;
    private static final String DEBE_TENER_DESCUENTO = "Todos lo articulos debe tener descuento minimo de 5%";
    public ServicioCrearOrden(RepositorioOrden repositorioOrden){
        this.repositorioOrden = repositorioOrden;
    }

    public Long ejecutar(Orden orden){
        validarSiAplicaPromocion(orden);
        return this.repositorioOrden.crear(orden);
    }

    private void validarSiAplicaPromocion(Orden orden) {
     DayOfWeek dia =  orden.getFecha().getDayOfWeek();
        if ( dia== DayOfWeek.FRIDAY){
            validaQueTengaAplicadoElDescuento(orden.getListaArticulos());
        }
        else if (dia ==DayOfWeek.TUESDAY){
            validaQueTengaAplicadoElDescuento(orden.getListaArticulos());
        }
    }

    private void validaQueTengaAplicadoElDescuento(List<ArticulosOrden> listaArticulos) {
        for (ArticulosOrden articulo :listaArticulos){
            if (articulo.getDescuento() <=4.0){
                throw new ExcepcionDescuento(DEBE_TENER_DESCUENTO);
            }
        }
    }
}
