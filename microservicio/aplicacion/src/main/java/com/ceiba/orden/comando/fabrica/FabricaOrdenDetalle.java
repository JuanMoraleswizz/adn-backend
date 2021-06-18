package com.ceiba.orden.comando.fabrica;

import com.ceiba.orden.comando.ComandoOrden;
import com.ceiba.orden.comando.ComandoOrdenDetalle;
import com.ceiba.producto.comando.Fabrica.FabricaProducto;
import com.ceiba.usuario.modelo.entidad.ArticulosOrden;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FabricaOrdenDetalle {

    public static List<ArticulosOrden> crear(List<ComandoOrdenDetalle> listaComandoArticulosOrdenes){
      List<ArticulosOrden> listaOrdenesDetalle = new ArrayList<>();
      FabricaProducto fabricaProducto = new FabricaProducto();
        listaComandoArticulosOrdenes.forEach(detalle ->
            listaOrdenesDetalle.add(new ArticulosOrden(detalle.getId(),null, fabricaProducto.crear(detalle.getProducto()),
                    detalle.getValorUnitario(),detalle.getCantidad(),detalle.getIva(),
                    detalle.getDescuento()))
        );
        return listaOrdenesDetalle;
    }
}
