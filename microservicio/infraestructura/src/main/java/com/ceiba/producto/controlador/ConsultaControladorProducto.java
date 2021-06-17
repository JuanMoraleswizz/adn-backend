package com.ceiba.producto.controlador;

import com.ceiba.producto.consulta.ManejadorListarProductos;
import com.ceiba.producto.consulta.ManejadorListarProductosPorCodigo;
import com.ceiba.usuario.modelo.dto.DtoProducto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
@Api(tags = { "Controlador consulta productos"})
public class ConsultaControladorProducto {
    private final ManejadorListarProductos manejadorListarProductos;
    private final ManejadorListarProductosPorCodigo manejadorListarProductosPorCodigo;
    public ConsultaControladorProducto(ManejadorListarProductos manejadorListarProductos, ManejadorListarProductosPorCodigo manejadorListarProductosPorCodigo ) {
        this.manejadorListarProductos = manejadorListarProductos;
        this.manejadorListarProductosPorCodigo = manejadorListarProductosPorCodigo;
    }

    @GetMapping
    @ApiOperation("Listar Productos")
    public List<DtoProducto> listar() {
        return this.manejadorListarProductos.ejecutar();
    }

    @GetMapping(value = "/{codigo}")
    @ApiOperation("Listar Productos")
    public List<DtoProducto> listarPorCodigo(@PathVariable("codigo") String codigo) {
        return this.manejadorListarProductosPorCodigo.ejecutar(codigo);
    }

}
