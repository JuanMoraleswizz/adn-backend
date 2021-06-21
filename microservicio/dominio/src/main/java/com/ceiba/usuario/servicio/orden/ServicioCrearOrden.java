package com.ceiba.usuario.servicio.orden;

import com.ceiba.dominio.excepcion.ExcepcionDescuento;
import com.ceiba.usuario.modelo.entidad.ArticulosOrden;
import com.ceiba.usuario.modelo.entidad.Orden;
import com.ceiba.usuario.puerto.repositorio.RepositorioOrden;

import java.util.Calendar;
import java.util.List;


public class ServicioCrearOrden {
    private final RepositorioOrden repositorioOrden;
    private static final String DEBE_TENER_DESCUENTO = "Todos lo articulos debe tener descuento minimo de 5%";
    public ServicioCrearOrden(RepositorioOrden repositorioOrden){
        this.repositorioOrden = repositorioOrden;
    }

    public Long ejecutar(Orden orden){
        validarPromocion(orden);
        return this.repositorioOrden.crear(orden);
    }

    private void validarPromocion(Orden orden) {
        Calendar c = Calendar.getInstance();
        c.set(orden.getFecha().getYear(),orden.getFecha().getMonthValue()-1, orden.getFecha().getDayOfMonth()); // vairables int
        int dia =  c.get(Calendar.DAY_OF_WEEK);
        if (dia == Calendar.FRIDAY){
            debeTenerDescuento(orden.getListaArticulos());
        }
        if (dia == Calendar.TUESDAY){
            debeTenerDescuento(orden.getListaArticulos());
        }
    }

    private void debeTenerDescuento(List<ArticulosOrden> listaArticulos) {
        for (ArticulosOrden articulo :listaArticulos){
            if (articulo.getDescuento() <=4.0){
                throw new ExcepcionDescuento(DEBE_TENER_DESCUENTO);
            }
        }
    }
}
