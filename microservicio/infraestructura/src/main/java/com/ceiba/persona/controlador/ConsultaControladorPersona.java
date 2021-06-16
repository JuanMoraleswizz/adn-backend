package com.ceiba.persona.controlador;

import com.ceiba.persona.consulta.ManejadorListarPersona;
import com.ceiba.producto.consulta.ManejadorListarProductos;
import com.ceiba.usuario.modelo.dto.DtoPersona;
import com.ceiba.usuario.modelo.dto.DtoProducto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persona")
@Api(tags = { "Controlador consulta persona"})
public class ConsultaControladorPersona {
    private final ManejadorListarPersona manejadorListarPersona;

    public ConsultaControladorPersona(ManejadorListarPersona manejadorListarPersona) {
        this.manejadorListarPersona = manejadorListarPersona;
    }

    @GetMapping
    @ApiOperation("Listar Usuarios")
    public List<DtoPersona> listar() {
        return this.manejadorListarPersona.ejecutar();
    }

}
