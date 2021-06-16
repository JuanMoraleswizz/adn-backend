package com.ceiba.persona.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.persona.comando.ComandoPersona;
import com.ceiba.persona.comando.manejador.ManejadorActualizarPersona;
import com.ceiba.persona.comando.manejador.ManejadorCrearPersona;
import com.ceiba.persona.comando.manejador.ManejadorEliminarPersona;
import com.ceiba.producto.comando.ComandoProducto;
import com.ceiba.producto.comando.manejador.ManejadorActualizarProducto;
import com.ceiba.producto.comando.manejador.ManejadorCrearProducto;
import com.ceiba.producto.comando.manejador.ManejadorEliminarProducto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
@Api(tags = { "Controlador comando persona"})
public class ComandoControladorPersona {
    private final ManejadorCrearPersona manejadorCrearPersona;
    private final ManejadorEliminarPersona manejadorEliminarPersona;
    private final ManejadorActualizarPersona manejadorActualizarPersona;

    public ComandoControladorPersona(ManejadorActualizarPersona manejadorActualizarPersona,
                                     ManejadorEliminarPersona manejadorEliminarPersona,
                                     ManejadorCrearPersona manejadorCrearPersona){
        this.manejadorActualizarPersona = manejadorActualizarPersona;
        this.manejadorCrearPersona = manejadorCrearPersona;
        this.manejadorEliminarPersona = manejadorEliminarPersona;
    }

    @PostMapping
    @ApiOperation("Crear Usuario")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoPersona comandoPersona) {
        return manejadorCrearPersona.ejecutar(comandoPersona);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar Producto")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarPersona.ejecutar(id);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar producto")
    public void actualizar(@RequestBody ComandoPersona comandoPersona,@PathVariable Long id) {
        System.out.println("entro al service");
        comandoPersona.setId(id);
        manejadorActualizarPersona.ejecutar(comandoPersona);
    }

}
