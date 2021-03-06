package com.ceiba.orden.controlador;


import com.ceiba.ComandoRespuesta;
import com.ceiba.orden.comando.ComandoOrden;
import com.ceiba.orden.comando.manejador.ManejadorCrearOrden;
import com.ceiba.orden.comando.manejador.ManejadorEliminarOrden;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orden")
@Api(tags = { "Controlador comando orden"})
public class ComandoControladorOrden {

    private final ManejadorCrearOrden manejadorCrearOrden;
    private final ManejadorEliminarOrden manejadorEliminarOrden;


    public ComandoControladorOrden(ManejadorEliminarOrden manejadorEliminarOrden,
                                     ManejadorCrearOrden manejadorCrearOrden){
        this.manejadorCrearOrden = manejadorCrearOrden;
        this.manejadorEliminarOrden = manejadorEliminarOrden;
    }

    @PostMapping
    @ApiOperation("Crear Orden")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoOrden comandoOrden) {
        return manejadorCrearOrden.ejecutar(comandoOrden);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar Orden")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarOrden.ejecutar(id);
    }

}
