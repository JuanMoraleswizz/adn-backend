package com.ceiba.persona.controlador;

import com.ceiba.persona.consulta.ManejadorListarPersona;
import com.ceiba.persona.consulta.ManejadorListarPersonaPorIdentificacion;
import com.ceiba.usuario.modelo.dto.DtoPersona;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persona")
@Api(tags = { "Controlador consulta persona"})
public class ConsultaControladorPersona {
    private final ManejadorListarPersona manejadorListarPersona;
    private final ManejadorListarPersonaPorIdentificacion manejadorListarPersonaPorIdentificacion;
    public ConsultaControladorPersona(ManejadorListarPersona manejadorListarPersona, ManejadorListarPersonaPorIdentificacion manejadorListarPersonaPorIdentificacion) {
        this.manejadorListarPersona = manejadorListarPersona;
        this.manejadorListarPersonaPorIdentificacion = manejadorListarPersonaPorIdentificacion;
    }

    @GetMapping
    @ApiOperation("Listar Personas")
    public List<DtoPersona> listar() {
        return this.manejadorListarPersona.ejecutar();
    }

    @GetMapping(value = "/{identificacion}")
    @ApiOperation("Listar Personas")
    public List<DtoPersona> listarPorIdentificacion(@PathVariable("identificacion") String identificacion) {
        return this.manejadorListarPersonaPorIdentificacion.ejecutar(identificacion);
    }

}
