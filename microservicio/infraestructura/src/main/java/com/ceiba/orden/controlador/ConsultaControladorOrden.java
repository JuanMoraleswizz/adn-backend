package com.ceiba.orden.controlador;

import com.ceiba.orden.consulto.ManejadorListaOrden;
import com.ceiba.orden.consulto.ManejadorListaOrdenPorCliente;
import com.ceiba.orden.consulto.ManejadorListarArticulosPorOrden;
import com.ceiba.usuario.modelo.dto.DtoArticulosOrden;
import com.ceiba.usuario.modelo.dto.DtoOrden;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orden")
@Api(tags = { "Controlador consulta ordenes"})
public class ConsultaControladorOrden {
    private final ManejadorListaOrden manejadorListaOrden;
    private final ManejadorListaOrdenPorCliente manejadorListaOrdenPorCliente;
    private final ManejadorListarArticulosPorOrden manejadorListarArticulosPorOrden;
    public ConsultaControladorOrden(ManejadorListaOrden manejadorListaOrden, ManejadorListaOrdenPorCliente manejadorListaOrdenPorCliente,
                                    ManejadorListarArticulosPorOrden manejadorListarArticulosPorOrden) {
        this.manejadorListaOrden = manejadorListaOrden;
        this.manejadorListaOrdenPorCliente= manejadorListaOrdenPorCliente;
        this.manejadorListarArticulosPorOrden =manejadorListarArticulosPorOrden;
    }
    @GetMapping
    @ApiOperation("Listar Orden")
    public List<DtoOrden> listar() {
        return this.manejadorListaOrden.ejecutar();
    }

    @GetMapping(value = "/{idPersona}")
    @ApiOperation("Listar Orden por cliente")
    public List<DtoOrden> listarPorCliente(@PathVariable("idPersona") Long idPersona) {
        return this.manejadorListaOrdenPorCliente.ejecutar(idPersona);
    }

    @GetMapping(value = "/articulo/{idOrden}")
    @ApiOperation("Listar articulos por Orden")
    public List<DtoArticulosOrden> listarArticulosPorOrden(@PathVariable("idOrden") Long idOrden) {
        return this.manejadorListarArticulosPorOrden.ejecutar(idOrden);
    }

}
