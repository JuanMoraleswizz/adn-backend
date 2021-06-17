package com.ceiba.producto.controlador;

import com.ceiba.producto.comando.ComandoProducto;
import com.ceiba.producto.comando.manejador.ManejadorActualizarProducto;
import com.ceiba.producto.comando.manejador.ManejadorCrearProducto;
import com.ceiba.producto.comando.manejador.ManejadorEliminarProducto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import com.ceiba.ComandoRespuesta;

@RestController
@RequestMapping("/productos")
@Api(tags = { "Controlador comando productos"})
public class ComandoControladorProducto {

    private final ManejadorCrearProducto manejadorCrearProducto;
    private final ManejadorEliminarProducto manejadorEliminarProducto;
    private final ManejadorActualizarProducto manejadorActualizarProducto;

    public ComandoControladorProducto(ManejadorActualizarProducto manejadorActualizarProducto,
                                      ManejadorEliminarProducto manejadorEliminarProducto,
                                      ManejadorCrearProducto manejadorCrearProducto){
        this.manejadorActualizarProducto = manejadorActualizarProducto;
        this.manejadorCrearProducto = manejadorCrearProducto;
        this.manejadorEliminarProducto = manejadorEliminarProducto;
    }

    @PostMapping
    @ApiOperation("Crear Producto")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoProducto comandoProducto) {
        return manejadorCrearProducto.ejecutar(comandoProducto);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar Producto")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarProducto.ejecutar(id);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar producto")
    public void actualizar(@RequestBody ComandoProducto comandoProducto,@PathVariable Long id) {
        System.out.println("entro al service");
        comandoProducto.setId(id);
        manejadorActualizarProducto.ejecutar(comandoProducto);
    }

}
