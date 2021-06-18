package com.ceiba.orden.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.orden.adaptador.dto.ArticulosOrdenEntity;
import com.ceiba.orden.adaptador.dto.OrdenEntity;
import com.ceiba.usuario.modelo.entidad.ArticulosOrden;
import com.ceiba.usuario.modelo.entidad.Orden;
import com.ceiba.usuario.puerto.repositorio.RepositorioOrden;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioOrdenMysql implements RepositorioOrden {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioOrdenMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @SqlStatement(namespace = "orden", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "orden", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace = "orden", value = "eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace = "orden", value = "eliminarPorOrden")
    private static String sqlEliminarPorOrden;

    @SqlStatement(namespace = "orden", value = "existe")
    private static String sqlExiste;

    @SqlStatement(namespace = "orden", value = "crearDetalle")
    private static String sqlCrearDetalle;


    @SqlStatement(namespace = "orden", value = "eliminarDetalle")
    private static String sqlEliminarDetalle;

    @SqlStatement(namespace = "orden", value = "actualizarDetalle")
    private static String sqlActualizarDetalle;

    @Override
    public Long crear(Orden orden) {
        OrdenEntity ordenEntity = new OrdenEntity();
        ordenEntity.setIdPersona(orden.getPersona().getId());
        ordenEntity.setFecha(orden.getFecha());
        Long idOrden = customNamedParameterJdbcTemplate.crear(ordenEntity, sqlCrear);
        for (ArticulosOrden articulo : orden.getListaArticulos()) {
        ArticulosOrdenEntity articulosOrdenEntity = new ArticulosOrdenEntity(null,idOrden,articulo.getProducto().getId(),
                articulo.getValorUnitario(), articulo.getCantidad(), articulo.getIva(),articulo.getDescuento());
            customNamedParameterJdbcTemplate.crear(articulosOrdenEntity, sqlCrearDetalle);
        }
        return idOrden;
    }

    @Override
    public void actualizar(Orden orden) {
        MapSqlParameterSource ordenParamSource = new MapSqlParameterSource();
        ordenParamSource.addValue("id",orden.getId());
        ordenParamSource.addValue("idPersona", orden.getPersona().getId());
        ordenParamSource.addValue("fecha", orden.getFecha());
        customNamedParameterJdbcTemplate.actualizar(orden, sqlActualizar);
    }

    @Override
    public void actualizar(ArticulosOrden articuloOrden) {
        MapSqlParameterSource articuloOrdenParamSource = new MapSqlParameterSource();
        articuloOrdenParamSource.addValue("id", articuloOrden.getId());
        articuloOrdenParamSource.addValue("idOrden", articuloOrden.getId());
        articuloOrdenParamSource.addValue("idProducto", articuloOrden.getProducto().getId());
        articuloOrdenParamSource.addValue("valorUnitario", articuloOrden.getValorUnitario());
        articuloOrdenParamSource.addValue("iva", articuloOrden.getIva());
        articuloOrdenParamSource.addValue("descuento", articuloOrden.getDescuento());
        customNamedParameterJdbcTemplate.crear(articuloOrdenParamSource, sqlActualizarDetalle);
    }

    @Override
    public void eliminarPorOrden(Long idOrden) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idOrden", idOrden);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarPorOrden, paramSource);

    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public void eliminarArticulo(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarDetalle, paramSource);

    }

    @Override
    public boolean existe(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, paramSource, Boolean.class);
    }
}
