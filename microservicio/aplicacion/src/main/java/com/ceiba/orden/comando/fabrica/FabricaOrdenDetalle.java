package com.ceiba.orden.comando.fabrica;

import com.ceiba.orden.comando.ComandoOrden;
import com.ceiba.usuario.modelo.entidad.ArticulosOrden;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FabricaOrdenDetalle {

    public List<ArticulosOrden> crear(ComandoOrden comandoOrden){
      List<ArticulosOrden> listaOrdenesDetalle = new ArrayList<>();
        comandoOrden.getListaDetalle().forEach(detalle ->{
            listaOrdenesDetalle.add(new ArticulosOrden(detalle.getId(),detalle.getIdOrden(),detalle.getIdProducto(),
                    detalle.getValorUnitario(),detalle.getCantidad(), detalle.getSubTotal(),detalle.getIva(),
                    detalle.getDescuento()));
        });
        return listaOrdenesDetalle;
    }
}
